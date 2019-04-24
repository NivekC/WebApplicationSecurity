

import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import org.jboss.logging.Logger;
import sun.util.logging.PlatformLogger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isaac kiplel
 */
public class MyDb {
    Connection con;
    public Connection getCon()
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
        String path ="jdbc:mysql://localhost:3306/travels";
        String user = "root";
        String pass = "";
        con = DriverManager.getConnection(path,user,pass); 
        
        }catch(ClassNotFoundException | SQLException ex){
            JOptionPane.showMessageDialog(null,"Error!\n"+ex,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return con;
        
    }
}
