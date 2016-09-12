package com.example;

public class HelloWorld {
    public static void main(String  [] args) {
        MoneySaver jim = new MoneySaver("Jim", 100);
        jim.signUpForChecking(30);
        CheckingAccount acc = (CheckingAccount) jim.getMyAccount();
        System.out.println(jim);
        System.out.println(acc);
        jim.deposit(40);
        System.out.println(jim);
        jim.withdraw(60);
        System.out.println(jim);
        System.out.println(acc);
    }
}

