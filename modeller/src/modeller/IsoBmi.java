/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeller;

// !!!!!!!! DETTE ER DEN FORKERTE ISO BMI KODE !!!!!!!!!!!!!!! 

//import java.util.Scanner;
import javafx.application.Application;
import javafx.stage.Stage;

public class IsoBmi extends Application {
    //Scanner input = new Scanner(System.in);
    
    int alder = 9; //alder i år
    double vagt = 35;  // Vægt i kg. Det er en double fordi den skal kunne registrere kommatal
    float hojde = 140;  //Højde i cm
    boolean kon = false;  //falsk = dreng, true = pige
    double granseOvervagt; //bruges til at sætte BMI grænseværdien for barnets køn og alder
    double granseSvarOvervagt;
    double bmi; //double fordi den skal kunne indeholde kommatal
    
    
    @Override
    public void start(Stage primaryStage){
    }

    
    public IsoBmi(){
        this.bmi = ((100*100*vagt)/(hojde*hojde));
        //System.out.println(bmi);
        
        if(kon == false){
            if(alder == 8 && bmi >= 18.44){
                System.out.println("Barnet har en BMI på "+bmi);
                            
                if(bmi >= 21.6){
                    granseSvarOvervagt = 21.6;
                    System.out.println("Grænseværdien for svær overvægt for en dreng på "+alder+" år er "+granseSvarOvervagt);
                    System.out.println("Barnet er derfor svært overvægtigt.");
                }
                else{
                    granseOvervagt = 18.44;
                    System.out.println("Grænseværdien for overvægt for en dreng på "+alder+" år er "+granseOvervagt);
                    System.out.println("Barnet er derfor overvægtigt.");
                }
            }
            
            else if(alder == 9 && bmi >= 19.1){
                System.out.println("Barnet har en BMI på "+bmi);
                            
                if(bmi >= 22.77){
                    granseSvarOvervagt = 22.77;
                    System.out.println("Grænseværdien for svær overvægt for en dreng på "+alder+" år er "+granseSvarOvervagt);
                    System.out.println("Barnet er derfor svært overvægtigt.");
                }
                else{
                    granseOvervagt = 19.1;
                    System.out.println("Grænseværdien for overvægt for en dreng på "+alder+" år er "+granseOvervagt);
                    System.out.println("Barnet er derfor overvægtigt.");
                }
            }
            
            else if(alder == 10 && bmi >= 19.84){
                System.out.println("Barnet har en BMI på "+bmi);
                            
                if(bmi >= 24.0){
                    granseSvarOvervagt = 24.0;
                    System.out.println("Grænseværdien for svær overvægt for en dreng på "+alder+" år er "+granseSvarOvervagt);
                    System.out.println("Barnet er derfor svært overvægtigt.");
                }
                else{
                    granseOvervagt = 19.84;
                    System.out.println("Grænseværdien for overvægt for en dreng på "+alder+" år er "+granseOvervagt);
                    System.out.println("Barnet er derfor overvægtigt.");
                }
            }
            
            else if(alder == 11 && bmi >= 20.5){
                System.out.println("Barnet har en BMI på "+bmi);
                            
                if(bmi >= 25.1){
                    granseSvarOvervagt = 25.1;
                    System.out.println("Grænseværdien for svær overvægt for en dreng på "+alder+" år er "+granseSvarOvervagt);
                    System.out.println("Barnet er derfor svært overvægtigt.");
                }
                else{
                    granseOvervagt = 20.5;
                    System.out.println("Grænseværdien for overvægt for en dreng på "+alder+" år er "+granseOvervagt);
                    System.out.println("Barnet er derfor overvægtigt.");
                }
            }
            
            else if(alder == 12 && bmi >= 21.22){
                System.out.println("Barnet har en BMI på "+bmi);
                            
                if(bmi >= 26.02){
                    granseSvarOvervagt = 26.02;
                    System.out.println("Grænseværdien for svær overvægt for en dreng på "+alder+" år er "+granseSvarOvervagt);
                    System.out.println("Barnet er derfor svært overvægtigt.");
                }
                else{
                    granseOvervagt = 21.22;
                    System.out.println("Grænseværdien for overvægt for en dreng på "+alder+" år er "+granseOvervagt);
                    System.out.println("Barnet er derfor overvægtigt.");
                }
            }
            
            else if (alder >= 8 && alder <= 12 && bmi < 18.44){
                System.out.println("Drengen er ikke overvægtig.");
            }
            
            else {
                System.out.println("Drengen ligger uden for aldersgruppen til dette system.");
            }

        }

        else {
            System.out.println("Barnet ligger uden for aldersgruppen til dette system.");
        }
    }
    
    
    /*
    private void udregnIsoBmi(int vagt, int hojde){
        isoBmi = vagt/(hojde*hojde);
                   
        System.out.println(isoBmi);
    }
    */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
