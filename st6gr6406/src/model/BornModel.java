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
public class BornModel {
    //attributter 
//    private StringProperty fornavn;
//    private StringProperty efternavn;
//    private StringProperty CPR;   //OBS, det ville ikke fungere med integer!!
//    private IntegerProperty familieID;
//    private BooleanProperty brugerType;
//    private StringProperty adgangskode;
    
    private int level;
    private int point;
//    public String avatarHarFarve;
//    public String avatarBukserFarve;
//    public String avatarTrojeFarve;
//    private String udfordring;
//    private String malsatning;
//    private String typeMalsatning;
//    private int malsatningVarighed;
//    private String typeUdfordring;
//    private int udfordringVarighed;
    private boolean startNiveau; //ch har lavet den 9. maj
    //Timer??
    

    
    
//    public void avatar(String avatarHarFarve, String avatarBukserFarve, String avatarTrojeFarve){
//        //Her skal der oprettes figurer, der ligner en avatar, det gør vi senere
//    }
    
    public String udfordring(String udfordringType, int udfordringVarighed){
        return getUdfordring();
    }
    
    public String malsatning(String malsatningType, int malsatningVarighed){
        return getMalsatning();
    }
    
    public int level(int point){
        return getLevel();
    }
    
    public int point(String udfordring, String malsatning){
        return getPoint();
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

    /**
     * @return the point
     */
    public int getPoint() {
        return point;
    }

    /**
     * @param point the point to set
     */
    public void setPoint(int point) {
        this.point = point;
    }

    /**
     * @return the udfordring
     */
    public String getUdfordring() {
        return udfordring;
    }

    /**
     * @param udfordring the udfordring to set
     */
    public void setUdfordring(String udfordring) {
        this.udfordring = udfordring;
    }

    /**
     * @return the malsatning
     */
    public String getMalsatning() {
        return malsatning;
    }

    /**
     * @param malsatning the malsatning to set
     */
    public void setMalsatning(String malsatning) {
        this.malsatning = malsatning;
    }

    /**
     * @return the typeMalsatning
     */
    public String getTypeMalsatning() {
        return typeMalsatning;
    }

    /**
     * @param typeMalsatning the typeMalsatning to set
     */
    public void setTypeMalsatning(String typeMalsatning) {
        this.typeMalsatning = typeMalsatning;
    }

    /**
     * @return the malsatningVarighed
     */
    public int getMalsatningVarighed() {
        return malsatningVarighed;
    }

    /**
     * @param malsatningVarighed the malsatningVarighed to set
     */
    public void setMalsatningVarighed(int malsatningVarighed) {
        this.malsatningVarighed = malsatningVarighed;
    }

    /**
     * @return the typeUdfordring
     */
    public String getTypeUdfordring() {
        return typeUdfordring;
    }

    /**
     * @param typeUdfordring the typeUdfordring to set
     */
    public void setTypeUdfordring(String typeUdfordring) {
        this.typeUdfordring = typeUdfordring;
    }

    /**
     * @return the udfordringVarighed
     */
    public int getUdfordringVarighed() {
        return udfordringVarighed;
    }

    /**
     * @param udfordringVarighed the udfordringVarighed to set
     */
    public void setUdfordringVarighed(int udfordringVarighed) {
        this.udfordringVarighed = udfordringVarighed;
    }

    /**
     * @return the startNiveau
     */
    public boolean getStartNiveau() {
        return startNiveau;
    }

    /**
     * @param startNiveau the startNiveau to set
     */
    public void setStartNiveau(boolean startNiveau) {
        this.startNiveau = startNiveau;
    }

}
