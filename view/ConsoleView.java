package com.javarush.task.jdk13.task53.task5307.view;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;

import java.util.Scanner;

import static com.javarush.task.jdk13.task53.task5307.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.task.jdk13.task53.task5307.constants.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View{
    @Override
    public String[] getParameters() {
        String parameter;
        printMenu();
        Scanner scanner = new Scanner(System.in);
        parameter = scanner.nextLine();
        return new String[]{parameter};
    }

    private void printMenu()
    {
        System.out.println("Выберите пункт меню");
        System.out.println("1. Зашифровать файл");
        System.out.println("2. Расшифровать файл");
        System.out.println("3. Расшифровать файл подбором");
        System.out.println("4. Выйти из приложения");
    }

    @Override
    public void printResults(Result result) {
        switch(result.getResultCode())
        {
            case OK -> System.out.println(SUCCESS+result.getMessage());
            case ERROR -> System.out.println(EXCEPTION+result.getApplicationException().getMessage());
        }
    }
}
