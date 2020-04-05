package com.kata.bank;

import java.util.Date;

public class WithdrawStatement extends AccountStatement {

    public WithdrawStatement(Date date, Double amount, Double balance) {
        super(date, amount, balance);
    }

    @Override
    public void print() {
        System.out.println(dateFormater.format(this.date) + " || || " + String.format("%.2f", this.amount) + " || " + String.format("%.2f", this.balance));
    }

}