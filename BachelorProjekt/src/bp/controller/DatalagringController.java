/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;


import bp.model.KontoModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author christinemariegrabow
 */
public class DatalagringController {

    
    java.sql.Connection con;
    Database database = new Database();
    
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
                f.setFornavn(rs.getString("Fornavn"));
                f.setEfternavn(rs.getString("Efternavn"));
                f.setCpr(rs.getString("CPR"));
                f.setFamilieID(rs.getString("FamilieID"));
                f.setBrugertype(rs.getBoolean("Brugertype"));
                f.setAdgangskode(rs.getString("Adgangskode"));
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
            String SQL = "INSERT INTO konto (Fornavn, Efternavn, CPR, FamilieID, Brugertype, Adgangskode)"            
            + " VALUES  ("
                    + "'" + konto.getFornavn()+ "',"
                    + "'" + konto.getEfternavn()+ "',"
                    + "'" + konto.getCpr()+"',"
                    + "'" + konto.getFamilieID()+"',"
                    + "'" + konto.getBrugertype()+"',"
                    + "'" + konto.getAdgangskode()+ "')"; 
            
            int rows = con.createStatement().executeUpdate(SQL, 1);
            if (rows > 0)
                System.out.println("Success!");
        }
        catch(SQLException e){
            System.out.println("Error on inserting Data");
        }
}
    
    
}
