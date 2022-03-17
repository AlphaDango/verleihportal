package tuc.isse.controller.exceptions;

/**
 * Exception fuer denn fall, dass im Rahmen kein Platz mehr ist.
 * @author Oliver Neumann
 * @version 1.0
 */
public class OutOfSlots extends Exception{

    public String toString() {
        return ("Error: Frame is out of available slots!");
    }
}
