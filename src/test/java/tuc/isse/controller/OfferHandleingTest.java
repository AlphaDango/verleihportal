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
 * JUnit4 Testklasse zum testen der OfferHandleing Klasse.
 * @author Oliver Neumann
 * @version 1.0
 */
public class OfferHandleingTest {

    Verleihportal verleihportal;
    Adress adress;
    Account user;

    @Before
    public void setUp(){
        verleihportal = new Verleihportal();
        adress = new Adress("Deutschland",38678,"CLZ","Großer Bruch","14");
        user = new Account(adress,"Tom","Lachsnacken","goofygoober");
        verleihportal.addUser(user);
    }

    @Test
    public void createNewOffer() throws OutOfSlots {
        Rahmen frame = new Rahmen(5,1,10f,"BasicFrame","Text", 4);
        Motor motor = new Motor(4,2,50f,"SuperDC","Text",2);
        Empfaenger empfaenger = new Empfaenger(6,15,20f,"Reciever900","Text",1);
        Akku akku = new Akku(16,2,100f,"SuperCharge","Text",1);
        Ferncontroller ferncontroller = new Ferncontroller(18,20,40f,"LongReacher","Text");

        OfferHandleing.createNewOffer(verleihportal,user,"Dangoflyer",frame,motor,empfaenger,akku,Flugzeugtyp.Ferngesteuert,ferncontroller);
        Angebot check = null;
        for(Angebot a: verleihportal.getOffers()){
            if (a.getModellflugzeug().getName().equals("Dangoflyer")){
                check = a;
                break;
            }
        }
        if (check != null)
            assert true;
        else assert false;
    }

    @Test
    public void removeOffer() throws OutOfSlots {
        Rahmen frame = new Rahmen(5,1,10f,"BasicFrame","Text", 4);
        Motor motor = new Motor(4,2,50f,"SuperDC","Text",2);
        Empfaenger empfaenger = new Empfaenger(6,15,20f,"Reciever900","Text",1);
        Akku akku = new Akku(16,2,100f,"SuperCharge","Text",1);
        Ferncontroller ferncontroller = new Ferncontroller(18,20,40f,"LongReacher","Text");

        OfferHandleing.createNewOffer(verleihportal,user,"Dangoflyer",frame,motor,empfaenger,akku,Flugzeugtyp.Ferngesteuert,ferncontroller);

        Angebot offer = verleihportal.getOffers().get(0);

        OfferHandleing.removeOffer(verleihportal,offer);

        if (verleihportal.getOffers().isEmpty())
            assert true;
        else
            assert false;

    }

    @Test
    public void returnOffer() throws OutOfSlots {
        Rahmen frame = new Rahmen(5,1,10f,"BasicFrame","Text", 4);
        Motor motor = new Motor(4,2,50f,"SuperDC","Text",2);
        Empfaenger empfaenger = new Empfaenger(6,15,20f,"Reciever900","Text",1);
        Akku akku = new Akku(16,2,100f,"SuperCharge","Text",1);
        Ferncontroller ferncontroller = new Ferncontroller(18,20,40f,"LongReacher","Text");

        OfferHandleing.createNewOffer(verleihportal,user,"Dangoflyer",frame,motor,empfaenger,akku,Flugzeugtyp.Ferngesteuert,ferncontroller);

        Angebot offer = verleihportal.getOffers().get(0);
        verleihportal.removeOffer(offer);
        user.addRentedModellflugzeug(offer);

        OfferHandleing.returnOffer(verleihportal,offer,user);

        if(user.getRentedModellflugzeuge().isEmpty()&&!verleihportal.getOffers().isEmpty())
            assert true;
        else
            assert false;
    }
}