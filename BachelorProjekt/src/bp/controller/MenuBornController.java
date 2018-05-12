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
public class MenuBornController implements Initializable {

    @FXML 
    public Button udfordringKnap; 
    
    @FXML 
    public Button malsatningKnap; 
    
    @FXML 
    public Button bornLogUdKnap; 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleBornLogUd() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) bornLogUdKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
//    @FXML
//    private void handleBornLogUd(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
//        if(event.getSource() == bornLogUdKnap){
//            stage = (Stage) bornLogUdKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
//        } else {
//            stage = (Stage) bornLogUdKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show(); 
//    }
    
    @FXML
    public void handleMalsatning() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) malsatningKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MalsatningView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
//    @FXML
//    private void handleMalsatning(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
//        if(event.getSource() == malsatningKnap){
//            stage = (Stage) malsatningKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/MalsatningView.fxml"));
//        } else {
//            stage = (Stage) malsatningKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/MalsatningView.fxml"));
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show(); 
//    }
    
    @FXML
    public void handleUdfordring() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) udfordringKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/UdfordringView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
//    @FXML
//    private void handleUdfordring(ActionEvent event) throws IOException {
//        Stage stage;
//        Parent root;
//        if(event.getSource() == udfordringKnap){
//            stage = (Stage) udfordringKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/UdfordringView.fxml"));
//        } else {
//            stage = (Stage) udfordringKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/UdfordringView.fxml"));
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show(); 
//    }
    
}
