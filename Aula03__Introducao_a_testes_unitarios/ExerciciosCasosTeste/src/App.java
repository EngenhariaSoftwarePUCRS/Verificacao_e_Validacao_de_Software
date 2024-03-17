public class App {
    public static void main(String[] args) throws Exception {
    }

    private static void evaluate(int output, int expected) {
        System.out.println("\nOutput: " + output + " | Expected: " + expected);
        if (output == expected) {
            System.out.println("\u001B[32mTest passed!\u001B[0m");
        } else {
            System.out.println("\u001B[31mTest failed!\u001B[0m");
        }
    }
}
