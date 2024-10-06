
package School_Management_System;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class DeleteDepartment extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    Font f, f1;
    JTextField tf1, tf2;
    JButton bt1, bt2;
    JPanel p1, p2;
    
    DeleteDepartment() {
        super("Delete Department Details");
        setSize(600, 420);
        setLocation(50, 10);
        setResizable(false);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 18);
        
        l1 = new JLabel("Delete Department Details");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.BLUE);
        l1.setFont(f);

        l2 = new JLabel("DeptId");
        l2.setFont(f1);

        l3 = new JLabel("DeptName");
        l3.setFont(f1);

        tf1 = new JTextField();
        tf2 = new JTextField();

        bt1 = new JButton("Delete");
        bt2 = new JButton("Back");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt1.setFont(f1);
        bt2.setFont(f1);
        tf1.setFont(f1);
        tf2.setFont(f1);
        bt1.setBackground(Color.red);
        bt2.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);
        //tf2.setEditable(false);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(5, 2, 10, 10));
        p2.add(l2);
        p2.add(l3);
        p2.add(tf1);
        p2.add(tf2);
        p2.add(bt1);
        p2.add(bt2);

        setLayout(new BorderLayout(10, 10));
        add(p1, BorderLayout.NORTH);
        add(p2, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bt1) {
            
    
           try {
                int id = Integer.parseInt(tf1.getText());
                String name = tf2.getText();

                ConnectionClass obj = new ConnectionClass(); // Establish connection to your database
                String querySelect = "SELECT * FROM Department WHERE id = " + id;
                ResultSet rs = obj.stm.executeQuery(querySelect);

               if (rs.next()) {
                    String queryUpdate ="DELETE FROM Department WHERE id = " + id ;
                    int updated = obj.stm.executeUpdate(queryUpdate);
                    
                    if (updated >= 0) {
                        JOptionPane.showMessageDialog(null, "Department deleted successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to delete department.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No departmrnt  found with the given ID.");
                }

                 //Close the JFrame after update
               this.setVisible(false);
           } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for ID.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error deleting department details.");
                e.printStackTrace();
           } catch (Exception e) {
              e.printStackTrace();
            }
       } else if (ae.getSource() == bt2) {
            //this.setVisible(false);
            // Close the JFrame when "Back" button is clicked
             this.dispose();
        }
    }

     public static void main(String[] args) {
     new DeleteDepartment().setVisible(true);
    }
}

