package einheitenAendern;

import dbUtil.DbConnect;
import einheitenAnzeigen.EinheitAnzeigenModel;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EinheitAendernModel {

    int id, sets, reps;
    double gewicht;
    String uebung, kategorie, datum;

    public EinheitAendernModel(){

    }

    public EinheitAendernModel(int id, String uebung, String kategorie, double gewicht, int sets, int reps, String datum) {

        this.id = id;
        this.sets = sets;
        this.reps = reps;
        this.gewicht = gewicht;
        this.uebung = uebung;
        this.kategorie = kategorie;
        this.datum = datum;
    }
    public void einheitAnzeigen(ObservableList<EinheitAnzeigenModel> dataList) {

        try {
            Connection conn = DbConnect.connectDb();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * from einheiten");

            while (rs.next()) {
                dataList.add(new EinheitAnzeigenModel(rs.getInt("id"), rs.getString("uebung"),
                        rs.getString("kategorie"), rs.getDouble("gewicht"),
                        rs.getInt("sets"), rs.getInt("reps"), rs.getString("datum")));

            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }


    public void einheitAendern(int chId, String uebung, String kategorie, double gewicht, int sets, int reps) {

        // Pruefen, ob Werte zum aendern einbgetragen wurden
        // Wenn Werte eingetragen wurden, wird die Datenbank aktualisiert
        if (uebung != "") {
            String sql = "UPDATE einheiten SET uebung = ? WHERE id = ?";
            try (Connection conn =  DbConnect.connectDb();
                 PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setInt(2, chId);
                pstmt.setString(1, uebung);
                pstmt.executeUpdate();

            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }
        }
        if (kategorie != "") {
            String sql = "UPDATE einheiten SET kategorie = ? WHERE id = ?";
            try (Connection conn =  DbConnect.connectDb();
                 PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setInt(2, chId);
                pstmt.setString(1, kategorie);
                pstmt.executeUpdate();

            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        if (gewicht != 0.0) {
            String sql = "UPDATE einheiten SET gewicht = ? WHERE id = ?";
            try (Connection conn =  DbConnect.connectDb();
                 PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setInt(2, chId);
                pstmt.setDouble(1, gewicht);
                pstmt.executeUpdate();

            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        if (sets != 0) {
            String sql = "UPDATE einheiten SET sets = ? WHERE id = ?";
            try (Connection conn =  DbConnect.connectDb();
                 PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setInt(2, chId);
                pstmt.setInt(1, sets);
                pstmt.executeUpdate();

            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

        if (reps != 0) {
            String sql = "UPDATE einheiten SET reps = ? WHERE id = ?";
            try (Connection conn =  DbConnect.connectDb();
                 PreparedStatement pstmt = conn.prepareStatement(sql)){

                pstmt.setInt(2, chId);
                pstmt.setInt(1, reps);
                pstmt.executeUpdate();

            }
            catch (SQLException exception) {
                exception.printStackTrace();
            }
        }

    }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public double getGewicht() {
        return gewicht;
    }

    public void setGewicht(double gewicht) {
        this.gewicht = gewicht;
    }

    public String getUebung() {
        return uebung;
    }

    public void setUebung(String uebung) {
        this.uebung = uebung;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }
}

