package org.example.CryptoAnalizer.services;



import org.example.CryptoAnalizer.Exception.ApplicationException;

import java.io.*;
import java.util.Scanner;

public class Reading_Writing {
    public static String readFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    public static void writeToFile(String path, String text)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(text);
            System.out.println("Текст успешно записан в файл: " + path);
        } catch (IOException e) {
            throw new ApplicationException("Ошибка записи в файл", e);
        }
    }

    static String getFilePath(String path) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу (или нажмите Enter для использования пути по умолчанию "+path+"): ");
        String filePath = scanner.nextLine();

        if (filePath.isEmpty()) {
            filePath = path;
        }

        return filePath;
    }


    static int getKey() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ключ для кода (или нажмите Enter для использования по умолчанию 13): ");
        String input = scanner.nextLine();

        int number;
        if (input.isEmpty()) {
            number = 13;
        } else {
            number = Integer.parseInt(input);
        }
        return number;
    }


}
