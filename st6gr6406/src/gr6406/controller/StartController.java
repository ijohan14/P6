/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr6406.controller;

import gr6406.Applikation;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import static javafx.scene.input.DataFormat.URL;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


/**
 *
 * @author Gruppe 18gr6406
 */
public class StartController {//implements Initializable {
    private Applikation main;
    
    
    
    private Stage stage;
    
//    public void initialize(URL location){
//        
//    } 
   
    
  
    /**
     * @param main  
     */
    public void setMain(Applikation main) {
        this.main = main;
    }
    
    
     /**
     * Returns true if the user clicked OK, false otherwise.
     * 
     * @return
     *
    public boolean isOkClicked() {
        return okClicked;
    }*/
    /**
     * 
     */
    @FXML
    private void handleOpretNyKontoKnap() throws IOException{
       //FXMLLoader loader = new FXMLLoader();
      /* AnchorPane opret = (AnchorPane) FXMLLoader.load(getClass().getResource("/gr6406/view/OpretNyKontoView.fxml"));
       Scene scene = new Scene(opret);
       stage.setScene(scene);   */
       
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/gr6406/view/OpretNyKontoView.fxml"));
        AnchorPane opret = (AnchorPane) loader.load();
        Scene scene = new Scene(opret);
        stage.setScene(scene);
        stage.show();

             // Set person overview into the center of root layout.
            //start.setCenter(opret);

            // Give the controller access to the main app.
        KontoController controller = loader.getController();
            //(this);
      
      
    }
    
    private void handleLoginKnap() {
        
    }
    
    private boolean erInputValid(){
        return false;
    }

   
    
}
