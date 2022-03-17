package tuc.isse.controller;

import tuc.isse.controller.exceptions.*;
import tuc.isse.model.Adress;
import tuc.isse.model.verleih.Verleihportal;
import tuc.isse.model.verleih.Account;

/**
 * Die AccountHandleing Klasse.
 * Hier werden transaktionen dem Nutzer betreffend behandelt.
 * @author Oliver Neumann
 * @version 1.0
 */
public class AccountHandleing {

    /**
     * Methode um eine Adressenobjekt fuer den User zu generieren.
     * @param land Land des Nutzers.
     * @param strasse Strasse des Nutzers.
     * @param stadt Stadt des Nutzers.
     * @param hausnummer Hausnummer des Nutzers.
     * @param plz Postleitzahl des Nutzers.
     * @return Ein Adress Objekt welches die Adressinformationen speichert.
     */
    public static Adress createNewAdress(String land, String strasse, String stadt, String hausnummer, int plz){
        return new Adress(land,plz,stadt,strasse,hausnummer);
    }

    /**
     * Methode um einen neuen Nutzer zu erstellen und ihm im Verleihportal zu hinterlegen.
     * @param verleihportal Betroffendes Verleihportal.
     * @param adress Adresse des Nutzers.
     * @param name Name des Nutzers.
     * @param username Benutzername des Nutzers.
     * @param passwordFields String Array mit zwei Elementen. Das Passwort und die wiederholte eingabe des Passwortes.
     * @throws PasswordNotIdentical Exception wird geworfen wenn die beiden Element des passwordFields nicht uebereinstimmen.
     * @throws UserNameAlreadyTaken Exception wird geworfen falls der angegebene Benutzername bereits vergeben ist.
     */
    public static void createNewUser(Verleihportal verleihportal,Adress adress, String name, String username, String[] passwordFields) throws PasswordNotIdentical, UserNameAlreadyTaken {
        if (!(passwordFields[0].equals(passwordFields[1])))
            throw new PasswordNotIdentical();

        for (Account a: verleihportal.getUsers()){
            if(a.getUsername().equals(username)){
                throw new UserNameAlreadyTaken();
            }
        }

        Account newUser = new Account(adress,name, username, passwordFields[0]);
        verleihportal.addUser(newUser);
    }

    /**
     * Methode um den Nutzer anzumelden.
     * @param verleihportal Betroffenes Verleihportal.
     * @param username Angegebener Benutzername.
     * @param password Angegebenes Passwort.
     * @return Nutzerobejekt wird zuruekgegeben welches in den darauffolgenen Views hinterlegt wird.
     * @throws InvalidPassword Exception wird geworfen falls das angegebene Passwort falsch ist.
     * @throws UnkownUser Exception wird geworden wenn der angegeben Benutzername im System unbekannt ist.
     */
    public static Account loginUser(Verleihportal verleihportal, String username, String password) throws InvalidPassword, UnkownUser {

        Account user = null;

        for(Account u : verleihportal.getUsers() ){
            if(u.getUsername().equals(username)){
                user = u;
                break;
            }
        }
        if(user == null)
            throw new UnkownUser();
        if(user.getUsername().equals(username) && user.getPassword().equals(password)){
            return user;
        }else {
            throw new InvalidPassword();
        }
    }
}
