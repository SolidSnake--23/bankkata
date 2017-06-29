package domain.operation;

import java.math.BigDecimal;
import java.util.function.Consumer;

public class Amount {
    private BigDecimal value;

    public Amount(double value) {

        this.value = new BigDecimal(value);
    }

    public Amount(BigDecimal value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return value != null ? value.equals(amount.value) : amount.value == null;
    }

    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                '}';
    }

    public BigDecimal getValue() {
        return value;
    }

    public Amount minus(Amount amount) {
        return new Amount(this.value.min(amount.value));
    }

    public Amount add(Amount amount) {
        return new Amount(this.value.add(amount.value));
    }

    public void print(Consumer<String> printer) {
        printer.accept(String.format(" | %.2f", value));
    }
}
