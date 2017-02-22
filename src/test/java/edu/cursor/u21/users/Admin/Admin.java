//package edu.cursor.u21.users.Admin;
//
//import edu.cursor.u21.users.BankClient2.BankClient;
//import edu.cursor.u21.users.Roles;
//import edu.cursor.u21.users.User;
//import lombok.Getter;
//import java.io.Serializable;
//import java.util.HashMap;
//
///**
// * Created by vk on 2/9/17.
// */
//@Getter
//public class Admin implements Serializable, User {
//
//    private String login;
//    private String password;
//    private Integer id;
//    Roles role = Roles.ADMIN;
//
//    public Admin(String login, String password, Integer id) {
//        this.login = login;
//        this.password = password;
//        this.id = id;
//    }
//
//    public void startSession(HashMap<String, BankClient> usersList) {
//        AdminMenu.adminMenu(usersList);
//    }
//}
