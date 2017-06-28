package infrastructure;

import domain.account.Balance;
import domain.account.Viewer;
import domain.operation.Operation;
import domain.operation.Operations;

import java.io.PrintStream;

public class ConsoleViewer implements Viewer {

    private PrintStream out;

    public ConsoleViewer(PrintStream out) {
        this.out = out;
    }

    @Override
    public void printOperations(Operations operations) {
        Balance balance = new Balance();

        printHeader();

        for (Operation operation : operations) {
            StringBuilder output = new StringBuilder();
            balance = balance.apply(operation);
            operation.print(output::append);
            balance.print(output::append);
            out.println(output.toString());
        }

    }

    private void printHeader() {
        out.println("DATE | AMOUNT | BALANCE");
    }

}
