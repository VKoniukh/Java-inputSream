package com.epam.rd.java.basic.practice4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part2 {

    static Logger logger;

    public static void main(String[] args) {
//        String outputText = getInput1("part2.txt");
//        outputText = ChangeInput(outputText);
//        System.out.println(outputText);
    }

    public static void CrNum() {
        // The target file
        File out = new File("C:\\Users\\1\\IdeaProjects\\dipnxtcf-task4\\src\\main\\resources\\part2.txt");
        FileWriter fw = null;
        int n = 10;
        // Try block: Most stream operations may throw IO exception
        try {
            // Create file writer object
            fw = new FileWriter(out);
            // Wrap the writer with buffered streams
            BufferedWriter writer = new BufferedWriter(fw);
            int line;
            Random random = new Random();
            while (n > 0) {
                // Randomize an integer and write it to the output file
                line = random.nextInt(50);
                writer.write(line + "\n");
                n--;
            }
            // Close the stream
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static String getInput1(String filePath) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\1\\IdeaProjects\\dipnxtcf-task4\\src\\main\\resources\\part2.txt"), "cp1251");
            while (scanner.hasNextLine()) {
                sb
                        .append(scanner.nextLine())
                        .append(System.lineSeparator());
                Integer[] myInts = new Integer[50];
                int mySpot = 0;
                while (scanner.hasNext()) {
                    myInts[mySpot] = Integer.valueOf(scanner.next());
                    mySpot++;
                }
                scanner.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
            logger.log(Level.SEVERE, "File does not exist");
        }
        return sb.toString();
    }

    public static void Sort() throws IOException {
//        Scanner fin = new Scanner(new File("C:\\Users\\1\\IdeaProjects\\dipnxtcf-task4\\src\\main\\resources\\part2.txt"), "cp1251");
//        ;
//        int[] nums = new int[100];
//        int cnt = 0;
//        while (fin.hasNextInt()) {
//            nums[cnt] = fin.nextInt();
//            cnt++;
        FileReader fin = new FileReader("part2.txt");
        int c;
        int number = 0;
        boolean ncheck = false;
        ArrayList<Integer> n = new ArrayList<Integer>();
        while ((c = fin.read()) != -1) {
            if (c >= 48 && c < 58) { //проверка соответствуют ли символы юникода цифрам
                number = number * 10 + Character.getNumericValue((char) c);
                ncheck = true;
            } else if (ncheck == true) {
                n.add(number);
                number = 0;
                ncheck = false;
            }

        }
        if (ncheck == true) { // не нашел решения получше,решает проблему если последним символом в файле является цифра,то предыдущая проверка не происходит.
            n.add(number);
            number = 0;
            ncheck = false;
        }
        Collections.sort(n);

        FileWriter fw = new FileWriter(new File("part2_sorted.txt"));
        for (int i : n) {
            fw.write(Integer.toString(i) + (char) 13 + (char) 10);//"(char)13" и "(char)10" символы юникода управления строкой и кареткой
            fw.flush();
        }
    }
}


//1.Создать клас который создает файл и заполняет файл "part2.txt" случайными целыми числами от 0 до 50 (всего 10 чисел)
//2.происходит считываение файла и перезапись содержимого в другой файл  ("part2 _ sorted.txt"),
// отсортировав числа в порядке возрастания
//3. Реализовать Отображение содержимого обоих файлов в консоли
// (номера должны быть разделены пробелом). Н
// 4.апишите собственный метод сортировки, который использует для этого некоторый алгоритм (например, сортировка пузырей).
// Выходной файл должен быть читаемым. Отображение содержимого входного и выходного файлов в консоли. Пример вывода консоли