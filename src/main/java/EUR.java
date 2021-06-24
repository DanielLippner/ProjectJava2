import java.io.Serializable;

public class EUR extends Coin implements Serializable {
    final double value = 4.23;
    @Override
    public double getValue() {
        return value;
    }

    @Override
    public double calculate(double amount) {
        return amount*getValue();
    }

}
