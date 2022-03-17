package tuc.isse.model.flugzeugteile;

/**
 * Ferncontroller Bauelement
 * @author Oliver Neumann
 * @version 1.0
 */
public class Ferncontroller extends Komponente{

    /**
     * Konstruktor des Ferncontrollers.
     * @param produktionsnummer Produktionsnummer des Ferncontrollers.
     * @param karalognummer Katalognummer des Ferncontrollers.
     * @param preis Preis des Ferncontrollers.
     * @param name Name des Ferncontrollers.
     * @param beschreibung Beschreibung des Ferncontrollers.
     */
    public Ferncontroller(int produktionsnummer, int karalognummer, float preis, String name, String beschreibung) {
        super(produktionsnummer, karalognummer, preis, name, beschreibung);
    }
}
