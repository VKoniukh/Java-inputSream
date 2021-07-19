package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {
    public static final String ONE_WORD = "[\\wа-яА-Я]{4,}";

    static Logger logger;

    public static void main(String[] args) {
        String outputText = getInput("part1.txt");
        outputText = ChangeInput(outputText);
        System.out.println(outputText);
    }

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

    public static String ChangeInput(String input) {
        String result = input;
        Pattern p = Pattern.compile(ONE_WORD, Pattern.MULTILINE);
        Matcher m = p.matcher(input);
        StringBuffer sb1 = new StringBuffer();
            while (m.find()) {
                String word = m.group();
                String newWord = word.substring(2);
                result = result.replace(m.group(), newWord);
            }

        return result.trim();
    }
}