package edu.cursor.u21.users.Admin;

import edu.cursor.u21.Utils.Roles;
import edu.cursor.u21.users.User;
import lombok.Getter;
import java.io.Serializable;
/**
 * Created by vk on 2/9/17.
 */
@Getter
public class Admin implements Serializable, User {

    private String login;
    private String password;
    Roles role = Roles.ADMIN;

    public Admin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void startSession() {
        AdminMethods.adminMenu();
    }
}
