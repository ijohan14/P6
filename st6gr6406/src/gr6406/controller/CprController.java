/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr6406.controller;

import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;

/**
 *
 * @author menxsk8
 */
public class CprController {
    
    /**kode for at få køn fra cpr nr**/
    public String extractGenderFromCpr(String cpr){
        
        String koen = cpr.substring(cpr.length()-1).trim();
        
        int number = Integer.parseInt(koen);//transform format fra string til int, så kan man lave matematiske beregninger med int'en
        
        koen = number%2==0?"F":"M"; //if else statement bare forkortet på en smartere måde, som vi lært i kursusgang "?", hvor ? er "if" statement og ":" er else
      
        return koen; 
    }
    /**kode for at få ælder fra cpr**/
    public String extractAgeFromCpr(String cpr){
        
        String aar = cpr.substring(4, 6);//4 og 6 er de pladser i string hvor man finder året personen er blevet født i, fra cpr nr
        int numberAar = Integer.parseInt(aar);//laver igen string format til int for at lave matematiske beregninger
        
        String month = cpr.substring(2, 4);//2 og 4 er de pladser hvor man finder måned personen er blevet født i, fra cpr nr
        int numberMonth = Integer.parseInt(month);//omndaner til int igen...
        
        String date = cpr.substring(0, 2);// o og 2 er de plandser man finder den dage person er blevet født i, fra cpr nr
        int numberDate = Integer.parseInt(date);//omdanning 
        
        /*grudet at pladser padser ikke med cpr nr orden, er fordi i en string man tæller fra 0 af, så dvs at hvis jeg vil gerne få fat i
        plaser 1 og 2 fra cpr nr i så skal det skrives som 0 og 1, men for et andet grung som jeg ikke fattede, man skal ikke skrive plads 1
        men i stedet plads 2, som den bliver ikke taget fat i af systemet men den siget at den skal bare tælle indtil plads 2. så de 2 første
        pladser af cpr nr, vil være 0, 2 i stringet*/
        
        //System.out.println("test "+numberDate+"  "+month+"  "+aar);
        
         Calendar cal1 = Calendar.getInstance();//dette er kalendar for det nuværende tid
         cal1.setTimeInMillis(System.currentTimeMillis()); //indlæser nuværende tid i millis sek ved at spørge pc'en
         
         Calendar cal2 = Calendar.getInstance();//dette er kalendar fra cpr nr.
         cal2.set(YEAR, numberAar);//jeg sætter YEAR til at være number aar, som er år fra cpr nr
         cal2.set(MONTH, numberMonth);//det samme bare måned
         cal2.set(DATE, numberDate);//og igen, men fra dag
         
         int diff = (cal1.get(YEAR)-cal2.get(YEAR))-1900;//her trækker jeg den nuværende år fra den fra cpr nr og minus 1900, så for man alder.
                 //eks        2018 - 84(ming fødsår)-1900 = 34 år
                 /*problemmet med min kode er at hvi man er født efter 2000, så for personen 100 år mere :,(, så skal man nok trække
                 2000 i stedet for 1900, så vil det virke for personer født efter 2000.*/
                 
         if(cal2.get(MONTH)>cal1.get(MONTH) || (cal1.get(MONTH)== cal2.get(MONTH) && cal1.get(DATE) > cal2.get(DATE))) {
            diff--; /*denne del af koden er for at beregne mere præcis ælder nå man indgår de dage og måneder personen er blevet født i. koden er ikke min, 
            den blev direkte kopieret af en hjemmeside, og adaptere med mine inputs, så no credit for beregningen*/
        }
         
        return diff+"";
    }
    
    public static void main (String[] args){  //denne del af koden er lavet kun for at teste om koden virker 
        
        CprController controller = new CprController();
        
        System.out.println("Køn: "+ controller.extractGenderFromCpr("1402843443"));
        System.out.println("Alder: "+ controller.extractAgeFromCpr("1402843443"));
    }
    
    
}
