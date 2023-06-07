package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void testTransfer() {
        Account from = new Account(500);
        Account to = new Account(0);
        Bank bank = new Bank();
        boolean transferSuccess = bank.transfer(from, to, 500);
        Assertions.assertTrue(transferSuccess);
        Assertions.assertEquals(0, from.getBalance());
        Assertions.assertEquals(500, to.getBalance());
    }

    @Test
    public void testTransferWhenAmountMoreThenBalance() { // попытаемся перевести больше денег, чем есть на счете
        Account from = new Account(500);
        Account to = new Account(0);
        Bank bank = new Bank();
        boolean transferSuccess = bank.transfer(from, to, 600);
        Assertions.assertFalse(transferSuccess);

        Assertions.assertEquals(500, from.getBalance());
        Assertions.assertEquals(0, to.getBalance());
    }

    @Test
    public void testTransferReturn() {// переводим деньги обратно
        Account from = new Account(500);
        Account to = new Account(1000);
        Bank bank = new Bank();
        boolean transferSuccess = bank.transfer(to, from, 300);

        Assertions.assertTrue(transferSuccess);

        Assertions.assertEquals(800, from.getBalance());
        Assertions.assertEquals(700, to.getBalance());
    }
}
