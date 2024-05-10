package org.example.CryptoAnalizer.services;

import org.example.CryptoAnalizer.Entity.Result;

public class Exit implements Function{
    @Override
    public Result execute(String[] parameters) {
        System.out.println("Завершение программы...");
        System.exit(0);
        return null;
    }
}
