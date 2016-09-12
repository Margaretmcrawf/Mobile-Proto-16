package com.example;

/**
 * Created by margaret on 9/11/16.
 */
public class CheckingAccount extends Account{

    public CheckingAccount(long amnt, MoneySaver ownr) {
        super(amnt, ownr);
    }
    public void withdraw(long cashmoney) {
        long amnt = getAmount();
        setAmount(amnt - cashmoney);
    }
}