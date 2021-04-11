import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

//import procalculator.*;
import hw2.*;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String[] dirs = new String[]{"calculator", "procalculator", "hw2"};
    static String[] names = new String[]{"calc.g", "procalc.g", "hw2.g"};


    public static void main(String[] args) throws IOException {
        System.out.println("Hello World!");
        System.out.println("Please choose input file from list:");
        Arrays.stream(names).forEach(name -> System.out.print(name + " "));
        System.out.println();
        try (Scanner scanner = new Scanner(System.in)) {
            int cnt = Integer.parseInt(scanner.nextLine());
            prepare(dirs[cnt], names[cnt]);
            test(dirs[cnt], scanner);
        }
    }

    private static void test(String dir, Scanner scanner) {
        System.out.println();
        System.out.println("=============================================================");
        System.out.println();
        System.out.println("Please enter what do you want to parse with generated parser: ");
        System.out.println("To quit print \"stop\"");
        int cnt = 0;

        String input = scanner.nextLine();
        while (!input.equals("stop")) {
            try {
                double output = calc(input, cnt++, dir);
                System.out.println(output);
            } catch (Exception e) {
                e.printStackTrace();
            }
            input = scanner.nextLine();
        }

    }

    private static double calc(String input, int cnt, String dir) {
        Lexer lexerS = new Lexer(input);

        List<Token> tokenList = lexerS.parseAll();
        System.out.println(tokenList);
        var exprContext = new Parser(tokenList).parseExpr();
        exprContext.process();
        String graph = exprContext.tree.toGraph();
        printGraph(graph, cnt, dir);
        return exprContext.res;
    }

    private static void printGraph(String text, int cnt, String dir) {
        String filename = "src\\main\\java\\" + dir + "\\graph" + cnt + ".txt";
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filename))) {
            writer.write("digraph G {\n" + text + "}");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void prepare(String dir, String name) throws IOException {
        String filename = "src\\main\\input\\" + name;
        System.out.println("File with grammar: " + filename);
        System.out.println();
        System.out.println("Opening file: <<<");
        InputStream is = new FileInputStream(filename);
        String data = new String(is.readAllBytes());
        System.out.println(data);
        is.close();
        System.out.println(">>> File closed");

        MegagrammarLexer lexer = new MegagrammarLexer(CharStreams.fromString(data));
        TokenStream tokens = new CommonTokenStream(lexer);
        MegagrammarParser parser = new MegagrammarParser(tokens);

        GrammarInfo gram = new MegaGramVisitor().visitGram(parser.gram());

        System.out.println("Input file parsed correctly");
        System.out.println();
        System.out.println("===========================");
        System.out.println();
        System.out.println("Generating Parser");
        System.out.println();
        UniversalPrinter printer = new UniversalPrinter(dir);

        printer.printEnums(gram);
        printer.printLexer(gram);
        printer.printTree();
        printer.printParser(gram);
    }
}
