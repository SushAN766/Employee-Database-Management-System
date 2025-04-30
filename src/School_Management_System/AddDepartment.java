
package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;


public class AddDepartment extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4;
    JFrame f;
    JTextField tf1,tf2;
    JButton bt1,bt2;
    //public String id,account2;
    AddDepartment(){
        f=new JFrame("Add new Deparment Details");
        f.setBackground(Color.yellow);
        f.setLayout(null);
       //account2=account;
        l1=new JLabel();
        l1.setBounds(0,0,840,600);
        l1.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("School_Management_System/Icons/ADD.jpg"));
        Image i1=img.getImage().getScaledInstance(840,600, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2=new JLabel ("Add Department Details");
        //l2.setHorizontalAlignment(JLabel.CENTER);
        l2.setBounds(230,50,500,50);
        l2.setFont(new Font("Ariel",Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        f.add(l1);
        
        
        l3=new JLabel ("DEPT ID");    
        l3.setBounds(50,150,150,35);
        l3.setFont(new Font("Ariel",Font.BOLD,25));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        tf1=new JTextField();
        tf1.setBounds(200,150,150,35);
        l1.add(tf1);
        
        l4=new JLabel ("DEPTNAME");    
        l4.setBounds(450,150,250,30);
        l4.setFont(new Font("Ariel",Font.BOLD,25));
        l4.setForeground(Color.BLACK);
        l1.add(l4);
        
        tf2=new JTextField();
        tf2.setBounds(600,150,150,35);
        l1.add(tf2);
        
        tf2.setFont(new Font("Ariel",Font.BOLD,20));
        tf1.setFont(new Font("Ariel",Font.BOLD,20));
       
        
        bt1=new JButton("Submit");
        bt2=new JButton("Back");
        
        bt1.setBackground(Color.BLACK);
        bt2.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);
        bt1.setFont(new Font("Ariel",Font.BOLD,20));
        bt2.setFont(new Font("Ariel",Font.BOLD,20));
        bt1.setBounds(250,300,150,40);
        bt2.setBounds(450,300,150,40);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        l1.add(bt1);
        l1.add(bt2);
        
        f.setVisible(true);
        f.setSize(840,600);
        f.setLocation(300,100);
        
        
    }
    
public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bt1){
            try{
                ConnectionClass obj = new ConnectionClass();
                int ID = Integer.parseInt(tf1.getText());
                String Name = tf2.getText();
                String q = "insert into department values('" + ID + "','" + Name + "')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Successfully inserted");
                f.setVisible(false);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please ensure ID is an integer.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "SQL Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(ae.getSource()==bt2){
            f.dispose();
        }
    }
    //public static void main (String[]args){
        //new AddDepartment().setVisible(true);
   // }
}