package com.example.sudokugame;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    public void closeBtnClick()
    {
        Platform.exit();
    }

    @FXML
    public void NewGameButton(ActionEvent event) throws IOException
    {
        Parent root = FXMLLoader.load(getClass().getResource("GamePage.fxml"));
        Scene scene = new Scene(root , 504, 346);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public static void linktextboxescells(Board B)
    {
        for(int i=1;i<10;i++)
        {
    //        B.setCellValue(txt2[i],txt2[i].Text);
      //      B.setCellValue(txt2[i],txt2[i].Text);
      //      B.setCellValue(txt2[i],txt2[i].Text);
      //      B.setCellValue(txt2[i],txt2[i].Text);
      //      B.setCellValue(txt2[i],txt2[i].Text);
      //      B.setCellValue(txt2[i],txt2[i].Text);
      //      B.setCellValue(txt2[i],txt2[i].Text);
      //      B.setCellValue(txt2[i],txt2[i].Text);
      //      B.setCellValue(txt2[i],txt2[i].Text);
       //     B.setCellValue(txt2[i],txt2[i].Text);
            // whenever textbox value is clicked it sets its value

        }
    }

    public void InputMethodTextChangeEvent(KeyEvent event) {
        TextField textField = (TextField) event.getSource();
        String textFieldName = textField.getId();
        System.out.println("Event fired from " + textFieldName);
    }
}
