package com.kata.bank;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
public class AccountStatements {
    private final List<AccountStatement> statements = new ArrayList<AccountStatement>();

    public Double getLastBalance() {
        Double balance = 0.0;
        final Integer nbOfStatements = statements.size();
        if (nbOfStatements > 0) {
            final AccountStatement lastStatement = statements.get(nbOfStatements - 1);
            balance = lastStatement.getBalance();
        }
        return balance;
    }

    public void addDeposit(final Date date, final Double amount) {
        final AccountStatement statement = new DepositStatement(date, amount, getLastBalance() + amount);
        statements.add(statement);
    }

    public void addWithdraw(final Date date, final Double amount) {
        final AccountStatement statement = new WithdrawStatement(date, amount, getLastBalance() - amount);
        statements.add(statement);
    }

    public void print() {
        System.out.println("date || credit || debit || balance");
        for (final AccountStatement statement : statements) {
            statement.print();
        }
    }
}