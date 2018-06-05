package com.matt.password_validator;

import org.junit.Test;

import static org.junit.Assert.*;


public class ValidatorTest {

    @Test
    public void testPasswordNotAllowed() {
        String pass1 = "abcdefg";
        String pass2 = "password";

        assertTrue(Validator.passwordCheck(pass1));
        assertFalse(Validator.passwordCheck(pass2));
    }

    @Test
    public void testLength() {
        String pass1 = "xyz";
        String pass2 = "abcdefgh";
        String pass3 = "ijklmnopwqrstuv";

        assertFalse(Validator.lengthCheck(pass1));
        assertTrue(Validator.lengthCheck(pass2));
        assertTrue(Validator.lengthCheck(pass3));
    }

    @Test
    public void testValidate() {
        String pass1 = "password";
        String pass2 = "abc";
        String[] pass2Checks = {"ijklmnopwq", "aB", "$$$", "1234"};
        String[] pass3Checks = {"1234567890", "AbCdEfGhhhh", "$$$$@@@@!!", "123aB", "12@@", "aB@$"};
        String[] pass4Checks = {"ABcdef777", "aB12$$", "a2c4e6g8i$$$@", "aBcD$$@@j"};
        String passAll = "123ABCefg$$$";

        assertEquals(1, Validator.validate(pass1));
        assertEquals(1, Validator.validate(pass2));
        assertEquals(5, Validator.validate(passAll));

        for (String pass : pass2Checks) {
            assertEquals(2,  Validator.validate(pass));
        }

        for (String pass : pass3Checks) {
            assertEquals(3, Validator.validate(pass));
        }

        for (String pass : pass4Checks) {
            assertEquals(4, Validator.validate(pass));
        }
    }

    @Test
    public void testNumber() {
        String pass1 = "abcdefghi";
        String pass2 = "a2c4e6g8i";

        assertFalse(Validator.numberCheck(pass1));
        assertTrue(Validator.numberCheck(pass2));
    }

    @Test
    public void testCase() {
        String pass1 = "abcdefghi";
        String pass2 = "DDDDDDDDDDDD";
        String pass3 = "TestingCase";
        String pass4 = "aaaaBBBBc";

        assertFalse(Validator.caseCheck(pass1));
        assertFalse(Validator.caseCheck(pass2));
        assertTrue(Validator.caseCheck(pass3));
        assertTrue(Validator.caseCheck(pass4));
    }

    @Test
    public void testSpecial() {
        String pass1 = "abcdefghi   ";
        String pass2 = "p@$$word3";

        assertFalse(Validator.specialCheck(pass1));
        assertTrue(Validator.specialCheck(pass2));
    }

}