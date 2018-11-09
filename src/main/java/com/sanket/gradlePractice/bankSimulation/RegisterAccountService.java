package com.sanket.gradlePractice.bankSimulation;

public class RegisterAccountService {

    private Bank.BankName bankName;
    String accountHolderName;

    public RegisterAccountService(Bank.BankName bankName, String accountHolderName){
        this.bankName = bankName;
        this.accountHolderName = accountHolderName;
    }

    public long registerSavingsAccount(){

        if (bankName == Bank.BankName.BOFA){
            return new BOFA().createSavingsAccount(accountHolderName);
        }
        return 0L;
    }

}
