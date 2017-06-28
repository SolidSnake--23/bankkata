package domain.account;

import domain.operation.Amount;
import domain.operation.OperationRepository;
import domain.operation.Operations;

public class Account {

    private OperationRepository operationRepository;
    private Viewer viewer;

    private Operations operations;
    private Amount balance;

    public Account(OperationRepository operationRepository, Viewer viewer) {
        this.operationRepository = operationRepository;
        this.viewer = viewer;
    }


    public void deposit(Amount amount) {
        operationRepository.persistDeposit(amount);
    }

    public void withdraw(Amount amount) {
        operationRepository.persistWithdraw(amount);
    }

    public void printOperations() {
        viewer.printOperations(operationRepository.allOperations());
    }
}
