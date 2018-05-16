/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.model;

/**
 *
 * @author christinemariegrabow
 */
public class BornModel {
    
    int startNiveau;
    
    public int startniveau(boolean svar1, boolean svar2, boolean svar3, boolean svar4){
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
        return startNiveau;
    }
}
    
    
