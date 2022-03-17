package tuc.isse.controller.exceptions;

/**
 * Exception falls der Nutzername bei der Registrierung bereits im System genutzt wird.
 * @author Oliver Neumann
 * @version 1.0
 */
public class UserNameAlreadyTaken extends Exception{

    public String toString() {
        return ("Error: Username is already taken!");
    }
}
