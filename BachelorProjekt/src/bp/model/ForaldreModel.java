/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author nathalie
 */
public class ForaldreModel {

    private SimpleStringProperty fornavn = new SimpleStringProperty("");
    private SimpleStringProperty efternavn =new SimpleStringProperty("");
    private SimpleStringProperty cpr = new SimpleStringProperty("");
    private SimpleStringProperty familieID = new SimpleStringProperty("");
    private SimpleBooleanProperty brugertype = new SimpleBooleanProperty();
    private SimpleStringProperty adgangskode = new SimpleStringProperty("");
    
    
    
    
    
    
    /**
     * Default
     */
    public ForaldreModel() {
        this("","","","",true,"");
    }
    
    public ForaldreModel(String fornavn, String efternavn, String cpr, String familieID, boolean brugertype, String adgangskode) {
        setFornavn(fornavn);
        setEfternavn(efternavn); 
        setCpr(cpr);
        setFamilieID(familieID);
        setBrugertype(brugertype);
        setAdgangskode(adgangskode);
    }
    
    /**
     * Constructor
     * @param fornavn
     * @param efternavn 
     */
//    public ForaldreModel(String fornavn, String efternavn, String cpr, String familieID, String adgangskode){
//        this.fornavn = new SimpleStringProperty(fornavn);
//        this.efternavn = new SimpleStringProperty(efternavn);
//        this.cpr = new SimpleStringProperty(cpr);
//        this.familieID = new SimpleStringProperty(familieID);
//        this.adgangskode = new SimpleStringProperty(adgangskode);
//    }

    /**
     * @return the fornavn
     */
    public String getFornavn() {
        return fornavn.get();
    }

    /**
     * @param fornavn the fornavn to set
     */
    public void setFornavn(String fornavn) {
        this.fornavn.set(fornavn);
        
    }
    
    public StringProperty fornavnProperty(){
        return fornavn;
    }

    /**
     * @return the efternavn
     */
    public String getEfternavn() {
        return efternavn.get();
    }

    /**
     * @param efternavn the efternavn to set
     */
    public void setEfternavn(String efternavn) {
        this.efternavn.set(efternavn);
    }
    
    public StringProperty efternavnProperty(){
        return efternavn;
    }
    /**
     * 
     */
    public String getCpr(){
        return cpr.get();
    }
    
    /**
     * 
     * @param cpr 
     */
    public void setCpr(String cpr){
        this.cpr.set(cpr);
    }
    
    public StringProperty cprProperty(){
        return cpr;
    }
    
    /**
     * 
     * @param familieID 
     */
    public String getFamilieID() {
        return familieID.get();
    }
    
    /**
     * 
     * @param familieID 
     */
    public void setFamilieID(String familieID){
        this.familieID.set(familieID);
    }
    
    public StringProperty familieIDProperty(){
        return familieID;
    }
    
    public boolean getBrugertype() {
        return brugertype.get();
    }
    
    /**
     * 
     * @param adgangskode 
     */
    public void setBrugertype(boolean brugertype){
        this.brugertype.set(brugertype);
    }
    
    public SimpleBooleanProperty brugertypeProperty(){
        return brugertype;
    }
    
    /**
     * 
     * @param adgangskode 
     */
    public String getAdgangskode() {
        return adgangskode.get();
    }
    
    /**
     * 
     * @param adgangskode 
     */
    public void setAdgangskode(String adgangskode){
        this.adgangskode.set(adgangskode);
    }
    
    public StringProperty adgangskodeProperty(){
        return adgangskode;
    }
    
  
}
