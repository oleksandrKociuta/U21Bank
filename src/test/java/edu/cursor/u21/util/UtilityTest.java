package edu.cursor.u21.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Саша on 28.02.2017.
 */
public class UtilityTest {
    @Test
    public void successHashingUsersPassword() throws Exception {
        assertEquals(
                "If Password 'love15', hashcode must be 'd2e950fcbe6a858a613de11e17426461'",
                "d2e950fcbe6a858a613de11e17426461",
                Utility.getPassword("love15"));
    }

    @Test(timeout = 3000)
    public void successConvertingStringToInt() throws Exception {
        String str = "10";
        assertEquals(
                10,
                Utility.getInt());
    }

    @Test
    public void loginCheck() throws Exception {

    }

    @Test
    public void ageCheck() throws Exception {

    }

    @Test
    public void dateCheck() throws Exception {

    }

    @Test
    public void telephoneNumberCheck() throws Exception {

    }

    @Test
    public void passportCheck() throws Exception {

    }

}