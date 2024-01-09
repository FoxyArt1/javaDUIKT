import org.example.BankAccount;
import org.example.InsufficientFundsException;
import org.example.NegativeAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    public void setUp() {
        bankAccount = new BankAccount("Mikhail", 1000.0);
    }

    @Test
    public void testDeposit() {
        double newBalance = bankAccount.deposit(500.0);
        assertEquals(1500.0, newBalance);

        // Test negative deposit
        double negativeBalance = bankAccount.deposit(-200.0);
        assertEquals(1500.0, negativeBalance);
    }

    @Test
    public void testWithdraw() {
        double newBalance = bankAccount.withdraw(500.0);
        assertEquals(500.0, newBalance);

        Exception negativeWithdrawal = assertThrows(NegativeAmountException.class, () -> bankAccount.withdraw(-200.0));
        assertEquals("Negative amount", negativeWithdrawal.getMessage());

        Exception insufficientFunds = assertThrows(InsufficientFundsException.class, () -> bankAccount.withdraw(1000.0));
        assertEquals("Insufficient funds", insufficientFunds.getMessage());
    }

    @Test
    public void testGetBalance() {
        double balance = bankAccount.getBalance();
        assertEquals(1000.0, balance);
    }

    @Test
    public void testGetAccountSummary() {
        String summary = bankAccount.getAccountSummary();
        assertEquals("Acc num: 0, acc name: Mikhail, bal: 1000.0", summary);
    }
}
