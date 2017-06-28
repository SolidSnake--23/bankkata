package infrastructure;

import domain.operation.*;

public class BankOperationRepository implements OperationRepository {

    protected Operations operations = new Operations();

    public void persistDeposit(Amount amount) {
        operations.add(new Deposit(amount, new Clock()));
    }

    public void persistWithdraw(Amount amount) {
        operations.add(new Withdraw(amount, new domain.operation.Clock()));
    }

    public Operations allOperations() {

        return operations;
    }


}
