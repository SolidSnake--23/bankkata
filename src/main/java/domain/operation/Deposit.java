package domain.operation;

import java.util.function.Consumer;

public class Deposit extends Operation {

    public Deposit(Amount amount, Clock clock) {
        super(amount, clock);
    }

    @Override
    public void print(Consumer<String> function) {
        function.accept(String.format("%s | %.2f", now(), amount.getValue()));
    }

    @Override
    public Amount forBalance(Amount balance) {
        return balance.add(this.amount);
    }
}
