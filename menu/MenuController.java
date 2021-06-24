package menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button btnSpeichern;
    @FXML
    private Button btnLoeschen;
    @FXML
    private Button btnCloseMenu;
    @FXML
    void windowSpeichern(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../einheitenSpeichern/einheitSpeichern.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Trainingseinheiten speichern");
            stage.getIcons().add(new Image("/icons/dumbbells.jpg"));
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (Exception e) {
            System.out.println("cant load new window");

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void windowAnzeigen(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../einheitenAnzeigen/einheitenAnzeigen.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Trainingseinheiten anzeigen");
            stage.getIcons().add(new Image("/icons/dumbbells.jpg"));
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (Exception e) {
            System.out.println("cant load new window");

        }
    }

    public void windowLoeschen(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../einheitenLoeschen/einheitenLoeschen.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Trainingseinheit löschen");
            stage.getIcons().add(new Image("/icons/dumbbells.jpg"));
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (Exception e) {
            System.out.println("cant load new window");

        }
    }

    public void windowAendern(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../einheitenAendern/einheitenAendern.fxml"));
            Parent root1 = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setTitle("Trainingseinheit ändern");
            stage.getIcons().add(new Image("/icons/dumbbells.jpg"));
            stage.setScene(new Scene(root1));
            stage.show();
        }
        catch (Exception e) {
            System.out.println("cant load new window");

        }
    }

    public void closeMenu(ActionEvent event) {
        // get a handle to the stage
        Stage stage = (Stage) btnCloseMenu.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}