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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import bp.model.RegistreringModel;
import java.time.LocalDate;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author christinemariegrabow
 */
public class RegistreringController{
    RegistreringModel RegMod = new RegistreringModel();
    DatabaseController dc;
    
    @FXML
    public Button kostRegistreringGemKnap;
    @FXML
    public Button kostRegistreringTilbageKnap;
    @FXML
    public Button bmiGemKnap;
    @FXML
    public Button bmiTilbageKnap;
    @FXML
    private RadioButton morgenmadKnap;
    @FXML
    private ToggleGroup maltid;
    @FXML
    private RadioButton frokostKnap;
    @FXML
    private RadioButton aftensmadKnap;
    @FXML
    private RadioButton snackKnap;
    @FXML
    private TextField kostFelt;
    @FXML
    private TextField bmiCprFelt;
    @FXML
    private TextField bmiHojdeFelt;
    @FXML
    private TextField bmiVagtFelt;
    @FXML
    private Label bmiUdregnetLabel;
    @FXML
    private Label bmiGemtLabel;
    @FXML
    private Label bmiFejlLabel;
    @FXML
    private DatePicker datoKostFelt; 
    @FXML
    private Label kostFejlLabel;
    @FXML
    private Label kostGemtLabel;
    
    public RegistreringController(){
        this.dc = new DatabaseController();
    }   
   
    public String radioSelectMaltid(){
        String message = "";
//        kostFejlLabel.setText("");
        if (morgenmadKnap.isSelected()){
            message += morgenmadKnap.getText();
        }
        if (frokostKnap.isSelected()){
            message += frokostKnap.getText();
        }
        if (aftensmadKnap.isSelected()){
            message += aftensmadKnap.getText();
        }
        if (snackKnap.isSelected()){
            message += snackKnap.getText();
          //  snackKnap.getText();
        } 

        return message;
    }
    
    @FXML
    public void handleKostRegistreringTilbage() throws IOException { 
        Stage stage;
        Parent root;
        stage = (Stage) kostRegistreringTilbageKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML
    public void handleKostRegistreringGem() throws IOException {
        String message = "";
        if (erKostValid()){
            LocalDate dato = datoKostFelt.getValue();
            String datoString = String.valueOf(dato);
            kostGemtLabel.setText(radioSelectMaltid()+" for "+datoString+ " er registreret!");
            kostFejlLabel.setText("");
            
        } 
    }
    
    private boolean erKostValid(){ 
        String errorMessage = "";
        kostGemtLabel.setText("");
        
        if (datoKostFelt.getValue() == null){
            errorMessage += "Ingen dato valgt!\n";
            kostFejlLabel.setText(errorMessage);
        }
        if ((snackKnap.isSelected() == false) && (morgenmadKnap.isSelected() == false) && (aftensmadKnap.isSelected() == false) && (frokostKnap.isSelected() == false)){
            errorMessage += "Intet måltid valgt!\n";
            kostFejlLabel.setText(errorMessage);
        }
        if (kostFelt.getText() == null || kostFelt.getText().length() == 0) {
            errorMessage += "Ingen valid kost!\n"; 
            kostFejlLabel.setText(errorMessage);
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    @FXML
    public void handleBmiTilbage() throws IOException { 
        Stage stage;
        Parent root;
        stage = (Stage) bmiTilbageKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    
    
    @FXML
    public void handleBmiRegistreringGem() throws IOException { 
        bmiUdregnetLabel.setText("");
        if (erBmiValid()){
            float Hojde = Float.valueOf(bmiHojdeFelt.getText());
            float Vagt = Float.valueOf(bmiVagtFelt.getText());
            int Alder = RegMod.getAlder(bmiCprFelt.getText());
            boolean Kon = RegMod.getKon(bmiCprFelt.getText());
            bmiUdregnetLabel.setText(RegMod.getBmi(Hojde, Vagt, Alder, Kon));
            //dc.tilfojBmiRegistreringTilDB(RegMod, konto)
            bmiGemtLabel.setText("Registering af ISO-BMI fuldført!");
            bmiFejlLabel.setText("");
        }
          
    }
    
    private boolean erBmiValid(){
        String errorMessage = "";
        
        if (bmiCprFelt.getText() == null || bmiCprFelt.getText().length() == 0) {
            errorMessage += "Intet validt CPR!\n"; 
            bmiGemtLabel.setText("");
            bmiFejlLabel.setText(errorMessage);
        }
        if (bmiHojdeFelt.getText() == null || bmiHojdeFelt.getText().length() == 0) {
            errorMessage += "Ingen valid højde!\n"; 
            bmiGemtLabel.setText("");
            bmiFejlLabel.setText(errorMessage);
        }
        if (bmiVagtFelt.getText() == null || bmiVagtFelt.getText().length() == 0) {
            errorMessage += "Ingen valid vægt!\n"; 
            bmiGemtLabel.setText("");
            bmiFejlLabel.setText(errorMessage);
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
