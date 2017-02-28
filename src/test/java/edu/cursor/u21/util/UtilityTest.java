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
                "If Password 'Love15', hashcode must be 'd2e950fcbe6a858a613de11e17426461'",
                "d2e950fcbe6a858a613de11e17426461",
                Utility.getPassword("love15"));
    }

    @Test
    public void getInt() throws Exception {


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

    @Test
    public void getSalt() throws Exception {

    }

    @Test
    public void getRandomInt() throws Exception {

    }

}