package com.kata.bank;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
public class AccountStatements {
    private final List<AccountStatement> statements = new ArrayList<AccountStatement>();

    public void addDeposit(final Date date, final Double amount, final Double balance) {
        final AccountStatement statement = new DepositStatement(date, amount, balance);
        statements.add(0, statement);
    }

    public void addWithdraw(final Date date, final Double amount, final Double balance) {
        final AccountStatement statement = new WithdrawStatement(date, amount, balance);
        statements.add(0, statement);
    }

    public void print() {
        System.out.println("date || credit || debit || balance");
        for (final AccountStatement statement : statements) {
            statement.print();
        }
    }
}