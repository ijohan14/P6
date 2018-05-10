/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author nathalie
 */
public class ForaldreModel {

    private SimpleStringProperty fornavn;
    private SimpleStringProperty efternavn;
    
    /**
     * Default
     */
    public ForaldreModel() {
        this(null, null);
    }
    
    /**
     * Constructor
     * @param fornavn
     * @param efternavn 
     */
    public ForaldreModel(String fornavn, String efternavn){
        this.fornavn = new SimpleStringProperty(fornavn);
        this.efternavn = new SimpleStringProperty(efternavn);
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
}
