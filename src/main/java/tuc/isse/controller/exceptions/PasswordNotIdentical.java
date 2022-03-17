package tuc.isse.controller.exceptions;

/**
 * Exception falls bei der Registrierung das die eingegeben Passwoerter nicht identisch sind.
 * @author Oliver Neumann
 * @version 1.0
 */
public class PasswordNotIdentical extends Exception{

    public String toString() {
        return ("Error: Passwords aren't identical!");
    }
}
