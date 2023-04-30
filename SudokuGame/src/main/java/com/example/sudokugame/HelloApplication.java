package com.example.sudokugame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    public static Board B = new Board();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Sudoku Game!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
       // GamePageController.linktextboxescells(B);
    }



   public static boolean SetValue(String TextFieldName, int Value)
   {
       int[] value = B.setCellValue(TextFieldName, Value);
       if(B.CheckRows(value[0],value[1]) && B.CheckColumns(value[0],value[1]) && B.ChecksubGrid(value[0],value[1]))
       {
            return true;
       }
       else
       {
            return false;
       }

   }

    public static boolean checkWinning()
    {
        if(B.checkWinningCondition())
        {
            return true;
        }
        return false;
    }


}