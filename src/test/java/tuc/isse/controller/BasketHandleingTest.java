package tuc.isse.controller;

import org.junit.Before;
import org.junit.Test;
import tuc.isse.controller.exceptions.OutOfSlots;
import tuc.isse.model.Adress;
import tuc.isse.model.flugzeugteile.*;
import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Angebot;
import tuc.isse.model.verleih.Verleihportal;

import static org.junit.Assert.*;

/**
 * JUnit4 Testklasse zum testen der BasketHandleing Klasse.
 * @author Oliver Neumann
 * @version 1.0
 */
public class BasketHandleingTest {

    Verleihportal verleihportal;
    Adress adress;
    Account user;
    Rahmen frame;
    Motor motor;
    Empfaenger empfaenger;
    Akku akku;
    Ferncontroller ferncontroller;
    Angebot angebot;

    @Before
    public void setUp() throws OutOfSlots {
        verleihportal = new Verleihportal();
        adress = new Adress("Deutschland",38678,"CLZ","Großer Bruch","14");
        user = new Account(adress,"Tom","Lachsnacken","goofygoober");
        verleihportal.addUser(user);

        frame = new Rahmen(5,1,10f,"BasicFrame","Text", 4);
        motor = new Motor(4,2,50f,"SuperDC","Text",2);
        empfaenger = new Empfaenger(6,15,20f,"Reciever900","Text",1);
        akku = new Akku(16,2,100f,"SuperCharge","Text",1);
        ferncontroller = new Ferncontroller(18,20,40f,"LongReacher","Text");
        OfferHandleing.createNewOffer(verleihportal,user,"Dangoflyer",frame,motor,empfaenger,akku,Flugzeugtyp.Ferngesteuert,ferncontroller);
        angebot = verleihportal.getOffers().get(0);

    }

    @Test
    public void addToBasket() {
        BasketHandleing.addToBasket(verleihportal,angebot,user);

        if(!user.getBasket().getOffers().isEmpty()&&verleihportal.getOffers().isEmpty())
            assert true;
        else
            assert false;
    }

    @Test
    public void removeFromBasket() {
        BasketHandleing.addToBasket(verleihportal,angebot,user);
        BasketHandleing.removeFromBasket(verleihportal,angebot,user);

        if(user.getBasket().getOffers().isEmpty()&&!verleihportal.getOffers().isEmpty())
            assert true;
        else
            assert false;
    }

    @Test
    public void checkout() {
        BasketHandleing.addToBasket(verleihportal,angebot,user);
        BasketHandleing.checkout(user);

        if (!user.getRentedModellflugzeuge().isEmpty()&&
        user.getBasket().getOffers().isEmpty()&&
        verleihportal.getOffers().isEmpty())
            assert true;
        else assert false;

    }
}