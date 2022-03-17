package tuc.isse.controller.exceptions;

/**
 * Exception fuer eine falsche Passworteingabe.
 * @author Oliver Neumann
 * @version 1.0
 */
public class InvalidPassword extends Exception{

    public String toString() {
        return ("Error: Password is invalid!");
    }
}
