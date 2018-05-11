/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeller;

import javafx.application.Application;
import javafx.stage.Stage;


//  !!!!!!!!!!! DET ER DENNE FIL DER HAR DEN RIGTIGE KODE FOR ISO BMI UDREGNING !!!!!!!!!

/**
 *
 * @author idav_
 */
public class IsoBmi2 extends Application {
    int alder = 8; //alder i år
    float vagt = 78;  // Vægt i kg. Det er en double fordi den skal kunne registrere kommatal
    float hojde = 127;  //Højde i cm
    boolean kon = false;  //falsk = dreng, true = pige
    double granseOvervagt; //bruges til at sætte BMI grænseværdien for barnets køn og alder
    double granseSvarOvervagt;
    double granseNormalVagt;
    float bmi; //double fordi den skal kunne indeholde kommatal
    String bmiBarn = "Barnet har en BMI på ";
    String normalVagt = "Barnet er derfor normalvægtigt. Vær opmærksom på at dette system ikke tester for undervægt.";
    
    @Override
    public void start(Stage primaryStage){
    }
    
    
    public IsoBmi2(){
    this.bmi = ((100*100*vagt)/(hojde*hojde));
    
    // Iso-Bmi resultat for 8 årig dreng
    if(kon == false && alder == 8){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 21.6;
        granseOvervagt = 18.44;
        System.out.println("Grænseværdierne for en dreng på "+alder+" år er: "
                            + "Overvægt = BMI > "+granseOvervagt+", "
                            + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 21.6){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 18.44){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
    
    // Iso-Bmi resultat for en 8 årig pige
    else if (kon == true && alder == 8){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 21.57;
        granseOvervagt = 18.35;
        System.out.println("Grænseværdierne for en pige på "+alder+" år er: "
                + "Overvægt = BMI > "+granseOvervagt+", "
                        + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 21.57){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 18.35){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
    
    // Iso-Bmi resultat for 9 årig dreng
    else if(kon == false && alder == 9){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 22.77;
        granseOvervagt = 19.2;
        System.out.println("Grænseværdierne for en dreng på "+alder+" år er: "
                + "Overvægt = BMI > "+granseOvervagt+", "
                        + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 22.77){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 19.2){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
            
    // Iso-Bmi resultat for en 9 årig pige
    else if (kon == true && alder == 9){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 22.81;
        granseOvervagt = 19.07;
        System.out.println("Grænseværdierne for en pige på "+alder+" år er:"
                + " Overvægt = BMI > "+granseOvervagt+", "
                        + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 22.81){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 19.07){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
    
    // Iso-Bmi resultat for 10 årig dreng
    else if(kon == false && alder == 10){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 24.00;
        granseOvervagt = 19.84;
        System.out.println("Grænseværdierne for en dreng på "+alder+" år er: "
                + "Overvægt = BMI > "+granseOvervagt+", "
                        + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 24.00){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 19.84){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
    
    // Iso-Bmi resultat for en 10 årig pige
    else if (kon == true && alder == 10){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 24.11;
        granseOvervagt = 19.86;
        System.out.println("Grænseværdierne for en pige på "+alder+" år er: "
                + "Overvægt = BMI > "+granseOvervagt+", "
                        + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 24.11){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 19.86){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
    
    // Iso-Bmi resultat for 11 årig dreng
    else if(kon == false && alder == 11){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 25.10;
        granseOvervagt = 20.55;
        System.out.println("Grænseværdierne for en dreng på "+alder+" år er: "
                + "Overvægt = BMI > "+granseOvervagt+", "
                        + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 25.10){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 20.55){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
    
    // Iso-Bmi resultat for en 11 årig pige
    else if (kon == true && alder == 11){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 25.42;
        granseOvervagt = 20.74;
        System.out.println("Grænseværdierne for en pige på "+alder+" år er: "
                + "Overvægt = BMI > "+granseOvervagt+", "
                        + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 25.42){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 20.74){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
    
    // Iso-Bmi resultat for 12 årig dreng
    else if(kon == false && alder == 12){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 26.02;
        granseOvervagt = 21.22;
        System.out.println("Grænseværdierne for en dreng på "+alder+" år er: "
                + "Overvægt = BMI > "+granseOvervagt+", "
                        + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 26.02){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 21.22){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
    
    // Iso-Bmi resultat for en 12 årig pige
    else if (kon == true && alder == 12){
        System.out.println(bmiBarn+bmi);
        granseSvarOvervagt = 26.67;
        granseOvervagt = 21.68;
        System.out.println("Grænseværdierne for en pige på "+alder+" år er: "
                + "Overvægt = BMI > "+granseOvervagt+", "
                        + "Svær overvægt = BMI > "+granseSvarOvervagt);
        
        if(bmi >= 26.67){
            System.out.println("Barnet er derfor svært overvægtigt.");
        }
        else if(bmi >= 21.68){
            System.out.println("Barnet er derfor overvægtigt.");
        }
        else{
            System.out.println(normalVagt);
        }
    }
            
    else {
        System.out.println("Barnet ligger uden for aldersgruppen til dette system.");
    }
    
}
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
