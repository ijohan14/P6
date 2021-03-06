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
public class BornController implements Initializable {

    static int milisekunder =0;
    static int sekunder = 0;
    static int minutter = 0;
    static int timer = 0;
    static boolean stadie = false;
    String timerTid;
    int intensitet;
    SpilModel SpilMod = new SpilModel();
    
    //malsatning
    @FXML
    public Button malsatningTilbageKnap; 
    @FXML
    private RadioButton gaturMalKnap;
    @FXML
    private RadioButton cykelSkoleMalKnap;
    @FXML
    private RadioButton enDagMalKnap;
    @FXML
    private RadioButton treDageMalKnap;
    @FXML
    private RadioButton femDageMalKnap;
    @FXML
    private RadioButton enUgeMalKnap;
    @FXML
    private Button manuelIndtastningMalsatningKnap;
    @FXML
    private Label malsatningFejlLabel;
    @FXML
    private Label malsatningGemtLabel;
    
    //udfordring
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
    public Text timerText;
    @FXML
    public Label udfordringFejlLabel;
    @FXML
    private RadioButton sjippetovKnap;
    @FXML
    private RadioButton gaturKnap;
    @FXML
    private RadioButton lobeturKnap;
    @FXML
    private RadioButton rulleskojteKnap;
    
    //menuborn
    @FXML 
    public Button bornLogUdKnap; 
    @FXML 
    public Button udfordringKnap;
    @FXML 
    public Button malsatningKnap; 
    
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
        Stage stage = (Stage) bornLogUdKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/LogIndView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
        System.out.println("Du er logget ud");
    }

    @FXML
    public void handleMalsatning() throws IOException {
        Stage stage = (Stage) malsatningKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/MalsatningView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
    }
    
    public boolean erMalsatningIndtastet(){ 
        String meddelelse = "";
        if ((gaturMalKnap.isSelected() == false) && (cykelSkoleMalKnap.isSelected() == false)){
            meddelelse += "Igen målsætning valgt!\n";
            malsatningFejlLabel.setText(meddelelse);
        }
        if ((enDagMalKnap.isSelected() == false) && (treDageMalKnap.isSelected() == false) && (femDageMalKnap.isSelected() == false) && (enUgeMalKnap.isSelected() == false)){
            meddelelse += "Ingen varighed for målsætning valgt!";
            malsatningFejlLabel.setText(meddelelse);
        }
        if (meddelelse.length() == 0) {
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
    public void handleMalsatningGem(){ 
        malsatningFejlLabel.setText("");
        if (erMalsatningIndtastet()){
            malsatningGemtLabel.setText("Målsætningen "+radioSelectMalsatning()+ " \naf varigheden "+ radioSelectMalsatningVarighed()+ " er registreret!");
        }
    }
    
    @FXML 
    public void handleManuelIndtastningMalsatning() throws IOException{ 
        Stage stage = (Stage) manuelIndtastningMalsatningKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/ManuelIndtastningView.fxml")); //...tastningFysiskAktivitetView
        stage.setScene(new Scene(root));
        stage.show();
    }
    
    @FXML
    public void handleUdfordring() throws IOException {
        Stage stage = (Stage) udfordringKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/UdfordringView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
    }
    
    public boolean erUdfordringIndtastet(){
        String meddelelse = "";
        if ((sjippetovKnap.isSelected() == false) && (gaturKnap.isSelected() == false) && (lobeturKnap.isSelected() == false) && (rulleskojteKnap.isSelected() == false)){
            meddelelse += "Ingen udfordring valgt!\n";
            udfordringFejlLabel.setText(meddelelse);
        }
        if (meddelelse.length() == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    
    @FXML
    public void handleStartTimer(){
        timerText.setText("0 : 0 : 0");
        if ((erUdfordringIndtastet()) && ((timer == 0) && (minutter == 0) && (sekunder == 0) && (milisekunder == 0)) ){
            udfordringFejlLabel.setText("");
            udfordringGemtLabel.setText("");
            udfordringOpsummeringLabel.setText("");
            //timerText.setText(SpilMod.startTimer());
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
    
        } else {
            udfordringFejlLabel.setText("Gem udfordringen før påbegyndelse\n af ny udfordring");
        }
    }
    
    
    @FXML
    public String radioSelectUdfordring(){
        String message = "";
        udfordringGemtLabel.setText("");
        udfordringOpsummeringLabel.setText("");
        if (sjippetovKnap.isSelected()){
            message += sjippetovKnap.getText();
            intensitet = 3; 
        }
        if (gaturKnap.isSelected()){
            message += gaturKnap.getText();
            intensitet = 1;
        }
        if (lobeturKnap.isSelected()){
            message += lobeturKnap.getText();
            intensitet = 3;
        }
        if (rulleskojteKnap.isSelected()){
            message += rulleskojteKnap.getText();
            intensitet = 2; 
        } 

        return message;
    }
    
    
    @FXML
    public void handleStopTimer (){
        stadie = false;
        int point = 240; //skal ideelt hentes fra database 
        String p = SpilMod.getPoint(minutter, intensitet, point);
        int po = Integer.parseInt(p);
        
        udfordringOpsummeringLabel.setText("Udfordring: "+radioSelectUdfordring()+"\nVarighed: "+timerTid+"\nNy pointsum: "+p +"\n"+SpilMod.getLevel(po, 1));
        
//        timer = 0;
//        minutter = 0;
//        sekunder = 0;
//        milisekunder = 0;

    }
    
    @FXML 
    public void handleUdfordringGem(){ 
        if ((erUdfordringIndtastet())){
            udfordringGemtLabel.setText("Udfordringen er gemt!");
            timer = 0;
            minutter = 0;
            sekunder = 0;
            milisekunder = 0;
        } else if ((erUdfordringIndtastet())&& ((timer == 0) && (minutter == 0) && (sekunder == 0) && (milisekunder == 0))){
            udfordringFejlLabel.setText("Start timer før du kan gemme");
        }
//         else {
//            udfordringFejlLabel.setText("Ingen udfordring valgt\nStart timer før du kan gemme");
//        }
//        
        
    }
    
    
    @FXML 
    public void handleManuelIndtastningTilbage() throws IOException{
        Stage stage = (Stage) manuelIndtastningTilbageKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
    }
    private boolean erManuelIndtastningIndtastet(){ 
        String meddelelse = "";
        if (typeManuelIndtastningFelt.getText() == null || typeManuelIndtastningFelt.getText().length() == 0) {
            meddelelse += "Ingen indtastet type af fysisk aktivitet!\n"; 
            manuelIndtastningFejlLabel.setText(meddelelse);
        }
        if (varighedManuelIndtastningFelt.getText() == null || varighedManuelIndtastningFelt.getText().length() == 0) {
            meddelelse += "Ingen indtastet varighed af fysisk aktivitet!\n";
            manuelIndtastningFejlLabel.setText(meddelelse);
        }
        if (intensitetManuelIndtastningFelt.getText() == null || intensitetManuelIndtastningFelt.getText().length() == 0) {
            meddelelse += "Ingen indtastet intensitet af fysisk aktivitet!\n"; 
            manuelIndtastningFejlLabel.setText(meddelelse);
        }
        if (meddelelse.length() == 0) {
            return true;
        } else {
            System.out.println(meddelelse);
            return false;
        }
    }
    
    @FXML 
    public void handleManuelIndtastningGem(){
        if(erManuelIndtastningIndtastet()){
            manuelIndtastningFejlLabel.setText("");
            manuelIndtastningGemtLabel.setText("Fysisk aktivitet gemt!");
        }
    }
    
    @FXML
    public void handleMalsatningTilbage() throws IOException { 
        Stage stage = (Stage) malsatningTilbageKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
    }
    
    @FXML
    public void handleUdfordringTilbage() throws IOException { 
        Stage stage = (Stage) udfordringTilbageKnap.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/bp/view/MenuBornView.fxml"));
        stage.setScene(new Scene(root));
        stage.show();   
    }

    
}
