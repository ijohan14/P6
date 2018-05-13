package modeller;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FysiskAktivitet {

    
    @FXML
    private Text timerDisplay;

    @FXML
    private Text minutterDisplay;

    @FXML
    private Text sekunderDisplay;

    @FXML
    private Button startKnap;

    @FXML
    private Button stopKnap;

    @FXML
    private Button pauseKnap;

    static int milisekunder =0;
    static int sekunder = 0;
    static int minutter = 0;
    static int timer = 0;
    static boolean stadie = false;
      
    
    
    @FXML
    private void handleStartKnap() throws IOException{
        
        
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
                            sekunderDisplay.setText(" : "+sekunder);
                            
                            minutterDisplay.setText(" : "+minutter);
                            timerDisplay.setText(" "+timer);
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
    
    @FXML
    private void handlePauseKnap() throws IOException{
        stadie = false;
    }
    
    @FXML
    private void handleStopKnap() throws IOException{
        stadie = false;
        timer = 0;
        minutter = 0;
        sekunder = 0;
        milisekunder = 0;
        
        timerDisplay.setText("00 : ");
        minutterDisplay.setText("00 : ");
        sekunderDisplay.setText("00");
        
    }
}

