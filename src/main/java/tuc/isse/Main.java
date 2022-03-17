package tuc.isse;

import tuc.isse.controller.OfferHandleing;
import tuc.isse.controller.exceptions.OutOfSlots;
import tuc.isse.model.Adress;
import tuc.isse.model.flugzeugteile.*;
import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Verleihportal;
import tuc.isse.view.LoginFrame;

/**
 * Main Klasse. Einstieg in das Programm.
 * @author Oliver Neumann
 * @version 1.0
 */
public class Main {
    public static void main (String[] args) throws OutOfSlots {
        Verleihportal verleihportal = new Verleihportal();

        Adress adress = new Adress("Deutschland",28790,"Schwanewede","Posener Str.","10");
        Adress deltaQuadrant = new Adress("DeltaQuad",99999,"USS Voyager","Deck 3","Kabine 5");
        Account oliver = new Account(adress,"Oliver Neumann","Dango","1234");
        Account paris = new Account(deltaQuadrant,"Lt. Tom Paris","CptProton","belana");

        OfferHandleing.createNewOffer(verleihportal,oliver,"Basicflyer",
                new Rahmen(220,1,50f,"BasicFrame","Ein einfacher Aluminiumrahmen",3),
                new Motor(351,18,100f,"RotorBasic","Ein einfacher Propellermotor",1),
                new Empfaenger(444,12,10f,"LowRange","Empfänger mit niedriger Reichweite",1),
                new Akku(575,32,50f,"LowCap","Akku mit 100Wh.",1),
                Flugzeugtyp.Ferngesteuert,
                new Ferncontroller(82,103,100f,"Standardcontroller","Fernsteuerung für einen Flieger"));

        OfferHandleing.createNewOffer(verleihportal,paris,"Deltaflyer",
                new Rahmen(223,4,300f,"HighTec","Großer und leichter Rahmen bei denen \nes an nichts fehlt",10),
                new Motor(353,20,500f,"QuadTurbine","Ein vier Turbinenantrieb",4),
                new Empfaenger(446,13,150f,"LongRange","Empfänger mit großer Reichweite",3),
                new Akku(578,35,200f,"DualMedCap","Zwei Medium Akkus parallel geschalten.\n400Wh.",2),
                Flugzeugtyp.Hybrid,
                new Ferncontroller(81,100,300f,"Hybridcontroller","Fernsteuerung für einen Hybriden Flieger"));


        verleihportal.addUser(oliver);
        verleihportal.addUser(paris);

        new LoginFrame();
    }
}