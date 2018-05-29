/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bp.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nathalie
 */

public class Database {
  
    static String dbAdresse   = "jdbc:mysql://db.course.hst.aau.dk:3306/hst_2018_18gr6406?autoReconnect=true&useSSL=false";
    static String dbBruger     = "hst_2018_18gr6406";
    static String dbKode = "aehiechahbuogheebaec";
    
    public Connection getConnection() {
        
        Connection forbindelse = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException cnfe) {
            System.out.println("Driver klasse ikke fundet");           
        }
                
        try {
            forbindelse = DriverManager.getConnection(dbAdresse, dbBruger, dbKode); 
            System.out.println("Forbindelse til database er oprettet");           
        }
        catch (SQLException me) {
            System.out.println("Forbindelse til database kunne ikke oprettes"); 
            System.out.println(me.getMessage());
        }
        
        return forbindelse;
    }
}

