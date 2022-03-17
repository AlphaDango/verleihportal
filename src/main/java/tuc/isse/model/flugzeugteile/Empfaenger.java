package tuc.isse.model.flugzeugteile;

/**
 * Empfaenger Bauelement
 * @author Oliver Neumann
 * @version 1.0
 */
public class Empfaenger extends Hauptkomponente{

    /**
     * Konstruktor des Empfaengers.
     * @param produktionsnummer Produktionsnummer des Empfaengers.
     * @param karalognummer Katalognummer des Empfaengers.
     * @param preis Preis des Empfaengers.
     * @param name Name des Empfaengers.
     * @param beschreibung Beschreibung des Empfaengers.
     * @param takingSlots Anzahl der Slots welches es im Rahmen verwendet.
     */
    public Empfaenger(int produktionsnummer, int karalognummer, float preis, String name, String beschreibung, int takingSlots) {
        super(produktionsnummer, karalognummer, preis, name, beschreibung, takingSlots);
    }
}
