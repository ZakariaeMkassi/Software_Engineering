package org.hbrs.se2.project.npng.controller;

public class PasswordController {

    public boolean PasswordSame(String password, String password2){


        if (password.equals(password2)){
            return true;
        }
        return false;
    }
}
