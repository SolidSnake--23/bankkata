package domain.account;

import domain.operation.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    @Mock
    private
    OperationRepository operationRepository;

    @Mock
    private
    Viewer viewer;

    @Test
    public void should_persist_operation_of_deposit() throws Exception {
        Account account = new Account(operationRepository, viewer);

        account.deposit(new Amount(893));

        verify(operationRepository).persistDeposit(new Amount(893));
    }

    @Test
    public void should_persist_operation_of_withdraw() throws Exception {
        Account account = new Account(operationRepository, viewer);

        account.withdraw(new Amount(893));

        verify(operationRepository).persistWithdraw(new Amount(893));
    }

    @Test
    public void should_retrieve_all_statements() throws Exception {
        Account account = new Account(operationRepository, viewer);

        Operations operations = new Operations(new Withdraw(new Amount(10), new Clock()), new Deposit(new Amount(10), new Clock()));

        when(operationRepository.allOperations()).thenReturn(operations);

        account.printOperations();

        verify(viewer).printOperations(operations);
    }
}