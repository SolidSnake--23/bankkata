package domain.account;

import domain.operation.Amount;
import domain.operation.Operation;

import java.util.function.Consumer;

public class Balance {

    private Amount value = new Amount(0);

    private Balance(Amount amount) {

        this.value = amount;
    }

    public Balance() {
    }

    public Balance apply(Operation operation) {
        return new Balance(operation.forBalance(value));
    }

    public void print(Consumer<String> printer) {
        value.print(printer);
    }
}
