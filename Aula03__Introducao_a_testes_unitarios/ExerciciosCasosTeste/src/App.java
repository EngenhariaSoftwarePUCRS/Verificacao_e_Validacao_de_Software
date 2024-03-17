public class App {
    public static void main(String[] args) throws Exception {
        testRomanNumerals();
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
}
