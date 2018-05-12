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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.M;
import javafx.stage.Stage;
import javax.swing.JTable;
import javafx.application.Application;

/**
 * FXML Controller class
 *
 * @author nathalie
 */
public class KontoController implements Initializable {
    
    private ForaldreModel konto;
    
    ObservableList brugertypeList=FXCollections.observableArrayList();
    
    private ObservableList<ForaldreModel> familieData = FXCollections.observableArrayList();
    
//   String[] coloumnNames = {"fornavn", "efternavn", "crp", "familieID", "adgangskode"};
//   Object[][] data = {
//       setKonto
//   } 
    
    @FXML
    private Button opretKontoKnap;
    @FXML
    private Button logIndKnap;
    @FXML
    private TextField cprLogIndFelt; 
    @FXML
    private TextField adgangskodeLogIndFelt;
    @FXML
    private Button opretKontoFortrydKnap;
    @FXML
    private Button opretKontoGemKnap;
    @FXML
    private TextField fornavnFelt;
    @FXML
    private TextField efternavnFelt; 
    @FXML 
    private TextField cprFelt;
    @FXML
    private TextField familieIDFelt;
    @FXML
    private ChoiceBox<String> brugertypeBoks;
    @FXML
    private TextField adgangskodeFelt;
    @FXML
    private Button visDataKnap;
    
    
    @FXML
    private void initialize(){
        
    }
            
            
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }   
    
    
     public void setKonto(ForaldreModel konto) {
        this.konto = konto;
        fornavnFelt.setText(konto.getFornavn());
        efternavnFelt.setText(konto.getEfternavn());
        cprFelt.setText(konto.getCpr());
        familieIDFelt.setText(konto.getFamilieID());
        adgangskodeFelt.setText(konto.getAdgangskode());
        
    }
    
    public ObservableList<ForaldreModel> getFamilieData() {
        ObservableList<ForaldreModel> familieData = FXCollections.observableArrayList();
        familieData.add(new ForaldreModel());
        return familieData;
    }
    
    @FXML
    public void handleOpretKonto() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) opretKontoKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/OpretKontoView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML
    public void handleOpretKontoFortryd() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML
    public void handleOpretKontoGem() throws IOException {
        Stage stage;
        Parent root;
        if(opretKontoValid()){
            familieData.add(new ForaldreModel(fornavnFelt.getText(), efternavnFelt.getText(),cprFelt.getText(),familieIDFelt.getText(),adgangskodeFelt.getText()));
            System.out.println("Fornavn: "+fornavnFelt.getText()+"\nEfternavn: "+efternavnFelt.getText()+"\nCpr: "+cprFelt.getText()+"\nFamilieiD: "+familieIDFelt.getText()+"\nAdganskode: "+adgangskodeFelt.getText());
        }
        stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
      
    private boolean opretKontoValid(){
        String errorMessage = "";
        
        if (fornavnFelt.getText() == null || fornavnFelt.getText().length() == 0) {
            errorMessage += "Intet valid fornavn!\n"; 
        }
        if (efternavnFelt.getText() == null || efternavnFelt.getText().length() == 0) {
            errorMessage += "Intet valid efternavn!\n"; 
        }
        if (cprFelt.getText() == null || cprFelt.getText().length() == 0) {
            errorMessage += "Intet valid cpr!\n"; 
        }
        if (familieIDFelt.getText() == null || familieIDFelt.getText().length() == 0) {
            errorMessage += "Intet valid familieID!\n"; 
        }
        if (adgangskodeFelt.getText() == null || adgangskodeFelt.getText().length() == 0) {
            errorMessage += "Intet valid adgangekode!\n"; 
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            System.out.println(errorMessage);
            return false;
        }
    }
    
    @FXML
    public void handleLogInd() throws IOException {
        Stage stage;
        Parent root;
        if(logIndIndtastet() ){ //Der må skulle være en if, der spørger efter kontotype, og så afhænger view af dette. 
                stage = (Stage) logIndKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
            } else {
                stage = (Stage) logIndKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
            }
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    
    private boolean logIndIndtastet(){
        String errorMessage = "";
        
        if (cprLogIndFelt.getText() == null || cprLogIndFelt.getText().length() == 0) {
            errorMessage += "Intet cpr indtastet!\n"; 
        }
        if (adgangskodeLogIndFelt.getText() == null || adgangskodeLogIndFelt.getText().length() == 0) {
            errorMessage += "Ingen adgangskode indtastet!\n"; 
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            System.out.println(errorMessage);
            return false;
        }
    }
    
    private boolean logIndValid(){
        String errorMessage = "";
        
        if (cprFelt.getText() != cprLogIndFelt.getText()){
            errorMessage += "cpr ikke validt\n";
        }
        if (adgangskodeFelt.getText() != adgangskodeLogIndFelt.getText()){
            errorMessage += "adgangskode ikke valid\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            System.out.println(errorMessage);
            return false;
        }
    }
    
    @FXML
    public void handleVisData() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) visDataKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/DatalagringView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
}
