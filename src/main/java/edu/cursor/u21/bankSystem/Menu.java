package edu.cursor.u21.bankSystem;

import edu.cursor.u21.users.Admin.AdminMenu;
import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.bankClient.Accounts.AccountMenu;
import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Login;
import edu.cursor.u21.util.Registration;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import java.util.HashMap;

import static edu.cursor.u21.util.Utility.getInt;


/**
 * Created by Kermit The Frog on 13.02.2017.
 */
@NoArgsConstructor
public class Menu {
    private Login login = new Login();
    private Registration registration = new Registration();
    private static Logger log = Logger.getLogger(Menu.class);

    public void menu() {
        while (true) {
            System.out.print("\n1.Login in system U21Bank.\n2.Register in system U21Bank.\n3.Exit.\nChoose option - >> ");
            log.info("start app");
            switch (getInt()) {
                case 1:
                    BankClient bankClient = login.logIn();
                    if (bankClient.getRole().equals(Roles.ADMIN)) {
                        AdminMenu.adminMenu((HashMap<String, BankClient>) login.getList());
                    } else {
                        AccountMenu.accountMenu(bankClient);
                    }
                    break;
                case 2:
                    registration.registration();
                    break;
                case 3:
                    log.info("exit");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Bad input!! Repeat !!\n");

            }
        }
    }
}
