import java.io.Serializable;

public class ILS extends Coin implements Serializable {
   final double value = 0.28;
    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double amount) {
        return amount*getValue();
    }
}
