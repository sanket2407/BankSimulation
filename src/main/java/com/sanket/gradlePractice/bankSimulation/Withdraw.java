package com.sanket.gradlePractice.bankSimulation;

public class Withdraw implements Runnable {

    private static Account account;
    private long amount;

    public Withdraw(Account account, long amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void run() {
        System.out.println("balance: " + account.withdraw(amount));
    }
}
