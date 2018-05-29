package com.matt.password_validator;

public class Validator {

    static public int validate(String password){
       int testsPassed = 0;

        if(passwordCheck(password)){
            testsPassed++;
        }
        if(lengthCheck(password)){
            testsPassed++;
        }

       return testsPassed;
    }

    static public boolean passwordCheck(String password){
        boolean check = false;

        if(!password.equals("password")){
            check = true;
        }

        return check;
    }

    static public boolean lengthCheck(String password){
        boolean check = false;

        if(password.length() >= 8){
            check = true;
        }

        return check;
    }

}
