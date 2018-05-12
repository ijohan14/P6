package modeller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class FysiskAktivitet{

    @FXML
    private Text tTimer;

    @FXML
    private Text mTimer;

    @FXML
    private Text sTimer;

    @FXML
    private Button startTimerKnap;

    @FXML
    private Button stopTimerKnap;
    
    static int sekunder = 0;
    static int minutter = 0;
    static int timer = 0;
    static boolean stadie = true;
    
    
    

}
