package edu.cursor.u21.util;

import edu.cursor.u21.users.bankClient.BankClient;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Саша on 09.02.2017.
 */
public final class Utility implements MagicConstantsInterface {

    public static Scanner sc = new Scanner(System.in);
    private static Logger log = Logger.getLogger(Utility.class);
    private static Random random = new Random();

    private Utility() {
        throw new IllegalStateException();
    }

    public static String getPassword(String stringForPassword) {

        String password = stringForPassword;
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
        String hashPassword = bigInt1.toString(HASH_BYTE);
        while (hashPassword.length() < HEXADECIMAL_NUMBER) {
            hashPassword = "0" + hashPassword;
        }
        return hashPassword;
    }

    public static String getStringForPassword() {
        String stringForPassword = sc.nextLine();
        while (stringForPassword.length() < MIN_LENGTH_PASSWORD || MAX_LENGTH_PASSWORD < stringForPassword.length()) {
            System.out.println("Your password must be 5-15 characters.\n" +
                    "Try again:");
            stringForPassword = sc.nextLine();
        }
        return stringForPassword;
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

    public static String nameAndSurnameCheck() {
        String nameOrSurname;
        while (true) {
            nameOrSurname = sc.nextLine();
            if (nameOrSurname.matches(NAME_SURNAME_REG)) {
                return nameOrSurname;
            }
            System.out.println("Wrong Format!! Repeat!!");
        }

    }

    public static String loginCheck() {
        String login;
        while (true) {
            login = sc.nextLine();
            if (login.matches(LOGIN_REG)) {
                return login;
            }
            System.out.println("Wrong Login Format !!! Repeat !");
        }
    }

    public static boolean isDateValid(String date) {
        SimpleDateFormat myFormat = new SimpleDateFormat("dd.MM.yyyy");
        myFormat.setLenient(false);
        try {
            myFormat.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static void exitProgram(Connection connection, Statement statement) {
        System.out.println("If you want exit press - > X or x or anything to continue ");
        String exit = sc.nextLine();
        if (exit.equals("x") || exit.equals("X")) {
            try {
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

    public static void exitProgram(Connection connection, Statement statement, ResultSet resultSet) {
        System.out.println("If you want exit press - > X or x or anything to continue ");
        String exit = sc.nextLine();
        if (exit.equals("x") || exit.equals("X")) {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }
    }

    public static String dateCheck() {
        String dateOfBirth;
        String arr[];
        int birthYear;
        while (true) {
            dateOfBirth = sc.nextLine();
            if (isDateValid(dateOfBirth)) {
                arr = dateOfBirth.split("\\.");
                birthYear = Integer.parseInt(arr[2]);
                Calendar currentYear = new GregorianCalendar();
                if (currentYear.get(Calendar.YEAR) - birthYear < ADULTHOOD || currentYear.get(Calendar.YEAR) - birthYear > MAX_AGE) {
                    System.out.println("Wrong year of birth entered !! Repeat! ");
                    continue;
                } else {
                    return dateOfBirth;
                }
            }
            System.out.println("Wrong Date Format!! Repeat!");
        }
    }

    public static String telephoneNumberCheck() {
        while (true) {
            String telephoneNumber = sc.nextLine();
            if (telephoneNumber.matches(TELEPHONE_NUMBER_REG)) {
                return telephoneNumber;
            }
            System.out.println("Wrong telephone input!! Telephone number is not required ! Repeat!");
        }
    }

    public static String passportCheck() {
        while (true) {
            String passport = sc.nextLine();
            if (passport.matches(MagicConstantsInterface.PASSPORT_REG)) {
                return passport;
            }
            System.out.println("Wrong passport input!! Passport Series are not required! Repeat!");
        }
    }

    private static int randomWithInterval(int min, int max) {
        return random.nextInt(max - min + ONE) + min;
    }

    public static String getSalt() {

        int amountOfCharacter = randomWithInterval(MIN_LENGTH_SALT, MAX_LENGTH_SALT);
        char[] saltCh = new char[amountOfCharacter];
        for (int i = 0; i < saltCh.length; i++) {
            int ascii = randomWithInterval(ASCII_MIN_VALUE, ASCII_MAX_VALUE);
            saltCh[i] = Character.toChars(ascii)[0];
        }
        return new String(saltCh);
    }

    public static String generateAccountNumber(HashMap<String, BankClient> users, edu.cursor.u21.users.bankClient.Accounts.Currency currency) {

        String number = currency.name() + random.nextInt(8);

        for (BankClient bc : users.values()) {
            for (String num : bc.getAccountHashMap().keySet()) {
                if (number.equals(num)) {
                    number = generateAccountNumber(users, currency);
                    break;
                }
            }
        }
        return number;
    }
}