
package projectreport;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Koneksi {
    private static Connection koneksimysql;
    public static Connection koneksiDB() {
        if (koneksimysql == null) {
            try {
                String DB = "jdbc:mysql://localhost/oop"; // nama database
                String user = "root";
                String pass = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksimysql = (Connection)DriverManager.getConnection(DB, user, pass);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal");
            }
        }
        return koneksimysql;
    }
}
