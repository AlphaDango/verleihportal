package tuc.isse.model.verleih;

import tuc.isse.model.flugzeugteile.Hauptkomponente;

/**
 * @author Oliver Neumann
 * @version 1.0
 */
public class Angebot {
    private final int ID;
    private Modellflugzeug modellflugzeug;
    private Account anbieter;

    /**
     * Konstruktor eines Angebots.
     * @param modellflugzeug Angebotenes Modellflugzeug.
     * @param anbieter Ersteller des Angebotes.
     */
    public Angebot(Modellflugzeug modellflugzeug, Account anbieter){
        ID = (int) (Math.random()*1000);
        this.modellflugzeug = modellflugzeug;
        this.anbieter = anbieter;
    }

    /**
     * Methode um den Mietpreis des Modellflugzeuges zu ermitteln.
     * Mietpreis ist 10% des Gesamtwertes der Modellflugzeuges.
     * @return Mietpreis als float.
     */
    public float getRentingPrice(){
        float price = 0;
        for(Hauptkomponente c: modellflugzeug.getRahmen().getHauptkomponenten())
            price += c.getPreis();

        return (price+modellflugzeug.getFerncontroller().getPreis())/10;
    }

    /**
     * Methode um den Anbieter mit einem User zu vergleichen.
     * @param user Zu vergleichenden User.
     * @return boolean ob es der selbe User ist wie der Anbieter.
     */
    public boolean compareUser(Account user){
        return user.equals(anbieter);
    }

    // Getter/Setter Sektion

    public String getUsername(){
        return anbieter.getUsername();
    }

    public Modellflugzeug getModellflugzeug() {
        return modellflugzeug;
    }

    @Override
    public String toString() {
        return modellflugzeug.getName()+ " " +ID;
    }
}
