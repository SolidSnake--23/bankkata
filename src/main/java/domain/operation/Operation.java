package domain.operation;

import java.time.format.DateTimeFormatter;
import java.util.function.Consumer;

public abstract class Operation {
    protected Amount amount;
    protected Clock clock;

    public Operation(Amount amount, Clock clock) {
        this.amount = amount;
        this.clock = clock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        return amount != null ? amount.equals(operation.amount) : operation.amount == null;
    }

    @Override
    public int hashCode() {
        return amount != null ? amount.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "amount=" + amount +
                '}';
    }

    protected String now() {
        return this.clock.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public abstract void print(Consumer<String> function);

    public abstract Amount forBalance(Amount balance);
}
