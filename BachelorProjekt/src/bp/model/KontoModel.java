/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.model;

import static java.sql.JDBCType.NULL;
import java.time.LocalDate;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author nathalie
 */
public class KontoModel {
    
     private final SimpleStringProperty fornavn;
    private final SimpleStringProperty efternavn;
     private final SimpleStringProperty cpr;
    private final SimpleStringProperty familieID;
     private final SimpleBooleanProperty brugertype;
    private final SimpleStringProperty adgangskode;
     private int startniveau;
    
  
    
    
    
    
    
    /**
     * Default
     */
    
    public KontoModel(){
        this("","","","",true,"",0);
    }
   
    
    /**
     * 
     * @param fornavn
     * @param efternavn
     * @param cpr
     * @param familieID
     * @param brugertype
     * @param adgangskode
     */
    public KontoModel(String fornavn, String efternavn, String cpr, String familieID, boolean brugertype, String adgangskode, int startniveau) {
        this.fornavn = new SimpleStringProperty(fornavn);
        this.efternavn = new SimpleStringProperty(efternavn);
        this.cpr = new SimpleStringProperty(cpr);
        this.familieID = new SimpleStringProperty(familieID);
        this.brugertype = new SimpleBooleanProperty(brugertype);
        this.adgangskode = new SimpleStringProperty(adgangskode);
        this.startniveau = startniveau;
        
    }
    
      

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
    
    
    public BooleanProperty brugertypeProperty(){
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

    
    public int getStartniveau(){
        return startniveau;
    }
    

    /**
     * @return the startniveau
     */
    public int getStartniveau(boolean svar1, boolean svar2, boolean svar3, boolean svar4) {
        int svarSum = (svar1 ? 1 : 0)+(svar2 ? 1 : 0)+(svar3 ? 1 : 0)+(svar4 ? 1 : 0);
        System.out.println("Svarsummen er: "+svarSum); //Dette kan indkommenteres, hvis det skal tjekkes om svarsummen bliver udregnet korrekt
        
        switch (svarSum) {
            case 1: startniveau = 1;
                break;
            case 2: startniveau = 1;
                break;
            case 3: startniveau = 2;
                break;
            case 4: startniveau = 2;
                break;
            default: startniveau = 1;
        }
        return startniveau;
    }

    /**
     * @param startniveau the startniveau to set
     */
    public void setStartniveau(int startniveau) {
        this.startniveau = startniveau;
    }
  
}
