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
public class BornekontoModel {
    //Attributter
    private int startniveau; 
    private int svarSum;
    private int hojde;
    private int vagt;
    private int alder;
    private boolean kon;
    private int svar1; 
    private int svar2; 
    private int svar3;
    //private int bmi;
    private int isobmi;
    
    //constructer 
    //private BørnekontoModel(){
      //  super();
        //vi skal lige have lavet det her, det skal være en super(det der står ovenover,  fordi det nedarver noget fra forældrekontomodel.
    //}
    
    //Metoder
    public void setStartniveau(int startniveau){
        this.startniveau = startniveau;
    }
    
    private void setSvarSum(int svarSum){
        this.svarSum = svarSum;
    }
    
    private void setSvar1(int svar1){
        this.svar1 = svar1;
    }
    
    private void setSvar2(int svar2){
        this.svar2 = svar2;
    }
    
    private void setSvar3(int svar3){
        this.svar3 = svar3;
    }
    
    //vi skal have givet svarSum en værdi. det skal være summen af svar1, svar2 og svar3. 
    
    public void startNiveau(int svarSum){
        if (svarSum == 0){
            setStartniveau(1); 
        }
        if  (svarSum == 1){ 
            setStartniveau(1); 
        }
        if (svarSum == 2){
            setStartniveau(2); 
        }
        if (svarSum == 3){
            setStartniveau(2);
        }
        else{
            System.out.println("Fejlmeddelelse");
        }
    }
    

    
    public void ISOBMI(int hojde, int vagt, int alder){
        //bmi = vagt/(hojde*hojde);
        //Herefter skal vi så udregne ISO-BMI ud fra BMI og alder.
        setIsobmi(vagt/(hojde*hojde)); //!!!!Her skal alder og køn regnes på!!!!
    }

    /**
     * @return the startniveau
     */
    public int getStartniveau() {
        return startniveau;
    }

    /**
     * @return the svarSum
     */
    public int getSvarSum() {
        return svarSum;
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
     * @return the svar1
     */
    public int getSvar1() {
        return svar1;
    }

    /**
     * @return the svar2
     */
    public int getSvar2() {
        return svar2;
    }

    /**
     * @return the svar3
     */
    public int getSvar3() {
        return svar3;
    }

    /**
     * @return the isobmi
     */
    public int getIsobmi() {
        return isobmi;
    }

    /**
     * @param isobmi the isobmi to set
     */
    public void setIsobmi(int isobmi) {
        this.isobmi = isobmi;
    }
    
     
    
            
}