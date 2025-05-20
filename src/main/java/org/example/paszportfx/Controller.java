package org.example.paszportfx;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private Label lblNumer;

    @FXML
    private Button btnOK;

    @FXML
    private Label lblImie;

    @FXML
    private Label lblNazwisko;

    @FXML
    private TextField txtFieldNumer;

    @FXML
    private TextField txtFieldImie;

    @FXML
    private TextField txtFieldNazwisko;

    @FXML
    private RadioButton radioBtnNiebieskie;

    @FXML
    private RadioButton radioBtnZielone;

    @FXML
    private RadioButton radioBtnPiwne;

    @FXML
    private ImageView imageViewLeft;

    @FXML
    private ImageView imageViewRight;

    @FXML
    private Label lblKolorOczu;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtFieldNumer.setOnAction(event -> {
            try {
                Image photo = new Image(String.valueOf(getClass().getResource("/images/" + txtFieldNumer.getText() + "-zdjecie.jpg")));
                Image finger = new Image(String.valueOf(getClass().getResource("/images/" + txtFieldNumer.getText() + "-odcisk.jpg")));
                imageViewLeft.setImage(photo);
                imageViewRight.setImage(finger);
            } catch (Exception e) {
                imageViewLeft.setImage(null);
                imageViewRight.setImage(null);
            }
        });

        btnOK.setOnAction(event -> {
            String name = txtFieldImie.getText();
            String surname = txtFieldNazwisko.getText();
            String color = "";
            if (radioBtnNiebieskie.isSelected()) color = "Kolor oczu - niebieski";
            if (radioBtnZielone.isSelected()) color = "Kolor oczu - zielony";
            if (radioBtnPiwne.isSelected()) color = "Kolor oczu - piwny";
            if (name.isEmpty() || surname.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Wprowadź dane!");
                alert.setContentText(null);
                alert.show();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION, name + " " + surname + " " + color);
                alert.show();
            }
        });


    }
}
