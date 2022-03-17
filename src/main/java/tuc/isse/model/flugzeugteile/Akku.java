package tuc.isse.model.flugzeugteile;

/**
 * Akku Bauelement
 * @author Oliver Neumann
 * @version 1.0
 */
public class Akku extends Hauptkomponente{

    /**
     * Konstruktor des Akkus
     * @param produktionsnummer Produktionsnummer des Akkus.
     * @param karalognummer Katalognummer des Akkus.
     * @param preis Preis des Akkus.
     * @param name Name des Akkus.
     * @param beschreibung Beschreibung des Akkus.
     * @param takingSlots Anzahl der Slots welches es im Rahmen verwendet.
     */
    public Akku(int produktionsnummer, int karalognummer, float preis, String name, String beschreibung, int takingSlots) {
        super(produktionsnummer, karalognummer, preis, name, beschreibung, takingSlots);
    }
}
