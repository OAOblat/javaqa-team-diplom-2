package ru.netology.javaqadiplom;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test //пополнение счета при нулевом балансе
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
    public void shouldThrowExceptionForNegativeInitialBalance() { // выбрасывает исключение, при попытке установить начальный баланс отрицательным

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(-10, 10, 10);
        });
    }

    @Test
    public void shouldThrowExceptionForNegativeCreditLimit() { // выбрасывает исключение, при попытке установить кредитный лимит отрицательным

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(10, -10, 10);
        });
    }

    @Test
    public  void shouldPayWhenOk() { //должна проходить оплата на сумму, при совершении которой не баланс не выходит за пределы кредитного лимита
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(3000);
        Assertions.assertEquals(-3000, account.getBalance());
    }

    @Test
    public void shouldNotPayIfAmountMoreThenCreditLimit() { // оплата не должна проходить, если по итогу баланс выходит за кредитный лимит
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(6000);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldPayIfAmountEqualsCreditLimit() { // оплата должна проходить, если при совершении покупки итоговый баланс равен кредитному лимиту
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(5000);
        Assertions.assertEquals(-5000, account.getBalance());
    }

    @Test
    public void shouldPayIfAmountEquals0() { // проверка оплаты, если сумма покупки равно 0
        CreditAccount account = new CreditAccount(
                500,
                5_000,
                15
        );
        account.pay(0);
        Assertions.assertEquals(500, account.getBalance());
    }

    @Test
    public void shouldPayIfAmountNegative() { // оплата не должна проходить, если сумма покупки  - отрицательное число
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );
        account.pay(-10);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldAddWhenInitialBalanceNot0() { // Пополнение счета, сумма пополнения должна суммироваться с начальным балансом
        CreditAccount account = new CreditAccount(
                1000,
                5_000,
                15
        );

        account.add(3_000);
        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldAddNegativeAmount() { // пополнение не должно работать, если сумма пополнения - отрицательное число
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(-3_000);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    public void shouldCalcPercentIfNegativeBalance() { // проценты должны начисляться, если баланс отрицательный
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(200);
        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldCalcPercentIfPositiveBalance() { // проценты НЕ должны начисляться, если баланс положительный
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.add(200);
        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldCalcPercentIfNegativeBalance2() { // проверка верного округления процентов (до единиц)
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        account.pay(290);
        Assertions.assertEquals(-43, account.yearChange());
    }

    @Test
    public void shouldNotCalcPercentIf0() { // проценты НЕ должны начисляться, если баланс = 0
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

}
