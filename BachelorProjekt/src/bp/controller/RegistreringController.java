/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author christinemariegrabow
 */
public class RegistreringController implements Initializable {

    @FXML
    public Button kostRegistreringGemKnap;
    
    @FXML
    public Button kostRegistreringFortrydKnap;
    
    @FXML
    public Button isoBmiGemKnap;
    
    @FXML
    public Button isoBmiFortrydKnap;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleFortrydKostRegistrering(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource() == kostRegistreringFortrydKnap){
            stage = (Stage) kostRegistreringFortrydKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
        } 
        else {
            stage = (Stage) kostRegistreringFortrydKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
    @FXML
    private void handleFortrydIsoBmi(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource() == isoBmiFortrydKnap){
            stage = (Stage) isoBmiFortrydKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
        } 
        else {
            stage = (Stage) isoBmiFortrydKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
}
