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
import javafx.scene.control.TextField;
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
    int aktivitetIntensitet;
    
    @FXML
    public Button malsatningTilbageKnap; 
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
    @FXML
    private Label pointsumLabel;
    @FXML
    private RadioButton cykelSkoleMalKnap;
    @FXML
    private RadioButton gaturMalKnap;
    @FXML
    private RadioButton enDagMalKnap;
    @FXML
    private RadioButton treDageMalKnap;
    @FXML
    private RadioButton femDageMalKnap;
    @FXML
    private RadioButton enUgeMalKnap;
    @FXML
    private Label malsatningLabel;
    @FXML
    private Label malsatningGemtLabel;
    @FXML
    private Label malsatningFejlLabel;
    @FXML
    private Button manuelIndtastningMalsatningKnap;
    @FXML
    private Button manuelIndtastningUdfordringKnap;
    
    //ManuelIndtastiningFysiskAktivitetView
    @FXML
    private TextField typeManuelIndtastningFelt;
    @FXML
    private TextField varighedManuelIndtastningFelt;
    @FXML
    private TextField intensitetManuelIndtastningFelt;
    @FXML
    private Button manuelIndtastningGemKnap;
    @FXML
    private Button manuelIndtastningTilbageKnap;
    @FXML
    private Label manuelIndtastningGemtLabel;
    @FXML
    private Label manuelIndtastningFejlLabel;
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
    
    public boolean malsatningValid(){
        String errorMessage = "";
        if ((gaturMalKnap.isSelected() == false) && (cykelSkoleMalKnap.isSelected() == false)){
            errorMessage += "Intet mål valgt!\n";
            malsatningFejlLabel.setText(errorMessage);
        }
        if ((enDagMalKnap.isSelected() == false) && (treDageMalKnap.isSelected() == false) && (femDageMalKnap.isSelected() == false) && (enUgeMalKnap.isSelected() == false)){
            errorMessage += "Ingen varighed for mål valgt!";
            malsatningFejlLabel.setText(errorMessage);
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public String radioSelectMalsatning(){
        String message = "";
        if (cykelSkoleMalKnap.isSelected()){
            message = "at cykle i skole";
        }
        if (gaturMalKnap.isSelected()){
            message = "at gå en tur";
        }
        return message;
    }
    
    public String radioSelectMalsatningVarighed(){
        String message = "";
        if (enDagMalKnap.isSelected()){
            message += enDagMalKnap.getText();
        }
        if (treDageMalKnap.isSelected()){
            message += treDageMalKnap.getText();
        }
        if (femDageMalKnap.isSelected()){
            message += femDageMalKnap.getText();
        }
        if (enUgeMalKnap.isSelected()){
            message += enUgeMalKnap.getText();
        }
        return message;
    }
    
    @FXML
    public void handleGemMalsatning(){
        malsatningFejlLabel.setText("");
        if (malsatningValid()){
            malsatningGemtLabel.setText("Målsætningen "+radioSelectMalsatning()+ " \naf længden "+ radioSelectMalsatningVarighed()+ " er gemt!");
        }
    }
    
    @FXML 
    public void handleManuelIndtastningMalsatning() throws IOException{
        Stage stage = (Stage) manuelIndtastningMalsatningKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/ManuelIndtastningFysiskAktivitetView.fxml"));
        stage.setScene(new Scene(root));
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
                                if(sekunder > 59){
                                    milisekunder = 0;
                                    sekunder = 0;
                                    minutter ++;
                                }
                                if(minutter > 59){
                                    milisekunder = 0;
                                    sekunder = 0;
                                    minutter = 0;
                                    timer ++;
                                }
                                milisekunder ++;
                                String timerString = String.valueOf(timer);
                                String minutterString = String.valueOf(minutter);
                                String sekunderString = String.valueOf(sekunder);

                                System.out.println(" "+timer+" : "+minutter+" : "+sekunder);
                                timerTid = " "+timerString+" : "+minutterString+" : "+sekunderString;
                                timerText.setText(timerTid);
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
            aktivitetIntensitet = 3; 
        }
        if (gaturKnap.isSelected()){
            message += gaturKnap.getText();
            aktivitetIntensitet = 1;
        }
        if (lobeturKnap.isSelected()){
            message += lobeturKnap.getText();
            aktivitetIntensitet = 3;
        }
        if (rulleskojteKnap.isSelected()){
            message += rulleskojteKnap.getText();
            aktivitetIntensitet = 2; 
        } 

        return message;
    }
    
    
    @FXML
    public void handleStopTimer (){
        stadie = false;
        int point = 240; //skal ideelt hentes fra database 
        String p = SpilMod.point(minutter, aktivitetIntensitet,point);
        int po = Integer.parseInt(p);
        
        udfordringOpsummeringLabel.setText("Udfordring: "+radioSelectUdfordring()+"\nVarighed: "+timerTid+"\nNy pointsum: "+p +"\n"+SpilMod.level(po, 1));
        
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
    public void handleManuelIndtastningUdfordring() throws IOException{
        Stage stage = (Stage) manuelIndtastningUdfordringKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/ManuelIndtastningFysiskAktivitetView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML 
    public void handleManuelIndtastningTilbage() throws IOException{
        Stage stage = (Stage) manuelIndtastningTilbageKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
    private boolean manuelIndtastningValid(){
        String errorMessage = "";
        if (typeManuelIndtastningFelt.getText() == null || typeManuelIndtastningFelt.getText().length() == 0) {
            errorMessage += "Ingen valid type af fysisk aktivitet!\n"; 
            manuelIndtastningFejlLabel.setText(errorMessage);
        }
        if (varighedManuelIndtastningFelt.getText() == null || varighedManuelIndtastningFelt.getText().length() == 0) {
            errorMessage += "Ingen valid varighed af fysisk aktivitet!\n";
            manuelIndtastningFejlLabel.setText(errorMessage);
        }
        if (intensitetManuelIndtastningFelt.getText() == null || intensitetManuelIndtastningFelt.getText().length() == 0) {
            errorMessage += "Ingen valid intensitet af fysisk aktivitet!\n"; 
            manuelIndtastningFejlLabel.setText(errorMessage);
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            System.out.println(errorMessage);
            return false;
        }
    }
    
    @FXML 
    public void handleManuelIndtastningGem(){
        if(manuelIndtastningValid()){
            manuelIndtastningFejlLabel.setText("");
            manuelIndtastningGemtLabel.setText("Fysisk aktivitet gemt!");
        }
    }
    
    @FXML
    public void handleTilbageMalsatning() throws IOException {
        Stage stage;
        Parent root;
        stage = (Stage) malsatningTilbageKnap.getScene().getWindow();
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
