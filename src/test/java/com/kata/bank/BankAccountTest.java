package com.kata.bank;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class BankAccountTest {
    private static final Logger LOGGER = LogManager.getLogger(BankAccountTest.class.getName());
    private final BankAccount account = new BankAccount();
    private final Double initialBalance = 1000.0;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    @Before
    public void setUp() throws ParseException {
        System.setOut(new PrintStream(outputStream));
        String stringDate = "14/01/2012";
        Date date = simpleDateFormat.parse(stringDate);
        account.depositMoney(date, initialBalance);
    }

    @After
    public void tearDown() {
        System.setOut(originalOutput);
    }

    @Test
    public void depositMoneyOnAccount() throws ParseException {
        String stringDate = "14/01/2012";
        Date date = simpleDateFormat.parse(stringDate);
        account.depositMoney(date, 1000.0);
        Double expected = initialBalance + 1000;
        assertEquals(expected, account.getBalance());
    }

    @Test
    public void withdrawMoneyFromAccount() {
        account.withdrawMoney(600.0);
        Double expected = initialBalance - 600;
        assertEquals(expected, account.getBalance());
    }

    @Test
    public void printStatements() throws ParseException {
        String expected = "date || credit || debit || balance\n"
                            + "14/01/2012 || 1000.00 || || 1000.00\n";
        account.print();
        assertEquals(expected, outputStream.toString());
    }
}