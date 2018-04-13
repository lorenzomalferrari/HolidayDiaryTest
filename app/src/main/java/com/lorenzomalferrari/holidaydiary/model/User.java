package com.lorenzomalferrari.holidaydiary.model;

import java.util.Date;

/**
 * Class representative of the User and his data
 * @author lorenzomalferrari.com
 */
public class User {

    private String username, firstName, lastName, email, password, city, country;
    private char gender/* M o F*/;
    private int age;
    private Date birthdate;

    /**
     * Default constructor
     * User with precompiled fields
     */
    public User() {
        this.username = "user";
        this.firstName = "User";
        this.lastName = "User";
        this.email = "user@user.com";
        this.password = "user";
        this.gender = 'M';
        this.city = "User";
        this.country = "User";
        this.age = 1; // creare una funzione che presa la data di nascita e la data di oggi....calcoli l'età...se birthdate = null non calcoli
        this.birthdate = new Date();
    }

    /**
     * Main Costructor
     * They are required fields
     * @param username
     * @param email
     * @param password
     */
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    /**
     * User Costructor
     * Complete constructor if the User compiles all the fields
     * @param username
     * @param firstName
     * @param lastName
     * @param email
     * @param password
     * @param gender
     * @param city
     * @param country
     * @param age
     * @param birthdate
     */
    public User(String username, String firstName, String lastName, String email, String password, char gender, String city, String country, int age, Date birthdate) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.city = city;
        this.country = country;
        this.age = age;
        this.birthdate = birthdate;
    }

    /**
     * Method that returns the user's username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Method that allows you to change the username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Method that returns the user's firstName
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Method that allows you to change the firstName
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Method that returns the user's lastName
     * @return  lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Method that allows you to change the lastName
     * @param  lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Metodo che restituisce l'email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo che modifica l'email dell'utente
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo che mi restituisce il genere dell'utente
     * @return
     */
    public char getGender() {
        return gender;
    }

    /**
     * Metodo che modifica il genere dell'utente
     * @param gender
     */
    public void setGender(char gender) {
        this.gender = gender;
    }

    /**
     * Metodo che restituisce la città dell'utente
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * Metodo che modifica la città dell'utente
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Metodo che restituisce lo stato dell'utente
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Metodo che modifica lo stato dell'utente
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    /**
     * Metodo che modifica l'età dell'utente
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Metodo che restituisce la data di nascita dell'utente
     * @return
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * Metodo che modifica la data di nascita dell'utente
     * @param birthdate
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * Metodo che mi modifica la password dell'utente
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Textual representation of the user
     * @return user
     */
    @Override
    public String toString() {
        return "User{" + "username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + ", gender=" + gender + ", city=" + city + ", country=" + country + ", age=" + age + ", birthdate=" + birthdate + '}';
    }

}