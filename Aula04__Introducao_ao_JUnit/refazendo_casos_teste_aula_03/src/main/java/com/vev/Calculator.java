package com.vev;

public class Calculator {
    public int evaluate(String expression) {
        int sum = 0;
        expression = expression.replaceAll("\\s", "");
        String[] summands = expression.split("\\+");
        for (String summand : summands) {
            sum += Integer.valueOf(summand);
        }
        return sum;
    }
}
