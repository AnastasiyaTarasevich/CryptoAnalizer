package com.javarush.task.jdk13.task53.task5307.services;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;
import com.javarush.task.jdk13.task53.task5307.Exception.ApplicationException;
import com.javarush.task.jdk13.task53.task5307.repository.ResultCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Encode implements Function {
    @Override
    public Result execute(String[] parameters) {

        String filePath = getFilePath();
        int number = getKey();
        try {
            String text = readFile(filePath);
            System.out.println("Незашифрованный текст: " + text);
            //            char[] encryptedText = encrypt(text.toCharArray(), key);
//            System.out.println("Зашифрованный текст: " + new String(encryptedText));

        } catch (IOException e) {
            throw new ApplicationException("Файла не существует", e);
        }
        return new Result(ResultCode.OK, "Encode");
    }
    private static String readFile(String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb.toString();
    }
    private String getFilePath() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу (или нажмите Enter для использования пути по умолчанию 'myFiles/text.txt'): ");
        String filePath = scanner.nextLine();

        if (filePath.isEmpty()) {
            filePath = "C:\\Users\\Nastya\\javarush\\3415430\\javarush-project\\src\\com\\javarush\\task\\jdk13\\task53\\task5307\\myFiles\\text.txt";
        }

        return filePath;
    }

    private int getKey() {
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
