package tuc.isse.model;

/**
 * Adress Klasse. Hilfsklasse zum vereinfachen der Adresse.
 * @author Oliver Neumann
 * @version 1.0
 */
public class Adress {
    private String strasse;
    private String stadt;
    private int plz;
    private String land;
    private String hausnummer;

    public Adress(String land, int plz, String stadt, String strasse, String hausnummer){
        this.land = land;
        this.strasse = strasse;
        this.stadt = stadt;
        this.plz = plz;
        this.hausnummer = hausnummer;
    }

    public String getStadt() {
        return stadt;
    }

    public int getPlz() {
        return plz;
    }

    public String getLand() {
        return land;
    }

    public String getStrasseHausnummer(){
        return strasse + " " + hausnummer;
    }
}
