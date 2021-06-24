package dbUtil;

import java.sql.*;


public class DbConnect {

    public static String dbEinheiten = "trainingseinheiten.db";

    // neue Datenbank erstellen
    public void createDb() {

        // url unter der die Datenbank erstellt werden soll
        String url = "jdbc:sqlite:D:\\Eigene Datein\\Studium_Informatik\\Java\\TrainingFX\\Database\\" + dbEinheiten;

        try (Connection conn = DriverManager.getConnection(url)) {

            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("Driver name " + meta.getDriverName());
                System.out.println("Database created");

            }

        } catch (SQLException ex) {
            // show exeption
            System.out.println(ex.getMessage());

        }

    }

    // Verbindung zu einer bestehenden Datenbank aufbauen
    public static Connection connectDb() {

        // SQLite connection string
        String url = "jdbc:sqlite:D:\\Eigene Datein\\Studium_Informatik\\Java\\TrainingFX\\Database\\" + dbEinheiten;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Verbindung hergestellt");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}



