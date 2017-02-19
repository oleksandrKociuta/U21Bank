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
        System.out.println("ID\t\t\tName\t\t\tSurname");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t\t\t%s\t\t\t%s\n",
                v.getId(), v.getName(), v.getSurname()));
    }

    static void displayUsersPhoneNumbers(HashMap<String, BankClient> listOfUsers) {
        System.out.println("Name\t\t\tSurname\t\t\tPhone");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t\t\t%s\t\t\t%d\n",
                v.getName(), v.getSurname(), v.getTelephoneNumber()));
    }

    static void displayUsersDateOfBirth(HashMap<String, BankClient> listOfUsers) {
        System.out.println("Name\t\t\tSurname\t\t\tDate of Birth");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t\t\t%s\t\t\t%s\n",
                 v.getName(), v.getSurname(), v.getDateOfBirth()));
    }

    static void filterByAge(int age, HashMap<String, BankClient> listOfUsers) {
        System.out.println("Name\t\t\tSurname\t\t\tAge");
        listOfUsers.values().forEach(v -> {
            if (v.getAge() == age) {
                System.out.printf("%s\t\t\t%s\t\t\t%d\n",
                         v.getName(), v.getSurname(), v.getAge());
            }
        });
    }

    static void printBankClientsBySurname(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.values().stream()
                .sorted(Comparator.comparing(BankClient::getSurname))
                .collect(Collectors.toList())
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
        System.out.println("ID\t\t\tName\t\tSurname\t\t\tAccount");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t%s\t%s\t\t\n",
                v.getId(), v.getName(), v.getSurname()));
        listOfUsers.values().forEach(v -> v.getAccountHashMap().values().stream()
                .filter(a -> (a instanceof Deposit))
                .collect(Collectors.toList()).forEach(account -> System.out.println(account.toString())));
    }

    static void displayUsersCreditAccounts(HashMap<String, BankClient> listOfUsers) {
        System.out.println("ID\t\t\tName\t\tSurname\t\t\tAccount");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t%s\t%s\t\t\n",
                v.getId(), v.getName(), v.getSurname()));
        listOfUsers.values().forEach(v -> v.getAccountHashMap().values().stream()
                .filter(a -> (a instanceof Credit))
                .collect(Collectors.toList()).forEach(account -> System.out.println(account.toString())));
    }

    static void displayUserTransferAccount(HashMap<String, BankClient> listOfUsers) {
        System.out.println("ID\t\t\tName\t\tSurname\t\t\tAccount");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t%s\t%s\t\t\n",
                v.getId(), v.getName(), v.getSurname()));
        listOfUsers.values().forEach(v -> v.getAccountHashMap().values().stream()
                .filter(a -> (a instanceof Transfer))
                .collect(Collectors.toList()).forEach(account -> System.out.println(account.toString())));
    }

    static void displayUserSavingAccount(HashMap<String, BankClient> listOfUsers) {
        System.out.println("ID\t\t\tName\t\tSurname\t\t\tAccount");
        listOfUsers.forEach((k, v) -> System.out.printf(
                "%s\t%s\t%s\t\t\n",
                v.getId(), v.getName(), v.getSurname()));
        listOfUsers.values().forEach(v -> v.getAccountHashMap().values().stream()
                        .filter(a -> (a instanceof Saving))
                        .collect(Collectors.toList()).forEach(account -> System.out.println(account.toString())));
    }
}