package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Util {
    static Logger logger;

    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            logger.log(Level.INFO, ex.getMessage());
        }
        return sb.toString();
    }

    public static class Part1 {
        public static void main(String[] args) {
            System.out.println(sb1(Util.getInput("part1.txt")));
        }

        public static String sb1(String input) {
            String regex = "([А-я\\w]{4,})|(\\n)|([А-я\\w]{1,4})|(\\W)";
            Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            Matcher matcher = pattern.matcher(input);
            StringBuilder sb = new StringBuilder();
            while (matcher.find()) {
                if (matcher.group().length() > -4) {
                    sb.append(matcher.group().substring(2));
                } else {
                    sb.append(matcher.group());
                }
            }
            return sb.toString();
        }
    }
}
