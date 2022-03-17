package tuc.isse.model.flugzeugteile;

import tuc.isse.controller.exceptions.OutOfSlots;

import java.util.ArrayList;

/**
 * Die Rahmen Klasse.
 * Der Rahmen traegt alle Hauptkomponenten.
 * @author Oliver Neumann
 * @version 1.0
 */
public class Rahmen extends Komponente{

    private ArrayList<Hauptkomponente> hauptkomponenten;
    private int freeCompSlots;

    /**
     * Konstruktor des Rahmens.
     * @param produktionsnummer Produktionsnummer des Rahmens.
     * @param katalognummer Katalognummer des Rahmens.
     * @param preis Preis des des Rahmens.
     * @param name Name des des Rahmens.
     * @param beschreibung Beschreibung des Rahmens.
     * @param compSlots Anzahl der freien Slots im Rahmen.
     */
    public Rahmen(int produktionsnummer, int katalognummer, float preis, String name, String beschreibung, int compSlots) {
        super(produktionsnummer, katalognummer, preis, name, beschreibung);
        hauptkomponenten = new ArrayList<>();
        this.freeCompSlots = compSlots;
    }

    /**
     * Methode um Hauptkomponenten aufzunehmen, solange noch freie
     * Komponenten Slots zu verfuegung stehen.
     * @param comp Aufzunehmende Komponente.
     * @throws OutOfSlots Exception welche geworfen wird wenn kein freier Slot mehr
     * zur verfuegung steht.
     */
    public void takeComp(Hauptkomponente comp) throws OutOfSlots {
        if(freeCompSlots - comp.getTakingSlots() >= 0){
            hauptkomponenten.add(comp);
            freeCompSlots -= comp.getTakingSlots();
        }else {
            throw new OutOfSlots();
        }
    }

    // Getter/Setter Sektion

    public ArrayList<Hauptkomponente> getHauptkomponenten() {
        return hauptkomponenten;
    }

    public int getFreeCompSlots(){
        return freeCompSlots;
    }
}
