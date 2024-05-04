package com.javarush.task.jdk13.task53.task5307.view;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;

import static com.javarush.task.jdk13.task53.task5307.constants.ApplicationCompletionConstants.EXCEPTION;
import static com.javarush.task.jdk13.task53.task5307.constants.ApplicationCompletionConstants.SUCCESS;

public class ConsoleView implements View{
    @Override
    public String[] getParameters() {
        return new String[0];
    }

    @Override
    public void printResults(Result result) {
        switch(result.getResultCode())
        {
            case OK -> System.out.println(SUCCESS);
            case ERROR -> System.out.println(EXCEPTION+result.getApplicationException().getMessage());
        }
    }
}
