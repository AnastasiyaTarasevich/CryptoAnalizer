package org.example.CryptoAnalizer.view;

import javafx.application.Application;
import org.example.CryptoAnalizer.Entity.Result;
import org.example.CryptoAnalizer.Main;

public class GUIView implements View{
    @Override
    public String[] getParameters() {
        return new String[0];
    }

    @Override
    public void printResults(Result result) {
        Application.launch(String.valueOf(Main.class));
    }
}
