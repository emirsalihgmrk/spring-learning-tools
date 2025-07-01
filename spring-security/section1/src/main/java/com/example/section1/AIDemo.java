package com.example.section1;

public class AIDemo {
    public static void main(String[] args) {
        add(1, 2);
        subtract(1, 2);
        multiply(2, 3);
        divide(6, 3);
    }

    public static void add(int num1, int num2) {
        System.out.println("sum: " + (num1 + num2));
    }

    public static void subtract(int num1, int num2) {
        System.out.println("difference: " + (num1 - num2));
    }

    public static void multiply(int num1, int num2) {
        System.out.println("product: " + (num1 * num2));
    }

    public static void divide(int num1, int num2) {
        System.out.println("quotient: " + (num1 / num2));
    }
}
