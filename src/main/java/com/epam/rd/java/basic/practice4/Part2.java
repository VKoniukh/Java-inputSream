package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {

    static Logger logger;

    public static void main(String[] args) {
        CreateFile();
        String outputText = getInput("part2.txt").trim();
        int[] toSort = strToArr(outputText);
        String result1 = bubbleSort(toSort);
        String result2 = null;
        try {
            result2 = reWrite(result1);
        } catch (IOException lol) {
            logger.log(Level.SEVERE, "File does not exist");
        }
        System.out.print("input ==> " + outputText + System.lineSeparator());
        System.out.print("output ==> " + result2 + System.lineSeparator());
    }

    public static int[] strToArr(String input) {
        String str = input.trim();
        String[] strArr = str.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);
        }
        return numArr;
    }


    public static String reWrite(String o) throws IOException {
        File myFoo = new File("part2_sorted.txt");
        FileWriter fooWriter = new FileWriter(myFoo);
        fooWriter.write(o);
        fooWriter.close();
        return o;
    }

    public static void CreateFile() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("part2.txt"), "cp1251"))) {
            int n = 10;
            int line;
            Random random = new Random();
            while (n > 0) {
                line = random.nextInt(50);
                writer.write(line + " ");
                n--;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static String bubbleSort(int arr[]) {
        int n = arr.length;
        for (int o = 0; o < n - 1; o++)
            for (int j = 0; j < n - o - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

        return toString(arr);

    }

    public static String toString(int[] a) {

        int iMax = a.length - 1;

        StringBuilder b = new StringBuilder();
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.toString();
            b.append(" ");
        }
    }

}
