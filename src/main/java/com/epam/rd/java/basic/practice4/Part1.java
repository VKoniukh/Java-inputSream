package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static void main(String[] args) {
        String outputText = getInput("part1.txt");
        outputText = sb1(outputText);
        System.out.println(outputText);
    }

    static Logger logger;

    public static String getInput(String filePath) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(filePath), "cp1251");
            while (scanner.hasNextLine()) {
                sb
                        .append(scanner.nextLine())
                        .append(System.lineSeparator());

            }
            scanner.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            logger.log(Level.SEVERE, "File does not exist");
        }
        return sb.toString();
    }
//[\wa-яА-Я]{4,}
    public static String sb1(String input) {
        String REGEX = "[a-zA-Z0-9][\\wа-яёА-ЯЁ]+/ig{4,}";
        String REPLACE = " ";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(input);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, REPLACE);
        }
        matcher.appendTail(buffer);
//            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
//            Matcher matcher = pattern.matcher(input);
//            StringBuilder sb = new StringBuilder();
//            while (matcher.find()) {
//                if (matcher.group().length() > -4) {
//                    sb.append(matcher.group().substring(2));
//                } else {
//                    sb.append(matcher.group());
//                }
//            }
//            return sb.toString();
        return buffer.toString().trim();
    }
}