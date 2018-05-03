/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author nathalie
 */
public class OpretKontoModel {

    private final SimpleStringProperty navn;
    
    public OpretKontoModel(){
        this(null);
    }
    
    public OpretKontoModel(String navn){
        this.navn = new SimpleStringProperty(navn);
    }
    
    public String getNavn(){
        return navn.get();
    }
    
    public void setNavn(String navn){
        this.navn.set(navn);
    }
    
}
