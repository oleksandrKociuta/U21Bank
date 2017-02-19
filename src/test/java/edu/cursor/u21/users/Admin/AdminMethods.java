package edu.cursor.u21.users.Admin;

import edu.cursor.u21.users.BankClient.Accounts.Credit;
import edu.cursor.u21.users.BankClient.Accounts.Deposit;
import edu.cursor.u21.users.BankClient.Accounts.Saving;
import edu.cursor.u21.users.BankClient.Accounts.Transfer;
import edu.cursor.u21.users.BankClient.BankClient;

import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

class AdminMethods {
    private AdminMethods() {
        throw new IllegalStateException();
    }

    static void displayListOfUsers(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.forEach((k, v) -> System.out.printf(
                "ID%s\tName%s\tSurname%s\n",
                v.getId(), v.getName(), v.getSurname()));
    }

    static void displayUsersPhoneNumbers(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.forEach((k, v) -> System.out.printf(
                "ID%s\tName%s\tSurname%s\tPhone Number%d\n",
                v.getId(), v.getName(), v.getSurname(), v.getTelephoneNumber()));
    }

    static void displayUsersDateOfBirth(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.forEach((k, v) -> System.out.printf(
                "ID%s\tName%s\tSurname%s\tPhone Number%s\n",
                v.getId(), v.getName(), v.getSurname(), v.getDateOfBirth()));
    }

    static void filterByAge(int age, HashMap<String, BankClient> listOfUsers) {
        listOfUsers.values().forEach(v -> {
            if (v.getAge() == age) {
                System.out.printf("ID%s\tName%s\tSurname%s\tAge%d\n",
                        v.getId(), v.getName(), v.getSurname(), v.getAge());
            }
        });
    }

    static void printBankClientsBySurname(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.values().stream()
                .sorted(Comparator.comparing(BankClient::getSurname))
                .forEach(System.out::println);
    }

    static void displayUsersAccounts(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.values().forEach(v -> System.out.printf(
                "ID%s\tName%s\tSurname%s\tAccounts%s\n",
                v.getId(), v.getName(), v.getSurname(), v.getAccountHashMap()
                        .keySet()
                        .toString()
        ));
    }

    static void displayUsersDepositAccounts(HashMap<String, BankClient> listOfUsers) {
        System.out.println("ID\tName\tSurname\t\t\tAccount");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t%s\t%s\t%s\t\n",
                v.getId(), v.getName(), v.getSurname(), v.getAccountHashMap().values().stream()
                                                         .filter(a -> (a instanceof Deposit)).toString()));
    }

    static void displayUsersCreditAccounts(HashMap<String, BankClient> listOfUsers) {
        System.out.println("ID\tName\tSurname\t\t\tAccount");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t%s\t%s\t%s\t\n",
                v.getId(), v.getName(), v.getSurname(), v.getAccountHashMap().values().stream()
                                                         .filter(a -> (a instanceof Credit)).toString()));
    }

    static void displayUserTransferAccount(HashMap<String, BankClient> listOfUsers) {
        System.out.println("ID\tName\tSurnamet\t\t\tAccount");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t%s\t%s\t%s\t\n",
                v.getId(), v.getName(), v.getSurname(), v.getAccountHashMap().values().stream()
                        .filter(a -> (a instanceof Transfer)).toString()));
    }

    static void displayUserSavingAccount(HashMap<String, BankClient> listOfUsers) {
        System.out.println("ID\t\t\tName\t\t\tSurname\t\t\tAccount");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t%s\t%s\t\t\n",
                v.getId(), v.getName(), v.getSurname()));
        listOfUsers.values().forEach(v -> v.getAccountHashMap().values().stream()
                        .filter(a -> (a instanceof Saving))
                        .collect(Collectors.toList()).forEach(account -> System.out.println(account.toString())));
    }
}