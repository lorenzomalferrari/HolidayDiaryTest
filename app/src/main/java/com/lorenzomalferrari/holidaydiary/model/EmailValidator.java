package com.lorenzomalferrari.holidaydiary.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Java email validation program
 * @author lorenzomalferrari
 */

public class EmailValidator {
    // Email Regex java
    private static final String EMAIL_REGEX = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$";

    // static Pattern object, since pattern is fixed
    private static Pattern pattern;

    // non-static Matcher object because it's created from the input String
    private Matcher matcher;

    public EmailValidator() {
        // initialize the Pattern object
        pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
    }

    /**
     * This method validates the input email address with EMAIL_REGEX pattern
     *
     * @param email
     * @return boolean
     */
    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Test
     * malfe.lore@gmail.com --> true
     * malfe.loregmail.com --> false
     *
     * Esito corretto
     */
    /*public static void main(String args[]) {
        System.out.println("-----------------------------");
        EmailValidator emailV = new EmailValidator();
        boolean v = emailV.validateEmail("malfe.lore@gmail.com");
        boolean v2 = emailV.validateEmail("malfe.loregmail.com");
        System.out.println(v);
        System.out.println(v2);
        System.out.println("-----------------------------");
    }*/
}
