package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
            MainApp.class.getResource("/form-bmi.fxml")
        );

        Scene scene = new Scene(loader.load());

        stage.setTitle("Aplikasi Kalkulator BMI");
        stage.setScene(scene);
        stage.setWidth(480);
        stage.setHeight(620);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}