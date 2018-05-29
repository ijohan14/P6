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
    
    //BmiRegistreringView
    @FXML
    public Button bmiGemKnap;
    @FXML
    public Button bmiTilbageKnap;
    @FXML
    private TextField bmiHojdeFelt;
    @FXML
    private TextField bmiVagtFelt;
    @FXML
    private TextField bmiCprFelt;
    @FXML
    private Label bmiUdregnetLabel;
    @FXML
    private Label bmiGemtLabel;
    @FXML
    private Label bmiFejlLabel;
    
    //KostRegistreringView
    @FXML
    public Button kostRegistreringGemKnap;
    @FXML
    public Button kostRegistreringTilbageKnap;
    @FXML
    private RadioButton kostMorgenmadKnap;
    @FXML
    private RadioButton kostFrokostKnap;
    @FXML
    private RadioButton kostAftensmadKnap;
    @FXML
    private RadioButton kostSnackKnap;
    @FXML
    private TextField kostFelt;
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
        if (kostMorgenmadKnap.isSelected()){
            message += kostMorgenmadKnap.getText();
        }
        if (kostFrokostKnap.isSelected()){
            message += kostFrokostKnap.getText();
        }
        if (kostAftensmadKnap.isSelected()){
            message += kostAftensmadKnap.getText();
        }
        if (kostSnackKnap.isSelected()){
            message += kostSnackKnap.getText();
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
        if (erKostIndtastet()){
            LocalDate dato = datoKostFelt.getValue();
            String datoString = String.valueOf(dato);
            kostGemtLabel.setText(radioSelectMaltid()+" for "+datoString+ " er registreret!");
            kostFejlLabel.setText("");
            
        } 
    }
    
    private boolean erKostIndtastet(){ 
        String errorMessage = "";
        kostGemtLabel.setText("");
        
        if (datoKostFelt.getValue() == null){
            errorMessage += "Ingen dato valgt!\n";
            kostFejlLabel.setText(errorMessage);
        }
        if ((kostSnackKnap.isSelected() == false) && (kostMorgenmadKnap.isSelected() == false) && (kostAftensmadKnap.isSelected() == false) && (kostFrokostKnap.isSelected() == false)){
            errorMessage += "Intet måltid valgt!\n";
            kostFejlLabel.setText(errorMessage);
        }
        if (kostFelt.getText() == null || kostFelt.getText().length() == 0) {
            errorMessage += "Ingen indtastet kost!\n"; 
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
        bmiFejlLabel.setText("");
        if (erBmiIndtastet()){
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
    
    private boolean erBmiIndtastet(){
        String meddelelse = "";
        
        if (bmiCprFelt.getText() == null || bmiCprFelt.getText().length() == 0) {
            meddelelse += "Intet indtastet CPR-nummer!\n"; 
            bmiGemtLabel.setText("");
            bmiFejlLabel.setText(meddelelse);
        }
        if (bmiHojdeFelt.getText() == null || bmiHojdeFelt.getText().length() == 0) {
            meddelelse += "Ingen indtastet højde!\n"; 
            bmiGemtLabel.setText("");
            bmiFejlLabel.setText(meddelelse);
        }
        if (bmiVagtFelt.getText() == null || bmiVagtFelt.getText().length() == 0) {
            meddelelse += "Ingen indtastet vægt!\n"; 
            bmiGemtLabel.setText("");
            bmiFejlLabel.setText(meddelelse);
        }
        if (meddelelse.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
}
