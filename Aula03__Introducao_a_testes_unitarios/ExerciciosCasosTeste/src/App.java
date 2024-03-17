import java.io.File;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        testRomanNumerals();
        testCalculator();
    }

    private static void evaluate(int output, int expected) {
        System.out.println("\nOutput: " + output + " | Expected: " + expected);
        if (output == expected) {
            System.out.println("\u001B[32mTest passed!\u001B[0m");
        } else {
            System.out.println("\u001B[31mTest failed!\u001B[0m");
        }
    }

    private static void testRomanNumerals() {
        RomanNumeral rn = new RomanNumeral();

        int output_I = rn.convert("I");
        evaluate(output_I, 1);

        int output_V = rn.convert("V");
        evaluate(output_V, 5);

        int output_IV = rn.convert("IV");
        evaluate(output_IV, 4);

        int output_IIII = rn.convert("IIII");
        evaluate(output_IIII, -1);

        int output_IVVI = rn.convert("IVVI");
        evaluate(output_IVVI, -1);
    }

    private static void testCalculator() {
        Calculator calc = new Calculator();

        File testCasesREADME = new File("TestCases\\Calculator.md");
        try (Scanner readmeScanner = new Scanner(testCasesREADME)) {
            // Skip header
            readmeScanner.nextLine();
            // Skip empty line
            readmeScanner.nextLine();
            // File structure = | Input | Expected | Actual | Result |
            while (readmeScanner.hasNextLine()) {
                // Get first column
                String line = readmeScanner.nextLine();
                String[] columns = line.split("\\|");
                String input = columns[1].replaceAll(" ", "");
                if (input.contains("MAX_INTEGER")) {
                    final String MAX_INT = Integer.toString(Integer.MAX_VALUE);
                    input = input.replaceAll("MAX_INTEGER", MAX_INT);
                }
                String expectedOutput = columns[2].replaceAll(" ", "");
                int expected;
                try {
                    expected = Integer.parseInt(expectedOutput);
                } catch (NumberFormatException e) {
                    expected = -1;
                }
                int output = calc.evaluate(input);
                evaluate(output, expected);
            }
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
