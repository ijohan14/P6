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
    
    //ObservableList<String> brugertypeList = FXCollections.observableArrayList("Barn", "Forælder");
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
    
//    @FXML
//    private Label fornavnLabel;
//    
//    @FXML
//    private Label efternavnLabel;
    
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
    //loadBrugertypeBoks(); 
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
    
//    public void setItems(ObservableList<ForaldreModel> familieData){
//        familieDataTable.setItems(familieData);
//    }
    
    
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
                    familieData.add(new ForaldreModel(fornavnFelt.getText(), efternavnFelt.getText(),cprFelt.getText(),familieIDFelt.getText(),adgangskodeFelt.getText()));
                    System.out.println("Fornavn: "+fornavnFelt.getText()+"\nEfternavn: "+efternavnFelt.getText()+"\nCpr: "+cprFelt.getText()+"\nFamilieiD: "+familieIDFelt.getText()+"\nAdganskode: "+adgangskodeFelt.getText());
                    //konto.setFornavn(fornavnFelt.getText());
                    //konto.setEfternavn(efternavnFelt.getText());
                }
               stage = (Stage) opretKontoGemKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
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
    private void handleLogInd(ActionEvent event) throws IOException {
        Stage stage;
        Parent root;
            if((event.getSource() == logIndKnap) && logIndIndtastet()){ //Der må skulle være en if, der spørger efter kontotype, og så afhænger view af dette. 
                stage = (Stage) logIndKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
            } else {
                stage = (Stage) opretKontoKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
            
            }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    private void handleVisData(ActionEvent event) throws IOException{ 
        Stage stage; 
        Parent root;
        if (event.getSource() == visDataKnap) {
                stage = (Stage) visDataKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/DatalagringView.fxml"));
            } 
        else {
                stage = (Stage) opretKontoKnap.getScene().getWindow();
                root = FXMLLoader.load(getClass().getResource("/bp/view/OpretKontoView.fxml"));
            
            }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
//    @FXML
//    private void displayChecked(ActionEvent event){
//        String movie = brugertypeBoks.getValue();
//        if (movie == null){
//            screen.setText("selecstkn");
//        }
//        else {
//            scren.setText("your betokæ");
//        }
//        
//    }
    private void loadBrugertypeBoks() {
        String a="foralder"; 
        String b="barn";
        brugertypeList.addAll(a, b);
        brugertypeBoks.getItems().setAll(brugertypeList);
    }
}
