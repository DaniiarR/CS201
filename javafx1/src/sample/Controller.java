package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Controller {

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private Button calculateButton;

    @FXML
    private ImageView bmiImageView;

    @FXML
    private Label bmiLabel;

    @FXML
    void calculateBmi(ActionEvent event) {

    }

}