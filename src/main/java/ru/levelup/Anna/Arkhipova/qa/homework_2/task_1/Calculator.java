package ru.levelup.Anna.Arkhipova.qa.homework_2.task_1;

import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.startCalculate();
    }

    public void startCalculate() {
        int num1, num2;
        float result;
        String operation;

        Scanner in = new Scanner(System.in);

        System.out.println("Enter first number:");

        while (!in.hasNextInt()) {
            System.out.println("Enter A Positive Integer");
            in.next();
        }
        num1 = in.nextInt();

        System.out.println("Enter operation (+,-,*,/):");
        operation = in.next();

        System.out.println("Enter second number:");
        while (!in.hasNextInt()) {
            System.out.println("Enter A Positive Integer");
            in.next();
        }
        num2 = in.nextInt();

        switch (operation) {
            case "+":
                result = num1 + num2;
                System.out.printf("Result = %f \n", result);
                break;
            case "-":
                result = num1 - num2;
                System.out.printf("Result = %f \n", result);
                break;
            case "*":
                result = num1 * num2;
                System.out.printf("Result = %f \n", result);
                break;
            case "/":
                if (num2 == 0) {
                    System.out.println("Error: divide by zero");
                    break;
                }
                result = (float) num1 / num2;
                System.out.printf("Result = %f \n", result);
                break;
            default:
                System.out.println("Your operation is not valid");
        }

        in.close();
    }
}
