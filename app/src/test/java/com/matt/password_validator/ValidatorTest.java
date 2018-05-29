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
        String pass3 = "ijklmnopwq";
        String pass4 = "1234567890";
        String pass5 = "a2c4e6g8i";
        String pass6 = "123";
        String pass7 = "a2c";

        //TODO: need to finish the stage 2 tests - case, special
        String pass8 = "Matthew1985";
        String pass9 = "matthew1985";
        String pass10 = "";
        String pass11 = "";

        //stage 1
       assertEquals(1, Validator.validate(pass1));
       assertEquals(1, Validator.validate(pass2));
       assertEquals(2, Validator.validate(pass3));

       //stage2 - number
       assertEquals(2, Validator.validate(pass4));
       assertEquals(3, Validator.validate(pass5));
       assertEquals(2, Validator.validate(pass6));
       assertEquals(2, Validator.validate(pass6));

       //stage2 - case


       //stage2 - special

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