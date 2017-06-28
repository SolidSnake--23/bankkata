package domain.operation;

public interface OperationRepository {


    void persistDeposit(Amount amount);

    void persistWithdraw(Amount amount);

    Operations allOperations();
}
