package edu.cursor.u21.users.Admin;

import edu.cursor.u21.users.bankClient.BankClient;

import java.util.HashMap;

/**
 * Created by uiv on 2/9/17.
 */
interface AdminInterface {
    void displayListOfUsers(HashMap<String, BankClient> hashMap);

    void filterByAge(int age, HashMap<String, BankClient> hashMap);

    void displayUsersPhoneNumbers(HashMap<String, BankClient> listOfUsers);

    void displayUsersDateOfBirth(HashMap<String, BankClient> listOfUsers);

    void printBankClientsBySurname(HashMap<String, BankClient> listOfUsers);

    void displayUsersAccountNumbers(HashMap<String, BankClient> listOfUsers);

    void displayUsersAccounts(HashMap<String, BankClient> listOfUsers);

    void displayDetailUsersAccounts(HashMap<String, BankClient> listOfUsers);
}
