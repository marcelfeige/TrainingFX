package einheitenSpeichern;

import dbUtil.DbConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EinheitSpeichernModel {

    public void einheitSpeichern() {

    }

    public void einheitSpeichern(String uebung, String kategorie, double gewicht, int sets, int reps, String formattedDate) {

        // sql Befehl zum speichern der Daten
        String sql = "INSERT INTO einheiten (uebung, kategorie, gewicht, sets, reps, datum) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DbConnect.connectDb();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, uebung);
            pstmt.setString(2, kategorie);
            pstmt.setDouble(3, gewicht);
            pstmt.setInt(4, sets);
            pstmt.setInt(5, reps);
            pstmt.setString(6, formattedDate);

            pstmt.executeUpdate();
            System.out.println("Daten gespeichert");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
