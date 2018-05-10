/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr6406.model;


import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;



/**
 *
 * @author 18gr6406
 */
public class BornModel extends ForaldreModel {
    //attributter 
//    private StringProperty fornavn;
//    private StringProperty efternavn;
//    private StringProperty CPR;   //OBS, det ville ikke fungere med integer!!
//    private IntegerProperty familieID;
//    private BooleanProperty brugerType;
//    private StringProperty adgangskode;
    
    private int level;
    private int point;
    private boolean startNiveau; //ch har lavet den 9. maj
    //Timer??
    

    
    
//    public void avatar(String avatarHarFarve, String avatarBukserFarve, String avatarTrojeFarve){
//        //Her skal der oprettes figurer, der ligner en avatar, det gør vi senere
//    }
    
   
    
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
