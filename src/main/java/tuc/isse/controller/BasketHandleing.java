package tuc.isse.controller;

import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Angebot;
import tuc.isse.model.verleih.Verleihportal;

import java.util.ArrayList;

/**
 * BasketHandleing Klasse.
 * Behandelt transaktionen dem Warenkorb betreffend.
 * @author Oliver Neumann
 * @version 1.0
 */
public class BasketHandleing {

    /**
     * Fuegt ein Angebot dem Warenkorb hinzu und reserviert dies.
     * @param verleihportal Betroffendes Verleihportal.
     * @param angebot Betroffendes Angebot.
     * @param account Nutzer des Warenkorbes.
     */
    public static void addToBasket(Verleihportal verleihportal, Angebot angebot, Account account){
        account.getBasket().addAngebot(angebot);
        verleihportal.removeOffer(angebot);
    }

    /**
     * Entfernt ein Angebot aus dem Warenkorb und stellt dieses wiederfuer andere zur verfuegung.
     * @param verleihportal Betroffendes Verleihportal.
     * @param angebot Betroffendes Angebot.
     * @param account Nutzer des Warenkorbes.
     */
    public static void removeFromBasket(Verleihportal verleihportal, Angebot angebot, Account account){
        account.getBasket().removeOffer(angebot);
        verleihportal.addOffer(angebot);
    }

    /**
     * Fuegt alle enthaltenden Angebot der Mietliste des Nutzers hinzu
     * und ermittelt die Bonuspunkte für den Nutzer.
     * Resettet den Warenkorb anschliessend.
     * @param account Nutzer des Warenkorbes.
     * @return Gibt den Gesamtbetrag des Warenkorbes zurueck.
     */
    public static float checkout(Account account){
        ArrayList<Angebot> offersInBasket;
        offersInBasket = account.getBasket().getOffers();
        for (Angebot a: offersInBasket){
            a.getModellflugzeug().setRented();
            account.addRentedModellflugzeug(a);
        }
        float price = account.getBasket().getTotalPrice();
        account.addBonusPoints((int)price/10);
        account.getBasket().flush();
        return price;
    }

}
