package tuc.isse.model.verleih;

import java.util.ArrayList;

/**
 * Einkaufswagen Klasse.
 * Hier werden Angebote vor dem chekout für den User reserviert.
 * @author Oliver Neumann
 * @version 1.0
 */
public class Einkaufswagen {
    private ArrayList<Angebot> angebote;
    private float totalPrice;

    public Einkaufswagen(){
        angebote = new ArrayList<>();
        totalPrice = 0;
    }

    /**
     * Methode um ein Angebot dem einkaufswagen hinzuzufuegen.
     * @param a Angebot welches in Einkaufwagen gelegt werden soll.
     */
    public void addAngebot(Angebot a){
        this.angebote.add(a);
        calculateTotalPrice();
    }

    /**
     * Methode um ein Angebot aus dem Einkaufswagen zu entfernen.
     * @param a Angebot welches aus dem Einkaufswagen entfert werden soll.
     */
    public void removeOffer(Angebot a){
        this.angebote.remove(a);
        calculateTotalPrice();
    }

    /**
     * Methode um den Gesamtpreis vom Inhalt des Einkaufswagens zu ermitteln.
     */
    private void calculateTotalPrice(){
        totalPrice = 0;
        for (Angebot a:angebote){
            totalPrice += a.getRentingPrice();
        }
    }

    /**
     * Methode um den Einkaufswagen nach dem checkout zu leeren.
     */
    public void flush(){
        angebote = new ArrayList<>();
        totalPrice = 0;
    }

    // Getter/Setter Sektion

    public ArrayList<Angebot> getOffers(){
        return angebote;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

}
