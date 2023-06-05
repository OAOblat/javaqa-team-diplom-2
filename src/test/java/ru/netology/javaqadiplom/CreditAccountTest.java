package ru.netology.javaqadiplom;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
    public static void main(String[] args) {
        CreditAccount account = new CreditAccount(-10, 10, 10);
        System.out.println("Начальный баланс: " + account.getBalance());

        CreditAccount account2 = new CreditAccount(10, -10, 10);
        System.out.println("Кредитный лимит: " + account.getBalance());
    }

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(3_000);
        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void shouldThrowExceptionForNegativeInitialBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(-10, 10, 10);
        });
    }

    @Test
    public void shouldThrowExceptionForNegativeCreditLimit() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(10, -10, 10);
        });
    }

    @Test
    public  void shouldPayWhenOk() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(3000);
        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void shouldPayIfAmountMoreThenCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(6000);
        Assertions.assertEquals(0, account.getBalance());
    }
}
