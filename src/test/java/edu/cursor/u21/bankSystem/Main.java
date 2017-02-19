package edu.cursor.u21.bankSystem;

import edu.cursor.u21.util.MagicConstantsInterface;
import edu.cursor.u21.util.Read;
import edu.cursor.u21.util.Write;
import edu.cursor.u21.users.Admin.AdminMenu;
import edu.cursor.u21.users.BankClient.Accounts.Account;
import edu.cursor.u21.users.BankClient.Accounts.Saving;
import edu.cursor.u21.users.BankClient.BankClient;

import java.math.BigDecimal;
import java.util.HashMap;

import static edu.cursor.u21.users.BankClient.Accounts.Currency.EUR;
import static edu.cursor.u21.users.BankClient.Accounts.Currency.UAH;
import static edu.cursor.u21.users.BankClient.Accounts.Currency.USD;

/**
 * Created by o.kociuta on 07.02.2017.
 */
public class Main {
    public static void main(String[] args) {
//        MainMenu mainMenu = new MainMenu();
//        mainMenu.menu();
        BankClient user1 = new BankClient("user1", "sdds", "sss", "jfjf", "kfffld", 25, "jfjfjfj", "jfjjjfjf", 2626026);
        BankClient user2 = new BankClient("user2", "sddddds", "ffdfsss", "jfjgggf", "kffggfld", 25, "jfjfjfffj", "jfjddjjfjf", 2626026);
        HashMap<String, BankClient> userMap = new HashMap<>();
        Account saving = new Saving(BigDecimal.valueOf(1000000), UAH);
        Account saving2 = new Saving(BigDecimal.valueOf(1000050), EUR);
        Account saving3 = new Saving(BigDecimal.valueOf(1000010), USD);

        user1.getAccountHashMap().put("01", saving);
        user1.getAccountHashMap().put("02", saving);
        user1.getAccountHashMap().put("03", saving);

        userMap.put("id100255", user1);
        userMap.put("id203255", user2);
        Write.writeFile(userMap);
        HashMap<String, BankClient> hashMap = Read.readFile(MagicConstantsInterface.usersFilePath);
        AdminMenu.adminMenu(hashMap);
    }
}