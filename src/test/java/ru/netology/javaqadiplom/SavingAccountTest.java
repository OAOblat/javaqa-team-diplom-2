package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test //Не работает округление до целочисленного значения
    public void testCalcPercent(){
        SavingAccount account = new SavingAccount(
                290,
                1_000,
                10_000,
                15
        );

        Assertions.assertEquals(43, account.yearChange());
    }
}


