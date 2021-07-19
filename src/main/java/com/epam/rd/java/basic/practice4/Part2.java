package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {

    static Logger logger;

    public static void main(String[] args) throws IOException {
        CreateFile();
        String outputText = getInput("part2.txt");
        Integer [] n = parsInt();
        Integer [] m1 = bubbleSort(n);
        String z = m1.toString();
        String finaltext = reWrite(z);


        System.out.println("input ==> " + outputText);
        System.out.println("output ==> " + finaltext);
       // outputText = CreateFile(outputText);
        //System.out.println(outputText);
    }

    public static String reWrite(String o) throws IOException {
        File myFoo = new File("C/Users/1/IdeaProjects/dipnxtcf-task4/part2.txt");
        FileWriter fooWriter = new FileWriter(myFoo, false); // true to append
        // false to overwrite.
        String n = getInput("part2.txt");
        fooWriter.write(o);
        fooWriter.close();
        return n;
    }

    public static void CreateFile() {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("part2.txt"), "cp1251"))) {
            int n = 10;
            int line;
            Random random = new Random();
            while (n > 0) {
                // Randomize an integer and write it to the output file
                line = random.nextInt(50);
                writer.write(line + " ");
                n--;
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer[] parsInt() {
        String out = getInput("part2.txt");
        char[] ch = out.toCharArray();
        Integer[] intarray = new Integer[ch.length];
        int i=0;
        for(i = 0; i < ch.length; i++){
            intarray[i]=Integer.parseInt(String.valueOf(ch))  ; //Exception in this line
        }
        return intarray;
    }



//        File out = new File("C/Users/1/IdeaProjects/dipnxtcf-task4/src/part2.txt");

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

    public static Integer[] bubbleSort(Integer[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
        return arr;
    }
}


//1.Создать клас который создает файл и заполняет файл "part2.txt" случайными целыми числами от 0 до 50 (всего 10 чисел)
//2.происходит считываение файла и перезапись содержимого в другой файл  ("part2 _ sorted.txt"),
// отсортировав числа в порядке возрастания
//3. Реализовать Отображение содержимого обоих файлов в консоли
// (номера должны быть разделены пробелом). Н
// 4.апишите собственный метод сортировки, который использует для этого некоторый алгоритм (например, сортировка пузырей).
// Выходной файл должен быть читаемым. Отображение содержимого входного и выходного файлов в консоли. Пример вывода консоли