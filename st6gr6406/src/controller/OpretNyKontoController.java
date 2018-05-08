/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.StartModel;
import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author 18gr6406
 */
public class OpretNyKontoController {
    //Attributter
    private StringProperty fornavn;
    private StringProperty efternavn;
    private StringProperty CPR;   //OBS, det ville ikke fungere med integer!!
    private IntegerProperty familieID;
    private BooleanProperty brugerType;
    private StringProperty adgangskode;
    private BooleanProperty sporgsmal1Svar;
    private BooleanProperty sporgsmal2Svar;
    private BooleanProperty sporgsmal3Svar;
    private BooleanProperty sporgsmal4Svar;
    private OpretNyKontoController brugerkonto;
    
 
    //Metoder
    //Er ikke sikker på at public void brugerkonto er korrekt
    public void brugerkonto(String CPR, String adgangskode) {
        this.CPR = new SimpleStringProperty(CPR);
        this.adgangskode = new SimpleStringProperty(adgangskode);
        
        this.fornavn = new SimpleStringProperty("indtast fornavn");
        this.efternavn = new SimpleStringProperty("indtast efternavn");
    }
    
    private void handleOkKnap(){
        
    }
    
    private void handleFortrydKnap(){
        
    }
    
    public void setBrugerkonto(OpretNyKontoController brugerkonto) {
        this.brugerkonto = brugerkonto;
        
        
        /*
        //Skal forbindes til OpretNyKontoView
        fornavnTekstFelt.setText(brugerkonto.getFornavn());
        efternavnTekstFelt.setText(brugerkonto.getEfternavn());
        CPRTekstFelt.setText(brugerkonto.getCPR());
        adgangskodeTekstFelt.setText(brugerkonto.getAdgangskode());
        familieIDTekstFelt.setText(Integer.toString(brugerkonto.getFamilieID());
        //Her mangler brugertype og sporgsmålSvar
        */
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
    public IntegerProperty getFamilieID() {
        return familieID;
    }

    /**
     * @param familieID the familieID to set
     */
    public void setFamilieID(IntegerProperty familieID) {
        this.familieID = familieID;
    }

    /**
     * @return the brugerType
     */
    public BooleanProperty getBrugerType() {
        return brugerType;
    }

    /**
     * @param brugerType the brugerType to set
     */
    public void setBrugerType(BooleanProperty brugerType) {
        this.brugerType = brugerType;
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

    /**
     * @return the sporgsmal1Svar
     */
    public BooleanProperty getSporgsmal1Svar() {
        return sporgsmal1Svar;
    }

    /**
     * @param sporgsmal1Svar the sporgsmal1Svar to set
     */
    public void setSporgsmal1Svar(BooleanProperty sporgsmal1Svar) {
        this.sporgsmal1Svar = sporgsmal1Svar;
    }

    /**
     * @return the sporgsmal2Svar
     */
    public BooleanProperty getSporgsmal2Svar() {
        return sporgsmal2Svar;
    }

    /**
     * @param sporgsmal2Svar the sporgsmal2Svar to set
     */
    public void setSporgsmal2Svar(BooleanProperty sporgsmal2Svar) {
        this.sporgsmal2Svar = sporgsmal2Svar;
    }

    /**
     * @return the sporgsmal3Svar
     */
    public BooleanProperty getSporgsmal3Svar() {
        return sporgsmal3Svar;
    }

    /**
     * @param sporgsmal3Svar the sporgsmal3Svar to set
     */
    public void setSporgsmal3Svar(BooleanProperty sporgsmal3Svar) {
        this.sporgsmal3Svar = sporgsmal3Svar;
    }

    /**
     * @return the sporgsmal4Svar
     */
    public BooleanProperty getSporgsmal4Svar() {
        return sporgsmal4Svar;
    }

    /**
     * @param sporgsmal4Svar the sporgsmal4Svar to set
     */
    public void setSporgsmal4Svar(BooleanProperty sporgsmal4Svar) {
        this.sporgsmal4Svar = sporgsmal4Svar;
    }
    
    
    
}
