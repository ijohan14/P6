/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;

import bp.model.SpilModel;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author christinemariegrabow
 */
public class MenuBornController implements Initializable {

    static int milisekunder =0;
    static int sekunder = 0;
    static int minutter = 0;
    static int timer = 0;
    static boolean stadie = false;
    String timerTid;
    
    @FXML
    public Button malsatningFortrydKnap; 
    @FXML
    public Button startTimerKnap;
    @FXML
    public Button stopTimerKnap;
    @FXML
    public Label udfordringGemtLabel;
    @FXML
    public Button udfordringFortrydKnap;
    @FXML
    public Button udfordringTilbageKnap;
    @FXML
    public Label udfordringOpsummeringLabel;
    @FXML 
    public Button udfordringKnap; 
    @FXML
    public Text timerText;
    @FXML
    public Label udfordringFejlLabel;
    @FXML 
    public Button malsatningKnap; 
    @FXML 
    public Button bornLogUdKnap; 
    @FXML
    private RadioButton sjippetovKnap;
    @FXML
    private RadioButton gaturKnap;
    @FXML
    private RadioButton lobeturKnap;
    @FXML
    private RadioButton rulleskojteKnap;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    public void handleBornLogUd() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) bornLogUdKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/StartView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }

    @FXML
    public void handleMalsatning() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) malsatningKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MalsatningView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML
    public void handleUdfordring() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) udfordringKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/UdfordringView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    public boolean udfordringValid(){
        String errorMessage = "";
        if ((sjippetovKnap.isSelected() == false) && (gaturKnap.isSelected() == false) && (lobeturKnap.isSelected() == false) && (rulleskojteKnap.isSelected() == false)){
            errorMessage += "Ingen udfordring valgt!\n";
            udfordringFejlLabel.setText(errorMessage);
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    SpilModel SpilMod = new SpilModel();
    
    @FXML
    public void handleStartTimer(){// throws IOException {
        timerText.setText("0 : 0 : 0");
        if (udfordringValid()){
            udfordringFejlLabel.setText("");
            udfordringGemtLabel.setText("");
            udfordringOpsummeringLabel.setText("");
            stadie = true;
            
            Thread stopUr = new Thread(){
                public void run(){
                    for(;;){
                        if(stadie == true){
                            try{
                                sleep(1);
                                if(milisekunder > 1000){
                                    milisekunder = 0;
                                    sekunder ++;
                                }
                                if(sekunder > 60){
                                    milisekunder = 0;
                                    sekunder = 0;
                                    minutter ++;
                                }
                                if(minutter > 60){
                                    milisekunder = 0;
                                    sekunder = 0;
                                    minutter = 0;
                                    timer ++;
                                }
                                milisekunder ++;
                                String timerString = String.valueOf(timer);
                                String minutterString = String.valueOf(minutter);
                                String sekunderString = String.valueOf(sekunder);
//                                sekunderDisplay.setText(" : "+sekunder);
//
//                                minutterDisplay.setText(" : "+minutter);
//                                timerDisplay.setText(" "+timer);
                                System.out.println(" "+timer+" : "+minutter+" : "+sekunder);
                                timerTid = " "+timerString+" : "+minutterString+" : "+sekunderString;
                                timerText.setText(timerTid);
//                                timerText.setText(" "+timer+" : "+minutter+" : "+sekunder);
                            }
                            catch(Exception e){
                            }
                        }
                        else{
                            break;
                        }
                    }
                }
            };
            stopUr.start();
    
        }
    }
    
    @FXML
    public String radioSelectUdfordring(){
        String message = "";
        udfordringGemtLabel.setText("");
        udfordringOpsummeringLabel.setText("");
        if (sjippetovKnap.isSelected()){
            message += sjippetovKnap.getText();
        }
        if (gaturKnap.isSelected()){
            message += gaturKnap.getText();
        }
        if (lobeturKnap.isSelected()){
            message += lobeturKnap.getText();
        }
        if (rulleskojteKnap.isSelected()){
            message += rulleskojteKnap.getText();
        } 

        return message;
    }
    
    
    @FXML
    public void handleStopTimer (){
        stadie = false;
        udfordringOpsummeringLabel.setText("Udfordring: "+radioSelectUdfordring()+"\nVarighed: "+timerTid);
        
        timer = 0;
        minutter = 0;
        sekunder = 0;
        milisekunder = 0;

    }
    
    @FXML 
    public void handleGemUdfordring(){
        udfordringGemtLabel.setText("Udfordringen er gemt!");
    }
    
    @FXML
    public void handleFortrydMalsatning() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) malsatningFortrydKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }
    
    @FXML
    public void handleTilbageUdfordring() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) udfordringTilbageKnap.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();   
    }

    
}
