/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author 18gr6406
 */
public class StartModel {
    //Attributter
    private StringProperty fornavn;
    private StringProperty efternavn;
    private StringProperty CPR;
    public BooleanProperty kon;
    public IntegerProperty alder;
    private StringProperty familieID;
    private BooleanProperty brugertype;
    private StringProperty adgangskode;
    public BooleanProperty sporgsmal1Svar;
    public BooleanProperty sporgsmal2Svar;
    public BooleanProperty sporgsmal3Svar;
    public BooleanProperty sporgsmal4Svar;
    public int startNiveau;
    
    /**
     * Default constructor
     * Denne sætter CPR og adgangskode til null som default.
     */
    public StartModel(){
        this(null, null, false);
    }
    
    public StartModel(String CPR, String adgangskode, Boolean brugertype) {
        this.CPR = new SimpleStringProperty(CPR);
        this.adgangskode = new SimpleStringProperty(adgangskode);
        this.brugertype = new SimpleBooleanProperty(brugertype);
        
        this.fornavn = new SimpleStringProperty("Indtast fornavn");
        this.efternavn = new SimpleStringProperty("Indtast efternavn");
        this.familieID = new SimpleStringProperty("Indtast familieID");
    }
    
    public void startNiveau(BooleanProperty sporgsmal1Svar, BooleanProperty sporgsmal2Svar, BooleanProperty sporgsmal3Svar, BooleanProperty sporgsmal4Svar){
        
    }

    /**
     * @return the fornavn
     */
    public StringProperty getFornavn() {
        return fornavn;
    }

    /**
     * @param fornavn the fornavn to set
     */
    public void setFornavn(StringProperty fornavn) {
        this.fornavn = fornavn;
    }

    /**
     * @return the efternavn
     */
    public StringProperty getEfternavn() {
        return efternavn;
    }

    /**
     * @param efternavn the efternavn to set
     */
    public void setEfternavn(StringProperty efternavn) {
        this.efternavn = efternavn;
    }

    /**
     * @return the CPR
     */
    public StringProperty getCPR() {
        return CPR;
    }

    /**
     * @param CPR the CPR to set
     */
    public void setCPR(StringProperty CPR) {
        this.CPR = CPR;
    }

    /**
     * @return the familieID
     */
    public StringProperty getFamilieID() {
        return familieID;
    }

    /**
     * @param familieID the familieID to set
     */
    public void setFamilieID(StringProperty familieID) {
        this.familieID = familieID;
    }

    /**
     * @return the brugertype
     */
    public BooleanProperty getBrugertype() {
        return brugertype;
    }

    /**
     * @param brugertype the brugertype to set
     */
    public void setBrugertype(BooleanProperty brugertype) {
        this.brugertype = brugertype;
    }

    /**
     * @return the adgangskode
     */
    public StringProperty getAdgangskode() {
        return adgangskode;
    }

    /**
     * @param adgangskode the adgangskode to set
     */
    public void setAdgangskode(StringProperty adgangskode) {
        this.adgangskode = adgangskode;
    }

    
    
}
