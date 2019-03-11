package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import model.vModel;

public class ViSolPane extends VBox {

    public ViSolPane(vModel model){
        super();

        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setFont(new Font("Courier New", 40));
        textArea.setText(model.getData());
        textArea.setEditable(false);
        textArea.setPrefHeight(Integer.MAX_VALUE);

        model.addObserver((x,y) -> textArea.setText(((vModel)x).getData()));

        TextField keyField = new TextField();

        keyField.setOnAction((x) -> {
            try {
                model.solve(x.toString());
            } catch (Exception e){
                createExceptionDialog(e);
            }
        });

        keyField.setPrefSize(200, 30);
        keyField.setMaxSize(200, 30);
        keyField.setFont(new Font("Courier New", 20));

        Button confirmButton = new Button("Confirm");
        confirmButton.setOnAction((x) -> keyField.getOnAction());

        VBox buttonBox = new VBox(keyField, confirmButton);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(20);
        buttonBox.setPrefHeight(100);
        buttonBox.setPadding(new Insets(20, 20, 20, 20));

        getChildren().addAll(textArea, buttonBox);
    }

    private void createExceptionDialog(Exception e){
        String message = "";
        if(e instanceof NumberFormatException){
            message = "Please enter a number!";
        }


        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText(e.getClass().getSimpleName());
        alert.setContentText(message);

        alert.showAndWait();
    }

}
