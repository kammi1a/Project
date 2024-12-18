package com.example.exemination_meka_true;

import com.example.exemination_meka_true.util.DatabaseInitializer;
import com.example.exemination_meka_true.util.DatabaseSeeder;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/exemination_meka_true/view/login.fxml"));
        primaryStage.setTitle("Examination System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        
        DatabaseInitializer.initDatabase();
        DatabaseSeeder.seedDatabase();

        
        launch(args);
        System.out.println("Application started successfully!");
    }
}
