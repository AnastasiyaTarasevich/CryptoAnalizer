package com.javarush.task.jdk13.task53.task5307.app;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;
import com.javarush.task.jdk13.task53.task5307.controller.MainController;
import com.javarush.task.jdk13.task53.task5307.repository.FunctionCode;
import com.javarush.task.jdk13.task53.task5307.repository.ResultCode;
import com.javarush.task.jdk13.task53.task5307.services.Function;

import static com.javarush.task.jdk13.task53.task5307.constants.FunctionCodeConstants.*;

public class Application {
    private final MainController mainController;
    public Application(MainController mainController){
        this.mainController=mainController;
    }

    public Result run()
    {
        String []parameters=mainController.getView().getParameters();
        String mode = parameters[0];
        Function function=getFunction(mode);
        Result result = function.execute(parameters);
        //FIXME рекурсия???
        if (result.getResultCode() == ResultCode.OK) {
            run();
        }
        return result;
    }
    private Function getFunction(String mode)
    {
        return switch (mode)
        {
            case "1"-> FunctionCode.valueOf(ENCODE).getFunction();
            case "2"-> FunctionCode.valueOf(DECODE).getFunction();
            case "3"-> FunctionCode.valueOf(BRUTE_FORCE).getFunction();
            case "4"-> FunctionCode.valueOf(EXIT).getFunction();
            default -> FunctionCode.valueOf(UNSUPPORTED_FUNCTION).getFunction();


        };
    }
    public void printResult(Result result)
    {
        mainController.getView().printResults(result);
    }
}
