package org.example.CryptoAnalizer;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.example.CryptoAnalizer.Entity.Result;
import org.example.CryptoAnalizer.app.Application;
import org.example.CryptoAnalizer.controller.HelloController;
import org.example.CryptoAnalizer.controller.MainController;
import org.example.CryptoAnalizer.view.ConsoleView;
import org.example.CryptoAnalizer.view.GUIView;
import org.example.CryptoAnalizer.view.View;

import java.io.IOException;
import java.util.Scanner;


public class Main  extends javafx.application.Application{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите тип приложения:");
        System.out.println("1. Консольное приложение");
        System.out.println("2. JavaFX приложение");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                View view=new ConsoleView();
            MainController mainController=new MainController(view);
            Application application=new Application(mainController);
            Result result=application.run();
            application.printResult(result);
                break;
            case 2:
               launch();

                break;
            default:
                System.out.println("Неправильный выбор.");
        }

    }
    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle("Криптоанализатор");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
