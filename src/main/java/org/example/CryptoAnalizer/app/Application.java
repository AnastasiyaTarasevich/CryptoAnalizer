package org.example.CryptoAnalizer.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.CryptoAnalizer.Entity.Result;
import org.example.CryptoAnalizer.Main;
import org.example.CryptoAnalizer.controller.HelloController;
import org.example.CryptoAnalizer.controller.MainController;
import org.example.CryptoAnalizer.repository.FunctionCode;
import org.example.CryptoAnalizer.repository.ResultCode;
import org.example.CryptoAnalizer.services.Function;
import org.example.CryptoAnalizer.constants.FunctionCodeConstants;

import java.io.IOException;


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
            case "1"-> FunctionCode.valueOf(FunctionCodeConstants.ENCODE).getFunction();
            case "2"-> FunctionCode.valueOf(FunctionCodeConstants.DECODE).getFunction();
            case "3"-> FunctionCode.valueOf(FunctionCodeConstants.BRUTE_FORCE).getFunction();
            case "4"-> FunctionCode.valueOf(FunctionCodeConstants.EXIT).getFunction();
            default -> FunctionCode.valueOf(FunctionCodeConstants.UNSUPPORTED_FUNCTION).getFunction();


        };
    }
    public void printResult(Result result)
    {
        mainController.getView().printResults(result);
    }

}
