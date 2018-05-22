/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.model;

import java.time.LocalDate;
import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

/**
 *
 * @author christinemariegrabow
 */
public class RegistreringModel {
//    int alder = 8; //alder i år
//    float vagt = 78;  // Vægt i kg. Det er en double fordi den skal kunne registrere kommatal
//    float hojde = 127;  //Højde i cm
//    boolean kon = false;  //falsk = dreng, true = pige
    double granseOvervagt; //bruges til at sætte BMI grænseværdien for barnets køn og alder
    double granseSvarOvervagt;
    double granseNormalVagt;
    float bmi; //double fordi den skal kunne indeholde kommatal
    String bmiBarn = "Barnet har en BMI på ";
    String normalVagt = "Barnet er derfor normalvægtigt. Vær opmærksom på at dette system ikke tester for undervægt.";
    
    
    //dato LocalDate, maltid String, kost String, holde int, vagt int, alder int, kon boolean, bmi float
    //get og set  - overvej hvad der skal ske med dem.
    
//    public void bmi (){
//        this.bmi = ((100*100*vagt)/(hojde*hojde));
//    }
    
    public void getKost(LocalDate dato, String maltid, String kost){
    }
    
    public void setKost(String registrerKost){
        
    }
    
    
    
    public String bmiUdregning(float hojde, float vagt, int alder, boolean kon){ //getBMI
        bmi = ((100*100*vagt)/(hojde*hojde));
        String bmiString = String.valueOf(bmi);
        //Iso-Bmi resultat for 8 årig dreng
        String returMeddelelse = "BMI: "+bmiString;
        if(kon == false && alder == 8){
//            System.out.println(bmiBarn+bmi);
            granseSvarOvervagt = 21.6;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 18.44;
            String goString = String.valueOf(granseOvervagt);
            returMeddelelse += "\nGrænseværdier - dreng, 8 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;
//            System.out.println("Grænseværdierne for en dreng på "+alder+" år er: "
//                                + "Overvægt = BMI > "+granseOvervagt+", "
//                                + "Svær overvægt = BMI > "+granseSvarOvervagt);

            if(bmi >= 21.6){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
//                System.out.println("Barnet er derfor svært overvægtigt.");
            }
            else if(bmi >= 18.44){
                returMeddelelse += "\nBarnet er derfor \novervægtigt.";
//                System.out.println("\nBarnet er derfor \novervægtigt.");
            }
            else{
                returMeddelelse += "\nBarnet er derfor \nnormalvægtigt.";// Vær opmærksom på at dette system ikke tester for undervægt.";
//                System.out.println(normalVagt);
            }
                

        }
    

        // Iso-Bmi resultat for en 8 årig pige
        else if (kon == true && alder == 8){
            granseSvarOvervagt = 21.57;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 18.35;
            String goString = String.valueOf(granseOvervagt);
                        returMeddelelse += "\nGrænseværdier - pige, 8 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;


            if(bmi >= 21.57){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
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
            granseSvarOvervagt = 22.77;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 19.2;
            String goString = String.valueOf(granseOvervagt);
                        returMeddelelse += "\nGrænseværdier - dreng, 9 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;


            if(bmi >= 22.77){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
            }
            else if(bmi >= 19.2){
                returMeddelelse += "\nBarnet er derfor \novervægtigt.";
            }
            else{
                returMeddelelse += "\nBarnet er derfor \nnormalvægtigt.";// Vær opmærksom på at dette system ikke tester for undervægt.";
            }
        }

        // Iso-Bmi resultat for en 9 årig pige
        else if (kon == true && alder == 9){

            granseSvarOvervagt = 22.81;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 19.07;
            String goString = String.valueOf(granseOvervagt);
                        returMeddelelse += "\nGrænseværdier - pige, 9 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;


            if(bmi >= 22.81){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
            }
            else if(bmi >= 19.07){
                returMeddelelse += "\nBarnet er derfor \novervægtigt.";
            }
            else{
                returMeddelelse += "\nBarnet er derfor \nnormalvægtigt.";// Vær opmærksom på at dette system ikke tester for undervægt.";
            }
        }

        // Iso-Bmi resultat for 10 årig dreng
        else if(kon == false && alder == 10){
            granseSvarOvervagt = 24.00;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 19.84;
            String goString = String.valueOf(granseOvervagt);
                        returMeddelelse += "\nGrænseværdier - dreng, 10 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;


            if(bmi >= 24.00){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
            }
            else if(bmi >= 19.84){
                returMeddelelse += "\nBarnet er derfor \novervægtigt.";
            }
            else{
                returMeddelelse += "\nBarnet er derfor \nnormalvægtigt.";// Vær opmærksom på at dette system ikke tester for undervægt.";
            }
        }

        // Iso-Bmi resultat for en 10 årig pige
        else if (kon == true && alder == 10){
            granseSvarOvervagt = 24.11;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 19.86;
            String goString = String.valueOf(granseOvervagt);
            returMeddelelse += "\nGrænseværdier - pige, 10 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;


            if(bmi >= 24.11){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
            }
            else if(bmi >= 19.86){
                returMeddelelse += "\nBarnet er derfor \novervægtigt.";
            }
            else{
                returMeddelelse += "\nBarnet er derfor \nnormalvægtigt.";// Vær opmærksom på at dette system ikke tester for undervægt.";
            }
        }

        // Iso-Bmi resultat for 11 årig dreng
        else if(kon == false && alder == 11){
            granseSvarOvervagt = 25.10;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 20.55;
            String goString = String.valueOf(granseOvervagt);
            returMeddelelse += "\nGrænseværdier - dreng, 11 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;


            if(bmi >= 25.10){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
            }
            else if(bmi >= 20.55){
                returMeddelelse += "\nBarnet er derfor \novervægtigt.";
            }
            else{
                returMeddelelse += "\nBarnet er derfor \nnormalvægtigt.";// Vær opmærksom på at dette system ikke tester for undervægt.";
            }
        }

        // Iso-Bmi resultat for en 11 årig pige
        else if (kon == true && alder == 11){
            granseSvarOvervagt = 25.42;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 20.74;
            String goString = String.valueOf(granseOvervagt);
            returMeddelelse += "\nGrænseværdier - pige, 11 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;


            if(bmi >= 25.42){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
            }
            else if(bmi >= 20.74){
                returMeddelelse += "\nBarnet er derfor \novervægtigt.";
            }
            else{
                returMeddelelse += "\nBarnet er derfor \nnormalvægtigt.";// Vær opmærksom på at dette system ikke tester for undervægt.";
            }
        }

        // Iso-Bmi resultat for 12 årig dreng
        else if(kon == false && alder == 12){
            granseSvarOvervagt = 26.02;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 21.22;
            String goString = String.valueOf(granseOvervagt);
            returMeddelelse += "\nGrænseværdier - dreng, 12 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;


            if(bmi >= 26.02){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
            }
            else if(bmi >= 21.22){
                returMeddelelse += "\nBarnet er derfor \novervægtigt.";
            }
            else{
                returMeddelelse += "\nBarnet er derfor \nnormalvægtigt.";// Vær opmærksom på at dette system ikke tester for undervægt.";
            }
        }

        // Iso-Bmi resultat for en 12 årig pige
        else if (kon == true && alder == 12){
            granseSvarOvervagt = 26.67;
            String gsoString = String.valueOf(granseSvarOvervagt);
            granseOvervagt = 21.68;
            String goString = String.valueOf(granseOvervagt);
            returMeddelelse += "\nGrænseværdier - pige, 12 år:\nOvervægt=BMI>"+ gsoString+"\nSvær overvægt=BMI>"+goString;


            if(bmi >= 26.67){
                returMeddelelse += "\nBarnet er derfor svært \novervægtigt.";
            }
            else if(bmi >= 21.68){
                returMeddelelse += "\nBarnet er derfor \novervægtigt.";
            }
            else{
                returMeddelelse += "\nBarnet er derfor \nnormalvægtigt.";// Vær opmærksom på at dette system ikke tester for undervægt.";
            }
        }

        else {
            returMeddelelse = "Barnet ligger uden for \naldersgruppen til dette system.";
        }
        return returMeddelelse;
    }
//    
     public boolean getCpr(String cpr){ //getkon
        
        boolean kon = false; //default dreng
        
        String k = cpr.substring(cpr.length()-1).trim();
        
        int konInt = Integer.parseInt(k);//transform format fra string til int, så kan man lave matematiske beregninger med int'en
        
        if (konInt % 2 == 0){
            kon =  true; //pige
        } else {
            kon = false; //dreng
        }
        return kon;   
    }
     
     public int getAlder(String cpr){ //getAlder
        
        String ar = cpr.substring(4, 6);//4 og 6 er de pladser i string hvor man finder året personen er blevet født i, fra cpr nr
        int numberAr = Integer.parseInt(ar);//laver igen string format til int for at lave matematiske beregninger
        
        String maned = cpr.substring(2, 4);//2 og 4 er de pladser hvor man finder måned personen er blevet født i, fra cpr nr
        int numberManed = Integer.parseInt(maned);//omndaner til int igen...
        
        String dato = cpr.substring(0, 2);// o og 2 er de plandser man finder den dage person er blevet født i, fra cpr nr
        int numberDato = Integer.parseInt(dato);//omdanning 
        
        /*grudet at pladser padser ikke med cpr nr orden, er fordi i en string man tæller fra 0 af, så dvs at hvis jeg vil gerne få fat i
        plaser 1 og 2 fra cpr nr i så skal det skrives som 0 og 1, men for et andet grung som jeg ikke fattede, man skal ikke skrive plads 1
        men i stedet plads 2, som den bliver ikke taget fat i af systemet men den siget at den skal bare tælle indtil plads 2. så de 2 første
        pladser af cpr nr, vil være 0, 2 i stringet*/
        
        //System.out.println("test "+numberDate+"  "+month+"  "+aar);
        
         Calendar cal1 = Calendar.getInstance();//dette er kalendar for det nuværende tid
         cal1.setTimeInMillis(System.currentTimeMillis()); //indlæser nuværende tid i millis sek ved at spørge pc'en
         
         Calendar cal2 = Calendar.getInstance();//dette er kalendar fra cpr nr.
         cal2.set(YEAR, numberAr);//jeg sætter YEAR til at være number aar, som er år fra cpr nr
         cal2.set(MONTH, numberManed);//det samme bare måned
         cal2.set(DATE, numberDato);//og igen, men fra dag
         
         int alder = (cal1.get(YEAR)-cal2.get(YEAR))-2000;//her trækker jeg den nuværende år fra den fra cpr nr og minus 1900, så for man alder.
                 //eks        2018 - 84(ming fødsår)-1900 = 34 år
                 /*problemmet med min kode er at hvi man er født efter 2000, så for personen 100 år mere :,(, så skal man nok trække
                 2000 i stedet for 1900, så vil det virke for personer født efter 2000.*/
                 
         if(cal2.get(MONTH)>cal1.get(MONTH) || (cal1.get(MONTH)== cal2.get(MONTH) && cal1.get(DATE) > cal2.get(DATE))) {
            alder--; /*denne del af koden er for at beregne mere præcis ælder nå man indgår de dage og måneder personen er blevet født i. koden er ikke min, 
            den blev direkte kopieret af en hjemmeside, og adaptere med mine inputs, så no credit for beregningen*/
        }
         
        return alder;
    }
     
}
