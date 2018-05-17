/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leifversion2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author nathalie
 */
public class DatalagringController {
    
    java.sql.Connection con;
    DBMySQLClass myDBClass = new DBMySQLClass();
    
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
    
    public DatalagringController(){
        
    }
     public void buildData() {
         con = myDBClass.getConnection();
        try{
            String SQL = "SELECT * FROM PERSON";
           
            ResultSet rs = con.createStatement().executeQuery(SQL);
            
            while(rs.next()){
                Person p = new Person();
                p.setFornavn(rs.getString("Fornavn"));
                p.setEfternavn(rs.getString("Efternavn"));
               
                personData.add(p);
            }
            for (Person person : personData){
                System.out.println(person.getFornavn()+" "+person.getEfternavn());
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
}
    
    
    public void insertPersonData(Person tempPerson) {
        try {
            String SQL = "INSERT INTO PERSON (Fornavn, Efternavn)"            
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
    
}
