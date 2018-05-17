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
}