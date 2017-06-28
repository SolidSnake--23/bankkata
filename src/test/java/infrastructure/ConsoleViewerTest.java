package infrastructure;

import domain.operation.Amount;
import domain.operation.Clock;
import domain.operation.Deposit;
import domain.operation.Operations;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;
import java.time.LocalDate;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleViewerTest {

    @Mock
    private PrintStream out;


    @Mock
    private Clock clock;

    @Test
    public void should_print_an_operation_with_date_amount_and_balance() throws Exception {
        ConsoleViewer consoleViewer = new ConsoleViewer(out);

        when(clock.now()).thenReturn(LocalDate.of(2017, 06, 23));

        consoleViewer.printOperations(new Operations(new Deposit(
                new Amount(100), clock),
                new Deposit(new Amount(100), clock),
                new Deposit(new Amount(100), clock)
        ));

        verify(out).println("DATE | AMOUNT | BALANCE");
        verify(out).println("23/06/2017 | 100,00 | 100,00");
        verify(out).println("23/06/2017 | 100,00 | 200,00");
        verify(out).println("23/06/2017 | 100,00 | 300,00");
    }
}