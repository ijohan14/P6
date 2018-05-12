/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeller;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

/**
 *
 * @author idav_
 */
public class Level extends Application {
    // Attributter
    double level = 1;
    double point;
    float pointSum;
    boolean fysiskAktivitet = true;
    float aktivitetLangde = 20;
    int aktivitetIntensitet = 2;
    float aktivPoint;
    double levelPoint;
    double mangelPoint;
    

    
    // Constructor
    @Override
    public void start(Stage primaryStage){
    }

    
    // Metoder
    public Level(){
        while(fysiskAktivitet == true){  //Når der er udført en fysisk aktivitet, skal fysiskAktivitet sættes til true. Derved kommer vi ind i denne løkke. Når der er blevet tildelt point for aktiviteten, så sættes fysiskAktivitet til false.
            aktivPoint = (10 * (aktivitetLangde/5)* aktivitetIntensitet);  //Her udregnes antallet af point, der skal tildeles for den fysiske aktivitet (10 point for hvert 5. minut ganget med intensiteten)
            //point = aktivPoint + point; //Her lægges pointene fra den fysiske aktivtet til barnets samlede pointsum
            levelPoint = aktivPoint + point;  //Bruges til at regne hvornår barnet skal op i level. Anvendes fordi denne skal 
            
            if(levelPoint >= 100 * Math.sqrt(level)){ //Hvis levelPoint er større end det krævede antal point for barnets pågældende level, kommer vi ind i dette loop for at stige et level.
                level ++;
                point = levelPoint;
                levelPoint = 0;
                System.out.println("Tillykke! Du er steget til level "+level+". Du er sej!");
            }
            else{ //Hvis ikke barnets point er høj nok til at stige i level, lægges pointene fra aktiviteten over i den samlede pointsum
                point = levelPoint;
                mangelPoint = (100 * Math.sqrt(level)-levelPoint);
                System.out.println("Dine nuværende point er: "+point+" Du mangler "+mangelPoint+" point for at komme til næste level! Fortsæt den gode indsats!");
            }
            fysiskAktivitet = false;
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}
