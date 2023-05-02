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


// This is the controller class of the main page
public class GamePageController {

    //Initializing Score and Lives
    public int score=0;
    public int lives=3;

    // Initializing buttons and textboxes to be used that are in UI.
    @FXML
    public Button closeBtn;
    @FXML
    public TextField scoreTxt;
    @FXML
    public TextField livesTxt;
    @FXML
    public TextField txt13;

    @FXML
    public TextField txt14;

    @FXML
    public TextField txt18;

    @FXML
    public TextField txt19;
    @FXML
    public TextField txt22;
    @FXML
    public TextField txt23;
    @FXML
    public  TextField txt25;
    @FXML
    public TextField txt35;
    @FXML
    public TextField txt36;

    @FXML
    public TextField txt37;

    @FXML
    public TextField txt41;

    @FXML
    public TextField txt46;

    @FXML
    public TextField txt49;

    @FXML
    public TextField txt91;

    @FXML
    public TextField txt94;

    @FXML
    public TextField txt98;

    @FXML
    public TextField txt81;

    @FXML
    public TextField txt82;

    @FXML
    public TextField txt89;

    @FXML
    public TextField txt75;

    @FXML
    public TextField txt76;

    @FXML
    public TextField txt77;

    @FXML
    public TextField txt52;

    @FXML
    public TextField txt58;

    @FXML
    public TextField txt64;

    @FXML
    public TextField txt66;

    @FXML
    public TextField txt67;


    // This function is fired whenever Close Button is Clicked. This Function closes the game
    @FXML
    public void closeBtnClick()
    {
        Platform.exit();
    }


    // This function re-starts the game and this function is fired whenever new game button
    // is clicked.
    @FXML
    public void NewGameButton(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
        Scene scene = new Scene(root , 504, 346);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }


    // This function will be called whenever text in textbox changes
    public void InputMethodTextChangeEvent(KeyEvent event) {
        TextField textField = (TextField) event.getSource();
        String textFieldName = textField.getId();
        String value = textField.getText();
        String allowedValues = "123456789";

        // If the value in text box is not valid this if condition will run and give an alert
        if (!allowedValues.contains(value) || value.length()>1) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Alert");
            alert.setHeaderText(null);
            alert.setContentText("You can't enter alphabets, multiple values and value greate then 9 and less then 1");
            alert.showAndWait();
            textField.clear();
        }
        // If the value is valid then else condition will run
        else {
            int intValue = Integer.parseInt(value);

            // If the entered Value is valid

            if(HelloApplication.SetValue(textFieldName,intValue)){
                // If answer is correct
                textField.setStyle("-fx-text-fill: blue;");
                score = score + 10;
                scoreTxt.setText(String.valueOf(score));
                if(HelloApplication.checkWinning())
                {
                    // Generates an alert that you win the game
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Result");
                    alert.setHeaderText("You Won");
                    alert.setContentText("Your score is "+ scoreTxt.getText());
                    alert.showAndWait();
                    Platform.exit();
                }
            }
            // If the entered value is Invalid
            else{
                textField.setStyle("-fx-text-fill: red;");
                lives = lives - 1;
                livesTxt.setText(String.valueOf(lives));

                // Losing Condition
                if(lives == 0)
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Game Over");
                    alert.setHeaderText("Game Over");
                    alert.setContentText("Your score is "+ scoreTxt.getText());
                    alert.showAndWait();
                    Platform.exit();
                }
            }
        }
    }

    // This function will be called when click on Initialize Button. Its populates the maze with some value.
    public void InitilizedatainTextFields(ActionEvent actionEvent) {
        txt13.setText("5");
        HelloApplication.SetValue("txt13",5);
        txt14.setText("7");
        HelloApplication.SetValue("txt14",7);
        txt18.setText("9");
        HelloApplication.SetValue("txt18",9);
        txt19.setText("8");
        HelloApplication.SetValue("txt19",8);
        txt22.setText("1");
        HelloApplication.SetValue("txt22",1);
        txt23.setText("6");
        HelloApplication.SetValue("txt23",6);
        txt25.setText("9");
        HelloApplication.SetValue("txt25",9);
        txt35.setText("8");
        HelloApplication.SetValue("txt35",8);
        txt36.setText("3");
        HelloApplication.SetValue("txt36",3);
        txt37.setText("5");
        HelloApplication.SetValue("txt37",5);
        txt41.setText("7");
        HelloApplication.SetValue("txt41",7);
        txt46.setText("9");
        HelloApplication.SetValue("txt46",9);
        txt49.setText("3");
        HelloApplication.SetValue("txt49",3);
        txt91.setText("2");
        HelloApplication.SetValue("txt91",2);
        txt94.setText("8");
        HelloApplication.SetValue("txt94",8);
        txt98.setText("7");
        HelloApplication.SetValue("txt98",7);
        txt81.setText("3");
        HelloApplication.SetValue("txt81",3);
        txt82.setText("5");
        HelloApplication.SetValue("txt82",5);
        txt89.setText("6");
        HelloApplication.SetValue("txt89",6);
        txt75.setText("1");
        HelloApplication.SetValue("txt75",1);
        txt76.setText("2");
        HelloApplication.SetValue("txt76",2);
        txt77.setText("4");
        HelloApplication.SetValue("txt77",4);
        txt52.setText("6");
        HelloApplication.SetValue("txt52",6);
        txt58.setText("1");
        HelloApplication.SetValue("txt58",1);
        txt64.setText("5");
        HelloApplication.SetValue("txt64",5);
        txt66.setText("4");
        HelloApplication.SetValue("txt66",4);
        txt67.setText("2");
        HelloApplication.SetValue("txt67",2);



        livesTxt.setText("3");
        scoreTxt.setText("0");

    }
}
