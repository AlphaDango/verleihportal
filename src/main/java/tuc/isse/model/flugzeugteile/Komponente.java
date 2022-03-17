package tuc.isse.model.flugzeugteile;

/**
 * Die Komonentenklasse.
 * Oberklasse aller Bauelemente eines Modellflugzeuges.
 * @author Oliver Neumann
 * @version 1.0
 */
public abstract class Komponente {
    private int produktionsnummer;
    private int karalognummer;
    private float preis;
    private String name;
    private String beschreibung;

    /**
     * Konstrukter einer Kompnente.
     * @param produktionsnummer Produktionsnummer einer Kompnente.
     * @param karalognummer Katalognummer einer Kompnente.
     * @param preis Preis einer Kompnente.
     * @param name Name einer Kompnente.
     * @param beschreibung Beschreibung einer Kompnente.
     */
    public Komponente(int produktionsnummer, int karalognummer, float preis, String name, String beschreibung){
        this.produktionsnummer = produktionsnummer;
        this.produktionsnummer = karalognummer;
        this.preis = preis;
        this.name = name;
        this.beschreibung = beschreibung;
    }

    /**
     * Methode um eine Komponente als String auszugeben.
     */
    @Override
    public String toString() {
        return name;
    }

    // Getter/Setter Sektion

    public int getProduktionsnummer(){
        return produktionsnummer;
    }

    public int getKaralognummer() {
        return karalognummer;
    }

    public float getPreis() {
        return preis;
    }

    public String getBeschreibung() {
        return beschreibung;
    }


}
