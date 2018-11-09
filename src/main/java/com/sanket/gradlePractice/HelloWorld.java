package com.sanket.gradlePractice;

import com.sanket.gradlePractice.bankSimulation.Bank;
import com.sanket.gradlePractice.bankSimulation.RegisterAccountService;
import com.sanket.gradlePractice.bankSimulation.UserThread;

import javax.swing.*;
import java.util.*;

public class HelloWorld {

    private static String greeting = "Hello world from Gradle project!";

    public static void main(String[] args) {

//        String greeting = getGreeting();
//        System.out.println(greeting);
//
//        String[] accountHolderNames = {"Sanket", "Harsh", "Chinmay", "Parth", "Rahil"};
//        List<Long> accountNumbers = new ArrayList<Long>();
//
//        for (String accountHolderName: accountHolderNames){
//            // create BOFA account for all given users.
//            RegisterAccountService registerAccountService = new RegisterAccountService(Bank.BankName.BOFA, accountHolderName);
//            accountNumbers.add(registerAccountService.registerSavingsAccount());
//        }
//
//        UserThread userThread1 = null;
//        UserThread userThread2 = null;
//
//        for(Long accountNumber: accountNumbers){
//
//            userThread1 = new UserThread(accountNumber);
//            userThread1.setAction(UserThread.Action.DEPOSIT, 10);
//            new Thread(userThread1).start();
//
//            userThread2 = new UserThread(accountNumber);
//            userThread2.setAction(UserThread.Action.WITHDRAW, 10);
//            new Thread(userThread2).start();
//        }

        doStuff();
    }

    public static String getGreeting(){
        return greeting;
    }

    public static void doStuff(){

        String str1 = "1234.10.0";
        System.out.println(str1.matches("[-+]?[0-9]*\\.?[0-9]+"));
        String str2 = "1,234.10";
        System.out.println(str2.matches("[-+]?[0-9]*\\.?[0-9]+"));
        String str3 = "12,,34.10";
        System.out.println(str3.matches("[-+]?[0-9]*\\.?[0-9]+"));
        String str4 = ".10";
        System.out.println(str4.matches("[-+]?[0-9]*\\.?[0-9]+"));
        String str5 = "1234.10,00";
        System.out.println(str5.matches("[-+]?[0-9]*\\.?[0-9]+"));
        String str6 = "1234.100000000000";
        System.out.println(str6.matches("[-+]?[0-9]*\\.?[0-9]+"));


    }
}
