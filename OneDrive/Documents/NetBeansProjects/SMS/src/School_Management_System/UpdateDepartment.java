
package School_Management_System;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class UpdateDepartment extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    Font f, f1;
    JTextField tf1, tf2;
    JButton bt1, bt2;
    JPanel p1, p2;
    
    UpdateDepartment() {
        super("Update Department Details");
        //setSize(700, 320);
        //setLocation(50, 10);
        setSize(500, 400);
        setLocation(50, 10);
        setResizable(false);

        f = new Font("Arial", Font.BOLD, 25);
        f1 = new Font("Arial", Font.BOLD, 20);
        
        l1 = new JLabel("Update Department Details");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.RED);
        l1.setFont(f);

        l2 = new JLabel("DeptId");
        l2.setFont(f1);

        l3 = new JLabel("DeptName");
        l3.setFont(f1);

        tf1 = new JTextField();
        tf2 = new JTextField();

        bt1 = new JButton("Update");
        bt2 = new JButton("Back");
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt1.setFont(f1);
        bt2.setFont(f1);
        tf1.setFont(f1);
        tf2.setFont(f1);
        //bt1.setBackground(Color.BLACK);
        bt1.setBackground(new Color(191,247,161));
        //bt2.setBackground(Color.BLACK);
        bt2.setBackground(new Color(191,247,161));
        bt1.setForeground(Color.BLACK);
        bt2.setForeground(Color.BLACK);
        //tf2.setEditable(false);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);
        
        p2 = new JPanel();
        //p2.setLayout(new GridLayout(5, 2, 10, 10));
        p2.setLayout(new GridLayout(4, 4, 10, 10));
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
                    String queryUpdate = "UPDATE Department SET name = '" + name + "' WHERE id = " + id;
                    int updated = obj.stm.executeUpdate(queryUpdate);
                    
                    if (updated >= 0) {
                        JOptionPane.showMessageDialog(null, "Department details updated successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update department details.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No deptname  found with the given ID.");
                }

                 //Close the JFrame after update
               this.setVisible(false);
           } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid integer for ID.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error updating department details.");
                e.printStackTrace();
           } catch (Exception e) {
              e.printStackTrace();
            }
       } else if (ae.getSource() == bt2) {
            this.setVisible(false); // Close the JFrame when "Back" button is clicked
        }
    }

     public static void main(String[] args) {
       new UpdateDepartment().setVisible(true);
    }
}
