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
public class SpilController implements Initializable {

    @FXML
    public Button malsatningFortrydKnap; 
    @FXML
    public Button udfordringFortrydKnap;
    @FXML
    public Button udfordringTilbageKnap; 
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleFortrydMalsatning() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) malsatningFortrydKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML
    public void handleFortrydUdfordring() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) udfordringFortrydKnap.getScene().getWindow();
        stage = (Stage) udfordringTilbageKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
}
