package combobox;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListUebungen {
    ObservableList<String> listRuecken = FXCollections.observableArrayList(
            "Kreuzheben", "Rudern", "Lat-Zug", "Klimmzüge");
    ObservableList<String> listBeine = FXCollections.observableArrayList(
            "Kniebeugen", "Beinbeuger", "Beinstrecker", "Ausfallschritte");
    ObservableList<String> listOberkoerper = FXCollections.observableArrayList(
            "Bankdrücken", "Schulterdrücken", "Seitheben", "Schrägbankdrücken");
    ObservableList<String> listArme = FXCollections.observableArrayList(
            "Bizeps", "Trizeps");

    public ObservableList<String> getListRuecken() {
        return listRuecken;
    }

    public void setListRuecken(ObservableList<String> listRuecken) {
        this.listRuecken = listRuecken;
    }

    public ObservableList<String> getListBeine() {
        return listBeine;
    }

    public void setListBeine(ObservableList<String> listBeine) {
        this.listBeine = listBeine;
    }

    public ObservableList<String> getListOberkoerper() {
        return listOberkoerper;
    }

    public void setListOberkoerper(ObservableList<String> listOberkoerper) {
        this.listOberkoerper = listOberkoerper;
    }

    public ObservableList<String> getListArme() {
        return listArme;
    }

    public void setListArme(ObservableList<String> listArme) {
        this.listArme = listArme;
    }
}
