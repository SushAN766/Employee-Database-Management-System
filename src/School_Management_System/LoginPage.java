
package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class LoginPage extends JFrame implements ActionListener{
    JFrame f;
    JLabel l1,l2,l4,l5;
    JTextField tf1;
    JPasswordField pf1;
    JButton bt1,bt2;        

    
    LoginPage(){
        f=new JFrame("Login Here");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,750,450);
        l1.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("School_Management_System/Icons/loginpage.png"));
        Image i1=img.getImage().getScaledInstance(750, 450, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2=new JLabel("Login Here");
        l2.setBounds(300,132,500,50);
        l2.setFont(new Font("Ariel",Font.BOLD,40));
        l2.setForeground(Color.BLUE);
        l1.add(l2);
        f.add(l1);
        
        
        
        l4=new JLabel("Username:"           );
        l4.setBounds(280,245,150,30);
        l4.setFont(new Font("Ariel",Font.BOLD,25));
        l4.setForeground(Color.red);
        l1.add(l4);
        
        tf1=new JTextField();
        tf1.setFont(new Font("Ariel",Font.BOLD,25));
        tf1.setBounds(480,245,150,30);
        l1.add(tf1);
        
        l5=new JLabel("Password:"           );
        l5.setBounds(280,295,150,30);
        l5.setFont(new Font("Ariel",Font.BOLD,25));
        l5.setForeground(Color.red);
        l1.add(l5);
        
        pf1=new JPasswordField();
        pf1.setFont(new Font("Ariel",Font.BOLD,25));
        pf1.setBounds(480,295,150,30);
        l1.add(pf1);
        
        
        bt1=new JButton("Login");
        bt2=new JButton("Exit");
        bt1.setFont(new Font("Ariel",Font.BOLD,18));
        bt2.setFont(new Font("Ariel",Font.BOLD,18));
        bt1.setBounds(280,350,150,40);
        bt2.setBounds(480,350,150,40);
        bt1.setBackground(new Color(191,247,161));
        bt2.setBackground(new Color(191,247,161));
        bt1.setForeground(Color.BLACK);
        bt1.setForeground(Color.BLACK);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        
        l1.add(bt1);
        l1.add(bt2);
        
        f.setVisible(true);
        f.setSize(750,460);
        f.setLocation(300,100);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bt1){
            try{
                ConnectionClass obj=new ConnectionClass();
                String username=tf1.getText();
                String password=pf1.getText();
                
                
                String q="select * from user1 where username='"+username+"'and password='"+password+"'";
                ResultSet rest=obj.stm.executeQuery(q);
                if(rest.next()){
                  new DepartmentEmployee().setVisible(true);
                  //System.out.println("Login Successful");
                 
                }
                else{
                     JOptionPane.showMessageDialog(null,"You have entered wrong username and password!");
                     f.setVisible(false);
                }
                
            }
            catch(Exception ex){
                ex.printStackTrace();
            }
        }
        if(ae.getSource()==bt2){
            f.setVisible(false);
        }
    }
    public static void main (String[]args){
        new LoginPage();
    }
}
