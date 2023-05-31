package com.partaki;

import java.util.Scanner;

//Создай консольное приложение “Калькулятор”. Приложение должно читать из консоли введенные пользователем строки, числа,
//арифметические операции проводимые между ними и выводить в консоль результат их выполнения.
//Реализуй класс Main с методом public static String calc(String input). Метод должен принимать строку с арифметическим
//выражением между двумя числами и возвращать строку с результатом их выполнения. Ты можешь добавлять свои импорты,
//классы и методы. Добавленные классы не должны иметь модификаторы доступа (public или другие)
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение разделяя пробелом: ");
        String exp = scanner.nextLine();
        String result = calc(exp);
        System.out.println(result);

    }
    public static String calc(String input) {
        Convent convent = new Convent();
        String[] exp = input.split(" ");
        int result = 0;
        boolean isRoman = false;
        if (exp.length == 3) {
            String c = exp[1];
            int a, b;
            if (convent.isRoman(exp[0]) == convent.isRoman(exp[2])) {
                isRoman = convent.isRoman(exp[0]);
                if (isRoman) {

                    a = convent.romanToInt(exp[0]);
                    b = convent.romanToInt(exp[2]);

                } else {

                    a = Integer.parseInt(exp[0]);
                    b = Integer.parseInt(exp[2]);
                }

                if ((a <= 10 && a >= 1) && (b <= 10 && b >= 1)) {

                    switch (c) {
                        case "+":
                            result = a + b;
                            break;
                        case "-":
                            result = a - b;
                            break;
                        case "*":
                            result = a * b;
                            break;
                        case "/":
                            result = a / b;
                            break;
                        default:
                            throw new RuntimeException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                    }


                } else {
                    throw new RuntimeException("числа должны быть в пределе от 1 до 10");
                }
            } else {
                throw new RuntimeException("используются одновременно разные системы счисления");
            }
        } else {
            throw new RuntimeException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        if (isRoman) {
            return (convent.intToRoman(result));
        } else {
            return String.valueOf(result);
        }
    }
}













