
package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DeleteEmployee extends JFrame implements ActionListener {
    JLabel id1,id2,id3,id4,id5,id6;
    JFrame f;
    JTextField t1,t2,t3,t4;
    JButton b1,b2;
    
    DeleteEmployee() {
        f=new JFrame("Delete Employee Details");
        f.setBackground(Color.yellow);
        f.setLayout(null);
        //account2=account;
        id1=new JLabel();
        id1.setBounds(0,0,840,600);
        id1.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("School_Management_System/Icons/DELEMP.jpg"));
        Image i1=img.getImage().getScaledInstance(840,600, Image.SCALE_SMOOTH);
        ImageIcon img1=new ImageIcon(i1);
        id1.setIcon(img1);
        
        id2=new JLabel ("DELETE EMPLOYEE DETAILS");
        id2.setBounds(230,50,500,50);
        id2.setFont(new Font("Ariel",Font.BOLD,25));
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
        id6=new JLabel ("DEPARTMENT");    
        id6.setBounds(50,300,140,30);
        id6.setFont(new Font("Ariel",Font.BOLD,20));
        id6.setForeground(Color.BLACK);
        id1.add(id6);
        
        
        t3=new JTextField();
        t3.setBounds(200,250,150,35);
        t4=new JTextField();
        t4.setBounds(200,300,150,35);
        id1.add(t4);
        
        t4.setFont(new Font("Ariel",Font.BOLD,20));
        t3.setFont(new Font("Ariel",Font.BOLD,20));
        t2.setFont(new Font("Ariel",Font.BOLD,20));
        t1.setFont(new Font("Ariel",Font.BOLD,20));
        
        id1.add(t3);
       
        
        b1=new JButton("Delete");
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

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            
    
           try {
                int id = Integer.parseInt(t1.getText());
                String Name = t2.getText();
                float Salary = Float.parseFloat(t3.getText());
                String department = t4.getText();

                ConnectionClass obj = new ConnectionClass(); // Establish connection to your database
                String querySelect = "SELECT * FROM Employee WHERE id = " + id;
                ResultSet rs = obj.stm.executeQuery(querySelect);

               if (rs.next()) {
                   // String queryUpdate = "UPDATE Employee SET name = '" + name + "' WHERE id = " + id;
                    String queryUpdate = "DELETE FROM Employee WHERE id = " + id;
                    int updated = obj.stm.executeUpdate(queryUpdate);
                    
                    if (updated >= 0) {
                        JOptionPane.showMessageDialog(null, "Employee deleted successfully!!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete employee.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No employee found with the given ID.");
                }

                 //Close the JFrame after update
               this.setVisible(false);
           } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for ID.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting employee.");
                e.printStackTrace();
           } catch (Exception e) {
              e.printStackTrace();
            }
       } else if (ae.getSource() == b2) {
            //this.setVisible(false); // Close the JFrame when "Back" button is clicked
             f.dispose();
        }
    }

   public static void main(String[] args) {
      new DeleteEmployee().setVisible(true);
    }
}


