package edu.cursor.u21.bankSystem;

import edu.cursor.u21.util.Login;
import edu.cursor.u21.util.Registration;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

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
        while (true) {
            System.out.print("\n1.Login in system U21Bank.\n2.Register in system U21Bank.\n3.Exit.\nChoose option - >> ");
            log.info("start app");
            switch (getInt()) {
                case 1:
                    login.logIn();
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
