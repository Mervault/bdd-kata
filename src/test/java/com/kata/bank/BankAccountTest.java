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

//TODO enlever les get balance inutiles
//TODO ajouter un test BDD (jbehave ou Cucumber)
public class BankAccountTest {
    private static final Logger LOGGER = LogManager.getLogger(BankAccountTest.class.getName());
    private final BankAccount account = new BankAccount();
    private final Double initialBalance = 1000.0;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private final String statementHeader = "date || credit || debit || balance\r\n";
    private final String initialStatement = "14/01/2012 || 1000,00 || || 1000,00\r\n";
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
    public void printStatements() throws ParseException {
        String expected = "date || credit || debit || balance\r\n"
                            + "14/01/2012 || 1000,00 || || 1000,00\r\n";
        account.print();
        assertEquals(expected, outputStream.toString());
    }

    @Test
    public void printStatementsAfterMoneyDepositMoney() throws ParseException {
        String stringDate = "14/01/2012";
        Date date = simpleDateFormat.parse(stringDate);
        Double amount = 1000.0;
        account.depositMoney(date, amount);
        account.print();
        Double expectedBalance = initialBalance + amount;
        String expectedStatement = stringDate + " || " + String.format("%.2f", amount) + " || || " + String.format("%.2f", expectedBalance) + "\r\n";
        String expectedStatementsList = statementHeader
                                    + initialStatement
                                    + expectedStatement;
        assertEquals(expectedStatementsList, outputStream.toString());
    }

    @Test
    public void printStatementsAfterMoneyWithdraw() throws ParseException {
        String stringDate = "14/01/2012";
        Date date = simpleDateFormat.parse(stringDate);
        Double amount = 600.0;
        account.withdrawMoney(date, amount);
        account.print();
        Double expectedBalance = initialBalance - amount;
        String expectedStatement = stringDate + " || || " + String.format("%.2f", amount) + " || " + String.format("%.2f", expectedBalance) + "\r\n";
        String expectedStatementsList = statementHeader
                                    + initialStatement
                                    + expectedStatement;
        assertEquals(expectedStatementsList, outputStream.toString());
    }
}