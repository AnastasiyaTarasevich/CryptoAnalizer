package com.javarush.task.jdk13.task53.task5307.services;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;

public class Exit implements Function{
    @Override
    public Result execute(String[] parameters) {
        System.out.println("Завершение программы...");
        System.exit(0);
        return null;
    }
}
