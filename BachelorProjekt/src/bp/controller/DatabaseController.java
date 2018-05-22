/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;


import bp.model.KontoModel;
import bp.model.SpilModel;
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
    
    private ObservableList<KontoModel> familieData = FXCollections.observableArrayList();
    public ObservableList<KontoModel> getFamilieData(){
        return familieData;
    }
    

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
                    f.setStartniveau(Integer.parseInt(rs.getString("Startniveau")));
                 } catch (NumberFormatException nfe) {
               
                     System.out.println("Error on formatting ZIP code to an integer");
                 }
                
                f.setStartniveau(rs.getInt("Startniveau"));
               
                familieData.add(f);
            }
            for (KontoModel konto : familieData){
                System.out.println(konto.getFornavn()+" "+konto.getEfternavn()
                        +" "+konto.getCpr()+" "+konto.getFamilieID()+" "
                        +konto.getBrugertype()+" "+konto.getAdgangskode()
                        +" "+konto.getStartniveau());
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Data kunne ikke hentes fra database");
        }
}
    
    
    public void tilfojKontoTilDB(KontoModel konto){ //opretKontoIDatabase
        con = database.getConnection(); 
        try {         

            stmt = con.prepareStatement("INSERT INTO konto (fornavn, efternavn, cpr, familieID, brugertype, adgangskode)"
                + "VALUES (?,?,?,?,?,?)");
            stmt.setString(1, konto.getFornavn());
            stmt.setString(2, konto.getEfternavn());
            stmt.setString(3, konto.getCpr());
            stmt.setString(4, konto.getFamilieID());
            stmt.setBoolean(5, konto.getBrugertype());
            stmt.setString(6, konto.getAdgangskode());
            stmt.executeUpdate();
            
        }

        catch(SQLException e){
            System.out.println("Konto kunne ikke tilføjes til database");
        }
}
    
    public boolean verificerCprDB(TextField tf) throws SQLException{
        con = database.getConnection();
        String SQL = "SELECT cpr FROM konto ORDER BY cpr";
        ResultSet rs = con.createStatement().executeQuery(SQL);
        
        String k = tf.getText();
        if(rs.next()){ 
            String cpr = rs.getString("cpr");
            if(k.equals(cpr)){
               System.out.println("Konto findes allerede"); //cpr 
                return true; 
            }else{
                System.out.println("Konto findes ikke");
                return false;
            }
            
        } else{
            return false;
        }
        
       
    }
    
    public boolean verificerLogInd(TextField cpr, TextField adgangskode){
        
        con = database.getConnection();
        try{
            stmt = con.prepareStatement("SELECT cpr, adgangskode FROM konto WHERE cpr = ? AND adgangskode = ?");
            stmt.setString(1, cpr.getText());
            stmt.setString(2, adgangskode.getText());
            
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
                return true;
            } else{
                return false;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
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
    
    public void tilfojRegistreringTilDB(){
        
    }
    
}
