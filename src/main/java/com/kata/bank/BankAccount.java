package com.kata.bank;

import java.util.Date;

public class BankAccount {
    private Double balance = 0.0;

    public void depositMoney(Date date, Double amount){
        balance += amount; 
        statements.addDeposit(date, amount, balance);};
    public void withdrawMoney(Date date, Double amount){
        balance -= amount; 
        statements.addWithdraw(date, amount, balance);};

    public void print() {
        statements.print();
    }

    private AccountStatements statements = new AccountStatements();
}