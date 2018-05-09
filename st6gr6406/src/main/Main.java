/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.StartController;
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
import model.StartModel;


/**
 *
 * @author 18gr6406
 */
public class Main extends Application{
    
    
    private Stage primaryStage;
    private AnchorPane rootLayout;
    
    /**
     * Her oprettes en observableList navngivet familieDate, som indeholder konti fra StartModel
     */
    private ObservableList<StartModel> familieData = FXCollections.observableArrayList();
    
    public Main(){
        familieData.add(new StartModel("131191-1234","adgangskodeTest", true));
        
    }
    
    public ObservableList<StartModel> getFamilieData() {
        return familieData;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Start();
    }
    
     public static void main(String[] args) {
        launch(args);
    }

    public void Start() {
        try{
            //Her loades rootlayout fra fxml-fil. 
            //Vore rootLayout er StartView, da dette er det nederste/bagerste view, man kan komme til
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/StartView.fxml"));
            rootLayout = (AnchorPane) loader.load();
            
            
            // Vi opretter nu en scene, der indeholder rootLayout
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            
            // Her giver vi controlleren adgang til Main
            StartController controller = loader.getController();
            controller.setMain(this);
            primaryStage.show();
            
        }
        catch(Exception e){
            System.out.println("Fejlmedelelse!");
        }
    }
     
}


  
