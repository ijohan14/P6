/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smarthealth.controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author christinemariegrabow
 */
public class KontoController {//implements Initializable {
ObservableList<String> brugertypeList=FXCollections.observableArrayList("Forælder", "Barn");

    @FXML
    private ChoiceBox brugertypeBoks;
    
    @FXML
    private Button opretKontoKnap;
    
    @FXML
    private Button opretKontoFortrydKnap;
    
    @FXML
    private RadioButton foralderKnap;
    
    @FXML
    private RadioButton barnKnap;

    /**
     * Initializes the controller class.
     */
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
////        loadBrugertype(opretKontoKnap);
//    }   
    public KontoController(){
        brugertypeBoks.setValue("mm");
        brugertypeBoks.setItems(brugertypeList);
    }
    
//    @FXML
//    private void initialize(){
//        brugertypeBoks.setValue("mm");
//        brugertypeBoks.setItems(brugertypeList);
//    }
    
    @FXML
    public void handleOpretKonto() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) opretKontoKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/smarthealth/view/OpretKontoView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML
    private void handleOpretKontoFortryd() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/smarthealth/view/StartView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
//    @FXML
//    private void handleOpretKonto() throws IOException {
//        
//        Stage stage;
//        Parent root;
//        
//        if(event.getSource() == opretKontoKnap){
//            
//            stage = (Stage) opretKontoKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/smarthealth/view/OpretKontoView.fxml"));
//            
//        } else {
//            stage = (Stage) opretKontoFortrydKnap.getScene().getWindow();
//            root = FXMLLoader.load(getClass().getResource("/smarthealth/view/StartView.fxml"));
//        }
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//        
//    }
    
//    private void loadBrugertype(Button event) throws IOException {
//        if(event.getSource() == opretKontoKnap){
//          ObservableList brugertypeList=FXCollections.observableArrayList();
//          brugertypeList.remove(brugertypeList);
//          String a="Forælder"; 
//          String b="Barn"; 
//          brugertypeList.addAll(a, b);
//          brugertypeBoks.getItems().addAll(brugertypeList);
//        }
//    }
    
//    public void loadBrugertype(){
//        brugertypeList.remove(brugertypeList);
//        String a="Forælder"; 
//        String b="Barn"; 
//        brugertypeList.addAll(a, b);
//        brugertypeBoks.getItems().addAll(brugertypeList);
//    }
    
}
