/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Gruppe 18gr6406
 */
public class RegistreringModel {
    private int dato; 
    private StringProperty maltid; 
    private StringProperty kost; 
    private int hojde; 
    private int vagt; 
    private int alder; 
    private BooleanProperty kon; 
    private int isoBmi; 

    /**
     * @return the dato
     */
    public int getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(int dato) {
        this.dato = dato;
    }

    /**
     * @return the maltid
     */
    public StringProperty getMaltid() {
        return maltid;
    }

    /**
     * @param maltid the maltid to set
     */
    public void setMaltid(StringProperty maltid) {
        this.maltid = maltid;
    }

    /**
     * @return the kost
     */
    public StringProperty getKost() {
        return kost;
    }

    /**
     * @param kost the kost to set
     */
    public void setKost(StringProperty kost) {
        this.kost = kost;
    }

    /**
     * @return the hojde
     */
    public int getHojde() {
        return hojde;
    }

    /**
     * @param hojde the hojde to set
     */
    public void setHojde(int hojde) {
        this.hojde = hojde;
    }

    /**
     * @return the vagt
     */
    public int getVagt() {
        return vagt;
    }

    /**
     * @param vagt the vagt to set
     */
    public void setVagt(int vagt) {
        this.vagt = vagt;
    }

    /**
     * @return the alder
     */
    public int getAlder() {
        return alder;
    }

    /**
     * @param alder the alder to set
     */
    public void setAlder(int alder) {
        this.alder = alder;
    }

    /**
     * @return the kon
     */
    public BooleanProperty getKon() {
        return kon;
    }

    /**
     * @param kon the kon to set
     */
    public void setKon(BooleanProperty kon) {
        this.kon = kon;
    }

    /**
     * @return the isoBmi
     */
    public int getIsoBmi() {
        return isoBmi;
    }

    /**
     * @param isoBmi the isoBmi to set
     */
    public void setIsoBmi(int isoBmi) {
        this.isoBmi = isoBmi;
    }
    
}
