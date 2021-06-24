package einheitenAendern;

import combobox.ListUebungen;
import combobox.ComboUebung;
import combobox.optionKategorie;
import dbUtil.DbConnect;
import einheitenAnzeigen.EinheitAnzeigenModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class EinheitAendernController implements Initializable {

    @FXML
    private Button btnCloseAendern;
    @FXML
    private Button btnRefreshTable;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField textId;
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
    private TableView<EinheitAnzeigenModel> einheitenTabelle;
    @FXML
    private TableColumn<EinheitAnzeigenModel, Integer> idCol;
    @FXML
    private TableColumn<EinheitAnzeigenModel, String> uebungCol;
    @FXML
    private TableColumn<EinheitAnzeigenModel, String> kategorieCol;
    @FXML
    private TableColumn<EinheitAnzeigenModel, Double> gewichtCol;
    @FXML
    private TableColumn<EinheitAnzeigenModel, Integer> setsCol;
    @FXML
    private TableColumn<EinheitAnzeigenModel, Integer> repsCol;
    @FXML
    private TableColumn<EinheitAnzeigenModel, String> datumCol;

    ObservableList<EinheitAnzeigenModel> dataList = FXCollections.observableArrayList();

    ListUebungen listUebungen = new ListUebungen();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        refreshTable();

        this.comboKategorie.setItems(FXCollections.observableArrayList(optionKategorie.values()));

    }

    public void refreshTable(){

        einheitenTabelle.getItems().clear();

        EinheitAendernModel einheitAendernModel = new EinheitAendernModel();

        einheitAendernModel.einheitAnzeigen(dataList);

        if(DbConnect.connectDb() != null){
            this.statusLabel.setText("Datenbank verbunden");
        }
        else {
            this.statusLabel.setText("Datenbank nicht verbunden");
        }

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        uebungCol.setCellValueFactory(new PropertyValueFactory<>("uebung"));
        kategorieCol.setCellValueFactory(new PropertyValueFactory<>("kategorie"));
        gewichtCol.setCellValueFactory(new PropertyValueFactory<>("gewicht"));
        setsCol.setCellValueFactory(new PropertyValueFactory<>("sets"));
        repsCol.setCellValueFactory(new PropertyValueFactory<>("reps"));
        datumCol.setCellValueFactory(new PropertyValueFactory<>("datum"));

        einheitenTabelle.setItems(dataList);

    }

    public void einheitAendern(){

        String uebung = comboUebung.getValue().toString();
        String kategorie = comboKategorie.getValue().toString();

        // Pruefen, ob die Eingaben richtig sind
        try {
            double gewicht = 0.0;
            int sets = 0;
            int reps = 0;

            // Pruefen, ob neue Werte eingetragen wurden, die geaendert werden muessen
            if (textGewicht.getText() != ""){
                gewicht = Double.parseDouble(textGewicht.getText());
            }

            if (textSets.getText() != ""){
                sets = Integer.parseInt(textSets.getText());
            }

            if (textReps.getText() != ""){
                reps = Integer.parseInt(textReps.getText());
            }

            EinheitAendernModel einheitAendernModel = new EinheitAendernModel();

            int chId = Integer.parseInt(textId.getText());

            einheitAendernModel.einheitAendern(chId, uebung, kategorie, gewicht, sets, reps);

            this.statusLabel.setText("Daten geändert");

            refreshTable();

        } catch (NumberFormatException nfe) {
            this.statusLabel.setText("Fehler bei der Eingabe");
            return;
        }
    }

    public void setComboUebung(ActionEvent event){

        ComboUebung.setComboUebung(comboKategorie, comboUebung);

    }

    @FXML
    public void closeAendern() {
        // get a handle to the stage
        Stage stage = (Stage) btnCloseAendern.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


}
