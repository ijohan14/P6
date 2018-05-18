/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;


import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import bp.model.KontoModel;
import java.sql.SQLException;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author nathalie
 */
public class KontoController {//implements Initializable {
    
    private KontoModel konto;
    private DatalagringController d;
    
    private boolean brugertypeTest;
    
    ObservableList brugertypeList=FXCollections.observableArrayList();
    
    private ObservableList<KontoModel> familieData = FXCollections.observableArrayList();
    
//   String[] coloumnNames = {"fornavn", "efternavn", "crp", "familieID", "adgangskode"};
//   Object[][] data = {
//       setKonto
//   } 
    
    //StartVIew
    @FXML
    private Button opretKontoKnap;
    @FXML
    private Button logIndKnap;
    @FXML
    private TextField cprLogIndFelt; 
    @FXML
    private TextField adgangskodeLogIndFelt;
    @FXML
    private Button visDataKnap;
    @FXML 
    private Label logIndFejlLabel;
    
    //OpretKontoView
    @FXML
    private Button opretKontoTilbageKnap;
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
    private TextField adgangskodeFelt;
//    @FXML
//    private ToggleGroup brugertype;
    @FXML
    private RadioButton foralderKnap; 
    @FXML
    private RadioButton barnKnap;
    @FXML
    private Label kontoGemtLabel;
    @FXML
    private Label opretKontoFejlLabel;
    
    //SporgeskemaBornView
    @FXML
    private RadioButton spEtJaKnap;
    @FXML
    private RadioButton spEtNejKnap;
    @FXML
    private RadioButton spToJaKnap; 
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
//    @FXML
//    private Button sporgeskemaGemKnap;
    @FXML
    private Label sporgeskemaGemtLabel;
    @FXML
    private Label sporgeskemaFejlLabel;
    @FXML
    private Button sporgeskemaFardigKnap;
    
//    public KontoController(){
//        this.d = new DatalagringController();
//    }
    
    
    @FXML
    public void handleVisData() throws IOException {
        Stage stage = (Stage) visDataKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/DatalagringView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
    }
    
    @FXML
    public void handleLogInd() throws IOException{
        if(logIndIndtastet() ){ //Der må skulle være en if, der spørger efter kontotype, og så afhænger view af dette. 
                Stage stage = (Stage) logIndKnap.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
                stage.setScene(new Scene(root));
        }
    }
    
    private boolean logIndIndtastet(){
        String errorMessage = "";
        if (cprLogIndFelt.getText() == null || cprLogIndFelt.getText().length() == 0) {
            errorMessage += "Intet cpr indtastet!\n"; 
            logIndFejlLabel.setText(errorMessage);
        }
        if (adgangskodeLogIndFelt.getText() == null || adgangskodeLogIndFelt.getText().length() == 0) {
            errorMessage += "Ingen adgangskode indtastet!\n"; 
            logIndFejlLabel.setText(errorMessage);
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
    

    public boolean radioSelectBrugertype(){
        boolean brugertype = true;
        if (foralderKnap.isSelected()){
            brugertype = true;
        }
        if (barnKnap.isSelected()){
            brugertype = false;
        }
        return brugertype;
    }
    
     public void setKonto(KontoModel konto) {
        this.konto = konto;
        fornavnFelt.setText(konto.getFornavn());
        efternavnFelt.setText(konto.getEfternavn());
        cprFelt.setText(konto.getCpr());
        familieIDFelt.setText(konto.getFamilieID());
        adgangskodeFelt.setText(konto.getAdgangskode());
        
    }
    
    public ObservableList<KontoModel> getFamilieData() {
        ObservableList<KontoModel> familieData = FXCollections.observableArrayList();
        familieData.add(new KontoModel());
        return familieData;
    }
    
    @FXML
    public void handleOpretKonto() throws IOException {
        Stage stage = (Stage) opretKontoKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/OpretKontoView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
    }
    
    @FXML
    public void handleTilbageOpretKonto() throws IOException {
        Stage stage = (Stage) opretKontoTilbageKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
    }
    
    @FXML
    public void handleOpretKontoGem() throws IOException {
        if(opretKontoValid()){
//            familieData.add(new ForaldreModel(fornavnFelt.getText(), efternavnFelt.getText(),cprFelt.getText(),familieIDFelt.getText(),brugertypeTest,adgangskodeFelt.getText()));
//            System.out.println("Fornavn: "+fornavnFelt.getText()+"\nEfternavn: "+efternavnFelt.getText()+"\nCpr: "+cprFelt.getText()+"\nFamilieiD: "+familieIDFelt.getText()+"\nAdganskode: "+adgangskodeFelt.getText());
            KontoModel k = new KontoModel(fornavnFelt.getText(), efternavnFelt.getText(), cprFelt.getText(), familieIDFelt.getText(), radioSelectBrugertype(), adgangskodeFelt.getText());
            
            //d.opretKontoIDatabase(k);
            kontoGemtLabel.setText("Konto af brugertypen "+radioSelectBrugertype()+ " er gemt!");
            
            if((opretKontoValid())&&(radioSelectBrugertype() == false)){
                Stage stage = (Stage) opretKontoGemKnap.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/bp/view/SporgeskemaBornView.fxml"));
                stage.setScene(new Scene(root));
                
            }
        } 
    }
    
    
      
    private boolean opretKontoValid(){
        String errorMessage = "";
        
        if (fornavnFelt.getText() == null || fornavnFelt.getText().length() == 0) {
            errorMessage += "Intet valid fornavn!\n"; 
            opretKontoFejlLabel.setText(errorMessage);
        }
        if (efternavnFelt.getText() == null || efternavnFelt.getText().length() == 0) {
            errorMessage += "Intet valid efternavn!\n";
            opretKontoFejlLabel.setText(errorMessage);
        }
        if (cprFelt.getText() == null || cprFelt.getText().length() == 0) {
            errorMessage += "Intet valid cpr!\n"; 
            opretKontoFejlLabel.setText(errorMessage);
        }
        if (familieIDFelt.getText() == null || familieIDFelt.getText().length() == 0) {
            errorMessage += "Intet valid familieID!\n"; 
            opretKontoFejlLabel.setText(errorMessage);
        }
        if((barnKnap.isSelected() == false) && (foralderKnap.isSelected() == false)){
            errorMessage += "Ingen valid brugertype!\n"; 
            opretKontoFejlLabel.setText(errorMessage);
        }
        if (adgangskodeFelt.getText() == null || adgangskodeFelt.getText().length() == 0) {
            errorMessage += "Intet valid adgangekode!\n"; 
            opretKontoFejlLabel.setText(errorMessage);
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            System.out.println(errorMessage);
            return false;
        }
    }
   
    public boolean radioSelectSpEt(){
        boolean svar = true;
        if (spEtJaKnap.isSelected() == true){
            svar = true;
        }
        if (spEtNejKnap.isSelected() == true){
            svar = false;
        }
        return svar;
    }
    
    public boolean radioSelectSpTo(){
        boolean svar = true;
        if (spToJaKnap.isSelected() == true){
            svar = true;
        }
        if (spToNejKnap.isSelected() == true){
            svar = false;
        }
        return svar;
    }
    public boolean radioSelectSpTre(){
        boolean svar = true;
        if (spTreJaKnap.isSelected() == true){
            svar = true;
        }
        if (spTreNejKnap.isSelected() == true){
            svar = false;
        }
        return svar;
    }
    public boolean radioSelectSpFire(){
        boolean svar = true;
        if (spFireJaKnap.isSelected() == true){
            svar = true;
        }
        if (spFireNejKnap.isSelected() == true){
            svar = false;
        }
        return svar;
    }
    
    
    public boolean validSporgeskemaBesvarelse(){
        String errorMessage = "";
        sporgeskemaGemtLabel.setText("");
        
        if ((spEtJaKnap.isSelected() == false) && (spEtNejKnap.isSelected() == false)){
            errorMessage += "Spørgsmål 1 mangler besvarelse!\n";
            sporgeskemaFejlLabel.setText(errorMessage);
        }
        if ((spToJaKnap.isSelected() == false) && (spToNejKnap.isSelected() == false)){
            errorMessage += "Spørgsmål 2 mangler besvarelse!\n";
            sporgeskemaFejlLabel.setText(errorMessage);
        }
        if ((spTreJaKnap.isSelected() == false) && (spTreNejKnap.isSelected() == false)){
            errorMessage += "Spørgsmål 3 mangler besvarelse!\n";
            sporgeskemaFejlLabel.setText(errorMessage);
        }
        if ((spFireJaKnap.isSelected() == false) && (spFireNejKnap.isSelected() == false)){
            errorMessage += "Spørgsmål 4 mangler besvarelse!\n";
            sporgeskemaFejlLabel.setText(errorMessage);
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    KontoModel km = new KontoModel();
    @FXML
    public void handleSporgeskemaGem() {
        if(validSporgeskemaBesvarelse()){
            km.getStartniveau(radioSelectSpEt(),radioSelectSpTo(),radioSelectSpTre(),radioSelectSpFire());
            sporgeskemaFejlLabel.setText("");
            sporgeskemaGemtLabel.setText("Besvarelse af spørgeskema gemt!");
            System.out.println(km.getStartniveau(radioSelectSpEt(),radioSelectSpTo(),radioSelectSpTre(),radioSelectSpFire()));
        }
    }
    
    @FXML
    public void handleSporgeskemaFardig() throws IOException{
        Stage stage = (Stage) sporgeskemaFardigKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();  
    }
    
   
    
}
