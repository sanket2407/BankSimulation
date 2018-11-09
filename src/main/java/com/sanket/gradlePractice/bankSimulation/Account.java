package com.sanket.gradlePractice.bankSimulation;

public interface Account {

    enum AccountType {
        SAVINGS, CHECKING, DEMATE
    }

    public long getAccountNumber();
    public String getAccountHolderName();
    public AccountType getAccountType();
    public long getAccountBalance();
    public float getAccountInterest();

    public long deposit(long amount);
    public long withdraw(long amount);

}
