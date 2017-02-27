package edu.cursor.u21.bankSystem;

import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Utility;
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

    }
}