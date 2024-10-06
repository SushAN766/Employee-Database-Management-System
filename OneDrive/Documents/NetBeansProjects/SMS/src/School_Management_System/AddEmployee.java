
package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class AddEmployee extends JFrame implements ActionListener{
    JLabel id1,id2,id3,id4,id5,id6;
    JFrame f;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    //public String id,account2;
    AddEmployee(){
        f=new JFrame("Add new Employee Details");
        f.setBackground(Color.yellow);
        f.setLayout(null);
        //account2=account;
        id1=new JLabel();
        id1.setBounds(0,0,840,600);
        id1.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("School_Management_System/Icons/addemp..jpg"));
        Image i1=img.getImage().getScaledInstance(840,600, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        id1.setIcon(img1);
        
        id2=new JLabel ("Add Employee Details");
        id2.setBounds(230,50,500,50);
        id2.setFont(new Font("Ariel",Font.BOLD,30));
        id2.setForeground(Color.BLACK);
        id1.add(id2);
        f.add(id1);
        
        
        id3=new JLabel ("ID");    
        id3.setBounds(50,150,150,30);
        id3.setFont(new Font("Ariel",Font.BOLD,25));
        id3.setForeground(Color.BLACK);
        id1.add(id3);
        
        t1=new JTextField();
        t1.setBounds(200,150,150,35);
        id1.add(t1);
        
        id4=new JLabel ("NAME");    
        id4.setBounds(50,200,150,30);
        id4.setFont(new Font("Ariel",Font.BOLD,25));
        id4.setForeground(Color.BLACK);
        id1.add(id4);
        
        t2=new JTextField();
        t2.setBounds(200,200,150,35);
        id1.add(t2);
        
        id5=new JLabel ("SALARY");    
        id5.setBounds(50,250,140,30);
        id5.setFont(new Font("Ariel",Font.BOLD,25));
        id5.setForeground(Color.BLACK);
        id1.add(id5);
        
        id6=new JLabel ("Department");    
        id6.setBounds(50,300,140,30);
        id6.setFont(new Font("Ariel",Font.BOLD,25));
        id6.setForeground(Color.BLACK);
        id1.add(id6);
        
        
        
        t3=new JTextField();
        t3.setBounds(200,250,150,35);
        id1.add(t3);
        t4=new JTextField();
        t4.setBounds(200,300,150,35);
        id1.add(t4);
        
        t4.setFont(new Font("Ariel",Font.BOLD,20));
        t3.setFont(new Font("Ariel",Font.BOLD,20));
        t2.setFont(new Font("Ariel",Font.BOLD,20));
        t1.setFont(new Font("Ariel",Font.BOLD,20));
       
        
        b1=new JButton("Submit");
        b2=new JButton("Back");
        
        b1.setBackground(new Color(191,247,161));
        b2.setBackground(new Color(191,247,161));
        b1.setForeground(Color.BLACK);
        b2.setForeground(Color.BLACK);
        b1.setFont(new Font("Ariel",Font.BOLD,18));
        b2.setFont(new Font("Ariel",Font.BOLD,18));
        b1.setBounds(150,400,150,40);
        b2.setBounds(350,400,150,40);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        id1.add(b1);
        id1.add(b2);
        
        f.setVisible(true);
        f.setSize(840,600);
        f.setLocation(300,100);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                int ID = Integer.parseInt(t1.getText());
                String Name=t2.getText();
                float Salary = Float.parseFloat(t3.getText());
                 String department = t4.getText();

            

                ConnectionClass obj=new ConnectionClass();  
                String q = "INSERT INTO Employee (ID, Name, Salary, department) VALUES ('" + ID + "', '" + Name + "', '" + Salary + "','" + department + "')";
                 obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Sucessfully inserted");
                f.setVisible(false);
        
               }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please ensure ID is an integer and Salary is a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
                
       if(ae.getSource()==b2){
            f.dispose();
        }
    }
        
   //public static void main (String[]args){
        //new AddEmployee().setVisible(true);
    //}
   
}

