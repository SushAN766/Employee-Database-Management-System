
package School_Management_System;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DepartmentEmployee extends JFrame implements ActionListener {
    JLabel l1;
    Font f,f1;
    JPanel p1;
    //public String id,account2;
    DepartmentEmployee(){
        this.setTitle("Management System");
        setLocation(0,0);
        setSize(1280,780);
        //account2=account;
        f=new Font("Ariel",Font.BOLD,20);
        f1=new Font("Ariel",Font.BOLD,20);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("School_Management_System/Icons/HOMEPAGE.jpg"));
        Image i1=img.getImage().getScaledInstance(1280, 780, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        l1=new JLabel(img1);
        
        JMenuBar m1=new JMenuBar();
        
        JMenu menu1=new JMenu("Department");
        JMenu menu2=new JMenu("Employee");
        
        JMenuItem ment1=new JMenuItem("Add Department");
        JMenuItem ment2=new JMenuItem("Delete Department");
        JMenuItem ment3=new JMenuItem("Update Department");
        JMenuItem ment4=new JMenuItem("View Department");
        menu1.add(ment1);
        menu1.add(ment2);
        menu1.add(ment3);
        menu1.add(ment4);
        
        JMenuItem ment5=new JMenuItem("Add Employee");
        JMenuItem ment6=new JMenuItem("Delete Employee");
        JMenuItem ment7=new JMenuItem("Update Employee");
        JMenuItem ment8=new JMenuItem("View Employee");
        
       
        
        
        
        menu2.add(ment5);
        menu2.add(ment6);
        menu2.add(ment7);
        menu2.add(ment8);
        
        m1.add(menu1);
        m1.add(menu2);
        
        
        menu1.setFont(f);
        menu2.setFont(f);
        
        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
        ment4.setFont(f1);
        ment5.setFont(f1);
        ment6.setFont(f1);
        ment7.setFont(f1);
        ment8.setFont(f1);
        m1.setBackground(new Color(4,1,54));
        
        menu1.setForeground(Color.GRAY);
        menu2.setForeground(Color.GRAY);
        
        ment1.setForeground(Color.GREEN);
        ment2.setForeground(Color.GREEN);
        ment3.setForeground(Color.GREEN);
        ment4.setForeground(Color.GREEN);
        ment5.setForeground(Color.GREEN);
        ment6.setForeground(Color.GREEN);
        ment7.setForeground(Color.GREEN);
        ment8.setForeground(Color.GREEN);
        
        
        ment1.setBackground(Color.BLACK);
        ment2.setBackground(Color.BLACK);
        ment3.setBackground(Color.BLACK);
        ment4.setBackground(Color.BLACK);
        ment5.setBackground(Color.BLACK);
        ment6.setBackground(Color.BLACK);
        ment7.setBackground(Color.BLACK);
        ment8.setBackground(Color.BLACK);
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
        
    }
    public void actionPerformed(ActionEvent ae){
               
                String comnd=ae.getActionCommand();
                if(comnd.equals("Add Department")){
                 new AddDepartment().setVisible(true);
                  //System.out.println("Add department open");
                } 
                else if(comnd.equals("Update Department"))
                {
                  // System.out.println("Update department open");
                     new UpdateDepartment().setVisible(true);
                }
                else if(comnd.equals("Delete Department"))
                {
                  //  System.out.println("Delete department open");
                     new DeleteDepartment().setVisible(true);
                }
                else if(comnd.equals("Add Employee"))
                {
                    //System.out.println("add employee open");
                     new AddEmployee().setVisible(true);
                }
                else if(comnd.equals("Update Employee"))
                {
                    //System.out.println("Update Employee open");
                     new UpdateEmployee().setVisible(true);
                }
                else if(comnd.equals("Delete Employee"))
                {
                  //  System.out.println("Delete Employee open");
                      new DeleteEmployee().setVisible(true);
                }
                else if(comnd.equals("View Department"))
                {
                   
                      new ViewDepartment().setVisible(true);
                }
                else if(comnd.equals("View Employee"))
                {
                  
                      new ViewEmployee().setVisible(true);
                }
                
                else if(comnd.equals("Exit"))
                {
                    System.exit(0);
                }
                
    }
    //public static void main (String[]args){
      //  new DepartmentEmployee().setVisible(true);
 
    //}
}


