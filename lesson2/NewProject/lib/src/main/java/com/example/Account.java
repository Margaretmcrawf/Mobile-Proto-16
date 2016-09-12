package com.example;

/**
 * Created by margaret on 9/11/16.
 */
public abstract class Account {
    private long amount;
    private MoneySaver owner;

    public Account(long amnt, MoneySaver ownr){
        amount = amnt;
        owner = ownr;
    }
    public String toString() {
        return "Account Balance: $" + amount + " Owner: " + owner;
    }

    public void setAmount(long amnt) {
        amount = amnt;
    }

    public long getAmount() {
        return amount;
    }

    public void deposit(long amnt) {
        amount += amnt;
    }

    public static Account largerAccount(Account acc1, Account acc2) {
        if (acc1.getAmount() > acc2.getAmount()) {
            return acc1;
        }
        return acc2; //not sure how to deal with equality with return type stuff...
    }
}
