package tuc.isse.controller;

import org.junit.Before;
import org.junit.Test;
import tuc.isse.controller.exceptions.*;
import tuc.isse.model.Adress;
import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Verleihportal;

import static org.junit.Assert.*;

/**
 * JUnit4 Testklasse zum testen der AccountHandleing Klasse.
 * @author Oliver Neumann
 * @version 1.0
 */
public class AccountHandleingTest {

    Verleihportal verleihportal;
    Account account;
    Adress adress;

    @Before
    public void setUp(){
        verleihportal = new Verleihportal();
        adress = new Adress("Deutschland", 35213,"Hubdorf","Gabelweg","15");
        account = new Account(adress,"TestUser","TestUsername","1234");
        verleihportal.addUser(account);
    }

    @Test
    public void createNewUser() throws UserNameAlreadyTaken, PasswordNotIdentical {
        Account testAcc = null;
        Adress test = new Adress("Deutschland", 35213,"Hubdorf","Gabelweg","15");
        AccountHandleing.createNewUser(verleihportal,test,"TestUser","GibbyGoober",new String[] {"1234","1234"});
        for (Account a: verleihportal.getUsers()){
            if(a.getUsername().equals("GibbyGoober")){
                testAcc = a;
            }
        }
        if(testAcc != null)
            assert true;
        else
            assert false;
    }

    @Test
    public void loginUser() throws UnkownUser, InvalidPassword {
        assertEquals(account,AccountHandleing.loginUser(verleihportal,"TestUsername","1234"));
    }
}