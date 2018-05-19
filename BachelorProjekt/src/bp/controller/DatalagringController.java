/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;


import bp.model.KontoModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author christinemariegrabow
 */
public class DatalagringController {

    
    java.sql.Connection con;
    Database database = new Database();
    private PreparedStatement stmt;
    
    private ObservableList<KontoModel> familieData = FXCollections.observableArrayList();
    public ObservableList<KontoModel> getFamilieData(){
        return familieData;
    }
    
   
    
    

    public DatalagringController(){
//        familieData.add(new ForaldreModel("Nathalie", "Trane", "1212070004", "3", false,"07"));
//        familieData.add(new ForaldreModel("Christine", "Grabow", "0101090002", "5", false, "09"));
//        familieData.add(new ForaldreModel("Ingeborg", "Jensen", "04041000006", "8" ,false, "10")); 
//        familieData.add(new ForaldreModel("Lise", "Jensen", "05059200008", "8", true, "92")); 
//        familieData.add(new ForaldreModel("Peter", "Jensen", "0420900003", "8", true, "90"));
        
       
        
       
    }
    
    public void hentDB() throws SQLException {
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
//                try {
//                    f.setStartniveau(Integer.parseInt(rs.getString("Startniveau")));
//                 } catch (NumberFormatException nfe) {
//               
//                     System.out.println("Error on formatting ZIP code to an integer");
//                 }
                
                //f.setStartniveau(rs.getInt("Startniveau"));
               
                familieData.add(f);
            }
            for (KontoModel kontoModel : familieData){
                System.out.println(kontoModel.getFornavn()+" "+kontoModel.getEfternavn()+" "+kontoModel.getCpr()+" "+kontoModel.getFamilieID()+" "+kontoModel.getBrugertype()+" "+kontoModel.getAdgangskode());
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Fejl ved data!");
        }
}
    
    
    public void opretKontoIDatabase(KontoModel konto){
        con = database.getConnection(); 
        try {
//            
//            String SQL = "INSERT INTO konto (fornavn, efternavn, cpr, familieID, brugertype, adgangskode)"            
//            + " VALUES  ("
//                    + "'" + konto.getFornavn()+ "',"
//                    + "'" + konto.getEfternavn()+ "',"
//                    + "'" + konto.getCpr()+"',"
//                    + "'" + konto.getFamilieID()+"',"
//                    + "'" + konto.getBrugertype()+"',"
//                    + "'" + konto.getAdgangskode()+ "')"; 
//            
//            int rows = con.createStatement().executeUpdate(SQL, 1);
//            
//            if (rows > 0)
//                System.out.println("Success!");
            

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
            System.out.println("Error on inserting Data");
        }
}
    
    public boolean getCprDB(TextField c) throws SQLException{
        con = database.getConnection();
        String SQL = "SELECT cpr FROM konto ORDER BY cpr";
        ResultSet rs = con.createStatement().executeQuery(SQL);
        
        String k = c.getText();
        if(rs.next()){ 
            String cpr = rs.getString("cpr");
            if(k.equals(cpr)){
               System.out.println("Konto findes allerede");
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
    
}
