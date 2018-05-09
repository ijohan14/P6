/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author nathalie
 */
public class VejledningModel {
    //Attributter
    private int dato;
    private String maltid;
    private String kost;
    private int vagt;
    private int hojde;
    private String kostVejledning; //Vejledningcontroller skal bruge, derfor +m
    private String kostRegistrering; //navnet hedder dette, fordi den hænger sammen med kostregistreringview og -controller
    private String fysiskAktivitetVejledning; 
    private String opskrifter;
    private int isoBmi;
    
    //Metoder
    public int isoBmi (int vagt, int hojde){
        return getIsoBmi();
    }
    
    public void dagensKost(int dato, String maltid, String kost){
        
    }

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
    public String getMaltid() {
        return maltid;
    }

    /**
     * @param maltid the maltid to set
     */
    public void setMaltid(String maltid) {
        this.maltid = maltid;
    }

    /**
     * @return the kost
     */
    public String getKost() {
        return kost;
    }

    /**
     * @param kost the kost to set
     */
    public void setKost(String kost) {
        this.kost = kost;
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
     * @return the kostVejledning
     */
    public String getKostVejledning() {
        return kostVejledning;
    }

    /**
     * @param kostVejledning the kostVejledning to set
     */
    public void setKostVejledning(String kostVejledning) {
        this.kostVejledning = kostVejledning;
    }

    /**
     * @return the kostRegistrering
     */
    public String getKostRegistrering() {
        return kostRegistrering;
    }

    /**
     * @param kostRegistrering the kostRegistrering to set
     */
    public void setKostRegistrering(String kostRegistrering) {
        this.kostRegistrering = kostRegistrering;
    }

    /**
     * @return the fysiskAktivitetVejledning
     */
    public String getFysiskAktivitetVejledning() {
        return fysiskAktivitetVejledning;
    }

    /**
     * @param fysiskAktivitetVejledning the fysiskAktivitetVejledning to set
     */
    public void setFysiskAktivitetVejledning(String fysiskAktivitetVejledning) {
        this.fysiskAktivitetVejledning = fysiskAktivitetVejledning;
    }

    /**
     * @return the opskrifter
     */
    public String getOpskrifter() {
        return opskrifter;
    }

    /**
     * @param opskrifter the opskrifter to set
     */
    public void setOpskrifter(String opskrifter) {
        this.opskrifter = opskrifter;
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
