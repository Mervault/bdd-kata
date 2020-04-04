package com.kata.bank;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import com.kata.bank.AccountStatement;

public class AccountStatements {
    private List<AccountStatement> statements = new ArrayList<AccountStatement>();

    public Double getLastBalance() {
        Double balance = 0.0;
        Integer nbOfStatements = statements.size();
        if(nbOfStatements > 0){
            AccountStatement lastStatement = statements.get(nbOfStatements-1);
            balance = lastStatement.getBalance();
        }
        return balance;
    }

    public void addDeposit(Date date, Double amount){
        AccountStatement statement = new AccountStatement(date, amount, getLastBalance()+amount);
        statements.add(statement);
    }
    public void addWithdraw(Double amount){
        Date date = new Date();
        AccountStatement statement = new AccountStatement(date, amount, getLastBalance()-amount);
        statements.add(statement);
    }

    public void print() {
        System.out.println("date || credit || debit || balance");
        for (AccountStatement statement: statements) {
            statement.print();
        }
    }
}