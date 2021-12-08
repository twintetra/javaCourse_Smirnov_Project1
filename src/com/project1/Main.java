package com.project1;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    static int result = 0;
    static boolean flag = false;
    public static void main(String[] args) {
        printMenu();
    }

    private static void printMenu() {
        System.out.println("Выберите вариант меню:");
        System.out.println("1. Ввести пример");
        System.out.println("2. Продолжить работать с предыдущим ответом");
        System.out.println("3. Выход");
        System.out.print("Вариант: ");
        Scanner menuItem = new Scanner(System.in);
        int choiceItem = menuItem.nextInt();
        if (choiceItem == 1) {
            expression();
            printMenu();
        }
        if (choiceItem == 2) {
            if (flag) {
                printMenu2();
            } else {
                System.out.println("Недоступно!");
            }
        }
        if (choiceItem == 3) {
            System.out.println("Вы вышли из программы");
        }
    }

    private static void printMenu2() {
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("5. Факториал");
        System.out.println("6. Возведение в степень");
        System.out.println("7. Сравнение");
        System.out.println("0. Назад");
        Scanner menu2Item = new Scanner(System.in);
        int choice2Item = menu2Item.nextInt();
        if (choice2Item == 0) {
            printMenu();
        }
        if (choice2Item == 5) {
            result = factorial(result);
            outResult();
            printMenu();
            return;
        }
        System.out.println("Введите второе число выражения:");
        Scanner scr2 = new Scanner(System.in);
        int expression2 = scr2.nextInt();
        switch (choice2Item) {
            case 1 -> result = sum(result, expression2);
            case 2 -> result = sub(result, expression2);
            case 3 -> result = multi(result, expression2);
            case 4 -> result = div(result, expression2);
            case 6 -> result = exp(result, expression2);
            case 7 -> result = compare(result, expression2);
            default -> {
            }
        }
        outResult();
        printMenu();
    }

    private static void expression() {
        System.out.println("Введите пример для вычисления: ");
        Scanner operation = new Scanner(System.in);
        String[] operationArr = operation.nextLine().split(" ");
        String operand = operationArr[1];
        int expressionLeft = Integer.parseInt(operationArr[0]);
        int expressionRight = 0;
        if (operationArr.length == 3) {
            expressionRight = Integer.parseInt(operationArr[2]);
        }
        if (Objects.equals(operand, "+")) {
            result = sum(expressionLeft, expressionRight);
        }
        if (Objects.equals(operand, "-")) {
            result = sub(expressionLeft, expressionRight);
        }
        if (Objects.equals(operand, "*")) {
            result = multi(expressionLeft, expressionRight);
        }
        if (Objects.equals(operand, "/")) {
            result = div(expressionLeft, expressionRight);
        }
        if (Objects.equals(operand, "!")) {
            result = factorial(expressionLeft);
        }
        if (Objects.equals(operand, "^")) {
            result = exp(expressionLeft, expressionRight);
        }
        if (Objects.equals(operand, "?")) {
            result = compare(expressionLeft, expressionRight);
        }
        outResult();
        flag = true;
    }

    private static void outResult() {
        System.out.println("Ответ: " + result);
    }

    private static int sum(int expressionLeft, int expressionRight) {
        return expressionLeft + expressionRight;
    }
    private static int sub(int expressionLeft, int expressionRight) {
        return expressionLeft - expressionRight;
    }

    private static int multi(int expressionLeft, int expressionRight) {
        return expressionLeft * expressionRight;
    }

    private static int div(int expressionLeft, int expressionRight) {
        return expressionLeft / expressionRight;
    }

    private static int factorial(int expression) {
        if (expression <= 1) {
            return 1;
        }
        return expression * factorial(expression - 1);
    }

    private static int exp(int expressionLeft, int expressionRight) {
        return (int) Math.pow(expressionLeft, expressionRight);
    }

    private static int compare(int expressionLeft, int expressionRight) {
        return Math.max(expressionLeft, expressionRight);
    }
}
