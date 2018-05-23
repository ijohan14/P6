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
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 */
public class DatabaseController {

    
    java.sql.Connection con;
    Database database = new Database();
    private PreparedStatement stmt;
    String meddelelse = "";
    
    private ObservableList<KontoModel> familieData = FXCollections.observableArrayList();
    private ObservableList<KontoModel> familie = FXCollections.observableArrayList();
    

    public DatabaseController(){
    }
    
    public void hentKontoDB() throws SQLException { 
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
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Data kunne ikke hentes fra database");
        }
}
    
    
    public String tilfojKontoTilDB(KontoModel konto){ 
        con = database.getConnection(); 
        
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
            
            return meddelelse = "Konto tilføjet til database";
        }

        catch(SQLException e){
            return meddelelse = "Konto kunne ikke tilføjes til database";
        }
}
    
    public boolean verificerCprDB(String indtastetCpr) throws SQLException{
        con = database.getConnection();
        String SQL = "SELECT * FROM konto where cpr = '" + indtastetCpr + "'";
        ResultSet rs = con.createStatement().executeQuery(SQL);
        
        if(rs.next()){ 
            String hentetCpr = rs.getString("cpr");
            if(indtastetCpr.equals(hentetCpr)){
                return true; 
            }else{
                //System.out.println("Konto findes ikke");
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
    
    
    public void hentSpilstatus(){
        
    }
    
    public void tilfojSpilstatus(SpilModel spil){
//        con = database.getConnection(); 
//        try {         
//
//            stmt = con.prepareStatement("INSERT INTO spil (point, level, udfordring, malsatning, varighed, cpr)"
//                + "VALUES (?,?,?,?,?,?)");
//            stmt.setString(1, spil.getPoint());
//            stmt.setString(2, spil.getLevel());
//            stmt.setString(3, spil.getUdordring());
//            stmt.setString(4, spil.getMalsatning());
//            stmt.setBoolean(5, spil.getVarighed());
//            stmt.setString(6, spil.getCpr());
//            stmt.executeUpdate();
//            
//        }
//
//        catch(SQLException e){
//            System.out.println("Konto kunne ikke tilføjes til database");
//        }
        
    }
    
    public String tilfojBmiRegistreringTilDB(RegistreringModel bmi, KontoModel konto){
        con = database.getConnection(); 
        
        try {       
            //convert RegistreringModel class LocalData to a sql date
            java.sql.Date date = java.sql.Date.valueOf(bmi.getDatotid());

            stmt = con.prepareStatement("INSERT INTO bmiRegistrering (cpr, datotid, hojde, vagt, bmi)"
                + "VALUES (?,?,?,?,?)");
            stmt.setString(1, konto.getCpr());
            stmt.setDate(2, date);
            stmt.setFloat(3, bmi.getHojde());
            stmt.setFloat(4, bmi.getVagt());
            stmt.setFloat(5, bmi.getBmi());
            stmt.executeUpdate();
            
            return meddelelse = "BMI registrering tilføjet til database";
        }

        catch(SQLException e){
            return meddelelse = "BMI registrering kunne ikke tilføjes til database";
        }
}
    public void hentFamilieDB(String id){
        con = database.getConnection();
        try{
        String SQL = "SELECT * FROM konto WHERE familieID = '"+id+"'";
        ResultSet rs = con.createStatement().executeQuery(SQL);
        while(rs.next()){
                KontoModel k = new KontoModel();
                k.setFornavn(rs.getString("fornavn"));
                k.setEfternavn(rs.getString("efternavn"));
                k.setCpr(rs.getString("cpr"));
                k.setFamilieID(rs.getString("familieID"));
                k.setBrugertype(rs.getBoolean("brugertype"));
                k.setAdgangskode(rs.getString("adgangskode"));
                try {
                    k.setStartniveau(Integer.parseInt(rs.getString("startniveau")));
                 } catch (NumberFormatException nfe) {               
                     System.out.println("Fejl ved formatering fra int til string");
                 }
               
                familie.add(k);
            }
            for (KontoModel km : familie){
                System.out.println(km.getFornavn()+" "+km.getEfternavn()
                        +" "+km.getCpr()+" "+km.getFamilieID()
                        +" "+km.getBrugertype()+" "+km.getAdgangskode()
                        +" "+km.getStartniveau());
            }
        } catch(SQLException e){
            System.out.println("Familie kunne ikke hentes");
        }
    }
        
}
    
