package domain.operation;

import java.util.*;
import java.util.function.Consumer;

public class Operations implements Iterable<Operation> {

    private List<Operation> operations = new ArrayList<>();


    public Operations() {

    }

    public Operations(Operation operation) {
        operations.add(operation);
    }

    public Operations(Operation... operations) {
        this.operations.addAll(Arrays.asList(operations));
    }

    public void add(Operation operation) {
        operations.add(operation);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operations that = (Operations) o;

        return operations != null ? operations.equals(that.operations) : that.operations == null;
    }

    @Override
    public int hashCode() {
        return operations != null ? operations.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Operations{" +
                "operations=" + operations +
                '}';
    }

    @Override
    public Iterator<Operation> iterator() {
        return operations.iterator();
    }

    @Override
    public void forEach(Consumer<? super Operation> action) {
        operations.forEach(action);
    }

    @Override
    public Spliterator<Operation> spliterator() {
        return operations.spliterator();
    }

}
