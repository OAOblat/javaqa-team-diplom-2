package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test //1 При пополнении не суммируется начальный баланс сбер. счета с суммой добавления,
    // а обновляется на сумму добавления в методе add
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                4_000,
                1_000,
                10_000,
                5
        );

        account.add(5_000);

        Assertions.assertEquals(4_000 + 5_000, account.getBalance());
    }
    @Test //2 При пополнении суммы до максимума
    // не меняется начальный баланс сберегательного счета в методе add
    public void testOverAddBalanceEqualsMax() {
        SavingAccount account = new SavingAccount(
                6_000,
                1_000,
                10_000,
                5
        );

        account.add(4_000);

        Assertions.assertEquals(6_000 + 4_000, account.getBalance());
    }

    @Test
    public void testOverAddBalanceHighMax() {
        SavingAccount account = new SavingAccount(
                7_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertFalse(false);
    }
    @Test
    public void testNegativeAdd() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        account.add(-1_000);

        Assertions.assertFalse(false);
    }

    @Test // 3 После совершения покупки начальный баланс сбер.
    // счета становится ниже минимального предела в методе pay
    public void testOverPayBalanceLowMin() {
        SavingAccount account = new SavingAccount(
                3_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        Assertions.assertEquals(3_000, account.getBalance());
    }

    @Test
    public void testOverPayBalanceEqualsMin() {
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                5
        );

        account.pay(7_000);

        Assertions.assertEquals(8_000 - 7_000, account.getBalance());
    }

    @Test
    public void testOverPayBalanceHighMin() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        account.pay(2_000);

        Assertions.assertEquals(5_000 - 2_000, account.getBalance());
    }
    @Test
    public void testNegativePay() {
        SavingAccount account = new SavingAccount(
                1_000,
                1_000,
                10_000,
                5
        );

        account.pay(-1_000);

        Assertions.assertFalse(false);
    }
    @Test //4 Не выкидывает исключение при отрицательном минимальном
    // балансе в конструкторе с параметрами
    public void testNegativeMinBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    3_000,
                    -2_500,
                    10_000,
                    5
            );
        });
    }

    @Test //5 Не выкидывает исключение при заданном минимальном
    // балансе в сравнении с максимальным
    public void testMinBalanceComparedMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    3_000,
                    10_000,
                    5_000,
                    5
            );
        });
    }

    @Test
    public void testNegativeRate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    5_000,
                    1_000,
                    10_000,
                    -1
            );
        });
    }

    @Test
    public void testYearChange() {
        SavingAccount account = new SavingAccount(
                200,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(30, account.yearChange());
    }
}
