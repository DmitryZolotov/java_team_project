package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {
    @Test
    public void shouldExceptIfCreditLimitNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(2_000,
                    0,
                    15);
        });
    }

    @Test
    public void shouldExceptIfCreditLimitNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(2_000,
                    -1_000,
                    15);
        });
    }

    @Test
    public void shouldExceptIfRateNull() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(2_000,
                    1_000,
                    0);
        });
    }

    @Test
    public void shouldExceptIfRateNegative() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new CreditAccount(2_000,
                    1_000,
                    -15);
        });
    }



    @Test
    public void shouldDecreasedBalance() {
        CreditAccount account = new CreditAccount(
                7_000,
                5_000,
                15
        );

        account.pay(1_000);

        Assertions.assertEquals(6_000, account.getBalance());
    }

    @Test
    public void shouldDecreasedBalanceToLimit() {
        CreditAccount account = new CreditAccount(
                7_000,
                5_000,
                15
        );

        account.pay(2_000);

        Assertions.assertEquals(5_000, account.getBalance());
    }

    @Test
    public void shouldNotDecreasedBalanceUnderLimit() {
        CreditAccount account = new CreditAccount(
                7_000,
                5_000,
                15
        );

        account.pay(12_000);

        Assertions.assertEquals(7_000, account.getBalance());
    }

    @Test
    public void shouldSaveBalanceIfAmountNegative() {
        CreditAccount account = new CreditAccount(
                7_000,
                5_000,
                15
        );

        account.pay(-4_000);

        Assertions.assertEquals(7_000, account.getBalance());
    }

    @Test
    public void shouldSaveBalanceIfAmountNull() {
        CreditAccount account = new CreditAccount(
                7_000,
                5_000,
                15
        );

        account.pay(0);

        Assertions.assertEquals(7_000, account.getBalance());
    }



    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldLeaveBalanceWithoutChangesCase1() {
        CreditAccount account = new CreditAccount(
                2_000,
                5_000,
                15
        );

        account.add(0);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldLeaveBalanceWithoutChangesCase2() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(-1_000);

        Assertions.assertEquals(1_000, account.getBalance());
    }



    @Test
    public void shouldShowNumberIfBalanceNegative () {
        CreditAccount account = new CreditAccount(
                -200,
                5_000,
                15
        );

        Assertions.assertEquals(-30, account.yearChange());
    }

    @Test
    public void shouldShowNumberIfBalancePositive () {
        CreditAccount account = new CreditAccount(
                200,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldShowNumberIfBalanceNull () {
        CreditAccount account = new CreditAccount(
                0,
                5_000,
                15
        );

        Assertions.assertEquals(0, account.yearChange());
    }

}
