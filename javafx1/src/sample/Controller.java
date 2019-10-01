package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private Label illegalWeightLabel;

    private double weight;
    private double height;
    private double bmi;
    @FXML
    void calculateBmi(ActionEvent event) {
        if (isLegalWeightAndHeight()) {
            bmi = weight / (height * height);
            bmiLabel.setText(String.format("Your BMI is: %.2f", bmi));
            if (bmi < 18.5) {
                bmiImageView.setImage(new Image("sample/underweight.png"));
            } else if (bmi >= 18.5 && bmi <= 25) {
                bmiImageView.setImage(new Image("sample/normal.png"));
            } else if (bmi >= 25 && bmi <= 29.9) {
                bmiImageView.setImage(new Image("sample/overweight.png"));
            } else if (bmi >= 30 && bmi <= 34.9) {
                bmiImageView.setImage(new Image("sample/obese.png"));
            } else if (bmi >= 35) {
                bmiImageView.setImage(new Image("sample/extremelyobese.png"));
            }
        }
    }

    private boolean isLegalWeightAndHeight() {
        try {
            weight = Double.parseDouble(weightTextField.getText());
            height = Double.parseDouble(heightTextField.getText());
            if (weight > 0 && height > 0) {
                illegalWeightLabel.setVisible(false);
                return true;
            } else {
                illegalWeightLabel.setVisible(true);
                return false;
            }
        } catch (NumberFormatException e) {
            illegalWeightLabel.setVisible(true);
        }
        return false;
    }
}