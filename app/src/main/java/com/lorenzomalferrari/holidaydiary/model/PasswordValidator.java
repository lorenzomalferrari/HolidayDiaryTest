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


    /**
     *
     * @return
     *  - true se la password rispecchia i requisiti minimi
     *  - false se non li rispetta
     */
    private boolean validatePassword(String password){
        boolean flag = false;
        //controllo la lunghezza
        if (isLengthCorrect(password) == true){
            //controllo i singoli caratteri della password per verificare se contiene le richieste specifiche
            for(int i = 0; i <= password.length(); i++){
                //password.charAt(i) = 'M';
            }
            flag = true;
        }
        else{
            //Mandare errore
            flag = false;
        }
        return flag;
    }
}
