// Controller Class for UI Interaction //
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.math.BigInteger;
import java.util.List;

public class FibonacciAndRiceController {

    @FXML
    private TextField inputField;

    @FXML
    private TextArea fibonacciOutput;

    @FXML
    private Label riceResultLabel;

    private final FibonacciService fibonacciService = new FibonacciService();
    private final RiceGrainService riceGrainService = new RiceGrainService();

    // // Event: Generate Fibonacci Sequence //
    @FXML
    private void handleGenerateFibonacci() {
        try {
            int n = Integer.parseInt(inputField.getText());
            if (n <= 0) {
                fibonacciOutput.setText("Please enter a positive integer.");
                return;
            }

            List<BigInteger> sequence = fibonacciService.generateFibonacci(n);
            fibonacciOutput.setText(sequence.toString());

        } catch (NumberFormatException e) {
            fibonacciOutput.setText("Invalid input. Please enter a number.");
        }
    }

    // Event: Calculate Rice Grains for the Full Chessboard //
    @FXML
    private void handleCalculateRice() {
        BigInteger total = riceGrainService.calculateRiceOnChessboard(64);
        riceResultLabel.setText("Total grains on a chessboard (64 squares):\n" + total.toString());
    }
}
