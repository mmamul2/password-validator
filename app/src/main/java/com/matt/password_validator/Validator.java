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
        if(numberCheck(password)){
            testsPassed++;
        }
        if(caseCheck(password)){
            testsPassed++;
        }
        if(specialCheck(password)){
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

    static public boolean numberCheck(String password){
        boolean check = false;

        if(password.matches(".*[0-9].*")) {
            check = true;
        }
        return check;
    }

    static public boolean caseCheck(String password){
        boolean check = false;

        if(password.matches(".*[a-z].*[A-Z].*") || password.matches(".*[A-Z].*[a-z].*")){
            check = true;
        }
        return check;
    }

    static public boolean specialCheck(String password){
        boolean check = false;

        //checks that password contains a non-letter, non-number, non-white space character
        if(password.matches(".*[^0-9a-zA-Z \\t\\n\\x0B\\f\\r].*")){
            check = true;
        }

        return check;
    }

}
