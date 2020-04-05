package com.kata.bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AccountStatement {
    protected static final SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");

    protected final Date date;
    protected final Double amount;
    protected final Double balance;
    
    public AccountStatement(Date date, Double amount, Double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    abstract public void print() ;
}