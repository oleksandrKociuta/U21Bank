package edu.cursor.u21.bankSystem;

import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.WriteAndRead;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by o.kociuta on 07.02.2017.
 */
public class Main {
    public static void main(String[] args) {
        Menu mainMenu = new Menu();
        mainMenu.menu();
//        Map<String, BankClient> list = new HashMap<>();
//        BankClient b = new BankClient();
//        b.setLogin("Admin_Test");
//        b.setName("Admin_test");
//        b.setRole(Roles.ADMIN);
//        b.setPassword("Admin_Test");
//        b.setSeriesOfPassport("Admin_Test");
//        b.setSurname("Admin_Test");
//        b.setTelephoneNumber("Admit_Test");
//        list.put("Admin_Test", b);
//        WriteAndRead.writeBankFile(list);
// IF you want to add some administrators;

    }
}