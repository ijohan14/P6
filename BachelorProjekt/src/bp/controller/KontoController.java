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
 */
public class KontoController {
    
    private KontoModel konto = new KontoModel("fornavn", "efternavn", "cpr","familieID", false, "adgangskode",1);
    private DatabaseController dc;
    
    private boolean brugertypeTest;
    
    ObservableList brugertypeList=FXCollections.observableArrayList();
    
    private ObservableList<KontoModel> familieData = FXCollections.observableArrayList();

    
    //LogIndView
    @FXML
    private Button opretKontoKnap;
    @FXML
    private Button logIndKnap;
    @FXML
    private TextField cprLogIndFelt; 
    @FXML
    private TextField adgangskodeLogIndFelt;
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
    
    public KontoController(){
        this.dc = new DatabaseController();
    }
    
        
    @FXML
    public void handleLogInd() throws IOException, SQLException{
        if(erLogIndIndtastet() ){             
            if(dc.verificerLogInd(cprLogIndFelt.getText(), adgangskodeLogIndFelt.getText())
                    && (dc.hentBrugertypeDB(cprLogIndFelt.getText())==true)){
                Stage stage = (Stage) logIndKnap.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
                stage.setScene(new Scene(root));                
                System.out.println("Du er logget ind som forældre");
            }else if(dc.verificerLogInd(cprLogIndFelt.getText(), adgangskodeLogIndFelt.getText())
                    && (dc.hentBrugertypeDB(cprLogIndFelt.getText())==false)){
                Stage stage = (Stage) logIndKnap.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
                stage.setScene(new Scene(root));                
                System.out.println("Du er logget ind som barn");
            }else{
                logIndFejlLabel.setText("Forkert CPR eller adgangskode");
                System.out.println("Du er ikke logget ind");
            }
                
        }
    }
    
    private boolean erLogIndIndtastet(){ 
        String meddelelse = "";
        if (cprLogIndFelt.getText() == null || cprLogIndFelt.getText().length() == 0) {
            meddelelse += "Intet cpr indtastet!\n"; 
            logIndFejlLabel.setText(meddelelse);
        }
        if (adgangskodeLogIndFelt.getText() == null || adgangskodeLogIndFelt.getText().length() == 0) {
            meddelelse += "Ingen adgangskode indtastet!\n"; 
            logIndFejlLabel.setText(meddelelse);
        }
        if (meddelelse.length() == 0) {
            return true;
        } else {
            System.out.println(meddelelse);
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
    
    
    @FXML
    public void handleOpretKonto() throws IOException {
        Stage stage = (Stage) opretKontoKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/OpretKontoView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
    }
    
    @FXML
    public void handleOpretKontoTilbage() throws IOException { 
        Stage stage = (Stage) opretKontoTilbageKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/LogIndView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
    }
    
    @FXML
    public void handleOpretKontoGem() throws IOException, SQLException {
                    opretKontoFejlLabel.setText("");

        if (dc.verificerCprDB(cprFelt.getText()) == false){

        if(erKontoIndtastet() && radioSelectBrugertype() == true){
            KontoModel k = new KontoModel(fornavnFelt.getText(), efternavnFelt.getText(), 
                    cprFelt.getText(), familieIDFelt.getText(), radioSelectBrugertype(), 
                    adgangskodeFelt.getText(),0);           
            kontoGemtLabel.setText(dc.tilfojKontoDB(k));
            dc.hentKontoDB();
        } else if((erKontoIndtastet())&&(radioSelectBrugertype() == false)){
            KontoModel k = new KontoModel(fornavnFelt.getText(), efternavnFelt.getText(), 
                    cprFelt.getText(), familieIDFelt.getText(), radioSelectBrugertype(), 
                    adgangskodeFelt.getText(),1);
            kontoGemtLabel.setText(dc.tilfojKontoDB(k)); 
            dc.hentKontoDB();             
            Stage stage = (Stage) opretKontoGemKnap.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/bp/view/SporgeskemaBornView.fxml"));
            stage.setScene(new Scene(root));
            stage.show();   
            }
        } else{
            
            kontoGemtLabel.setText("Konto med CPR "+cprFelt.getText()+ " eksisterer.");
        }
    }
    
    
      
    private boolean erKontoIndtastet(){ 
        String meddelelse = "";
        opretKontoFejlLabel.setText("");

        
        if (fornavnFelt.getText() == null || fornavnFelt.getText().length() == 0) {
            meddelelse += "Intet indtastet fornavn!\n"; 
            opretKontoFejlLabel.setText(meddelelse);
        }
        if (efternavnFelt.getText() == null || efternavnFelt.getText().length() == 0) {
            meddelelse += "Intet indtastet efternavn!\n";
            opretKontoFejlLabel.setText(meddelelse);
        }
        if (cprFelt.getText() == null || cprFelt.getText().length() == 0) {
            meddelelse += "Intet indtastet cpr!\n"; 
            opretKontoFejlLabel.setText(meddelelse);
        }
        if (familieIDFelt.getText() == null || familieIDFelt.getText().length() == 0) {
            meddelelse += "Intet indtastet familieID!\n"; 
            opretKontoFejlLabel.setText(meddelelse);
        }
        if((barnKnap.isSelected() == false) && (foralderKnap.isSelected() == false)){
            meddelelse += "Ingen indtastet brugertype!\n"; 
            opretKontoFejlLabel.setText(meddelelse);
        }
        if (adgangskodeFelt.getText() == null || adgangskodeFelt.getText().length() == 0) {
            meddelelse += "Intet indtastet adgangekode!\n"; 
            opretKontoFejlLabel.setText(meddelelse);
        }
        if (meddelelse.length() == 0) {
            return true;
        } else {
            System.out.println(meddelelse);
            return false;
        }
    }
   
    public boolean svar1(){ 
        boolean svar = true;
        if (spEtJaKnap.isSelected() == true){
            svar = true;
        }
        if (spEtNejKnap.isSelected() == true){
            svar = false;
        }
        return svar;
    }
    
    public boolean svar2(){ 
        boolean svar = true;
        if (spToJaKnap.isSelected() == true){
            svar = true;
        }
        if (spToNejKnap.isSelected() == true){
            svar = false;
        }
        return svar;
    }
    public boolean svar3(){ 
        boolean svar = true;
        if (spTreJaKnap.isSelected() == true){
            svar = true;
        }
        if (spTreNejKnap.isSelected() == true){
            svar = false;
        }
        return svar;
    }
    public boolean svar4(){
        boolean svar = true;
        if (spFireJaKnap.isSelected() == true){
            svar = true;
        }
        if (spFireNejKnap.isSelected() == true){
            svar = false;
        }
        return svar;
    }
    
    
    private boolean erSporgeskemaBesvarelseIndtastet(){
        String meddelelse = "";
        sporgeskemaGemtLabel.setText("");
        
        if ((spEtJaKnap.isSelected() == false) && (spEtNejKnap.isSelected() == false)){
            meddelelse += "Spørgsmål 1 mangler besvarelse!\n";
            sporgeskemaFejlLabel.setText(meddelelse);
        }
        if ((spToJaKnap.isSelected() == false) && (spToNejKnap.isSelected() == false)){
            meddelelse += "Spørgsmål 2 mangler besvarelse!\n";
            sporgeskemaFejlLabel.setText(meddelelse);
        }
        if ((spTreJaKnap.isSelected() == false) && (spTreNejKnap.isSelected() == false)){
            meddelelse += "Spørgsmål 3 mangler besvarelse!\n";
            sporgeskemaFejlLabel.setText(meddelelse);
        }
        if ((spFireJaKnap.isSelected() == false) && (spFireNejKnap.isSelected() == false)){
            meddelelse += "Spørgsmål 4 mangler besvarelse!\n";
            sporgeskemaFejlLabel.setText(meddelelse);
        }
        if (meddelelse.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    @FXML
    public void handleSporgeskemaGem() {
        if(erSporgeskemaBesvarelseIndtastet()){
            int startniveau = konto.getStartniveau(svar1(), svar2(), svar3(), svar4());
            sporgeskemaFejlLabel.setText("");
            sporgeskemaGemtLabel.setText("Startniveauet "+startniveau+" er tildelt");
            System.out.println("Startniveauet "+startniveau+" er tildelt");
            
            //i databasecontroller skal der være en metode der ændrer startniveau for barnet. lige nu er det 0 som default.
        }
    }
    
    @FXML
    public void handleSporgeskemaFardig() throws IOException{
        Stage stage = (Stage) sporgeskemaFardigKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/LogIndView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();  
    }
    
   
    
}
