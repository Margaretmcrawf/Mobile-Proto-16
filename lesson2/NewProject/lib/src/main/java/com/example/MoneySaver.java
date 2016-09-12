package com.example;

/**
 * Created by margaret on 9/11/16.
 */
public class MoneySaver {
    private long myMoney;
    private Account myAccount;
    private String name;

    public MoneySaver(String name, long money) {
        this.name = name;
        myMoney = money;
    }

    public String getName() {
        return name + " My balance is " + myMoney;
    }

    public Account getMyAccount() {
        return myAccount;
    }

    public String toString() {
        return name + ", ";
    }

    public void deposit(long amount) {
        myAccount.deposit(amount);
    }

    public void withdraw(long amount) {
        CheckingAccount myCheckingAccount = (CheckingAccount) myAccount;
        myCheckingAccount.withdraw(amount);
    }

    public void signUpForChecking(long amount) {
        myAccount = new CheckingAccount(amount, this);
        myMoney -= amount;
    }

    public static void main(String[] args) {

    }
}
