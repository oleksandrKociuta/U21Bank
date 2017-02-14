package edu.cursor.u21.users.Admin;

import edu.cursor.u21.users.BankClient.BankClient;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

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
        listOfUsers.forEach((String k, BankClient v) -> {
            if (v.getAge() == age) {
                System.out.printf("ID%s\tName%s\tSurname%s\tAge%d\n",
                        v.getId(), v.getName(), v.getSurname(), v.getAge());
            }
        });
    }

    static void sortBySurname(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(v -> System.out.println(v.getValue().getSurname()));
    }

    static void displayUsersAccounts(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.forEach((k, v) -> System.out.printf(
                "ID%s\tName%s\tSurname%s\tPhone Number%s\n",
                v.getId(), v.getName(), v.getSurname(), v.getAccount()));
    }

    static void displayUsersDepositAccounts(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.forEach((k, v) -> System.out.printf(
                "ID%s\tName%s\tSurname%s\tPhone Number%s\n",
                v.getId(), v.getName(), v.getSurname(), v.getDepositAccount()));
    }

    static void displayUsersCreditAccounts(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.forEach((k, v) -> System.out.printf(
                "ID%s\tName%s\tSurname%s\tPhone Number%s\n",
                v.getId(), v.getName(), v.getSurname(), v.getCreditAccount()));
    }

    static void displayUserTransferAccount(String userId, HashMap<String, BankClient> listOfUsers) {
        listOfUsers.forEach((String k, BankClient v) -> {
            if (v.getId().equals(userId)) {
                System.out.printf("ID%s\tName%s\tSurname%s\tAge%d\n",
                        v.getId(), v.getName(), v.getSurname(), v.getTransferAccount());
            }
        });
    }
}
