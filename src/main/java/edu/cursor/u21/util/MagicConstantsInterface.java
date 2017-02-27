package edu.cursor.u21.util;

/**
 * Created by Саша on 12.02.2017.
 */
public interface MagicConstantsInterface {

    int HEXADECIMAL_NUMBER = 32;
    int HASH_BYTE = 16;
    int MIN_LENGTH_PASSWORD = 5;
    int MAX_LENGTH_PASSWORD = 15;
    int ADULT_HOOD = 17;
    String DAY_OF_BIRTH_REG = "^\\d{2}-\\d{2}-\\d{4}$";
    String TELEPHONE_NUMBER_REG = "^(\\+?\\d{12})|(\\d{10})$";
    String PASSPORT_REG = "^[A-Z]{2}\\d{6}$";
    int MIN_LENGTH_SALT =8;
    int MAX_LENGTH_SALT =18;
    int ONE =1;
    int ASCII_MAX_VALUE =126;
    int ASCII_MIN_VALUE =33;
    String USERS_FILE_PATH = "Users.md";
    String BANK_FILE_PATH = "BankAccount.md";
    int ASCII_MAX_NUMBER =57;
    int ASCII_MIN_NUMBER =48;
    int MAX_AGE = 150;
}

