package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void shouldTransferMoneyTestCase1() {
        CreditAccount creditAcc = new CreditAccount(
                7_000,
                5_000,
                15
        );

        SavingAccount savingAcc = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(creditAcc, savingAcc, 3_000));
    }

    @Test
    public void shouldTransferMoneyTestCase2() {
        CreditAccount creditAcc = new CreditAccount(
                7_000,
                5_000,
                15
        );

        SavingAccount savingAcc = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(savingAcc, creditAcc, 3_000));
    }

    @Test
    public void shouldTransferMoneyTestCase3() {
        CreditAccount creditAcc1 = new CreditAccount(
                7_000,
                5_000,
                15
        );

        CreditAccount creditAcc2 = new CreditAccount(
                7_000,
                5_000,
                15
        );

        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(creditAcc1, creditAcc2, 3_000));
    }

    @Test
    public void shouldTransferMoneyTestCase4() {
        SavingAccount savingAcc1 = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        SavingAccount savingAcc2 = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        Bank bank = new Bank();

        Assertions.assertTrue(bank.transfer(savingAcc1, savingAcc2, 3_000));
    }

    @Test
    public void shouldNotTransferMoneyTestCase1() {
        CreditAccount creditAcc = new CreditAccount(
                2_000,
                1_000,
                15
        );

        SavingAccount savingAcc = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAcc, creditAcc, 0));
    }

    @Test
    public void shouldNotTransferMoneyTestCase2() {
        CreditAccount creditAcc = new CreditAccount(
                2_000,
                1_000,
                15
        );

        SavingAccount savingAcc = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAcc, creditAcc, -1_000));
    }

    @Test
    public void shouldNotTransferMoneyTestCase3() {
        CreditAccount creditAcc = new CreditAccount(
                2_000,
                1_000,
                15
        );

        SavingAccount savingAcc = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAcc, creditAcc, 100_000));
    }

    @Test
    public void shouldNotTransferMoneyTestCase4() {
        CreditAccount creditAcc = new CreditAccount(
                2_000,
                1_000,
                15
        );

        SavingAccount savingAcc = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(creditAcc, savingAcc, 100_000));
    }

    @Test
    public void shouldNotTransferMoneyTestCase5() {
        CreditAccount creditAcc1 = new CreditAccount(
                7_000,
                5_000,
                15
        );

        CreditAccount creditAcc2 = new CreditAccount(
                7_000,
                5_000,
                15
        );

        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(creditAcc1, creditAcc2, 100_000));
    }

    @Test
    public void shouldNotTransferMoneyTestCase6() {
        SavingAccount savingAcc1 = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        SavingAccount savingAcc2 = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );

        Bank bank = new Bank();

        Assertions.assertFalse(bank.transfer(savingAcc1, savingAcc2, 100_000));
    }
}
