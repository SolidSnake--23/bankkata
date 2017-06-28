package infrastructure;

import domain.operation.*;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BankOperationRepositoryTest {

    private BankOperationRepository bankOperationRepository;

    @Before
    public void init() {
        bankOperationRepository = new BankOperationRepository();
    }

    @Test
    public void persistDeposit() throws Exception {
        bankOperationRepository.persistDeposit(new Amount(23));

        Operations operations = new Operations(new Deposit(new Amount(23), new domain.operation.Clock()));
        assertThat(bankOperationRepository.allOperations()).isEqualTo(operations);
    }

    @Test
    public void persistWithdraw() throws Exception {
        bankOperationRepository.persistWithdraw(new Amount(32));

        Operations operations = new Operations(new Withdraw(new Amount(32), new Clock()));
        assertThat(bankOperationRepository.allOperations()).isEqualTo(operations);
    }

    @Test
    public void allOperations() throws Exception {
        bankOperationRepository.persistWithdraw(new Amount(32));
        bankOperationRepository.persistDeposit(new Amount(23));

        Withdraw withdraw = new Withdraw(new Amount(32), new domain.operation.Clock());
        Deposit deposit = new Deposit(new Amount(23), new Clock());

        Operations operations = new Operations(withdraw, deposit);
        assertThat(bankOperationRepository.allOperations()).isEqualTo(operations);
    }

}