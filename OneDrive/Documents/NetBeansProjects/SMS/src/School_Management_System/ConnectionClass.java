
package School_Management_System;

import java.sql.*;
public class ConnectionClass {
    Connection con;
    Statement stm;
    ConnectionClass(){
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sms","root","SushAn366#");
        stm=con.createStatement();
        if(con.isClosed()){
            System.out.println("Y");
        }
        else{
            System.out.println("n");
        }
        }
    
        catch(Exception ex){
                ex.printStackTrace();
                }
        
    }
    public static void main (String[]args){
        new ConnectionClass();
    }
    class connection{
        public connection()
        {
            
        }
    
    }
}
