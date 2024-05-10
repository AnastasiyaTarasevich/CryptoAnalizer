package org.example.CryptoAnalizer.view;



import org.example.CryptoAnalizer.Entity.Result;
import org.example.CryptoAnalizer.constants.ApplicationCompletionConstants;

import java.util.Scanner;


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
            case OK -> System.out.println(ApplicationCompletionConstants.SUCCESS+result.getMessage());
            case ERROR -> System.out.println(ApplicationCompletionConstants.EXCEPTION+result.getApplicationException().getMessage());
        }
    }
}
