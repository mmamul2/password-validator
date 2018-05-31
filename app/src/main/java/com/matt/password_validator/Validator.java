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

    //cannot be the word "password"
    //TODO: this may be dropped, not needed given the other rules.
    static public boolean passwordCheck(String password){
        boolean check = false;

        if(!password.equals("password")){
            check = true;
        }

        return check;
    }

    //must be 8+ character long
    static public boolean lengthCheck(String password){
        boolean check = false;

        if(password.length() >= 8){
            check = true;
        }

        return check;
    }

    //must contain atleast 1 number and 1 letter
    static public boolean numberCheck(String password){
        boolean check = false;

        if(password.matches(".*[0-9].*")) {
            check = true;
        }
        return check;
    }

    //must contain atleast 1 upper case and 1 lower case letter
    static public boolean caseCheck(String password){
        boolean check = false;

        if(password.matches(".*[a-z].*[A-Z].*") || password.matches(".*[A-Z].*[a-z].*")){
            check = true;
        }
        return check;
    }

    //must contain atleast 1 special character
    static public boolean specialCheck(String password){
        boolean check = false;


        if(password.matches(".*[\\p{Punct}].*")){
            check = true;
        }

        return check;
    }

}
