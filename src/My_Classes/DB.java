/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package My_Classes;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;


/**
 *
 * @author jhung
 */
public class DB {
    
    //create a connection between the project & mySQL databalse>
   
     private static String serverName = "localhost";
     private static String userName = "root";
     private static String dbName = "java_library_system";
     private static Integer portNumber = 3306;
     private static String pass = "";
    
    // create a function to creaate & return the connection
     public static Connection getConnection()
     {
         Connection connection = null;
         
        MysqlDataSource datasource = new MysqlDataSource();
        
        datasource.setServerName(serverName);
        datasource.setUser(userName);
        datasource.setDatabaseName(dbName);
        datasource.setPortNumber(portNumber);
        datasource.setPassword(pass);
         
        
         try {
             connection = datasource.getConnection();
         } catch (SQLException ex) {
             Logger.getLogger(DB.class.getName()).log(Level.SEVERE, null, ex);
             
         }
       return connection;   
     }
           
            
}
