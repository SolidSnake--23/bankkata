package domain.operation;

import java.util.function.Consumer;

public class Amount {
    private double value;

    public Amount(double value) {

        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Amount amount = (Amount) o;

        return value == amount.value;
    }

    @Override
    public int hashCode() {
        return (int) (value);
    }

    @Override
    public String toString() {
        return "Amount{" +
                "value=" + value +
                '}';
    }

    public double getValue() {
        return value;
    }

    public Amount minus(Amount amount) {
        return new Amount(this.value - amount.value);
    }

    public Amount add(Amount amount) {
        return new Amount(this.value + amount.value);
    }

    public void print(Consumer<String> printer) {
        printer.accept(String.format(" | %.2f", value));
    }
}
