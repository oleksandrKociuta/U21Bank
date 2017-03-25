package edu.cursor.u21.controller;

import edu.cursor.u21.util.Login;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vk on 3/20/17.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public Login init() {
        Login model = new Login();
//        model.addAttribute("msg", "Please Enter Your Login Details");
        return model;
    }
}
