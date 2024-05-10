package org.example.CryptoAnalizer.services;



import org.example.CryptoAnalizer.Entity.Result;
import org.example.CryptoAnalizer.Exception.ApplicationException;
import org.example.CryptoAnalizer.repository.ResultCode;

import java.io.IOException;
import java.util.*;

public class StatisticalAnalysis implements Function{
    private String defaultPathForRead = "C:\\Users\\Nastya\\javarush\\3415430\\javarush-project\\src\\com\\javarush\\task\\jdk13\\task53\\task5307\\myFiles\\encrypt.txt";
    private String defaultReferencePath = "C:\\Users\\Nastya\\javarush\\3415430\\javarush-project\\src\\com\\javarush\\task\\jdk13\\task53\\task5307\\myFiles\\reference.txt";

    private String defaultPathForWrite = "C:\\Users\\Nastya\\javarush\\3415430\\javarush-project\\src\\com\\javarush\\task\\jdk13\\task53\\task5307\\myFiles\\statistical.txt";

    @Override
    public Result execute(String[] parameters) {
        String filePath = Reading_Writing.getFilePath(defaultPathForRead);
        String referencePath=Reading_Writing.getFilePath(defaultReferencePath);
        try {
            String text = Reading_Writing.readFile(filePath);
            String reference=Reading_Writing.readFile(referencePath);
            Map<Character,Integer> referendFrequncy=frequencyMap(reference);
            System.out.println("Зашифрованный текст: " + text);
            String decryptedText = decrypt(text,referendFrequncy);
            System.out.println("Расшифрованный текст: " + decryptedText);
            String fileForDecrypt = Reading_Writing.getFilePath(defaultPathForWrite);
            Reading_Writing.writeToFile(fileForDecrypt, decryptedText);
        } catch (IOException e) {
            throw new ApplicationException("Файла не существует", e);
        }
        return new Result(ResultCode.OK, "Statistical analysis");
    }

    private String decrypt(String text, Map<Character, Integer> referenceFrequency) {
        // Получаем карту частот символов зашифрованного текста
        Map<Character, Integer> encryptedFrequency = frequencyMap(text);

        // Создаем список записей частот символов зашифрованного текста
        List<Map.Entry<Character, Integer>> encryptedList = new ArrayList<>(encryptedFrequency.entrySet());
        // Сортируем список по значениям частот (по убыванию)
        encryptedList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<Map.Entry<Character, Integer>> referenceList = new ArrayList<>(referenceFrequency.entrySet());
        referenceList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Создаем отображение для соответствия символов в зашифрованном тексте символам в референсном тексте
        Map<Character, Character> charMapping = new HashMap<>();
        // Проходим по записям в списках частот символов и устанавливаем соответствия
        for (int i = 0; i < encryptedList.size() && i < referenceList.size(); i++) {
            charMapping.put(encryptedList.get(i).getKey(), referenceList.get(i).getKey());
        }

        // Расшифровываем текст, заменяя символы из зашифрованного текста на символы из референсного текста
        StringBuilder decryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            decryptedText.append(charMapping.getOrDefault(c, c)); // Если символ не найден в отображении, остается без изменений
        }

        return decryptedText.toString();
    }


    private static Map<Character,Integer> frequencyMap(String text)
    {
        text=text.toLowerCase();
        Map<Character,Integer> frequency=new HashMap<>();
        for(char c:text.toCharArray())
        {
            frequency.put(c,frequency.getOrDefault(c,0)+1);
        }
        return frequency;
    }
}
