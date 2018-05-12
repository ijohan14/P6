/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stupidprojectbecauseleif;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author christinemariegrabow
 */
public class MainChoiceBox extends Application{
    @Override
    public void start(Stage primaryStage) throws IOException{
        Parent parent = FXMLLoader.load(geClass().getResource("/stupidprojectbecauseleif/viewchoicebox.fxml"));
        Scene scene = new Scene(parent);
        primaryStage.setScene(scene); 
        primaryStage.show();
    }
    
    public static void main(String[] args){
        launch(args);
    }
}
