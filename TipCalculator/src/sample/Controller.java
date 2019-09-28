package sample;

// TipCalculatorController.java
// Controller that handles calculateButton and tipPercentageSlider events
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller {
    // formatters for currency and percentages
    private static final NumberFormat currency =
            NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent =
            NumberFormat.getPercentInstance();

    private BigDecimal tipPercentage = new BigDecimal(0.15); // 15% default

    // GUI controls defined in FXML and used by the controller's code
    @FXML
    private TextField amountTextField;

    @FXML
    private Label tipPercentageLabel;

    @FXML
    private Slider tipPercentageSlider;

    @FXML
    private TextField tipTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private TextField totalForEveryoneTextField;

    @FXML
    private TextField amountOfPeopleTextField;

    BigDecimal amount;
    int amountOfPeople;
    BigDecimal tip;
    BigDecimal total;
    BigDecimal totalForEveryone;

    // calculates and displays the tip and total amounts
    @FXML
    private void calculateButtonPressed(ActionEven
                                                    t event) {
        try {
            amount = new BigDecimal(amountTextField.getText());
            tip = amount.multiply(tipPercentage);
            total = amount.add(tip);
            amountOfPeople = Integer.parseInt(amountOfPeopleTextField.getText());
            if (amountOfPeople > 0) {
                totalForEveryone = total.divide(new BigDecimal(amountOfPeople));
                totalForEveryoneTextField.setText(currency.format(totalForEveryone));
            }
            tipTextField.setText(currency.format(tip));
            totalTextField.setText(currency.format(total));

        }
        catch (NumberFormatException ex) {
            amountTextField.setText("Enter amount");
            amountTextField.selectAll();
            amountTextField.requestFocus();
        }
    }

    // called by FXMLLoader to initialize the controller
    public void initialize() {
        // 0-4 rounds down, 5-9 rounds up
        currency.setRoundingMode(RoundingMode.HALF_UP);

        // listener for changes to tipPercentageSlider's value
        tipPercentageSlider.valueProperty().addListener(
                (ov, oldValue, newValue) -> {
                    tipPercentage =
                            BigDecimal.valueOf(newValue.intValue() / 100.0);
                    tipPercentageLabel.setText(percent.format(tipPercentage));

                    amount = new BigDecimal(amountTextField.getText());
                    tip = amount.multiply(tipPercentage);
                    tipTextField.setText(currency.format(tip));
                }
        );

        amountTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d{0,10}([\\.]\\d{0,4})?")) {
                amountTextField.setText(oldValue);
            }
        });


    }
}
