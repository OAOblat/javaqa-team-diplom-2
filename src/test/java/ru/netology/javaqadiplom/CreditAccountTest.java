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

    @Test
    public void shouldPayIfAmountEqualsCreditLimit() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(5000);
        Assertions.assertEquals(-5000, account.getBalance());
    }

    @Test
    public void shouldPayIfAmountEquals0() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(0);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayIfAmountNegative() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(-10);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddWhenInitialBalanceNot0() {
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3_000);
        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmount() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldCalcPercentIfNegativeBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(200);
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldCalcPercentIfPositiveBalance() {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(200);
        Assertions.assertEquals(0, account.yearChange());
    }

}
