package org.example.CryptoAnalizer.services;

import org.example.CryptoAnalizer.Entity.Result;
import org.example.CryptoAnalizer.Exception.ApplicationException;
import org.example.CryptoAnalizer.constants.CryptoAlphabet;
import org.example.CryptoAnalizer.repository.ResultCode;

import java.io.IOException;
import java.util.*;

public class BruteForce implements Function {
    private String defaultPathForRead = "D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\encrypt.txt";
    private String defaultReferencePath = "D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\reference.txt";

    private String defaultPathForWrite = "D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\brute_force.txt";

    @Override
    public Result execute(String[] parameters) {
        String filePath = Reading_Writing.getFilePath(defaultPathForRead);
        String referencePath=Reading_Writing.getFilePath(defaultReferencePath);
        try {
            String text = Reading_Writing.readFile(filePath);
            String reference=Reading_Writing.readFile(referencePath);
            System.out.println("Зашифрованный текст: " + text);
            String decryptedText = decryptBruteForce(text,reference);
            System.out.println("Расшифрованный текст: " + decryptedText);
            String fileForDecrypt = Reading_Writing.getFilePath(defaultPathForWrite);
            Reading_Writing.writeToFile(fileForDecrypt, decryptedText);
        } catch (IOException e) {
            throw new ApplicationException("Файла не существует", e);
        }
        return new Result(ResultCode.OK, "Brute Force");
    }

    public static String decryptBruteForce(String encryptedText, String referenceText) {
        String bestDecryption = "";
        double bestSimilarity = Double.MIN_VALUE;

        for (int key = 0; key < CryptoAlphabet.ALPHABET.length(); key++) {
            String decryptionAttempt = Decode.decrypt(encryptedText, key);
            double similarity = calculateSimilarity(decryptionAttempt, referenceText);
            if (similarity > bestSimilarity) {
                bestDecryption = decryptionAttempt;
                bestSimilarity = similarity;
            }
        }

        return bestDecryption;
    }


    private static double calculateSimilarity(String decryptedText, String referenceText) {

        String[] decryptedWords = decryptedText.split("\\s+");
        String[] referenceWords = referenceText.split("\\s+");
        Set<String> decryptedSet = new HashSet<>(Arrays.asList(decryptedWords));
        Set<String> referenceSet = new HashSet<>(Arrays.asList(referenceWords));

        int matchingWords = 0;
        for (String word : decryptedSet) {
            if (referenceSet.contains(word)) {
                matchingWords++;
            }
        }

        double similarity = (double) matchingWords / referenceWords.length;
        return similarity;
    }


}
