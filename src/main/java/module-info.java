module org.example.CryptoAnalizer {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.example.CryptoAnalizer to javafx.fxml;
    opens org.example.CryptoAnalizer.controller to javafx.fxml;

    exports org.example.CryptoAnalizer;
}
