package edu.cursor.u21.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by alexandrmanikhin on 13.02.17.
 */

class Login {
    public void run() throws FileNotFoundException {
        Scanner scan = new Scanner (new File("the\\dir\\myFile.extension"));
        Scanner keyboard = new Scanner (System.in);
        String user = scan.nextLine();
        String pass = scan.nextLine();

        String inpUser = keyboard.nextLine();
        String inpPass = keyboard.nextLine();

        if (inpUser.equals(user) && inpPass.equals(pass)) {
            System.out.print("Welcome to the system" + user);
        } else {
            System.out.print("Oops");
        }
    }
}