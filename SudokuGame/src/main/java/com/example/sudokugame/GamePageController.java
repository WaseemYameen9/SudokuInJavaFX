package com.example.sudokugame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class GamePageController {
    @FXML
    public Button closeBtn;
    @FXML
    public TextField txt11;

    @FXML
    public TextField txt22;

    @FXML
    public TextField txt33;

    @FXML
    public TextField txt44;
    @FXML
    public TextField txt55;
    @FXML
    public TextField txt66;
    @FXML
    public  TextField txt77;
    @FXML
    public TextField txt88;
    @FXML
    public TextField txt99;


    @FXML
    public void closeBtnClick()
    {
        Platform.exit();
    }

    //@FXML
    //public void initialize() {
    //    Board board = new Board();
    //    InitilizedatainTextFields();
    //}
    @FXML
    public void NewGameButton(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
        Scene scene = new Scene(root , 504, 346);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    public static void InitilizedatainTextFields()
    {


    }

    public void InputMethodTextChangeEvent(KeyEvent event) {
        TextField textField = (TextField) event.getSource();
        String textFieldName = textField.getId();
        String value = textField.getText();
        String allowedValues = "123456789";
        if (!allowedValues.contains(value) || value.length()>1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("You can't enter alphabets, multiple values and value greate then 9 and less then 1");
            alert.showAndWait();
            textField.clear();
        }
        else {
            int intValue = Integer.parseInt(value);
            if(HelloApplication.SetValue(textFieldName,intValue)){
                textField.setStyle("-fx-text-fill: blue;");
            }
            else{
                textField.setStyle("-fx-text-fill: red;");

            }
        }
    }

    public void InitilizedatainTextFields(ActionEvent actionEvent) {
        txt11.setText("1");
        txt22.setText("2");
        txt33.setText("3");
        txt44.setText("4");
        txt55.setText("5");
        txt66.setText("6");
        txt77.setText("7");
        txt88.setText("8");
        txt99.setText("9");

    }
}
