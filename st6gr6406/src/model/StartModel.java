/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.BooleanProperty;

/**
 *
 * @author 18gr6406
 */
public class StartModel {
    //Attributter
    public StringProperty fornavn;
    public StringProperty efternavn;
    public IntegerProperty CPR;
    public BooleanProperty kon;
    public IntegerProperty alder;
    public IntegerProperty familieID;
    public BooleanProperty brugerType;
    public StringProperty adgangskode;
    public BooleanProperty sporgsmal1Svar;
    public BooleanProperty sporgsmal2Svar;
    public BooleanProperty sporgsmal3Svar;
    public BooleanProperty sporgsmal4Svar;
    public int startNiveau;
    
    //Metoder
    public void startNiveau(BooleanProperty sporgsmal1Svar, BooleanProperty sporgsmal2Svar, BooleanProperty sporgsmal3Svar, BooleanProperty sporgsmal4Svar){
        
    }

    
    
}
