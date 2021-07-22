package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    public static final String input = getFileInput("part3.txt");

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        start("part3.txt");
    }


    public static void start(String filename) {
        while (sc.hasNextLine()) {
                switch (sc.nextLine()) {
                    case "String":
                        System.out.println(getStringValues() + " ");
                        break;
                    case "char":
                        System.out.println(getCharValues() + " ");
                        break;
                    case "int":
                        System.out.println(getIntValues() + " ");
                        break;
                    case "double":
                        System.out.println(getDoubleValues() + " ");
                        break;
                    case "stop":
                        return;
                    default:
                        System.out.println("incorrect input");
                        break;
                }
        }
    }

    public static String getStringValues() {
        StringBuilder sb = new StringBuilder();
        String regex = "([\\p{L}]+)[^\\p{L}]+";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String block = matcher.group();
            String word = block.replaceAll(regex, "$1");
            sb.append((word.length() >= 2 ? word + " " : ""));
        }

        return sb.toString().trim();
    }

    public static String getCharValues() {
        StringBuilder sb = new StringBuilder();
        String regex = "(?<=\\s|^).(?=\\s|$)";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            String block = matcher.group();
            String word = block.replaceAll(regex, "$1");
            sb.append((word.length() == 1 ? word + " " : ""));
        }

        return sb.toString().trim();
    }

    public static String getDoubleValues() {
        StringBuilder sb = new StringBuilder();
        String regex = "\\b\\d+\\.\\d+\\b";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }
        return sb.toString().trim();
    }

    public static String getIntValues() {
        StringBuilder sb = new StringBuilder();
        String regex = "(?<=\\s|^)[-]?[0-9]+(?=\\s|$)";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            sb.append(matcher.group()).append(" ");
        }
        return sb.toString().trim();
    }

    public static String getFileInput(String fileName) {
        StringBuilder sb = new StringBuilder();

        try (Scanner scanner = new Scanner(new File(fileName), "cp1251")) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine() + System.lineSeparator();
                sb.append(line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return sb.toString();
    }
}


//    Файл содержит символы, целые числа и числа с плавающей запятой.
//    Напишите класс, имеющий следующие функциональные возможности: в цикле пользователь вводит тип данных
//    (один из них: char, int, double, String), в ответ приложение распечатывает на консоль все значения соответствующих типов,
//    которые существуют в файле. Если пользователь вводит слово "stop", приложение выходит из цикла.
//    В других случаях необходимо напечатать "Неверный ввод". Разрешите задачу с помощью регулярных выражений.
//    Примечание: Строка должна считаться последовательностью из двух и более символов.
//    Символы - латинские или кириллические буквы в верхнем или нижнем регистре
//    (убедитесь, что во входном файле могут содержаться кириллические буквы).
//        Пример исходного файла:
//        ————————————————————————-
//        bcd 43.43 432 и л фвыа 89 .98
//        ————————————————————————-