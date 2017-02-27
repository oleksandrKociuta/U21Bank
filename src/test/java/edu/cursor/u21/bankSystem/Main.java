package edu.cursor.u21.bankSystem;

import edu.cursor.u21.users.Admin.AdminMenu;
import edu.cursor.u21.util.MagicConstantsInterface;
import edu.cursor.u21.util.Read;

/**
 * Created by o.kociuta on 07.02.2017.
 */
public class Main {
    public static void main(String[] args) {
//        Menu mainMenu = new Menu();
//        mainMenu.menu();
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
        AdminMenu.adminMenu(Read.readFile(MagicConstantsInterface.USERS_FILE_PATH));
    }
}