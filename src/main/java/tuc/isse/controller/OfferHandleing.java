package tuc.isse.controller;

import tuc.isse.controller.exceptions.OutOfSlots;
import tuc.isse.model.flugzeugteile.*;
import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Angebot;
import tuc.isse.model.verleih.Modellflugzeug;
import tuc.isse.model.verleih.Verleihportal;

/**
 * Die OfferHandleing Klasse.
 * Hier werden transaktionen den Angeboten betreffend behandelt.
 * @author Oliver Neumann
 * @version 1.0
 */
public class OfferHandleing {

    /**
     * Methode um ein neues Angebot mit einem Modellflieger zu erstellen.
     * @param verleihportal Betroffenes Verleihportal.
     * @param user Nutzer welcher das Angebot erstellt.
     * @param planeName Name des Modellflugzeuges.
     * @param rahmen Rahmen des Modellflugzeuges.
     * @param motor Motor des Modellflugzeuges.
     * @param empfaenger Empfaenger des Modellflugzeuges.
     * @param akku Akku des Modellflugzeuges.
     * @param flugzeugtyp Typ des des Modellflugzeuges.
     * @param ferncontroller Ferncontroller des Modellflugzeuges.
     * @throws OutOfSlots Exception wird geworden falls eines oder mehrerer der Hauptkomponenten nicht mehr passt.
     */
    public static void createNewOffer(Verleihportal verleihportal, Account user,String planeName,
                                      Rahmen rahmen, Motor motor, Empfaenger empfaenger, Akku akku,
                                      Flugzeugtyp flugzeugtyp, Ferncontroller ferncontroller) throws OutOfSlots {
        rahmen.takeComp(motor);
        rahmen.takeComp(empfaenger);
        rahmen.takeComp(akku);


        Modellflugzeug modellflugzeug = new Modellflugzeug(flugzeugtyp,rahmen,ferncontroller,planeName);
        Angebot newOffer = new Angebot(modellflugzeug,user);
        verleihportal.addOffer(newOffer);
    }

    /**
     * Methode um ein Angebot aus Verleihportal zu entfernen.
     * @param verleihportal Betroffenes Verleihportal.
     * @param offer Angebot welches entfernt werden soll.
     */
    public static void removeOffer(Verleihportal verleihportal, Angebot offer){
        verleihportal.removeOffer(offer);
    }

    /**
     * Methode um ein Angebot welches von einem User geliehen wurde
     * zurueck zu geben.
     * @param verleihportal Betroffenes Verleihportal.
     * @param offer Angebot zum zuruekgeben.
     * @param renter Mieter welcher das Angebot zuruek gibt.
     */
    public static void returnOffer(Verleihportal verleihportal, Angebot offer, Account renter){
        offer.getModellflugzeug().returnModellflugzeug();
        verleihportal.addOffer(offer);
        renter.removeRentedModellflugzeug(offer);
    }
}
