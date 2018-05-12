/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leifversion2;

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
public class MenuController implements Initializable {

    @FXML Button opretKontoKnap;
    @FXML Button opretKontoFortrydKnap;
    @FXML Button personOverviewKnap;
    @FXML Button overviewPersonFortrydKnap;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    @FXML
    private void handleOpretKonto() throws IOException {
        Stage stage;
        Parent root;           
        stage = (Stage) opretKontoKnap.getScene().getWindow();            
        root = FXMLLoader.load(getClass().getResource("AddPerson.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
    @FXML
    private void handlePersonOverview(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) personOverviewKnap.getScene().getWindow();            
        root = FXMLLoader.load(getClass().getResource("PersonOverview.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show(); 
    }
    
}
