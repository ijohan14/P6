/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leifversion2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nathalie
 */

public class DBMySQLClass {
  
    static String dbAdress   = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2018_18gr6406?autoReconnect=true&useSSL=false";
    static String dbUser     = "hst_2018_18gr6406";
    static String dbPassword = "aehiechahbuogheebaec";
    
    public Connection getConnection() {
        
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Driver class not found");           
        }
                
        try {
            con = DriverManager.getConnection(dbAdress, dbUser, dbPassword);            
        }
        catch (SQLException me) {
            System.out.println("Connection could not be factorized"); 
            System.out.println(me.getMessage());
        }
        
        return con;
    }
}

