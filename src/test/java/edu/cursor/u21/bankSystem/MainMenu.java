package edu.cursor.u21.bankSystem;

import edu.cursor.u21.Utils.Registration;
import lombok.NoArgsConstructor;
import org.apache.log4j.Logger;

import static edu.cursor.u21.Utils.Utility.getInt;
import static edu.cursor.u21.Utils.Utility.identifyUser;


/**
 * Created by Kermit The Frog on 13.02.2017.
 */
@NoArgsConstructor
public class MainMenu {
    public static Logger log = Logger.getLogger(MainMenu.class);
    public void menu() {
        while (true) {
            System.out.print("\n1.Login in system U21Bank.\n2.Register in system U21Bank.\n3.Exit.\nChoose option - >> ");
            log.info("start app");
            switch (getInt()) {
                case 1:
                    identifyUser().startSession();
                    break;
                case 2:
                    Registration.registration();
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
