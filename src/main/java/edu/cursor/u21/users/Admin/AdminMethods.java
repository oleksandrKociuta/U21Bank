package edu.cursor.u21.users.Admin;

import edu.cursor.u21.users.bankClient.Accounts.AccountType;
import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.UtilityScanner;
import lombok.NoArgsConstructor;

import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

@NoArgsConstructor
class AdminMethods implements AdminInterface{

    private static void displayBankClientAccounts(BankClient bankClient) {
        if (!(bankClient == null)) {
            System.out.println(bankClient.getId() + "\t" + bankClient.toString());
            bankClient.getAccountHashMap().forEach((t, u) -> System.out.println("AccountInterface ID: " + t + "\t" + u.toString()));
        } else {
            System.out.println("No data to display");
        }
    }

    public void displayListOfUsers(HashMap<String, BankClient> listOfUsers) {
        if (listOfUsers == null) {
            System.out.println("No data. List of users is empty");
        } else {
            System.out.println("ID\t\t\tName\t\t\tSurname");
            listOfUsers.forEach((k, v) -> System.out.printf(
                    "%s\t\t\t%s\t\t\t%s\n",
                    v.getId(), v.getName(), v.getSurname()));
        }
    }

    public void displayUsersPhoneNumbers(HashMap<String, BankClient> listOfUsers) {
        if (!listOfUsers.isEmpty()) {
            System.out.println("Name\t\t\tSurname\t\t\tPhone");
            listOfUsers.forEach((k, v) -> System.out.printf(
                    "%s\t\t\t%s\t\t\t%s\n",
                    v.getName(), v.getSurname(), v.getTelephoneNumber()));
        } else {
            System.out.println("No data to display");
        }
    }

    public void displayUsersDateOfBirth(HashMap<String, BankClient> listOfUsers) {
        if (!listOfUsers.isEmpty()) {
            System.out.println("Name\t\t\tSurname\t\t\tDate of Birth");
            listOfUsers.forEach((k, v) -> System.out.printf(
                    "%s\t\t\t%s\t\t\t%s\n",
                    v.getName(), v.getSurname(), v.getDateOfBirth()));
        } else {
            System.out.println("No data to display");
        }
    }

    public void filterByAge(int age, HashMap<String, BankClient> listOfUsers) {
        if (!listOfUsers.isEmpty()) {
            System.out.println("Name\t\t\tSurname\t\t\tAge");
            listOfUsers.values().forEach(v -> {
                if (v.getAge() == age) {
                    System.out.printf("%s\t\t\t%s\t\t\t%d\n",
                            v.getName(), v.getSurname(), v.getAge());
                }
            });
        } else {
            System.out.println("No data to display");
        }
    }

    public void printBankClientsBySurname(HashMap<String, BankClient> listOfUsers) {
        if (!listOfUsers.isEmpty()) {
            listOfUsers.values().stream()
                    .sorted(Comparator.comparing(BankClient::getSurname))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);
        } else {
            System.out.println("No data to display");
        }
    }

    public void displayUsersAccountNumbers(HashMap<String, BankClient> listOfUsers) {
        if (!listOfUsers.isEmpty()) {
            System.out.println("ID \t\t\tName \tSurname \tAccount");
            listOfUsers.values().forEach(v -> System.out.printf(
                    "%s\t%s\t%s\t%s\n",
                    v.getId(), v.getName(), v.getSurname(), v.getAccountHashMap()
                            .keySet()
                            .toString()
            ));
        } else {
            System.out.println("Not enough data");
        }
    }

    public void displayUsersAccounts(HashMap<String, BankClient> listOfUsers) {
        System.out.println("Enter type of Account: 0 - Credit, 1 - Deposit, 2 - Saving, 3 - Transfer");

        AccountType[] accountTypesArray = AccountType.values();
        int accountType = UtilityScanner.scanNumberFromZeroToThree();

        if (!listOfUsers.isEmpty()) {
            listOfUsers.values().forEach(bankClient -> bankClient.getAccountHashMap().values().stream()
                    .filter(v -> v.getAccountType() == accountTypesArray[accountType]).sorted()
                    .forEach(z -> System.out.println(bankClient.toString() + "\t" + z.toString())));
        } else {
            System.out.println("Not enough data: Account doesn't contains full information.");
        }
    }

    public void displayDetailUsersAccounts(HashMap<String, BankClient> listOfUsers) {
        if (!listOfUsers.isEmpty()) {
            System.out.println("------------------------------------------------");
            listOfUsers.values().forEach(AdminMethods::displayBankClientAccounts);
        } else {
            System.out.println("Some Account doesn't contain full information.");
        }
    }
}