package edu.cursor.u21.util;

import edu.cursor.u21.users.bankClient.Accounts.*;
import edu.cursor.u21.users.bankClient.BankClient;
import org.apache.log4j.Logger;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

    public static String loginCheck() {
        Map<String, BankClient> list = WriteAndRead.readBankFile();
        String login;
        while (true) {
            login = sc.nextLine();
            if (!list.containsKey(login)) {
                return login;
            }
            System.out.println("Login is already used !!! Repeat !");
        }
    }

    public static int ageCheck() {
        int age;
        while (true) {
            age = getInt();
            if (age > ADULT_HOOD && age < MagicConstantsInterface.MAX_AGE) {
                return age;
            }
            System.out.println("User must be upper 17 years old !! Or User Enter Wrong Data!  Repeat !");
        }
    }

    public static String dateCheck() {
        String dateOfBirth;
        while (true) {
            dateOfBirth = sc.nextLine();
            if (dateOfBirth.matches(DAY_OF_BIRTH_REG)) {
                return dateOfBirth;
            }
            System.out.println("Wrong Date Format!! Repeat!");
        }
    }

    public static String telephoneNumberCheck() {
        while (true) {
            Map<String, BankClient> list = WriteAndRead.readBankFile();
            String telephoneNumber = sc.nextLine();
            if (telephoneNumber.matches(MagicConstantsInterface.TELEPHONE_NUMBER_REG) &&
                    list.values().stream().noneMatch(e -> e.getTelephoneNumber().equals(telephoneNumber))) {
                return telephoneNumber;
            }
            System.out.println("Wrong telephone input!! Telephone number in use or not required ! Repeat!");
        }
    }

    public static String passportCheck() {
        Map<String, BankClient> list = WriteAndRead.readBankFile();
        while (true) {
            String passport = sc.nextLine();
            if (passport.matches(MagicConstantsInterface.PASSPORT_REG) &&
                    list.values().stream().noneMatch(e -> e.getSeriesOfPassport().equals(passport))) {
                return passport;
            }
            System.out.println("Wrong passport input!! Passport Series in use or not required! Repeat!");
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

        String number = currency.name()+random.nextInt(8);

        for (BankClient bc: users.values()) {
            for (String num : bc.getAccountHashMap().keySet()){
                if(number.equals(num)){
                    number = generateAccountNumber(users, currency);
                    break;
                }
            }
        }
        return number;
    }
}