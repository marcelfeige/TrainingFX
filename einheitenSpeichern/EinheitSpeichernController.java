package einheitenSpeichern;

import combobox.ComboUebung;
import combobox.ListUebungen;
import combobox.optionKategorie;
import dbUtil.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class EinheitSpeichernController<event> implements Initializable{

    @FXML
    private ComboBox<String> comboUebung;
    @FXML
    private ComboBox<optionKategorie> comboKategorie;
    @FXML
    private TextField textGewicht;
    @FXML
    private TextField textSets;
    @FXML
    private TextField textReps;
    @FXML
    private DatePicker datepicker;
    @FXML
    private Button btnSave;
    @FXML
    private Button btnClose;
    @FXML
    private Label statusLabel;

    ListUebungen listUebungen = new ListUebungen();

    public void speichern(ActionEvent event){

        String kategorie = comboKategorie.getValue().toString();

        String uebung = comboUebung.getValue();
        // get date from datepicker
        LocalDate datum = datepicker.getValue();
        // formate date an convert to string
        String formattedDate = datum.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        // Pruefen, ob die Eingaben richtig sind
        try {
            double gewicht = Double.parseDouble(textGewicht.getText());
            int sets = Integer.parseInt(textSets.getText());
            int reps = Integer.parseInt(textReps.getText());

            EinheitSpeichernModel einheitSpeichernModel = new EinheitSpeichernModel();
            einheitSpeichernModel.einheitSpeichern(uebung, kategorie, gewicht, sets, reps, formattedDate);

            this.statusLabel.setText("Daten gespeichert");

        } catch (NumberFormatException nfe) {
            this.statusLabel.setText("Fehler bei der Eingabe");
            return;
        }
    }

    @FXML
    private void close(){
        // get a handle to the stage
        Stage stage = (Stage) btnClose.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void setComboUebung(ActionEvent event){

        ComboUebung.setComboUebung(comboKategorie, comboUebung);

    }

    public void initialize(URL url, ResourceBundle rb) {

        Connection conn =  DbConnect.connectDb();

        if(DbConnect.connectDb() != null){
            this.statusLabel.setText("Datenbank verbunden");
        }
        else {
            this.statusLabel.setText("Datenbank nicht verbunden");
        }

        this.comboKategorie.setItems(FXCollections.observableArrayList(optionKategorie.values()));

    }

}
