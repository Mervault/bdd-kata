package com.kata.bank;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class AccountStatement {
    private static final SimpleDateFormat dateFormater = new SimpleDateFormat("dd/MM/yyyy");

    private final Date date;
    private final Double amount;
    private final Double balance;
    
    public AccountStatement(Date date, Double amount, Double balance) {
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    public void print() {
        System.out.println(dateFormater.format(this.date) + " || " + String.format("%.2f", this.amount) + " || || " + String.format("%.2f", this.balance));
    }
}