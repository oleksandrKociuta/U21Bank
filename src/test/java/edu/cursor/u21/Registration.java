package edu.cursor.u21;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Sabat on 12.02.2017.
 */
public class Registration {

    public void registration() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String Name = sc.nextLine();
        System.out.println("Enter your surname");
        String Surname = sc.nextLine();
        System.out.println("Enter your age");
        int Age = sc.nextInt();
        if (Age < 18) {
            System.out.println("You minors");
            System.exit(Age);
        }
        System.out.println("Enter your telephone number");
        String TelephoneNumber = sc.nextLine();
        System.out.println("Enter your date of birth");
        String DateOfBirth = sc.nextLine();
        System.out.println("Enter your series of passport");
        String SeriesOfPassport = sc.nextLine();
        System.out.println("Enter your username");
        String Username = sc.nextLine();
        System.out.println("Enter your password");
        int Password = sc.nextInt();
        File myFile = new File("C://User.md");
        try {
            FileWriter fileWriter = new FileWriter(myFile,false);
            fileWriter.write("Your name:" + Name + "\n");
            fileWriter.write("Your surname:" + Surname + "\n");
            fileWriter.write("Your age:" + Age + "\n");
            fileWriter.write("Your telephone nuber:" + TelephoneNumber + "\n");
            fileWriter.write("Your date of birth:" + DateOfBirth + "\n");
            fileWriter.write("Your series of passport:" + SeriesOfPassport + "\n");
            fileWriter.write("Your username:" + Username + "\n");
            fileWriter.write("Your password:" + Password);
            fileWriter.close();
//            boolean createNewFile("C://user.md");

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}