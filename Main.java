package com.javarush.task.jdk13.task53.task5307;

import com.javarush.task.jdk13.task53.task5307.Entity.Result;
import com.javarush.task.jdk13.task53.task5307.app.Application;
import com.javarush.task.jdk13.task53.task5307.controller.MainController;
import com.javarush.task.jdk13.task53.task5307.view.ConsoleView;
import com.javarush.task.jdk13.task53.task5307.view.View;

public class Main {
    public static void main(String[] args) {
        View view=new ConsoleView();
        MainController mainController=new MainController(view);
        Application application=new Application(mainController);
        Result result=application.run();
        application.printResult(result);
    }
}
