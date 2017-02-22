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

    static void displayUsersAccountsNumbers(HashMap<String, BankClient> listOfUsers) {
        System.out.println("ID \t\t\tName \tSurname \tAccounts");
        listOfUsers.values().forEach(v -> System.out.printf(
                "%s\t%s\t%s\t%s\n",
                v.getId(), v.getName(), v.getSurname(), v.getAccountHashMap()
                        .keySet()
                        .toString()
        ));
    }

    static void displayUsersDepositAccounts(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.values().forEach(bankClient -> bankClient.getAccountHashMap().values().stream()
                .filter(v -> v instanceof Deposit).sorted()
                .forEach(z -> System.out.println(bankClient.toString() + "\t" + z.toString())));
    }

    static void displayUsersCreditAccounts(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.values().forEach(bankClient -> bankClient.getAccountHashMap().values().stream()
                .filter(v -> v instanceof Credit)
                .forEach(z -> System.out.println(bankClient.toString() + "\t" + z.toString())));
    }

    static void displayUsersTransferAccounts(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.values().forEach(bankClient -> bankClient.getAccountHashMap().values().stream()
                .filter(v -> v instanceof Transfer)
                .forEach(z -> System.out.println(bankClient.toString() + "\t" + z.toString())));
    }

    static void displayUsersSavingAccounts(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.values().forEach(bankClient -> bankClient.getAccountHashMap().values().stream()
                .filter(v -> v instanceof Saving)
                .forEach(z -> System.out.println(bankClient.toString() + "\t" + z.toString())));
    }

    private static void displayBankClientAccounts(BankClient bankClient) {
        System.out.println(bankClient.getId() + "\t" + bankClient.toString());
        bankClient.getAccountHashMap().forEach((t, u) -> System.out.println("Account ID: " + t.toString() + "\t" + u.toString()));
    }

    static void displayDetailUsersAccounts(HashMap<String, BankClient> listOfUsers) {
        listOfUsers.values().forEach(AdminMethods::displayBankClientAccounts);
    }
}