
package School_Management_System;


import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class ViewDepartment extends JFrame {
    String[] columnNames = {"ID", "DeptName"};
    String[][] data = new String[30][2]; // Adjusted to 2 columns to match the column names
    int i = 0, j = 0;
    JTable table;
    Font font;

    ViewDepartment() {
        super("Department Information");
        setSize(800, 400);
        setLocation(100, 100);
        font = new Font("Arial", Font.BOLD, 16);

        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM Department";
            ResultSet rs = obj.stm.executeQuery(query);

            while (rs.next() && i < 30) { // Ensure we don't exceed the array bounds
                data[i][0] = rs.getString("id");
                data[i][1] = rs.getString("name");
                i++;
            }

            table = new JTable(data, columnNames);
            table.setFont(font);
            table.setBackground(Color.BLACK);
            table.setForeground(Color.WHITE);

            JScrollPane sp = new JScrollPane(table);
            add(sp);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ViewDepartment().setVisible(true);
   }
}