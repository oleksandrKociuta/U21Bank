package edu.cursor.u21.bankSystem;

import edu.cursor.u21.users.Admin.AdminMenu;
import edu.cursor.u21.users.Roles;
import edu.cursor.u21.users.bankClient.Accounts.AccountMenu;
import edu.cursor.u21.users.bankClient.BankClient;
import edu.cursor.u21.util.Login;
import edu.cursor.u21.util.Registration;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import java.sql.SQLException;

import static edu.cursor.u21.util.Utility.getInt;


/**
 * Created by Kermit The Frog on 13.02.2017.
 */
@NoArgsConstructor
public class Menu {
    private static Logger log = Logger.getLogger(Menu.class);
    private Login login = new Login();
    private Registration registration = new Registration();

    public void menu() {
        log.info("start app");
        while (true) {
            System.out.print("\n1.Sign in system U21Bank.\n2.Sign up system U21Bank.\n3.Exit.\nChoose option - >> ");
            switch (getInt()) {
                case 1:
                    BankClient bankClient = null;
                    try {
                        bankClient = login.logIn();
                    } catch (SQLException e) {
                        System.out.println("Can't log in User !!");
                        e.printStackTrace();
                    }
                    assert bankClient != null;
                    if (bankClient.getRole().equals(Roles.ADMIN)) {
                        new AdminMenu().adminMenu();
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
