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
public class MenuForaldreController implements Initializable {
    
    @FXML
    public Button kostRegistreringKnap;
    
    @FXML
    public Button isoBmiKnap;
    
    @FXML
    public Button vejledningKnap;
    
    @FXML
    public Button foraldreLogUdKnap;
    
    @FXML
    public Button vejledningTilbageKnap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleForaldreLogUd() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) foraldreLogUdKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
//    @FXML
//    private void handleForaldreLogUd(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
//        if(event.getSource() == foraldreLogUdKnap){
//            stage = (Stage) foraldreLogUdKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
//        } else {
//            stage = (Stage) foraldreLogUdKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show(); 
//    }
    
    @FXML
    public void handleVejledning() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) vejledningKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/VejledningView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
//    @FXML
//    private void handleVejledning(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
//        if(event.getSource() == vejledningKnap){
//            stage = (Stage) vejledningKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/VejledningView.fxml"));
//        } 
//        else {
//            stage = (Stage) vejledningTilbageKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show(); 
//    }
    
    
    @FXML
    public void handleKostRegistrering() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) kostRegistreringKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/KostRegistreringView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
//    @FXML
//    private void handleKostRegistrering(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
//        if(event.getSource() == kostRegistreringKnap){
//            stage = (Stage) kostRegistreringKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/KostRegistreringView.fxml"));
//        } else {
//            stage = (Stage) kostRegistreringKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/KostRegistreringView.fxml"));
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show(); 
//    }
    
    @FXML
    public void handleIsoBmi() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) isoBmiKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/IsoBmiView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
//    @FXML
//    private void handleIsoBmi(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
//        if(event.getSource() == isoBmiKnap){
//            stage = (Stage) isoBmiKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/IsoBmiView.fxml"));
//        } else {
//            stage = (Stage) isoBmiKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/IsoBmiView.fxml"));
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show(); 
//    }
    
    @FXML
    public void handleVejledningTilbage() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) vejledningTilbageKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
}
