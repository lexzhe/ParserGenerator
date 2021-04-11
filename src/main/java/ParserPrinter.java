import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class ParserPrinter {
//    private int index = 0;

    private static final String template = """
            import java.util.*;

            public class Parser {

                private int position = 0;
                private List<Token> data;

                public Parser(List<Token> data) {
                    this.data = data;
                }

            %s
            }
            """;

    public String createParser(GrammarInfo info) {
        return String.format(template, makeContexts(info) + makeParseFunctions(info));
    }

    private String makeContexts(GrammarInfo info) {
        String mainCtx = """
                    public static class GrammarContext {
                        public String text;
                    }
                """;
        String terminalsContexts = info.getTerminals().stream().map(this::makeTerminalContext).collect(Collectors.joining("\n"));
        String nodesContexts = info.getNodes().stream().map(node -> makeNodeContext(info, node)).collect(Collectors.joining("\n"));
        return mainCtx + "\n" + nodesContexts + "\n" + terminalsContexts + "\n";
    }

    public String makeTerminalContext(GrammarInfo.Terminal terminal) {
        String template = """
                    public static class %sContext extends GrammarContext {
                        public Tree tree = new Tree("%s");
                    }
                """;
        String name = toName(terminal.getName());
        return String.format(template, name, name);
    }

    public String makeNodeContext(GrammarInfo info, GrammarInfo.Node node) {
        String name = toName(node.getName());
        String template = """
                    public static class %sContext extends GrammarContext {                        
                        private int localIndexRule = -1;
                    
                        %s
                        public Tree tree = new Tree("%s");
                
                        public void process() {
                %s
                        }                   
                    }
                """;

        String declaration = node.initCode;
        String fields = makeFields(node);
        String processFunction = makeProcessFunction(info, node);
        return String.format(template, name, declaration + "\n" + fields, name, processFunction);
    }

    private String makeFields(GrammarInfo.Node node) {
        return node.fieldCounter.entrySet().stream().map(e -> {
            String name = e.getKey();
            Integer count = e.getValue();
            return count == 1 ? "        public " + toName(name) + "Context " + name + ";\n"
                    : "        private List<" + toName(name) + "Context> = new ArrayList<>();" + name + ";\n";
        }).collect(Collectors.joining());
    }

    private String makeProcessFunction(GrammarInfo info, GrammarInfo.Node node) {
        String switchTemplate = """
                            switch (localIndexRule) {
                %s
                            }
                """;
        String caseTemplate = """
                                case %s:
                                    %s
                                    break;
                """;

        StringBuilder strb = new StringBuilder();
        for (var entry : node.fieldCounter.entrySet()) {
            String name = entry.getKey();
            if (info.getTerminals().stream().anyMatch(l -> l.getName().equals(name))) {
                continue;
            }
            if (entry.getValue() == 1) {
                strb.append("            if (").append(name).append(" != null) {\n");
                strb.append(makeParentCode(info, name));
                strb.append("                ").append(name).append(".process();\n            }\n");
            } else {
                strb.append("            ").append(name).append(".stream()\n.filter(Object::notNull)\n.forEach(x -> x.process());\n");
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < node.rulesCode.size(); i++) {
            builder.append(String.format(caseTemplate, i, node.rulesCode.get(i)));
        }
        return strb.toString() + String.format(switchTemplate, builder.toString()) + "\n";
    }

    private String makeParentCode(GrammarInfo info, String name) {
        Optional<GrammarInfo.Node> child = info.getNodes().stream().filter(node -> node.getName().equals(name)).findFirst();
        if (child.isPresent()) {
            GrammarInfo.Node childNode = child.get();
            String parentCode = childNode.parentCode;
            if (parentCode.isEmpty()) {
                return "";
            } else {
                return parentCode.replace("this", name) + "\n";
            }
        } else {
            return "";
        }
    }

    private String makeParseFunctions(GrammarInfo info) {
        String nodeFunctions = info.getNodes().stream().map(n -> makeParseNode(info, n)).collect(Collectors.joining("\n")) + "\n";
        String terminalFunctions = info.getTerminals().stream().map(this::makeParseTerminal).collect(Collectors.joining("\n")) + "\n";
        return nodeFunctions + "\n" + terminalFunctions;
    }

    private String makeParseTerminal(GrammarInfo.Terminal terminal) {
        String name = toName(terminal.name);
        String funTemplate = """
                    public %sContext parse%s() {
                        %sContext result = new %sContext();
                        result.tree.text = data.get(position).text;
                        result.text = data.get(position++).text;
                        return result;
                    }
                """;
        return String.format(funTemplate, name, name, name, name);
    }

    private String makeParseNode(GrammarInfo info, GrammarInfo.Node node) {
        String name = toName(node.getName());
        String parseTemplate = """
                    public %sContext parse%s() {
                %s
                    }
                """;
        String body = makeFunctionBody(info, node);

        return String.format(parseTemplate, name, name, body);
    }


    private String makeFunctionBody(GrammarInfo info, GrammarInfo.Node node) {
//        index = 0;
        String resultType = toName(node.getName());
        String switchTemplate = """
                        %sContext result = new %sContext();
                        switch (data.get(position).terminal) {
                %s
                        }
                %s
                """;
        String caseTemplate = """
                            case %s:
                                result = new %sContext();
                %s
                                return result;
                """;
        StringBuilder strb = new StringBuilder();
        for (String termName : node.first) {
            if (!termName.equals("")) {
                strb.append(String.format(caseTemplate, termName, resultType, makeCaseBody(info, node, termName)));
            }
        }
        boolean needsException = false;
        if (node.first.contains("")) {
            processDefaultBlock(node, strb);
        } else {
            needsException = true;
        }
        String exception = needsException ? "        throw new IllegalStateException(\"Unexpected token \" + data.get(position).terminal.name() + \" at position: \" + position);" : "";
        return String.format(switchTemplate, resultType, resultType, strb.toString(), exception);
    }

    private void processDefaultBlock(GrammarInfo.Node node, StringBuilder builder) {
        String defaultTemplate = """
                            default:
                                result = new %sContext();
                                result.localIndexRule = %s;
                                return result;
                """;
        int number = 0;
        for (int i = 0; i < node.rules.size(); i++) {
            List<String> toList = node.rules.get(i).to;
            if (!toList.isEmpty() && toList.get(0).equals("")) {
                number = i;
                break;
            }
        }
        String name = toName(node.getName());
        builder.append(String.format(defaultTemplate, name, number));
    }

    private String makeCaseBody(GrammarInfo info, GrammarInfo.Node node, String termName) {
        GrammarInfo.Rule nextRule = null;
        int number = 0;
        for (GrammarInfo.Rule rule : node.rules) {
            String nextStateName = rule.to.get(0);
            Set<String> firstByNextState = info.first.get(nextStateName);
            if (firstByNextState == null && nextStateName.equals(termName)) {
                nextRule = rule;
                break;
            }
            if (firstByNextState != null && firstByNextState.contains(termName)) {
                nextRule = rule;
                break;
            }
            number++;
        }
        if (nextRule == null) {
            throw new IllegalStateException("null");
        }
        String settingNumber = "                " + "result" + ".localIndexRule = " + number + ";\n";
        return settingNumber + nextRule.to.stream().map(toRuleName -> {
            Integer count = node.fieldCounter.get(toRuleName);
            if (count == null || count == 1) {
                String line = "                " + "result." + toRuleName + " = parse" + toName(toRuleName) + "();";
                String treeLine = "                " + "result.tree.add(result." + toRuleName + ".tree);";
                return line + "\n" + treeLine;
            } else {
                return "                " + "result" + "." + toRuleName + ".add(parse" + toName(toRuleName) + "());";
            }
        }).collect(Collectors.joining("\n"));
    }

    public static String toName(String v) {
        return Character.toUpperCase(v.charAt(0)) + v.substring(1);
    }
}
