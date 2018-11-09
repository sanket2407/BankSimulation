package com.sanket.gradlePractice.bankSimulation;

import java.util.Random;

public class SavingsAccount implements Account {

    private long accountNumber;
    private String accountHolderName;
    private AccountType accountType;
    private long accountBalance;

    //TODO: account interest should depend on repo rate set by Reserve Bank.
    private static final float REPO_RATE = 1.0F;
    private static final float accountInterest = REPO_RATE + 0.5F;

    private static final AccountType ACCOUNT_TYPE = AccountType.SAVINGS;
    private static long count = 1000000L;

    public SavingsAccount(String accountHolderName){
        setAccountNumber(createRandomAccountNumber());
        setAccountHolderName(accountHolderName);
        setAccountType(ACCOUNT_TYPE);
        setAccountBalance(1000L);
    }

    private long createRandomAccountNumber(){
        //TODO: write some good logic to generate unique random number
        count = count + 1;
        return count;

    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setAccountBalance(long accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public long getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String getAccountHolderName() {
        return accountHolderName;
    }

    @Override
    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public long getAccountBalance() {
        return accountBalance;
    }

    @Override
    public float getAccountInterest() {
        return accountInterest;
    }

    @Override
    public long deposit(long amount) {

        if(amount < 0){
            return -1;
        }

        synchronized (this) {
            setAccountBalance(getAccountBalance() + amount);
            System.out.println(getAccountBalance());
            return this.getAccountBalance();
        }
    }

    @Override
    public long withdraw(long amount) {

        if(amount < 0){
            return -1;
        }

        // check for current balance and verify that it has enough balance to withdraw amount
        synchronized (this) {

            printThreadTrace("started");

            long accountBalance = getAccountBalance();
            System.out.println("performing deduction on amount: " + accountBalance);
            System.out.println("deduction amount: " + amount);
            long deductedBalance = accountBalance - amount;
            if ( deductedBalance > 0){
                setAccountBalance(deductedBalance);

                printThreadTrace("completed");
                System.out.println(getAccountBalance());
                return getAccountBalance();
            }

            printThreadTrace("completed");
            return -1;
        }
    }

    private void printThreadTrace(String action){
        if (action == "started"){
            System.out.println("<<<" + Thread.currentThread().getName() + " : " + action + "...");
        }
        if (action == "completed"){
            System.out.println( Thread.currentThread().getName() + " : " + action + ">>>");
        }
    }
}
