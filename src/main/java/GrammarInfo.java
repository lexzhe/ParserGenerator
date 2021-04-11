import java.util.HashSet;
import java.util.List;
import java.util.*;

public final class GrammarInfo {
    private final List<Node> nodes;
    private final List<Terminal> terminals;
    public Map<String, Set<String>> first;
    public List<Rule> allRules;

    public GrammarInfo() {
        terminals = new ArrayList<>();
        nodes = new ArrayList<>();
    }

    public GrammarInfo(List<Terminal> terminals, List<Node> nodes, List<Rule> rules) {
        this.terminals = terminals;
        this.nodes = nodes;
        this.allRules = rules;
    }

    public List<Terminal> getTerminals() {
        return terminals;
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public static final class Node {
        private final String name;
        public Set<String> first = new HashSet<>();
        public final String initCode;
        public final List<Rule> rules;
        public final List<String> rulesCode;
        public final String parentCode;
        public final Map<String, Integer> fieldCounter;

        public Node(String name, String initCode, String parentCode, List<Rule> rules, List<String> rulesCode ) {
            this.name = name;
            this.initCode = initCode;
            this.parentCode = parentCode;
            this.rules = rules;
            this.rulesCode = rulesCode;

            fieldCounter = new HashMap<>();
            for (Rule rule : rules) {
                var tempMap = new HashMap<String, Integer>();
                for (String ruleName : rule.to) {
                    tempMap.merge(ruleName, 1, Integer::sum);
                }
                for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
                    fieldCounter.merge(entry.getKey(), entry.getValue(), Math::max);
                }
            }
        }

        public String getName() {
            return name;
        }

    }

    public static final class Terminal {
        public final String name;
        public final String regularExpression;

        public Terminal(String name, String regularExpression) {
            this.name = name;
            this.regularExpression = regularExpression;
        }
        public String getName() {
            return name;
        }
    }

    public static class Rule {
        public final String from;
        public final List<String> to;
        public Rule(String from, List<String> to) {
            this.from = from;
            this.to = to;
        }
    }


}
