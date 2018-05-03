/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.OpretKontoModel;

/**
 *
 * @author nathalie
 */
public class Main extends Application{
    
    private ObservableList<OpretKontoModel> familieData = FXCollections.observableArrayList();
    private Stage primaryStage;

    public Main(){
        familieData.add(new OpretKontoModel("Trine"));
        familieData.forEach((o) -> {
            System.out.println(o.toString());
        });
    }

    @Override
    public void start(Stage primaryStage) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
    
    
}
