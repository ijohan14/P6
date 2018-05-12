/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leifversion2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import leifversion2.PersonOverviewController;

/**
 *
 * @author nathalie
 */
public class AddPersonController {//implements Initializable{

    @FXML Button addPersonGemKnap;
    @FXML Button opretKontoFortrydKnap;
    @FXML TextField fornavnFelt;
    @FXML TextField efternavnFelt;
    
    private Person person;
    //ObservableList<Person> personData = new PersonOverviewController().getContent();
    ObservableList<Person> personData = FXCollections.observableArrayList();
    
    public ObservableList<Person> getContent() {        
        personData.add(new Person("Nathalie", "Trane"));
        personData.add(new Person("Christine", "Grabow")); // your data
        return personData;
    }
    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//    }
    
    @FXML
    private void handleOpretKontoFortryd() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @FXML
    private void handleAddPersonGem() throws IOException {
        Stage stage;
        Parent root;
        if(isInputValid()){
           //personData.add(new Person(fornavnFelt.getText(),efternavnFelt.getText()));
            personData.add(new Person("j","je"));
            System.out.println(personData.get(0).toString());
           System.out.println("Fornavn: "+fornavnFelt.getText()+"\nEfternavn: "+efternavnFelt.getText());
        }
        stage = (Stage) addPersonGemKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("PersonOverview.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }

    private boolean isInputValid() {
        String errorMessage = "";
        
        if (fornavnFelt.getText() == null || fornavnFelt.getText().length() == 0) {
            errorMessage += "Intet valid fornavn!\n"; 
        }
        if (efternavnFelt.getText() == null || efternavnFelt.getText().length() == 0) {
            errorMessage += "Intet valid efternavn!\n"; 
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            System.out.println(errorMessage);
            return false;
        }
    }
    
    
    
}
    
