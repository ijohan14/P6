/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;

import bp.model.ForaldreModel;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.M;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nathalie
 */
public class KontoController implements Initializable {
    
    private ForaldreModel konto;
    
    ObservableList<String> brugertypeList = FXCollections.observableArrayList("Barn", "Forælder");
    private ObservableList<ForaldreModel> familieData = FXCollections.observableArrayList();
    
    
    @FXML
    private Button opretKontoKnap;
    
    @FXML
    private Button opretKontoFortrydKnap;
    
    @FXML
    private Button opretKontoGemKnap;
    
    @FXML
    private TextField fornavnFelt;
    
    @FXML
    private TextField efternavnFelt; 
    
    @FXML
    private ChoiceBox brugertypeBoks;
    
    @FXML
    private void initialize(){
        brugertypeBoks.setValue("Vælg");
        brugertypeBoks.setItems(brugertypeList);
        
    }
            
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    
     public void setKonto(ForaldreModel konto) {
        this.konto = konto;
        fornavnFelt.setText(konto.getFornavn());
        efternavnFelt.setText(konto.getEfternavn());
        
    }
     
    public ObservableList<ForaldreModel> getFamilieData() {
        return familieData;
    }
    
    
    @FXML
    private void handleOpretKonto(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
        if(event.getSource() == opretKontoKnap){
            stage = (Stage) opretKontoKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/OpretKontoView.fxml"));
        } else {
            stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
            
    }
    
    @FXML
    private void handleOpretKontoGem(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
            if(event.getSource() == opretKontoGemKnap){
               if(opretKontoValid()){
                    familieData.add(new ForaldreModel(fornavnFelt.getText(), efternavnFelt.getText()));
                    //konto.setFornavn(fornavnFelt.getText());
                    //konto.setEfternavn(efternavnFelt.getText());
                    System.out.println(familieData.get(0));
                }
                stage = (Stage) opretKontoGemKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/FXML.fxml"));
            } else {
                stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
            
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    private boolean opretKontoValid(){
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
            System.out.println("Nope!");
            return false;
        }
    }
    
}
