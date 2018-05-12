/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leifversion2;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author nathalie
 */
public class Person {

    private final SimpleStringProperty fornavn;
    private final SimpleStringProperty efternavn;
    
    public Person(String fornavn, String efternavn){
        this.fornavn = new SimpleStringProperty(fornavn);
        this.efternavn = new SimpleStringProperty(efternavn);
    }
    
     public String getFornavn() {
        return fornavn.get();
    }

    public void setFornavn(String fornavn) {
        this.fornavn.set(fornavn);
    }

    public StringProperty fornavnProperty() {
        return fornavn;
    }

    public String getEfternavn() {
        return efternavn.get();
    }

    public void setEfternavn(String efternavn) {
        this.efternavn.set(efternavn);
    }

    public StringProperty efternavnProperty() {
        return efternavn;
    }
    
}
