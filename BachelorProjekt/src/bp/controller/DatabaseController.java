/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;


import bp.model.KontoModel;
import bp.model.SpilModel;
import bp.model.RegistreringModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 */
public class DatabaseController {

    
    java.sql.Connection con;
    Database database = new Database();
    String meddelelse = "";
            
    private ObservableList<KontoModel> familieData = FXCollections.observableArrayList();
    private ObservableList<KontoModel> familieID = FXCollections.observableArrayList();
    

    public DatabaseController(){
    }
    
    public String hentKontoDB(){ 
         con = database.getConnection();
         
        try{
            String SQL = "SELECT * FROM konto";
           
            ResultSet rs = con.createStatement().executeQuery(SQL);
            
            while(rs.next()){
                KontoModel f = new KontoModel();
                f.setFornavn(rs.getString("fornavn"));
                f.setEfternavn(rs.getString("efternavn"));
                f.setCpr(rs.getString("cpr"));
                f.setFamilieID(rs.getString("familieID"));
                f.setBrugertype(rs.getBoolean("brugertype"));
                f.setAdgangskode(rs.getString("adgangskode"));
                try {
                    f.setStartniveau(Integer.parseInt(rs.getString("startniveau")));
                 } catch (NumberFormatException nfe) {               
                     System.out.println("Fejl ved formatering fra int til string");
                 }
               
                familieData.add(f);
            }
            for (KontoModel konto : familieData){
                System.out.println(konto.getFornavn()+" "+konto.getEfternavn()
                        +" "+konto.getCpr()+" "+konto.getFamilieID()
                        +" "+konto.getBrugertype()+" "+konto.getAdgangskode()
                        +" "+konto.getStartniveau());
            }
            
            System.out.println("Forbindelse til databasen er oprettet og data er hentet fra konto");
            return meddelelse = "Forbindelse til databasen er oprettet og data er hentet fra konto";
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Der blev ikke oprettet forbindelse til databasen");
            return meddelelse = "Der blev ikke oprettet forbindelse til databasen";
        }
}
    
    
    public String tilfojKontoDB(KontoModel konto){ 
        con = database.getConnection(); 
        PreparedStatement stmt;
        
        try {         

            stmt = con.prepareStatement("INSERT INTO konto (fornavn, efternavn, cpr, familieID, brugertype, adgangskode, startniveau)"
                + "VALUES (?,?,?,?,?,?,?)");
            stmt.setString(1, konto.getFornavn());
            stmt.setString(2, konto.getEfternavn());
            stmt.setString(3, konto.getCpr());
            stmt.setString(4, konto.getFamilieID());
            stmt.setBoolean(5, konto.getBrugertype());
            stmt.setString(6, konto.getAdgangskode());
            stmt.setInt(7, konto.getStartniveau());
            stmt.executeUpdate();
            
            System.out.println("Forbindelse er oprettet og konto er tilføjet til database");
            return meddelelse = "Forbindelse er oprettet og konto er tilføjet til database";
        }

        catch(SQLException e){
            System.out.println("Forbindelse ikke oprettet til databasen og konto kunne ikke tilføjes");
            return meddelelse = "Forbindelse ikke oprettet til databasen og konto kunne ikke tilføjes";
        }
}
    
    public boolean verificerCprDB(String indtastetCpr) throws SQLException{
        con = database.getConnection();
        String SQL = "SELECT * FROM konto where cpr = '" + indtastetCpr + "'";
        ResultSet rs = con.createStatement().executeQuery(SQL);
        
        if(rs.next()){ 
            String hentetCpr = rs.getString("cpr");
            if(indtastetCpr.equals(hentetCpr)){
                System.out.println("Konto findes");
                return true; 
            }else{
                System.out.println("Konto findes ikke");
                return false;
            }
            
        } else{
            return false;
        }
        
       
    }
    
    public boolean verificerLogInd(String indtastetCpr, String indtastetAdgangskode) throws SQLException{
        con = database.getConnection();
        String SQL ="SELECT * FROM konto WHERE cpr = '"+indtastetCpr+"'";
        ResultSet rs = con.createStatement().executeQuery(SQL);
            
            if (rs.next()){
                String hentetCpr = rs.getString("cpr");
                String hentetAdgangskode = rs.getString("adgangskode");
                if(indtastetCpr.equals(hentetCpr) && indtastetAdgangskode.equals(hentetAdgangskode)){
                    
                    return true;
                }else{
                    return false;
                }
            } else{
                return false;
            }
        
    }
    
    public boolean hentBrugertypeDB(String cpr) throws SQLException{
        con = database.getConnection();
        String SQL = "SELECT brugertype FROM konto WHERE cpr = '"+cpr+"'";
        ResultSet rs = con.createStatement().executeQuery(SQL);
        if(rs.next()){
            boolean brugertype = rs.getBoolean("brugertype");
            return brugertype;
        }else{
            return false;
        }
    }
    
    
    public String hentSpilDB(){
        return meddelelse;
    }
    
    public String tilfojSpilDB(SpilModel spil){
        return meddelelse;
    }
    
    public String hentRegistreringDB(){
        return meddelelse;
    }
    
    public String tilfojRegistreringDB(RegistreringModel registrering){
        return meddelelse;
    }
}
    
