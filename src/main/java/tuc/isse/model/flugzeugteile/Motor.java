package tuc.isse.model.flugzeugteile;
/**
 * Akku Bauelement
 * @author Oliver Neumann
 * @version 1.0
 */
public class Motor extends Hauptkomponente{

    /**
     * Konstruktor eines Motors.
     * @param produktionsnummer Produktionsnummer eines Motors.
     * @param karalognummer Katalognummer eines Motors.
     * @param preis Preis eines Motors.
     * @param name Name eines Motors.
     * @param beschreibung Beschreibung eines Motors.
     * @param takingSlots Anzahl der Slots welches es im Rahmen verwendet.
     */
    public Motor(int produktionsnummer, int karalognummer, float preis, String name, String beschreibung, int takingSlots) {
        super(produktionsnummer, karalognummer, preis, name, beschreibung, takingSlots);
    }
}
