/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.model;

import static java.lang.Thread.sleep;

/**
 *
 * @author Gruppe 18gr6406
 */
public class SpilModel {
    float aktivPoint;
    float mangelPoint;
    String timerTid;
    
    
    //metode udfordring()
    //metode malsatning(type, varighed)
    
    
    //metode 
    
    
    
    public String point(int aktivitetLangde, int aktivitetIntensitet, int pointsum){ //udregnpoint
        aktivPoint = ((aktivitetLangde *2) * aktivitetIntensitet);
        pointsum += aktivPoint; 
        String nyPointsum = String.valueOf(pointsum);
        return nyPointsum; 
    }
    
    public String level(int pointsum, int level){
        String outputLevel ="";
        if(pointsum >= (100 * Math.sqrt(level))+(100* Math.sqrt(level+1))){ //Hvis levelPoint er større end det krævede antal point for barnets pågældende level, kommer vi ind i dette loop for at stige et level.
                level ++;
                outputLevel = "Du er nu steget til level "+String.valueOf(level);
            }
            else{ //Hvis ikke barnets point er høj nok til at stige i level, lægges pointene fra aktiviteten over i den samlede pointsum
                mangelPoint = Math.round((100 * Math.sqrt(level))+(100* Math.sqrt(level+1))-pointsum);
                outputLevel = "Du er "+ String.valueOf(mangelPoint)+" point fra at stige i level.";
            }
        return outputLevel;
    }
    
    public String startTimer(){
        boolean  stadie = true; 
        Thread stopUr = new Thread(){
            public void run(){
                for(;;){
                    if(stadie == true){
                        try{
                            sleep(1);
                            int milisekunder = 0;
                            int sekunder = 0;
                            if(milisekunder > 1000){
                                milisekunder = 0;
                                sekunder ++;
                            }
                            int minutter = 0;
                            if(sekunder > 59){
                                milisekunder = 0;
                                sekunder = 0;
                                minutter ++;
                            }
                            int timer = 0;
                            if(minutter > 59){
                                milisekunder = 0;
                                sekunder = 0;
                                minutter = 0;
                                timer ++;
                            }
                            milisekunder ++;
                            String timerString = String.valueOf(timer);
                            String minutterString = String.valueOf(minutter);
                            String sekunderString = String.valueOf(sekunder);

                            System.out.println(" "+timer+" : "+minutter+" : "+sekunder);
                            timerTid = " "+timerString+" : "+minutterString+" : "+sekunderString;
//                                timerText.setText(timerTid);
                        }
                        catch(Exception e){
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        };
        stopUr.start();
        return timerTid;
    }
}
    
