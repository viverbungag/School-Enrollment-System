/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnrollmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author
 */
public class EnrollmentSystem {

    /**
     * @param args the command line arguments
     */
    
    static Connection con;
    static Connection con2;
    static String user;
    static String pass;
    
    public static void main(String[] args) {
        // TODO code application logic here
        

        
        user = "root";
        pass = "Langgalangga1";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/information_schema", user, pass);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        Login LoginClass = new Login();
        LoginClass.setVisible(true);

    }
    
}
