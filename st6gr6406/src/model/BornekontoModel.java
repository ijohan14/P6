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
    public int startniveau; 
    private int svarSum;
    private int hojde;
    private int vagt;
    public int alder; 
    private int svar1; 
    private int svar2; 
    private int svar3;
    
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
    
    public void startNivaeu(int svarSum){
        if (svarSum == 0){
            startniveau = 1; 
        }
        if  (svarSum == 1){ 
            startniveau = 1; 
        }
        if (svarSum == 2){
            startniveau = 2; 
        }
        if (svarSum == 3){
            startniveau = 2;
        }
        else{
            System.out.println("Fejlmeddelelse");
        }
    }
    
            
}