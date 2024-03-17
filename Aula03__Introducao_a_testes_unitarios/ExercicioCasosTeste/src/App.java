package Aula03_Introducao_a_testes_unitarios.ExercicioCasosTeste.src;

public class App {
    public static void main(String[] args) throws Exception {
        RomanNumeral rn = new RomanNumeral();
        int output = rn.convert("I");
        System.out.println(output);
    }
}
