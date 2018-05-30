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
        //1 pass
        String pass1 = "password";
        String pass2 = "abc";

        //2 pass
        String pass3 = "ijklmnopwq";
        String[] pass2arr = {"ijklmnopwq", "aB", "$$$", "1234"};

        //3 pass
        String pass4 = "1234567890";
        String pass5 = "a2c4e6g8i"; //these 2 test the same stuff.
        String[] pass3arr = {"1234567890", "AbCdEfGhhhh", "$$$$@@@@!!", "123aB", "12@@", "aB@$"};

        //4 pass
        String pass6 = "ABcdef777";
        String pass7 = "aB12$$";
        String pass8 = "a2c4e6g8i$$$@";
        String pass9 = "aBcD$$@@j";
        String[] pass4arr = {"ABcdef777", "aB12$$", "a2c4e6g8i$$$@", "aBcD$$@@j"};

        //all pass
        String pass10 = "123ABCefg$$$";
//TODO: need to update this to work with the arrays to tidy up the code.
        assertEquals(1, Validator.validate(pass1));
        assertEquals(1, Validator.validate(pass2));
        assertEquals(2, Validator.validate(pass3));
        assertEquals(3, Validator.validate(pass4));
        assertEquals(3, Validator.validate(pass5));
        assertEquals(4, Validator.validate(pass6));
        assertEquals(4, Validator.validate(pass7));
        assertEquals(4, Validator.validate(pass8));
        assertEquals(4, Validator.validate(pass9));
        assertEquals(5, Validator.validate(pass10));
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

        assertFalse(Validator.numberCheck(pass1));
        assertFalse(Validator.numberCheck(pass2));
        assertTrue(Validator.numberCheck(pass3));
    }

    @Test
    public void testSpecial() {
        String pass1 = "abcdefghi";
        String pass2 = "p@$$word3";

        assertFalse(Validator.numberCheck(pass1));
        assertTrue(Validator.numberCheck(pass2));
    }

}