package com.lorenzomalferrari.holidaydiary.model;

/**
 * Class to validate the past depending on specific requirements
 * @author lorenzomalferrari.com
 */
public class PasswordValidator {

    /**
     *  Che caratteri dovrà contenere la password?
     *
     *  - 2 numeri
     *  - 1 maiuscola
     *  - 1 minuscola
     *
     * Da quanti caratteri dovrà essere composta la password?
     *
     *  - 6 caratteri
     */

    /**
     * Metodo che mi dice se la lunghezza della password è accettabile
     * @param password
     * @return >= 6 Accettabile (true)
     *
     */
    private boolean isLengthCorrect(String password){
        boolean status = false;
        if (password.length() >= 6){
            return status = true;
        }
        else
        {
            return status;
        }
    }
}
