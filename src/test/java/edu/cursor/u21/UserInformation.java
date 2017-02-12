package edu.cursor.u21;

import java.io.IOException;


/**
 * Created by Sabat on 07.02.2017.
 */
public class UserInformation {
    private String Name;
    private String Surname;
    private int Age;
    private String Username;
    private int Password;
    private String DateOfBirth;
    private String SeriesOfPassport;

//    public UserInformation(String name, String surname, int age, String username, int password, String dateOfBirth, String seriesOfPassport) {
//        Name = name;
//        Surname = surname;
//        Age = age;
//        Username = username;
//        Password = password;
//        DateOfBirth = dateOfBirth;
//        SeriesOfPassport = seriesOfPassport;
//    }
    public String getName() {
        return Name;
    }

    public  void setName(String name) {Name = name;}

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        Password = password;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getSeriesOfPassport() {
        return SeriesOfPassport;
    }

    public void setSeriesOfPassport(String seriesOfPassport) {
        SeriesOfPassport = seriesOfPassport;
    }

    public void reg() throws IOException {
    }





}
