/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



/**
 *
 * @author 18gr6406
 */
public class MenuBornModel {
    //attributter 
    private StringProperty fornavn;
    private StringProperty efternavn;
    private StringProperty CPR;   //OBS, det ville ikke fungere med integer!!
    private IntegerProperty familieID;
    private BooleanProperty brugerType;
    private StringProperty adgangskode;
    
    public int level;
    public int point;
    public String avatarHarFarve;
    public String avatarBukserFarve;
    public String avatarTrojeFarve;
    public String udfordring;
    public String malsatning;
    public String typeMalsatning;
    public int malsatningVarighed;
    public String typeUdfordring;
    public int udfordringVarighed;
    //Timer??
    

    
    
    public void avatar(String avatarHarFarve, String avatarBukserFarve, String avatarTrojeFarve){
        //Her skal der oprettes figurer, der ligner en avatar, det gør vi senere
    }
    
    public String udfordring(String udfordringType, int udfordringVarighed){
        return udfordring;
    }
    
    public String malsatning(String malsatningType, int malsatningVarighed){
        return malsatning;
    }
    
    public int level(int point){
        return level;
    }
    
    public int point(String udfordring, String malsatning){
        return point;
    }

}
