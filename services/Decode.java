package com.javarush.task.jdk13.task53.task5307.services;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;
import com.javarush.task.jdk13.task53.task5307.Exception.ApplicationException;
import com.javarush.task.jdk13.task53.task5307.constants.CryptoAlphabet;
import com.javarush.task.jdk13.task53.task5307.repository.ResultCode;

import java.io.*;

public class Decode implements Function{
    private String defaultPathForRead="C:\\Users\\Nastya\\javarush\\3415430\\javarush-project\\src\\com\\javarush\\task\\jdk13\\task53\\task5307\\myFiles\\encrypt.txt";

    private String defaultPathForWrite="C:\\Users\\Nastya\\javarush\\3415430\\javarush-project\\src\\com\\javarush\\task\\jdk13\\task53\\task5307\\myFiles\\decrypt.txt";
    @Override
    public Result execute(String[] parameters) {

        String filePath = Reading_Writing.getFilePath(defaultPathForRead);
        int number = Reading_Writing.getKey();
        try {
            String text = Reading_Writing.readFile(filePath);
            System.out.println("Зашифрованный текст: " + text);
            String decryptedText = decrypt(text, number);
            System.out.println("Расшифрованный текст: " + decryptedText);
            String fileForDecrypt= Reading_Writing.getFilePath(defaultPathForWrite);
            Reading_Writing.writeToFile(fileForDecrypt, decryptedText);
        } catch (IOException e) {
            throw new ApplicationException("Файла не существует", e);
        }
        return new Result(ResultCode.OK, "Encode");
    }


    public static String decrypt(String text,int key)
    {
        StringBuilder decrypted=new StringBuilder();
        for(char c:text.toCharArray())
        {
            int index= CryptoAlphabet.ALPHABET.indexOf(c);
            if(index!=-1)
            {
                index=(index-key+CryptoAlphabet.ALPHABET.length())%CryptoAlphabet.ALPHABET.length();

                decrypted.append(CryptoAlphabet.ALPHABET.charAt(index));
            }
            else {
                decrypted.append(c);
            }
        }
        return decrypted.toString();
    }
}
