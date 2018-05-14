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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author christinemariegrabow
 */
public class RegistreringController implements Initializable {
    @FXML
    public Button kostRegistreringGemKnap;
    @FXML
    public Button kostRegistreringFortrydKnap;
    @FXML
    public Button isoBmiGemKnap;
    @FXML
    public Button isoBmiTilbageKnap;
    @FXML
    private RadioButton morgenmadKnap;
    @FXML
    private ToggleGroup maltid;
    @FXML
    private RadioButton middagsmadKnap;
    @FXML
    private RadioButton aftensmadKnap;
    @FXML
    private RadioButton snackKnap;
    @FXML
    private TextField kostFelt;
    @FXML
    private TextField isoBmiCprFelt;
    @FXML
    private TextField isoBmiHojdeFelt;
    @FXML
    private TextField isoBmiVagtFelt;
    @FXML
    private Label bmiUdregnetLabel;
    @FXML
    private Label bmiGemtLabel;
    @FXML
    private Label bmiFejlLabel;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void radioSelectMaltid(){
        String message = "";
        if (morgenmadKnap.isSelected()){
            message += morgenmadKnap.getText()+"\n";
        }
        if (middagsmadKnap.isSelected()){
            message += middagsmadKnap.getText()+"\n";
        }
        if (aftensmadKnap.isSelected()){
            message += aftensmadKnap.getText()+"\n";
        }
        if (snackKnap.isSelected()){
            message += snackKnap.getText()+"\n";
        }
        System.out.println(message);
    }
    
    @FXML
    public void handleFortrydKostRegistrering() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) kostRegistreringFortrydKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML
    public void handleGemKostRegistrering() throws IOException {
        Stage stage;
        Parent root;
        if (registrerKostValid()){
            stage = (Stage) kostRegistreringGemKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));           
        } else {
            stage = (Stage) kostRegistreringGemKnap.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/bp/view/KostRegistreringView.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    private boolean registrerKostValid(){
        String errorMessage = "";
        
        if (kostFelt.getText() == null || kostFelt.getText().length() == 0) {
            errorMessage += "Intet valid kost!\n"; 
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            System.out.println(errorMessage);
            return false;
        }
    }
    
    @FXML
    public void handleFortrydIsoBmi() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) isoBmiTilbageKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    RegistreringModel RegMod = new RegistreringModel();
    
    @FXML
    public void handleGemIsoBmiRegistrering() throws IOException {
        Stage stage;
        Parent root;
        bmiUdregnetLabel.setText("");
        if (registrerIsoBmiValid()){
            
            float Hojde = Float.valueOf(isoBmiHojdeFelt.getText());
            float Vagt = Float.valueOf(isoBmiVagtFelt.getText());
            int Alder = RegMod.udtrakAlderFraCpr(isoBmiCprFelt.getText());
            boolean Kon = RegMod.udtrakKonFraCpr(isoBmiCprFelt.getText());
            bmiUdregnetLabel.setText(RegMod.bmiUdregning(Hojde, Vagt, Alder, Kon));
            bmiGemtLabel.setText("Registering af ISO-BMI fuldført!");
            bmiFejlLabel.setText("");
            stage = (Stage) isoBmiGemKnap.getScene().getWindow();
           ///root = FXMLLoader.load(getClass().getResource("/bp/view/MenuForaldreView.fxml"));
//        } else {
//            stage = (Stage) isoBmiGemKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/bp/view/IsoBmiView.fxml"));
//            Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show(); 
        }
          
    }
    
    private boolean registrerIsoBmiValid(){
        String errorMessage = "";
        
        if (isoBmiCprFelt.getText() == null || isoBmiCprFelt.getText().length() == 0) {
            errorMessage += "Intet valid CPR!\n"; 
            bmiGemtLabel.setText("");
            bmiFejlLabel.setText(errorMessage);
        }
        if (isoBmiHojdeFelt.getText() == null || isoBmiHojdeFelt.getText().length() == 0) {
            errorMessage += "Intet valid højde!\n"; 
            bmiGemtLabel.setText("");
            bmiFejlLabel.setText(errorMessage);
        }
        if (isoBmiVagtFelt.getText() == null || isoBmiVagtFelt.getText().length() == 0) {
            errorMessage += "Intet valid vægt!\n"; 
            bmiGemtLabel.setText("");
            bmiFejlLabel.setText(errorMessage);
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            //System.out.println(errorMessage);
            return false;
        }
    }
    
}
