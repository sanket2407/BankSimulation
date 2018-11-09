package com.sanket.gradlePractice.bankSimulation;

import java.util.List;
import java.util.Map;

public class BOFA implements Bank {

    private final String BANK_NAME = "BANK OF AMERICA";
    private String bankAddress = "Somewhere in USA";
    private String bankCEOName = "Bob";
    private Map<Long,Account> accounts;
    private List<Account.AccountType> accountTypes;

    public BOFA(){
        setAccountTypes();
    }

    private void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    private void setBankCEONameName(String bankCEOName) {
        this.bankCEOName = bankCEOName;
    }

    @Override
    public String getName() {
        return BANK_NAME;
    }

    @Override
    public String getBankAddress() {
        return bankAddress;
    }

    @Override
    public String getBankCEOName() {
        return bankCEOName;
    }

    private void setAccountTypes() {
        this.accountTypes = accountTypes;
    }

    @Override
    public List<Account.AccountType> getAllAccountTypes() {
        accountTypes.add(Account.AccountType.SAVINGS);
        accountTypes.add(Account.AccountType.CHECKING);
        return accountTypes;
    }

    private long addAccount(Account account){

        Long accountNumber = account.getAccountNumber();

        // check if account already exists,
        // TODO: return exception if already exists
        if (accounts != null && !accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, account);
            return accountNumber;
        }

        return -1;
    }

    @Override
    public boolean removeAccount(Account account) {

        Long accountNumber = account.getAccountNumber();

        // check if account already exists,
        // TODO: return exception if not exist
        synchronized (this) {
            if (accounts != null && accounts.containsKey(accountNumber)) {
                accounts.remove(accountNumber);
                return true;
            }
        }
        return false;
    }

    public long createSavingsAccount(String accountHolderName){

        synchronized (this) {
            Account savingsAccount = new SavingsAccount(accountHolderName);
            // check if Savings account for given account holder name is already exists.
            // TODO: go for better approach to handle this case
            if (accounts != null) {
                for (Long accountNumber : accounts.keySet()) {
                    Account account = accounts.get(accountNumber);
                    if (account.getAccountHolderName() == accountHolderName && account.getAccountType() == Account.AccountType.SAVINGS) {
                        return -1;
                    }
                }
            }

            // add savings account
            addAccount(savingsAccount);
            return savingsAccount.getAccountNumber();
        }
    }

    public Account getAccountFromAccountNumber(long accountNumber){
        Account account = null;
        if (accounts != null){
            return accounts.get(accountNumber);
        }
        return account;
    }

    public Map<Long, Account> getAccounts() {
        return accounts;
    }

}
