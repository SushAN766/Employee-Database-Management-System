
package School_Management_System;

//import java.awt.*;
//import javax.swing.*;
//import java.sql.*;

//public class ViewEmployee extends JFrame {
 //   String[] columnNames = {"ID", "Name", "Salary","Department"};
   // String[][] data = new String[30][3];
    //int i = 0, j = 0;
    //JTable table;
    //Font font;

    //ViewEmployee() {
      //  super("Employee Information");
        //setSize(800, 400);
        //setLocation(100, 100);
        //font = new Font("Arial", Font.BOLD, 16);

        //try {
          //  ConnectionClass obj = new ConnectionClass();
            //String query = "SELECT * FROM Employee";
            //ResultSet rs = obj.stm.executeQuery(query);

          //  while (rs.next()) {
            //    data[i][0] = rs.getString("id");
              //  data[i][1] = rs.getString("name");
                //data[i][2] = rs.getString("salary");
                //data[i][3] = rs.getString("Department");
                //i++;
      //      }

        //    table = new JTable(data, columnNames);
         //   table.setFont(font);
         //   table.setBackground(Color.BLACK);
         //   table.setForeground(Color.WHITE);

           // JScrollPane sp = new JScrollPane(table);
           // add(sp);
      //  } catch (Exception ex) {
        //    ex.printStackTrace();
      //  }
 //   }

   // public static void main(String[] args) {
     //   new ViewEmployee().setVisible(true);
    //}
//}





import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class ViewEmployee extends JFrame {
    String[] columnNames = {"ID", "Name", "Salary", "Department"};
    String[][] data = new String[30][3];
    
    JTable table;
    Font font;

    ViewEmployee() {
        super("Employee Information");
        setSize(800, 400);
        setLocation(100, 100);
        font = new Font("Arial", Font.BOLD, 16);

        try {
            ConnectionClass obj = new ConnectionClass();
            String query = "SELECT * FROM Employee";
            ResultSet rs = obj.stm.executeQuery(query);

            ArrayList<String[]> dataList = new ArrayList<>();

            while (rs.next()) {
                String[] row = {
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("salary"),
                    rs.getString("Department")
                };
                dataList.add(row);
            }

            data = new String[dataList.size()][columnNames.length];
            for (int i = 0; i < dataList.size(); i++) {
                data[i] = dataList.get(i);
            }

            table = new JTable(data, columnNames);
            table.setFont(font);
            table.setBackground(Color.BLACK);
            table.setForeground(Color.WHITE);

            JScrollPane sp = new JScrollPane(table);
            add(sp);

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching data from database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ViewEmployee().setVisible(true);
        });
    }
}




