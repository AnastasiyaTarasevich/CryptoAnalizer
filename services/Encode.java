package com.javarush.task.jdk13.task53.task5307.services;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;
import com.javarush.task.jdk13.task53.task5307.Exception.ApplicationException;
import com.javarush.task.jdk13.task53.task5307.constants.CryptoAlphabet;
import com.javarush.task.jdk13.task53.task5307.repository.ResultCode;

import java.io.*;
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
            String encryptedText = encrypt(text, number);
            System.out.println("Зашифрованный текст: " + encryptedText);
            String fileForEncrypt=getFilePathForEncrypt();
            writeToFile(fileForEncrypt, encryptedText);
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
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    private static void writeToFile(String path, String text)
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(text);
            System.out.println("Текст успешно записан в файл: " + path);
        } catch (IOException e) {
            throw new ApplicationException("Ошибка записи в файл", e);
        }
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
    private String getFilePathForEncrypt() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь к файлу для записи (или нажмите Enter для использования пути по умолчанию 'myFiles/encrypt.txt'): ");
        String filePath = scanner.nextLine();

        if (filePath.isEmpty()) {
            filePath = "C:\\Users\\Nastya\\javarush\\3415430\\javarush-project\\src\\com\\javarush\\task\\jdk13\\task53\\task5307\\myFiles\\encrypt.txt";
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


    private String encrypt(String text,int key)
    {
        StringBuilder encrypted=new StringBuilder();
        for(char c:text.toCharArray())
        {
            int index= CryptoAlphabet.ALPHABET.indexOf(c);
            if(index!=-1)
            {
                index=(index+key)%CryptoAlphabet.ALPHABET.length();
                encrypted.append(CryptoAlphabet.ALPHABET.charAt(index));
            }
            else {
                encrypted.append(c);
            }
        }
        return encrypted.toString();
    }
}
