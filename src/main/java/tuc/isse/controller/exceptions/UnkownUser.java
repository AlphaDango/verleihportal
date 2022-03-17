package tuc.isse.controller.exceptions;

/**
 * Exception falls der Nutzername beim Login nicht im System bekannt ist.
 * @author Oliver Neumann
 * @version 1.0
 */
public class UnkownUser extends Exception{

    public String toString() {
        return ("Error: Username is unknown!");
    }
}
