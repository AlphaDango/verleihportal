package tuc.isse.model.verleih;

import tuc.isse.model.flugzeugteile.Ferncontroller;
import tuc.isse.model.flugzeugteile.Flugzeugtyp;
import tuc.isse.model.flugzeugteile.Rahmen;

/**
 * Die Modellflugzeug Klasse.
 * Ein Modellflugzeug besteht aus verschiedenen Modellbaukombonenten.
 * @author Oliver Neumann
 * @version 1.0
 */
public class Modellflugzeug {

    private Flugzeugtyp flugzeugtyp;
    private Rahmen rahmen;
    private Ferncontroller ferncontroller;
    private int compSlots;
    private boolean ausgeliehen;
    private String name;

    /**
     * Konstruktor des Moddellflugzeuges.
     * @param flugzeugtyp Art des Modellfliegers.
     * @param rahmen Rahmen des Modellfliegers.
     * @param ferncontroller Fernbedienung des Modellfliegers (abhängig vom Typen des Fliegers)
     * @param name Der Name des Modellflugzeuges.
     */
    public Modellflugzeug(Flugzeugtyp flugzeugtyp, Rahmen rahmen, Ferncontroller ferncontroller, String name){
        this.flugzeugtyp = flugzeugtyp;
        this.rahmen = rahmen;
        this.ferncontroller = ferncontroller;
        this.ausgeliehen = false;
        this.name = name;
        compSlots = rahmen.getFreeCompSlots();
    }

    /**
     * Gibt ein geliehenes Modellflugzeug wieder frei.
     */
    public void returnModellflugzeug(){
        this.ausgeliehen = false;
    }

    // Getter/Setter Sektion

    public Flugzeugtyp getFlugzeugtyp() {
        return flugzeugtyp;
    }

    public Rahmen getRahmen() {
        return rahmen;
    }

    public Ferncontroller getFerncontroller() {
        return ferncontroller;
    }

    public int getCompSlots() {
        return compSlots;
    }

    public void setRented(){
        this.ausgeliehen = true;
    }

    public boolean isAusgeliehen() {
        return ausgeliehen;
    }

    public String getName() {
        return name;
    }
}