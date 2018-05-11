/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeller;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author idav_
 */
public class Startniveau extends Application {
    // Attributter
    boolean svar1 = true;
    boolean svar2 = false;
    boolean svar3 = true;
    boolean svar4 = true;
    int startNiveau;

    
    // Constructor
    @Override
    public void start(Stage primaryStage){
    }

    
    // Metoder
    public Startniveau(){
        int svarSum = (svar1 ? 1 : 0)+(svar2 ? 1 : 0)+(svar3 ? 1 : 0)+(svar4 ? 1 : 0);
        //System.out.println("Svarsummen er: "+svarSum); //Dette kan indkommenteres, hvis det skal tjekkes om svarsummen bliver udregnet korrekt
        
        switch (svarSum) {
            case 1: startNiveau = 1;
                break;
            case 2: startNiveau = 1;
                break;
            case 3: startNiveau = 2;
                break;
            case 4: startNiveau = 2;
                break;
            default: startNiveau = 1;
        }

        //System.out.println("Dit startniveau er: "+startNiveau); //Dette kan indkommenteres, hvis startniveauet skal tjekkes
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
