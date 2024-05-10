package org.example.CryptoAnalizer.services;

import org.example.CryptoAnalizer.Entity.Result;
import org.example.CryptoAnalizer.Exception.ApplicationException;
import org.example.CryptoAnalizer.constants.CryptoAlphabet;
import org.example.CryptoAnalizer.repository.ResultCode;

import java.io.*;

public class Decode implements Function{
    private String defaultPathForRead="D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\encrypt.txt";

    private String defaultPathForWrite="D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\decrypt.txt";
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
