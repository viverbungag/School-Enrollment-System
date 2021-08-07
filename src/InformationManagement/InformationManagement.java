/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InformationManagement;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ricky
 */
public class InformationManagement {

    /**
     * @param args the command line arguments
     */
    
    static Connection con;
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        

        
        String user = "root";
        String pass = "Langgalangga1";

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/im",user,pass);
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        students studentsClass = new students();
        studentsClass.setVisible(true);
        
        


//        Menu index = new Menu();
//        index.setVisible(true);
        
//        TransReport a = new TransReport();
//        a.setVisible(true);
        
//        report b = new report();
//        b.setVisible(true);
//        
//        public static final String user = "root";
//        public static final String pass = "Naiskongmagpakalasingdahilwalakana14";
        
        

        
    }
    
}
