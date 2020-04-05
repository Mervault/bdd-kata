package com.kata.bank;

//import io.cucumber.core.gherkin.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;


import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

import io.cucumber.java.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class StepDefinitions {
    private final static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    private final BankAccount account = new BankAccount();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;

    @Before
    public void before(final Scenario scenario) {
        System.setProperty("line.separator", "\n");
        System.out.print("line.separator = " + System.lineSeparator());
        System.setOut(new PrintStream(outputStream));

    }

    @After
    public void after(final Scenario scenario) {
        System.setOut(originalOutput);
    }

    @Given("a client makes a deposit of {double} on {string}")
    public void a_client_makes_a_deposit_of_on(final Double amount, final String stringDate) throws ParseException {
        final Date date = simpleDateFormat.parse(stringDate);
        account.depositMoney(date, amount);
    }

    @Given("a deposit of {double} on {string}")
    public void a_deposit_of_on(final Double amount, final String stringDate) throws ParseException {
        final Date date = simpleDateFormat.parse(stringDate);
        account.depositMoney(date, amount);
    }

    @Given("a withdrawal of {double} on {string}")
    public void a_withdrawal_of_on(final Double amount, final String stringDate) throws ParseException {
        final Date date = simpleDateFormat.parse(stringDate);
        account.withdrawMoney(date, amount);
    }

    @When("she prints her bank statement")
    public void she_prints_her_bank_statement() {
        account.print();
    }

    @Then("she would see:")
    public void she_would_see(String expectedStatementsList) {
        expectedStatementsList = expectedStatementsList.replace("\n", System.lineSeparator());
            expectedStatementsList = expectedStatementsList + System.lineSeparator() ;
            assertEquals(expectedStatementsList, outputStream.toString());
    }
}
