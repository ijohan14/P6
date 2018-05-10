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
 * @author nathalie
 */
public class KontoController implements Initializable {
    @FXML
    private Button OpretKontoKnap;
    
    @FXML
    private Button OpretKontoFortrydKnap;
            
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
    @FXML
    private void handleOpretKonto(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource() == OpretKontoKnap){
            stage = (Stage) OpretKontoKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/OpretKontoView.fxml"));
        } else {
            stage = (Stage) OpretKontoFortrydKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
            
    }
    
}
