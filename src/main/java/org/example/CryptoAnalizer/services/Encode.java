package org.example.CryptoAnalizer.services;

import org.example.CryptoAnalizer.Entity.Result;
import org.example.CryptoAnalizer.Exception.ApplicationException;
import org.example.CryptoAnalizer.constants.CryptoAlphabet;
import org.example.CryptoAnalizer.repository.ResultCode;

import java.io.*;

public class Encode implements Function {
    private String defaultPathForRead="D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\text.txt";

    private String defaultPathForWrite="D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\encrypt.txt";
    @Override
    public Result execute(String[] parameters) {

        String filePath = Reading_Writing.getFilePath(defaultPathForRead);
        int number = Reading_Writing.getKey();
        try {
            String text = Reading_Writing.readFile(filePath);
            System.out.println("Незашифрованный текст: " + text);
            String encryptedText = encrypt(text, number);
            System.out.println("Зашифрованный текст: " + encryptedText);
            String fileForEncrypt= Reading_Writing.getFilePath(defaultPathForWrite);
            Reading_Writing.writeToFile(fileForEncrypt, encryptedText);
        } catch (IOException e) {
            throw new ApplicationException("Файла не существует", e);
        }
        return new Result(ResultCode.OK, "Encode");
    }

    public String encrypt(String text, int key)
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
