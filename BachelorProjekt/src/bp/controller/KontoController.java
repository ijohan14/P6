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
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import bp.model.ForaldreModel;

/**
 * FXML Controller class
 *
 * @author nathalie
 */
public class KontoController {//implements Initializable {
    
    private ForaldreModel konto;
    
    private boolean brugertypeTest;
    
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
    private TextField fornavnFelt;
    @FXML
    private TextField efternavnFelt; 
    @FXML
    private TextField cprFelt;
    @FXML
    private TextField familieIDFelt;
    @FXML
    private TextField adgangskodeFelt;
    @FXML
    private Button visDataKnap;
    @FXML
    private RadioButton spEtJaKnap;
    @FXML
    private RadioButton spEtNejKnap;
    @FXML
    private RadioButton spJaToKnap; 
    @FXML
    private RadioButton spToNejKnap; 
    @FXML
    private RadioButton spTreJaKnap;
    @FXML
    private RadioButton spTreNejKnap;
    @FXML
    private RadioButton spFireJaKnap; 
    @FXML 
    private RadioButton spFireNejKnap; 
    @FXML
    private Button sporgeskemaGemKnap;
    @FXML
    private Button sporgeskemaFortrydKnap;
    @FXML
    private ToggleGroup brugertype;
    @FXML
    private RadioButton foralderKnap; 
    @FXML
    private RadioButton barnKnap;
    
    
    @FXML
    public void radioSelectBrugertype(ActionEvent event){
        String message = "";
        if (foralderKnap.isSelected()){
            brugertypeTest = true; 
            brugertype.setUserData("Forælder");
            message += foralderKnap.getText()+"\n";
        }
        if (barnKnap.isSelected()){
            brugertypeTest = false; 
            brugertype.setUserData("Barn");
            message += barnKnap.getText()+"\n";
        }
        System.out.println(message);
    }
    
    @FXML
    public void radioSelectSpEt(ActionEvent event){
        String message = "";
        if (spEtJaKnap.isSelected()){
            message += spEtJaKnap.getText()+"\n";
        }
        if (spEtNejKnap.isSelected()){
            message += spEtNejKnap.getText()+"\n";
        }
        System.out.println(message);
    }
    
    @FXML
    public void radioSelectSpTo(ActionEvent event){
        String message = "";
        if (spJaToKnap.isSelected()){
            message += spJaToKnap.getText()+"\n";
        }
        if (spToNejKnap.isSelected()){
            message += spToNejKnap.getText()+"\n";
        }
        System.out.println(message);
    }
    
    @FXML
    public void radioSelectSpTre(ActionEvent event){
        String message = "";
        if (spTreJaKnap.isSelected()){
            message += spTreJaKnap.getText()+"\n";
        }
        if (spTreNejKnap.isSelected()){
            message += spTreNejKnap.getText()+"\n";
        }
        System.out.println(message);
    }
    
    @FXML
    public void radioSelectSpFire(ActionEvent event){
        String message = "";
        if (spFireJaKnap.isSelected()){
            message += spFireJaKnap.getText()+"\n";
        }
        if (spFireNejKnap.isSelected()){
            message += spFireNejKnap.getText()+"\n";
        }
        System.out.println(message);
    }
    
            
    /**
     * Initializes the controller class.
     */
    
    

    
    
    
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
            familieData.add(new ForaldreModel(fornavnFelt.getText(), efternavnFelt.getText(),cprFelt.getText(),familieIDFelt.getText(),brugertypeTest,adgangskodeFelt.getText()));
            System.out.println("Fornavn: "+fornavnFelt.getText()+"\nEfternavn: "+efternavnFelt.getText()+"\nCpr: "+cprFelt.getText()+"\nFamilieiD: "+familieIDFelt.getText()+"\nAdganskode: "+adgangskodeFelt.getText());
            stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        } else {
        stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/OpretKontoView.fxml"));
        }
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
                root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
            } else {
                stage = (Stage) logIndKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
            }
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }
    
    ForaldreModel ForMod = new ForaldreModel();  
    
    
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
