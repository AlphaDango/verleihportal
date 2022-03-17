package tuc.isse.model.verleih;

import tuc.isse.view.*;


import java.util.ArrayList;

/**
 * Kernklasse des Verleihportales
 * @author Oliver Neumann
 * @version 1.0
 */
public class Verleihportal {

    private ArrayList<Account> users;
    private ArrayList<Angebot> offers;

    public Verleihportal(){
        this.users = new ArrayList<>();
        this.offers = new ArrayList<>();
        LoginFrame.addVerleih(this);
        RegisterFrame.addVerleih(this);
        AccountFrame.addVerleih(this);
        VerleihFrame.addVerleih(this);
        VerleihenFrame.addVerleih(this);
        ReturnFrame.addVerleih(this);
    }

    /**
     * Methode um einen neuen User im Verleihportal zu hinzuzufuegen.
     * @param u User welche hinzuzufuegen ist.
     */
    public void addUser(Account u){
        users.add(u);
    }

    /**
     * Methode um ein neues Angebot im Verleihportal zu hinzuzufuegen.
     * @param a Angebot welche hinzuzufuegen ist.
     */
    public void addOffer(Angebot a){
        offers.add(a);
    }

    /**
     * Methode um ein Angebot aus dem Verleihportal zu entfernen.
     * @param a Angebot welches entfernt werden soll.
     */
    public void removeOffer(Angebot a){
        offers.remove(a);
    }

    // Getter/Setter Sektion

    public ArrayList<Account> getUsers(){
        return users;
    }

    public ArrayList<Angebot> getOffers() {
        return offers;
    }
}
