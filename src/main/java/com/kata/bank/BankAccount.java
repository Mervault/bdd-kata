package com.kata.bank;

import java.util.Date;

public class BankAccount {
    public void depositMoney(Date date, Double amount){ statements.addDeposit(date, amount);};
    public void withdrawMoney(Double amount){statements.addWithdraw(amount);};
    //TODO remplacer Integer get... par un void print... si on peut capturer le print dans la classe de test
    public Double getBalance(){
        return statements.getLastBalance();
    }

    public void print() {
        statements.print();
    }

    private AccountStatements statements = new AccountStatements();
}