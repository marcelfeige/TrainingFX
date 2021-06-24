package einheitenLoeschen;

import dbUtil.DbConnect;
import einheitenAnzeigen.EinheitAnzeigenModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class EinheitLoeschenController implements Initializable {


    @FXML
    private Button btnCloseLoeschen;
    @FXML
    private Button btnDeleteEintrag;
    @FXML
    private Button btnRefreshTable;
    @FXML
    private Label statusLabel;
    @FXML
    private TextField textId;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        refreshTable();

    }

    public void refreshTable(){

        einheitenTabelle.getItems().clear();

        EinheitLoeschenModel einheitLoeschenModel = new EinheitLoeschenModel();
        einheitLoeschenModel.einheitLoeschen(dataList);

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

    @FXML
    public void closeLoeschen() {
        // get a handle to the stage
        Stage stage = (Stage) btnCloseLoeschen.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    public void deleteEinheit() {

        int delId = Integer.parseInt(textId.getText());

        EinheitLoeschenModel einheitLoeschenModel = new EinheitLoeschenModel();

        einheitLoeschenModel.deleteEinheit(delId);

        refreshTable();
    }
}
