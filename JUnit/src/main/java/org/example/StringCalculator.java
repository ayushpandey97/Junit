package org.example;

public class StringCalculator {

    public int add(String numbers) throws IllegalArgumentException {
        if (numbers.isEmpty()) {
            return 0;
        }
        numbers = numbers.replace("\n", ",");
        String[] numberArray = numbers.split(",");

        int sum = 0;
        StringBuilder negativeNumbers = new StringBuilder();

        for (String number : numberArray) {
            if (!number.trim().isEmpty()) {
                int num = Integer.parseInt(number.trim());

                // Check if the number is negative
                if (num < 0) {
                    if (negativeNumbers.length() > 0) {
                        negativeNumbers.append(", ");
                    }
                    negativeNumbers.append(num);
                }
                if (num <= 1000) {
                    sum += num;
                }
            }
        }

        if (negativeNumbers.length() > 0) {
            throw new IllegalArgumentException("Negatives not allowed: " + negativeNumbers.toString());
        }

        return sum;
    }

    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        try {
            System.out.println(calculator.add(""));
            System.out.println(calculator.add("1"));
            System.out.println(calculator.add("1,2"));
            System.out.println(calculator.add("1\n2,3"));
            System.out.println(calculator.add("1001,2"));
            System.out.println(calculator.add("2,-3,4"));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
