package org.example.CryptoAnalizer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import org.example.CryptoAnalizer.services.BruteForce;
import org.example.CryptoAnalizer.services.Decode;
import org.example.CryptoAnalizer.services.Encode;
import org.example.CryptoAnalizer.services.Reading_Writing;
import org.example.CryptoAnalizer.view.View;

import java.io.File;
import java.io.IOException;

public class HelloController {
    Reading_Writing readingWriting;

    @FXML
    private Label welcomeText;

    @FXML
    private ComboBox<String> modeComboBox;

    @FXML
    private Label referenceFileLabel;
    @FXML
    private TextField referenceFilePathTextField;

    @FXML
    private TextField FilePathTextField;
    @FXML
    private Button browseReferenceButton;

    @FXML
    private TextField keyTextField;
    @FXML
    private TextArea outputTextArea;


    @FXML
    private void handleModeChange(ActionEvent event) {
        String mode = modeComboBox.getSelectionModel().getSelectedItem();
        switch (mode) {
            case "Шифрование":
                FilePathTextField.setText("D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\text.txt");
                break;
            case "Расшифровка":
                FilePathTextField.setText("D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\encrypt.txt");
                break;
            case "Brute Force":
                FilePathTextField.setText("D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\encrypt.txt");
                referenceFileLabel.setVisible(true);
                referenceFilePathTextField.setVisible(true);
                browseReferenceButton.setVisible(true);
                referenceFilePathTextField.setText("D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\reference.txt");
                break;
            default:
                referenceFileLabel.setVisible(false);
                referenceFilePathTextField.setVisible(false);
                browseReferenceButton.setVisible(false);
                break;
        }
    }

    @FXML
    private void handleBrowseAction(ActionEvent event) {
        selectFile(FilePathTextField);
    }

    @FXML
    private void handleBrowseReferenceAction(ActionEvent event) {
        selectFile(referenceFilePathTextField);
    }


    @FXML
    private void execute(ActionEvent event) throws IOException {
        String mode = modeComboBox.getSelectionModel().getSelectedItem();
        String filePath = FilePathTextField.getText();
        int key=Integer.parseInt(keyTextField.getText());
        String text = Reading_Writing.readFile(filePath);

        Encode encode=new Encode();
        Decode decode=new Decode();
        BruteForce bruteForce=new BruteForce();
        switch (mode)
        {
            case "Шифрование":
                String encryptedText = encode.encrypt(text, key);
                outputTextArea.setText("Исходный текст: " + text + "\n\nЗашифрованный:\n" + encryptedText);
                String path="D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\encrypt.txt";
               Reading_Writing.writeToFile(path,encryptedText);
                break;
            case "Расшифровка":
                String decryptedText = decode.decrypt(text, key);
                outputTextArea.setText("Исходный текст: " + text + "\n\nРасшифрованный:\n" + decryptedText);
                String path1="D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\decrypt.txt";
                Reading_Writing.writeToFile(path1,decryptedText);
                break;
            case "Brute Force":
                String filePathForReference = referenceFilePathTextField.getText();
                String ReferenceText = Reading_Writing.readFile(filePathForReference);
                String decryptedBrute_Force=bruteForce.decryptBruteForce(text,ReferenceText);
                outputTextArea.setText("Исходный текст: " + text + "\n\nРасшифрованный:\n" + decryptedBrute_Force);
                String path2="D:\\cryptoAnalizer\\src\\main\\java\\org\\example\\CryptoAnalizer\\myFiles\\brute_force.txt";
                Reading_Writing.writeToFile(path2, decryptedBrute_Force);


        }
    }
    @FXML
    private void clear(ActionEvent event) {
        FilePathTextField.clear();
        outputTextArea.clear();
        keyTextField.clear();
        referenceFilePathTextField.clear();
    }
    private void selectFile(TextField textField) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Выберите файл");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Выбор файла", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(textField.getScene().getWindow());
        if (selectedFile != null) {
            textField.setText(selectedFile.getAbsolutePath());
        }
    }


}
