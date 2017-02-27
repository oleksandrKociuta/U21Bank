package edu.cursor.u21.users.Admin;

import edu.cursor.u21.users.bankClient.Accounts.Credit;
import edu.cursor.u21.users.bankClient.Accounts.Deposit;
import edu.cursor.u21.users.bankClient.Accounts.Saving;
import edu.cursor.u21.users.bankClient.Accounts.Transfer;
import edu.cursor.u21.users.bankClient.BankClient;

import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

class AdminMethods {
    private AdminMethods() {
        throw new IllegalStateException();
    }

    static void displayListOfUsers(HashMap<String, BankClient> listOfUsers) {
        try {
            System.out.println("ID\t\t\tName\t\t\tSurname");
            listOfUsers.forEach((k, v) -> System.out.printf(
                    "%s\t\t\t%s\t\t\t%s\n",
                    v.getId(), v.getName(), v.getSurname()));
        } catch (NullPointerException e) {
            System.out.println("No data to display");
        }
    }

    static void displayUsersPhoneNumbers(HashMap<String, BankClient> listOfUsers) {
        try {
            System.out.println("Name\t\t\tSurname\t\t\tPhone");
            listOfUsers.forEach((k, v) -> System.out.printf(
                    "%s\t\t\t%s\t\t\t%s\n",
                    v.getName(), v.getSurname(), v.getTelephoneNumber()));
        } catch (NullPointerException e) {
            System.out.println("No data to display");
        }
    }

    static void displayUsersDateOfBirth(HashMap<String, BankClient> listOfUsers) {
        try {
            System.out.println("Name\t\t\tSurname\t\t\tDate of Birth");
            listOfUsers.forEach((k, v) -> System.out.printf(
                    "%s\t\t\t%s\t\t\t%s\n",
                    v.getName(), v.getSurname(), v.getDateOfBirth()));
        } catch (NullPointerException e) {
            System.out.println("No data to display");
        }
    }

    static void filterByAge(int age, HashMap<String, BankClient> listOfUsers) {
        try {
            System.out.println("Name\t\t\tSurname\t\t\tAge");
            listOfUsers.values().forEach(v -> {
                if (v.getAge() == age) {
                    System.out.printf("%s\t\t\t%s\t\t\t%d\n",
                            v.getName(), v.getSurname(), v.getAge());
                }
            });
        } catch (NullPointerException e) {
            System.out.println("No data to display");
        }
    }

    static void printBankClientsBySurname(HashMap<String, BankClient> listOfUsers) {
        try {
            listOfUsers.values().stream()
                    .sorted(Comparator.comparing(BankClient::getSurname))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        } catch (NullPointerException e) {
            System.out.println("No data to display");
        }
    }

    static void displayUsersAccountsNumbers(HashMap<String, BankClient> listOfUsers) {
        try {
            System.out.println("ID \t\t\tName \tSurname \tAccounts");
            listOfUsers.values().forEach(v -> System.out.printf(
                    "%s\t%s\t%s\t%s\n",
                    v.getId(), v.getName(), v.getSurname(), v.getAccountHashMap()
                            .keySet()
                            .toString()
            ));
        } catch (NullPointerException e) {
            System.out.println("Not enough data: some accounts doesn't contain number id.");
        }
    }

    static void displayUsersDepositAccounts(HashMap<String, BankClient> listOfUsers) {
        try {
            listOfUsers.values().forEach(bankClient -> bankClient.getAccountHashMap().values().stream()
                    .filter(v -> v instanceof Deposit).sorted()
                    .forEach(z -> System.out.println(bankClient.toString() + "\t" + z.toString())));
        } catch (NullPointerException e) {
            System.out.println("Not enough data: some Deposit Accounts doesn't contain full information.");
        }
    }

    static void displayUsersCreditAccounts(HashMap<String, BankClient> listOfUsers) {
        try {
            listOfUsers.values().forEach(bankClient -> bankClient.getAccountHashMap().values().stream()
                    .filter(v -> v instanceof Credit)
                    .forEach(z -> System.out.println(bankClient.toString() + "\t" + z.toString())));
        } catch (NullPointerException e) {
            System.out.println("Not enough data: some Credit Accounts doesn't contain full information.");
        }
    }

    static void displayUsersTransferAccounts(HashMap<String, BankClient> listOfUsers) {
        try {
            listOfUsers.values().forEach(bankClient -> bankClient.getAccountHashMap().values().stream()
                    .filter(v -> v instanceof Transfer)
                    .forEach(z -> System.out.println(bankClient.toString() + "\t" + z.toString())));
        } catch (NullPointerException e) {
            System.out.println("Not enough data: some Transfer Accounts doesn't contain full information.");
        }
    }

    static void displayUsersSavingAccounts(HashMap<String, BankClient> listOfUsers) {
        try {
            listOfUsers.values().forEach(bankClient -> bankClient.getAccountHashMap().values().stream()
                    .filter(v -> v instanceof Saving)
                    .forEach(z -> System.out.println(bankClient.toString() + "\t" + z.toString())));
        } catch (NullPointerException e) {
            System.out.println("Not enough data: some Saving Accounts doesn't contain full information.");
        }
    }

    private static void displayBankClientAccounts(BankClient bankClient) {
        try {
            System.out.println(bankClient.getId() + "\t" + bankClient.toString());
            bankClient.getAccountHashMap().forEach((t, u) -> System.out.println("Account ID: " + t + "\t" + u.toString()));
        } catch (NullPointerException e) {
            System.out.println("No data to display");
        }
    }

    static void displayDetailUsersAccounts(HashMap<String, BankClient> listOfUsers) {
        try {
            listOfUsers.values().forEach(AdminMethods::displayBankClientAccounts);
        } catch (NullPointerException e) {
            System.out.println("Some Accounts doesn't contain full information.");
        }
    }
}