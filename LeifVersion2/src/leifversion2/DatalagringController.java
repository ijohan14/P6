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
    
    private ObservableList<Person> personData = FXCollections.observableArrayList();
    
    private DBClass objDbClass = new DBClass();
    java.sql.Connection con;
    
    
    public DatalagringController() throws ClassNotFoundException, SQLException{
        con = objDbClass.getConnection();
        buildData();
    }
    
    private void buildData() {
        try{
            String SQL = "Select FirstName, LastName from Person Order By LastName";
           
            ResultSet rs = con.createStatement().executeQuery(SQL);
            
            while(rs.next()){
                Person p = new Person();
                p.setFornavn(rs.getString("FirstName"));
                p.setEfternavn(rs.getString("LastName"));
               
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
    
    public class DBClass {
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        return
        DriverManager.getConnection("jdbc:derby://localhost:1527/LeifVersion2DB","leif","leif");
    }
}
    
}
