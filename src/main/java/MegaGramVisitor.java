import org.antlr.v4.runtime.RuleContext;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MegaGramVisitor {
    public GrammarInfo visitGram(MegagrammarParser.GramContext ctx) {
        List<MegagrammarParser.ExpressionContext> expressions = ctx.expression();
        List<MegagrammarParser.TokenContext> terminals = ctx.token();

        List<GrammarInfo.Terminal> leafs = terminals.stream().map(this::visitTerminal).collect(Collectors.toList());
        List<GrammarInfo.Node> nodes = expressions.stream().map(this::visitExpression).collect(Collectors.toList());
        List<GrammarInfo.Rule> allRules = nodes.stream().flatMap(n -> n.rules.stream()).collect(Collectors.toList());
        var info = setFirst(new GrammarInfo(leafs, nodes, allRules));
        setFollow(info);
        return info;
    }

    private GrammarInfo.Terminal visitTerminal(MegagrammarParser.TokenContext ctx) {
        String name = ctx.TERMINAL().getText();
        String regexp = ctx.CHARS().getText();
        String regexpinner = regexp.substring(1, regexp.length() - 1);
        return new GrammarInfo.Terminal(name, regexpinner);
    }

    private GrammarInfo.Node visitExpression(MegagrammarParser.ExpressionContext ctx) {
        String name = ctx.NONTERMINAL().getText();

        MegagrammarParser.InitialattributesContext initctx = ctx.initialattributes();
        String init = "";
        if (initctx != null) {
            init = getContent(initctx.CODE().getText());
        }

        MegagrammarParser.ParentattributesContext parentctx = ctx.parentattributes();
        String parentCode = "";
        if (parentctx != null) {
            parentCode = getContent(parentctx.CODE().getText());
        }

        List<String> synthesCode = new ArrayList<>();
        List<GrammarInfo.Rule> rules = ctx.rules().onerule()
                .stream().map(x -> visitOneRule(name, x, synthesCode)).collect(Collectors.toList());

        GrammarInfo.Node node = new GrammarInfo.Node(name, init, parentCode, rules, synthesCode);
        if (ctx.rules().EMPTY() != null) {
            rules.add(new GrammarInfo.Rule(name, List.of("")));
        }
        return node;
    }

    private GrammarInfo.Rule visitOneRule(String name, MegagrammarParser.OneruleContext context, List<String> code) {
        if (context.syntezattributes() != null) {
            code.add(getContent(context.syntezattributes().CODE().getText()));
        }
        return visitChain(name, context.chain());
    }

    private GrammarInfo.Rule visitChain(String name, MegagrammarParser.ChainContext chain) {
        return new GrammarInfo.Rule(name, chain.name().stream()
                .map(RuleContext::getText)
                .collect(Collectors.toList()));
    }

    private void setFollow(GrammarInfo info) {
        Map<String, Set<String>> follow = new HashMap<>();
        var first = info.first;
        var rules = info.allRules;
        Predicate<String> isNode = (data) -> info.getNodes().stream().anyMatch(d -> d.getName().equals(data));
        Predicate<String> isTerminal = (data) -> info.getTerminals().stream().anyMatch(d -> d.getName().equals(data)) || data.equals("");

        info.getNodes().forEach(node -> follow.put(node.getName(), new HashSet<>()));
        follow.get("expr").add("$");


        boolean changed = true;
        while (changed) {
            changed = false;
            for (GrammarInfo.Rule ruleA : rules) {
                String aName = ruleA.from;
                for (int i = 0; i < ruleA.to.size(); i++) {
                    String bName = ruleA.to.get(i);
                    if (isNode.test(bName)) {
                        Set<String> bSet = follow.get(bName);
                        if (i < ruleA.to.size() - 1) {
                            String gammaName = ruleA.to.get(i + 1);
                            Set<String> gammaFirst = new HashSet<>();
                            if (isTerminal.test(gammaName)) {
                                gammaFirst.add(gammaName);
                            } else {
                                gammaFirst = first.get(gammaName);
                            }
                            boolean result = bSet.addAll(gammaFirst);
                            if (gammaFirst.contains("")) {
                                result |= bSet.addAll(follow.get(aName));
                            }
                            changed |= result;
                        } else {
                            changed |= bSet.addAll(follow.get(aName));
                        }
                    }
                }
            }
        }
        check(info, info.getNodes(), info.first, follow);
    }

    private void check(GrammarInfo info, List<GrammarInfo.Node> nodes,  Map<String, Set<String>> first, Map<String, Set<String>> follow){
        Predicate<String> isTerminal = (data) -> info.getTerminals().stream().anyMatch(d -> d.getName().equals(data)) || data.equals("");
        for (var node : nodes){
            Set<String> set = new HashSet<>();
            String prev = node.getName();
            for (var rule1 : node.rules) {
                for (var rule2 : node.rules) {
                    if (rule1 != rule2) {
                        String term1 = rule1.to.get(0);
                        String term2 = rule2.to.get(0);
                        if (isTerminal.test(term1)) {
                            if (isTerminal.test(term2)) {
                                if (term1.equals(term2)) throw new AssertionError("Not LL(1) " );
                            } else {
                                if (first.get(term2).contains(term1)) throw new AssertionError("Not LL(1) " );
                            }
                        } else {
                            if (!isTerminal.test(term2)) {
                                for (var i : first.get(term2)) {
                                    if (first.get(term1).contains(i)) throw new AssertionError("Not LL(1) " );
                                }
                            }
                        }
                    }
                }
//                String next = rule.to.get(0);
//                if (isTerminal.test(next)){
//                    var set2 = first.get(next);
//                    if (set2 != null) {
//                        for (String s : set2) {
//                            if (set.contains(s)) {
//
//                            } else {
//                                set.add(s);
//                            }
//                        }
//                    }
//
//                }

            }
        }
    }



    private GrammarInfo setFirst(GrammarInfo descriptor) {
        Map<String, Set<String>> first = new HashMap<>();
        Predicate<String> isLeaf = (data) -> descriptor.getTerminals().stream().anyMatch(d -> d.getName().equals(data)) || data.equals("");
        descriptor.getNodes().forEach(node -> first.put(node.getName(), new HashSet<>()));
        boolean changed = true;
        while (changed) {
            changed = false;
            for (GrammarInfo.Rule currentRule : descriptor.allRules) {
                Set<String> setFrom = first.get(currentRule.from);
                if (!currentRule.to.isEmpty()) {
                    String nextRuleName = currentRule.to.get(0);
                    if (isLeaf.test(nextRuleName)) {
                        if (!setFrom.contains(nextRuleName)) {
                            changed = true;
                            setFrom.add(nextRuleName);
                        }
                    } else {
                        Set<String> setTo = first.get(nextRuleName);
                        boolean result = setFrom.addAll(setTo);
                        if (result) {
                            changed = true;
                        }
                    }
                }
            }
        }

        for (GrammarInfo.Node node : descriptor.getNodes()) {
            String name = node.getName();
            node.first = first.get(name);
        }

        descriptor.first = first;

        return descriptor;
    }

    public static String getContent(String content) {
        int len = content.length();
        return content.substring(1, len - 1);
    }
}
