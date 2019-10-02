package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField ageTextField;

    @FXML
    private Label targetHeartRateLabel;

    @FXML
    private Label ageErrorLabel;

    @FXML
    private Label maxHeartRateLabel;

    @FXML
    private Button calculateButton;

    private double age;
    private double targetHeartRateLow;
    private double targetHeartRateHigh;
    private double maxHeartRate;

    private static final String TARGET_RATE = "Your target heart rate is: ";
    private static final String MAX_RATE = "Your maximum heart rate is: ";

    public void initialize() {
        calculateButton.setOnAction(e -> {
            calculate();
        });
    }

    private void calculate() {
        if (isValidAge()) {
            maxHeartRate = 220 - age;
            targetHeartRateLow = maxHeartRate / 100 * 50;
            targetHeartRateHigh = maxHeartRate / 100 * 70;
            targetHeartRateLabel.setText(TARGET_RATE + targetHeartRateLow + " - " + targetHeartRateHigh);
            maxHeartRateLabel.setText(MAX_RATE + maxHeartRate);
        }
    }

    private boolean isValidAge() {
        try {
            age = Integer.parseInt(ageTextField.getText());
            if (age > 0 && age <= 130) {
                ageErrorLabel.setVisible(false);
                targetHeartRateLabel.setVisible(true);
                maxHeartRateLabel.setVisible(true);
                return true;
            } else {
                targetHeartRateLabel.setVisible(false);
                maxHeartRateLabel.setVisible(false);
                ageErrorLabel.setVisible(true);
            }
        } catch (NumberFormatException e) {
            targetHeartRateLabel.setVisible(false);
            maxHeartRateLabel.setVisible(false);
            ageErrorLabel.setVisible(true);
            return false;
        }
        return false;
    }
}