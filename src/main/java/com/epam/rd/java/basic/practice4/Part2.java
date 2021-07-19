package com.epam.rd.java.basic.practice4;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;

public class Part2 {

    public static void main(String[] args) {

    }

    public static void CrNum() {
        // The target file
        File out = new File("random.txt");
        FileWriter fw = null;
        int n = 50;
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
}


//1.Создать клас который создает файл и заполняет файл "part2.txt" случайными целыми числами от 0 до 50 (всего 10 чисел)
//2.Создать происходит считываение файла и перезапись содержимого в другой файл  ("part2 _ sorted.txt"),
// отсортировав числа в порядке возрастания
//3. Реализовать Отображение содержимого обоих файлов в консоли
// (номера должны быть разделены пробелом). Н
// 4.апишите собственный метод сортировки, который использует для этого некоторый алгоритм (например, сортировка пузырей).
// Выходной файл должен быть читаемым. Отображение содержимого входного и выходного файлов в консоли. Пример вывода консоли