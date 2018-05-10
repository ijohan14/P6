/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr6406.controller;

import gr6406.Applikation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class StartController implements Initializable {
    //private Applikation main;
    //private Stage stage;
    
    @FXML
    private Button OpretNyKontoKnap;
    
    @FXML
    private Button OpretNyKontoFortryd;
    
    
    /** 
     * Initialize the control class
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        
    } 
   
    
  
    /**
     * @param main  
     *
    public void setMain(Applikation main) {
        this.main = main;
    }*/
    
    
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
    private void handleOpretNyKontoKnap(ActionEvent event) throws IOException{
        Stage stage;
        Parent root;
        if (event.getSource() == OpretNyKontoKnap){
            stage = (Stage) OpretNyKontoKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/gr6406/view/OpretNyKontoView.fxml."));
        } else {
            stage = (Stage) OpretNyKontoFortryd.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/gr6406/view/StartView.fxml."));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
                
      
    }
    /*
    private void handleLoginKnap() {
        
    }
    
    private boolean erInputValid(){
        return false;
    }*/

   
    
}
