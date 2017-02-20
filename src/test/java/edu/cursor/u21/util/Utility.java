package edu.cursor.u21.util;

import edu.cursor.u21.users.Admin.Admin;
import edu.cursor.u21.users.BankClient.BankClient;
import edu.cursor.u21.users.User;
import org.apache.log4j.Logger;

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Саша on 09.02.2017.
 */
public final class Utility implements MagicConstantsInterface {

    private Utility() {
        throw new IllegalStateException();
    }

    private static Logger log = Logger.getLogger(Utility.class);
    public static Scanner sc = new Scanner(System.in);
    public static Random random = new Random();

    public static String getPassword() {

        String password = getStringForPassword();
        String salt = "Random$SaltValue#WithSpecialCharacters12@$@4&#%^$*";
        password = password + salt;
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            log.error("Unexpected error", e);
        }
        messageDigest.reset();
        messageDigest.update(password.getBytes());
        byte[] digest = messageDigest.digest();
        BigInteger bigInt1 = new BigInteger(1, digest);
        String hashPassword = bigInt1.toString(hashByte);
        while (hashPassword.length() < hexadecimalNumber) {
            hashPassword = "0" + hashPassword;
        }
        return hashPassword;
    }

    private static String getStringForPassword() {
        String getPassword = sc.nextLine();
        while (getPassword.length() < minLengthPassword || maxLengthPassword < getPassword.length()) {
            System.out.println("Your password must be 5-15 characters.\n" +
                    "Try again:");
            getPassword = sc.nextLine();
        }
        return getPassword;
    }

    private static boolean checkForUniqueness(String login) {
        File file = new File(login + fileFormat);
        return file.exists();
    }

//    public static void passportCheck() {
//        String seriesOfPassport = sc.nextLine();
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            boolean check = false;
//            boolean check1 = false;
//            String current;
//            if (seriesOfPassport.matches(passportReg)) {
//                check = true;
//            } else {
//                System.out.println("Wrong passport input!! Repeat!");
//            }
//            if (check == true) {
//                while ((current = br.readLine()) != null) {
//                    if (current.equals(seriesOfPassport)) {
//                        System.out.println("The user of with such  data already exist.Please check your data!!!");
//                        System.out.println("Enter again data:");
//                        passportCheck();
//                        check1 = true;
//                    }
//                }
//            }
//            if (!check & check1 == false) {
//                passportCheck();
//            }
//        } catch (Exception e) {
//            log.error("An error in the input data", e);
//        }
//    }

//    public static void loginCheck()  {
//        String login = sc.nextLine();
//        try{
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
//        String current1;
//        while ((current1 = bufferedReader.readLine()) != null) {
//            if (current1.equals(login)) {
//                System.out.println("Login is already used !!! Repeat !");
//                System.out.println("Think of other login:");
//                loginCheck();
//            }
//        }
//    } catch (Exception e) {
//            log.error("An error in the input data", e);
//        }
//    }


    public static User identifyUser() {
        while (true) {
            System.out.print("Enter User Login - > ");
            String login = sc.nextLine();
            System.out.print("Enter User Password - > ");
            String password = getPassword();
            if (!Utility.checkForUniqueness(login)) {
                System.out.println("Bad User Data !!! ");
                continue;
            }
            try (FileInputStream fileInput = new FileInputStream(login + fileFormat)) {
                ObjectInputStream objectInput = new ObjectInputStream(fileInput);
                User user = (User) objectInput.readObject();
                if (user.getClass().getSimpleName().contains(adminClass)) {
                    Admin admin = (Admin) user;
                    if (admin.getPassword().equals(password)) {
                        log.info("log as admin: " + login);
                        return admin;
                    }
                } else if (user.getClass().getSimpleName().contains(bankClientClass)) {
                    BankClient bankClient = (BankClient) user;
                    if (bankClient.getPassword().equals(password)) {
                        log.info("log as user: " + login);
                        return bankClient;
                    }
                }
                objectInput.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Bad User's Login or Password !! Repeat! ");
        }
    }

    public static int getInt() {
        while (true) {
            String str = sc.nextLine();
            if ((str.matches("\\d+"))) {
                return Integer.parseInt(str);
            }
            System.out.println("Wrong input! Repeat!");
        }
    }
// ---- alex manikhin login implementation -----
//    public void run() throws FileNotFoundException {
//        String login = null;
//        Scanner scan = new Scanner(new File(login + fileFormat));
//        Scanner keyboard = new Scanner(System.in);
//        login = scan.nextLine();
//        String password = scan.nextLine();
//
//        System.out.println("login:");
//        String inpUser = keyboard.nextLine();
//
//        System.out.println("password:");
//        String inpPass = keyboard.nextLine();
//
//        if (inpUser.equals(login) && inpPass.equals(password)) {
//            System.out.print("Welcome to the system" + login);
//        } else {
//            System.out.print("Oops");
//        }
//    }

    public static String loginCheck() {
        String login;
        while (true) {
            login = sc.nextLine();
            if (!checkForUniqueness(login)) {
                return login;
            }
            System.out.println("Login is already used !!! Repeat !");
        }
    }

    public static int ageCheck() {
        int age;
        while (true) {
            age = getInt();
            if (age > adultHood) {
                return age;
            }
            System.out.println("User must be upper 17 years old !! Repeat !");
        }
    }

    public static String dateCheck() {
        String dateOfBirth;
        while (true) {
            dateOfBirth = sc.nextLine();
            if (dateOfBirth.matches(dayOfBirthReg)) {
                return dateOfBirth;
            }
            System.out.println("Wrong Date Format!! Repeat!");
        }
    }

    public static int telephoneNumberCheck() {
        String telephoneNumber;
        while (true) {
            telephoneNumber = sc.nextLine();
            if (telephoneNumber.matches(telephoneNumberReg)) {
                return Integer.parseInt(telephoneNumber);
            }
            System.out.println("Wrong telephone input!! Repeat!");
        }
    }

    public static String passportCheck() {
        String passport;
        while (true) {
            passport = sc.nextLine();
            if (passport.matches(passportReg)) {
                return passport;
            }
            System.out.println("Wrong passport input!! Repeat!");
        }
    }

    private static int randomWithInterval(int min, int max){
        return random.nextInt(max-min+one)+min;
    }

    public static String getSalt(){

        int amountOfCharacter = randomWithInterval(minLengthSalt, maxLengthSalt);
        char[] saltCh=new char[amountOfCharacter];
        for (int i=0;i<saltCh.length;i++){
            int ascii=randomWithInterval(asciiMinValue, asciiMaxValue);
            saltCh[i] = Character.toChars(ascii)[0];
        }
        String salt = new String(saltCh);
        return salt;
    }
    public static int getRandomInt(int amountNumber){

        char[] saltCh=new char[amountNumber];
        for (int i=0;i<saltCh.length;i++){
            int ascii=randomWithInterval(asciiMinNumber, asciiMaxNumber);
            saltCh[i] = Character.toChars(ascii)[0];
        }
        return Integer.parseInt(new String(saltCh));
    }
}