/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.StringProperty;

/**
 *
 * @author Gruppe 18gr6406
 */
public class SpilModel {
    private StringProperty udfordring;
    private StringProperty malsatning; 
    private StringProperty typeMalsatning;
    private StringProperty varighedMalsatning; 
    private StringProperty type; 
    private StringProperty varighed; 

    /**
     * @return the udfordring
     */
    public StringProperty getUdfordring() {
        return udfordring;
    }

    /**
     * @param udfordring the udfordring to set
     */
    public void setUdfordring(StringProperty udfordring) {
        this.udfordring = udfordring;
    }

    /**
     * @return the malsatning
     */
    public StringProperty getMalsatning() {
        return malsatning;
    }

    /**
     * @param malsatning the malsatning to set
     */
    public void setMalsatning(StringProperty malsatning) {
        this.malsatning = malsatning;
    }

    /**
     * @return the typeMalsatning
     */
    public StringProperty getTypeMalsatning() {
        return typeMalsatning;
    }

    /**
     * @param typeMalsatning the typeMalsatning to set
     */
    public void setTypeMalsatning(StringProperty typeMalsatning) {
        this.typeMalsatning = typeMalsatning;
    }

    /**
     * @return the varighedMalsatning
     */
    public StringProperty getVarighedMalsatning() {
        return varighedMalsatning;
    }

    /**
     * @param varighedMalsatning the varighedMalsatning to set
     */
    public void setVarighedMalsatning(StringProperty varighedMalsatning) {
        this.varighedMalsatning = varighedMalsatning;
    }

    /**
     * @return the type
     */
    public StringProperty getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(StringProperty type) {
        this.type = type;
    }

    /**
     * @return the varighed
     */
    public StringProperty getVarighed() {
        return varighed;
    }

    /**
     * @param varighed the varighed to set
     */
    public void setVarighed(StringProperty varighed) {
        this.varighed = varighed;
    }
    
}
