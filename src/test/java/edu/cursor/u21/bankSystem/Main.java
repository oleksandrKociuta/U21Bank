package edu.cursor.u21.bankSystem;

import edu.cursor.u21.users.Admin.AdminMenu;
import edu.cursor.u21.users.BankClient.Accounts.Account;
import edu.cursor.u21.users.BankClient.Accounts.Saving;
import edu.cursor.u21.users.BankClient.BankClient;
import edu.cursor.u21.util.MagicConstantsInterface;
import edu.cursor.u21.util.Read;
import edu.cursor.u21.util.Write;

import java.util.HashMap;

/**
 * Created by o.kociuta on 07.02.2017.
 */
public class Main {
    public static void main(String[] args) {
//        MainMenu mainMenu = new MainMenu();
//        mainMenu.menu();
        BankClient user1 = new BankClient("user1", "sdds", "sss", "Petro", "Ivanov", 25, "jfjfjfj", "jfjjjfjf", 2626026);
        BankClient user2 = new BankClient("user2", "sddddds", "ffdfsss", "Stepan", "Romaniv", 25, "jfjfjfffj", "jfjddjjfjf", 2626026);
        HashMap<String, BankClient> userMap = new HashMap<>();
        Account saving = new Saving();
        Account saving2 = new Saving();
        Account saving3 = new Saving();

        user1.getAccountHashMap().put(1, saving);
        user1.getAccountHashMap().put(02, saving2);
        user1.getAccountHashMap().put(03, saving3);
        user2.getAccountHashMap().put(1, saving);
        user2.getAccountHashMap().put(02, saving2);
        user2.getAccountHashMap().put(03, saving3);

        userMap.put("id100255", user1);
        userMap.put("id203255", user2);
        Write.writeFile(userMap);
        HashMap<String, BankClient> hashMap = Read.readFile(MagicConstantsInterface.usersFilePath);
        AdminMenu.adminMenu(hashMap);
//        hashMap.values().forEach(System.out::println);
//        AccountMenu.accountMenu(user1);
    }
}