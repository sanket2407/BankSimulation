package com.sanket.gradlePractice.bankSimulation;

public class UserThread implements Runnable {

    public enum Action {
        WITHDRAW, DEPOSIT
    }

    //Account holder name
    private long accountNumber;
    private Action action;
    private long amount;
    BOFA bofa = new BOFA();

    public long getAccountNumber() {
        return accountNumber;
    }

    public Action getAction() {
        return action;
    }

    public long getAmount() {
        return amount;
    }

    public UserThread(long accountNumber){
        this.accountNumber = accountNumber;
    }

    public void setAction(Action action, long amount) {
        this.action = action;
        this.amount = amount;
    }


    @Override
    public void run() {
        switch (action){
            case WITHDRAW:
                System.out.println("Going to perform " + getAction() + " $" + getAmount() + " for : " + getAccountNumber());

                // TODO: get bank name from enum

                Account withdrawAccount = bofa.getAccountFromAccountNumber(getAccountNumber());
                if (withdrawAccount != null) {
                    withdrawAccount.withdraw(amount);
                }

                break;

            case DEPOSIT:
                System.out.println("Going to perform " + getAction() + " $" + getAmount() + " for : " + getAccountNumber());
                Account depositAccount = bofa.getAccountFromAccountNumber(getAccountNumber());
                if (depositAccount != null) {
                    depositAccount.withdraw(amount);
                }

                break;

        }
    }

}
