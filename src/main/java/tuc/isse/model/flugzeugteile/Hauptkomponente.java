package tuc.isse.model.flugzeugteile;
/**
 * Abstrakte Klasse fuer die Hauptkompnenten.
 * Erbt von der Komponenten Klasse.
 * @author Oliver Neumann
 * @version 1.0
 */
public abstract class Hauptkomponente extends Komponente{

    private int takingSlots;

    /**
     * Konstruktor einer Hauptkomonente.
     * @param produktionsnummer Produktionsnummer einer Hauptkomonente.
     * @param karalognummer Katalognummer einer Hauptkomonente.
     * @param preis Preis einer Hauptkomonente.
     * @param name Name einer Hauptkomonente.
     * @param beschreibung Beschreibung einer Hauptkomonente.
     * @param takingSlots Anzahl der Slots welches es im Rahmen verwendet.
     */
    public Hauptkomponente(int produktionsnummer, int karalognummer, float preis, String name, String beschreibung, int takingSlots) {
        super(produktionsnummer, karalognummer, preis, name, beschreibung);
        this.takingSlots = takingSlots;
    }

    public int getTakingSlots() {
        return takingSlots;
    }
}
