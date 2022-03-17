package tuc.isse.model.verleih;

import tuc.isse.model.Adress;

import java.util.ArrayList;

/**
 * Userklasse. Hier werden Informationen ueber die User gespeichert.
 * @author Oliver Neumann
 * @version 1.0
 */
public class Account {

    private Adress adress;
    private String name;
    private String username;
    private String password;
    private int bonusPoints;
    private Einkaufswagen basket;
    private ArrayList<Angebot> rentedModellflugzeuge;

    /**
     * Konstuktor des Users
     * @param adress Adresse vom User.
     * @param name Name vom User.
     * @param username Username des Users.
     * @param password Passwort des Users.
     */
    public Account(Adress adress, String name, String username, String password){
        this.name = name;
        this.password = password;
        this.bonusPoints = 0;
        this.adress = adress;
        this.username = username;
        this.rentedModellflugzeuge = new ArrayList<>();
        this.basket = new Einkaufswagen();
    }

    /**
     * Methode um ein geliehenes Angebot hinzuzufuegen.
     * @param a Geliehenes Angebot (quasi wie eine Kaufbeleg).
     */
    public void addRentedModellflugzeug(Angebot a){
        rentedModellflugzeuge.add(a);
    }

    /**
     * Methode um ein geliehenes Angebot zu entfernen.
     * @param offer Geliehenes Angebot (quasi wie eine Kaufbeleg).
     */
    public void removeRentedModellflugzeug(Angebot offer) {
        rentedModellflugzeuge.remove(offer);
    }

    /**
     * Methode um verdiente Bonuspunkte hinzuzufuegen.
     * @param bonusPoints Verdiente Bonuspunkte.
     */
    public void addBonusPoints(int bonusPoints){
        this.bonusPoints += bonusPoints;
    }

    // Getter/Setter Sektion

    public String getUsername() {
        return username;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public Adress getAdress(){
        return adress;
    }

    public int getBonusPoints() {
        return bonusPoints;
    }

    public Einkaufswagen getBasket() {
        return basket;
    }

    public ArrayList<Angebot> getRentedModellflugzeuge() {
        return rentedModellflugzeuge;
    }
}
