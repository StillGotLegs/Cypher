package se.dennisj.gui;

import java.nio.file.Files;
import java.nio.file.Paths;

import se.dennisj.model.vModel;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ViSol extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileChooser fs = new FileChooser();
        String data = new String(Files.readAllBytes(Paths.get(fs.showOpenDialog(primaryStage).getAbsolutePath())));

        primaryStage.setScene(new Scene(new ViSolPane(new vModel(data)), 700,700));
        primaryStage.setTitle("Vigerne Solver");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

