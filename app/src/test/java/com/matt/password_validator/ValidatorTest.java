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

       assertEquals(1, Validator.validate(pass1));
       assertEquals(1, Validator.validate(pass2));
       assertEquals(2, Validator.validate(pass3));
    }
}