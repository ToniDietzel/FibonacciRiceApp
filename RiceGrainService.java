// Service Class for Rice Grain Legend Logic //
import java.math.BigInteger;

public class RiceGrainService {

    // // Calculate Rice Grains on Half Chessboard //
    public BigInteger calculateRiceOnChessboard(int squares) {
        BigInteger total = BigInteger.ZERO;
        BigInteger grains = BigInteger.ONE;

        for (int i = 1; i <= squares; i++) {
            total = total.add(grains);
            grains = grains.multiply(BigInteger.TWO);
        }

        return total;
    }
}