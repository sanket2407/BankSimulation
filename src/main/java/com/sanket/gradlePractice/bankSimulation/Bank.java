package com.sanket.gradlePractice.bankSimulation;
import java.util.List;

public interface Bank {

    enum BankName{
        BOFA, CHASE
    }
    public String getName();
    public String getBankAddress();
    public String getBankCEOName();
    public List<Account.AccountType> getAllAccountTypes();
    public boolean removeAccount(Account account);

}
