package combobox;

import javafx.scene.control.ComboBox;

import java.awt.event.ActionEvent;

public class ComboUebung {


    public static void setComboUebung(ComboBox comboKategorie, ComboBox comboUebung){
        ListUebungen listUebungen = new ListUebungen();

        if (comboKategorie.getValue().toString().equals("Rücken")) {
            comboUebung.setItems(listUebungen.getListRuecken());
        }
        else if (comboKategorie.getValue().toString().equals("Beine")){
            comboUebung.setItems(listUebungen.getListBeine());
        }
        else if (comboKategorie.getValue().toString().equals("Oberkörper")){
            comboUebung.setItems(listUebungen.getListOberkoerper());
        }
        else if (comboKategorie.getValue().toString().equals("Arme")){
            comboUebung.setItems(listUebungen.getListArme());
        }

    }

}
