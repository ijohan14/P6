/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leifversion2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author nathalie
 */
public class LeifVersion2 extends Application {
    public Stage stage;
    
    ObservableList<Person> personData = FXCollections.observableArrayList();
     
     /**
      * 
      * @return 
      */
     public ObservableList<Person> getPersonData(){
         ObservableList<Person> personData = FXCollections.observableArrayList();
         personData.add(new Person());
         return personData;
     }
    
    private DBClass objDbClass = new DBClass();
    java.sql.Connection con;
  
    
  
    
    @Override
    public void start(Stage stage) throws IOException, ClassNotFoundException, SQLException{
        this.stage = stage;
        
        con = objDbClass.getConnection();
        buildData();
        
        Parent root = FXMLLoader.load(getClass().getResource("PersonOverview.fxml"));
        stage.setScene(new Scene(root));
        stage.show();
        
    } 
    
    
    private void buildData() {
        try{
            String SQL = "Select Fornavn, Efternavn from Person Order By Efternavn";
           
            ResultSet rs = con.createStatement().executeQuery(SQL);
            
            while(rs.next()){
                Person p = new Person();
                p.setFornavn(rs.getString("Fornavn"));
                p.setEfternavn(rs.getString("Efternavn"));
               
                personData.add(p);
            }
            for (Person person : personData){
                System.out.println(person.getFornavn());
            }
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
}
    
    
    public void insertPersonData(Person tempPerson) {
        try {
            String SQL = "INSERT INTO LEIF.PERSON (Fornavn, Efternavn)"            
            + " VALUES  ("
                    + "'" + tempPerson.getFornavn()+ "',"
                    + "'" + tempPerson.getEfternavn()+  "')"; 
           
            int rows = con.createStatement().executeUpdate(SQL, 1);
            if (rows > 0)
                System.out.println("Success!");
        }
        catch(SQLException e){
            System.out.println("Error on inserting Data");
        }
}
    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

 
   
    
}
