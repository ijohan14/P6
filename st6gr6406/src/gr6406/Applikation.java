/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr6406;

import gr6406.controller.StartController;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import gr6406.model.ForaldreModel;


/**
 *
 * @author 18gr6406
 */
public class Applikation extends Application{
    
    
    //public Stage primaryStage;
    //private Parent start;
    
    /**
     * Her oprettes en observableList navngivet familieDate, som indeholder konti fra StartModel
     */
    private ObservableList<ForaldreModel> familieData = FXCollections.observableArrayList();
    
    public Applikation(){
        familieData.add(new ForaldreModel("131191-1234","adgangskodeTest", true));
        
    }
    
    public ObservableList<ForaldreModel> getFamilieData() {
        return familieData;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //this.primaryStage = primaryStage;
        
        //open("view/StartView.fxml");
        
        Parent root = FXMLLoader.load(getClass().getResource("view/StartView.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
       
    }
    
     public static void main(String[] args) {
        launch(args);
    }

   /**
    * global metode, der kan bruges til at åbne et nyt view.
    * @param stiView
    * @return
    * @throws Exception 
    *
    
     public Parent open(String stiView) throws Exception {
       
            start = (Parent) FXMLLoader.load(getClass().getResource(stiView));
            Scene scene = primaryStage.getScene();
            if (scene == null) {
                scene = new Scene(start);
                primaryStage.setScene(scene);
            } else {
                primaryStage.getScene().setRoot(start);
            }
            primaryStage.show();
            primaryStage.sizeToScene();
            return start;
            
        }*/
     
     
      /* 
    public void Start() {
        try{
            FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("view/StartView.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        StartController controller = loader.getController();
        controller.setMain(this);
        
        primaryStage.setTitle("FUN HEALTH");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
            
        }
        catch(Exception e){
            System.out.println("Fejlmedelelse!");
        }
    }*/
     
     
     
}


  
