package einheitenLoeschen;

import dbUtil.DbConnect;
import einheitenAnzeigen.EinheitAnzeigenModel;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EinheitLoeschenModel {

    int id, sets, reps;
    double gewicht;
    String uebung, kategorie, datum;

    public EinheitLoeschenModel() {

    }

    public EinheitLoeschenModel(int id, String uebung, String kategorie, double gewicht, int sets, int reps, String datum) {

        this.id = id;
        this.sets = sets;
        this.reps = reps;
        this.gewicht = gewicht;
        this.uebung = uebung;
        this.kategorie = kategorie;
        this.datum = datum;
    }

    public void einheitLoeschen(ObservableList<EinheitAnzeigenModel> dataList){
        try {
            String sql = "SELECT * from einheiten";
            Connection conn =  DbConnect.connectDb();
            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()){
                dataList.add(new EinheitAnzeigenModel(rs.getInt("id"), rs.getString("uebung"),
                        rs.getString("kategorie"), rs.getDouble("gewicht"),
                        rs.getInt("sets"), rs.getInt("reps"), rs.getString("datum")));

            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }


    }

    public void deleteEinheit(int delId) {

        String sql = "DELETE FROM einheiten WHERE id = ?";
        try (Connection conn =  DbConnect.connectDb();
             PreparedStatement pstmt = conn.prepareStatement(sql)){

            pstmt.setInt(1, delId);
            pstmt.executeUpdate();

        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public int getId() {
        return id;
    }

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

