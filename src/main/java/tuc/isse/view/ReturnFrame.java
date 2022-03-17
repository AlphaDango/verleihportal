package tuc.isse.view;

import tuc.isse.controller.OfferHandleing;
import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Angebot;
import tuc.isse.model.verleih.Verleihportal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Das Rueckgabe Menue.
 * Hier koennen Nutzer ihre ausgeliehenen Modellflugzeuge zuruekgeben.
 * @author Oliver Neumann
 * @version 1.0
 */
public class ReturnFrame extends JFrame {

    private Account account;

    private static Verleihportal verleihportal;

    private final JFrame returnMenu = new JFrame("Ausgeliehene Modellflugzeuge von ");

    public ReturnFrame(Account account){
        this.account = account;
        returnMenu.setTitle("Ausgeliehene Modellflugzeuge von " + account.getUsername());

        JButton backB = new JButton("Zurück");
        JButton returnB = new JButton("Entfernen");
        JLabel userName = new JLabel(account.getUsername());


        JList<Angebot> rentedOffers = new JList<>();
        DefaultListModel<Angebot> rentedOffersList = new DefaultListModel<>();
        rentedOffers.setModel(rentedOffersList);
        for (Angebot a: account.getRentedModellflugzeuge())
            rentedOffersList.addElement(a);


        backB.setBounds (135, 255, 100, 20);
        returnB.setBounds (275, 200, 110, 20);
        userName.setBounds (145, 20, 125, 25);
        rentedOffers.setBounds (165, 85, 220, 115);


        JPanel panel = new JPanel();
        panel.setVisible (true);
        panel.setPreferredSize (new Dimension(415, 315));
        panel.setLayout (null);


        returnMenu.add(backB);
        returnMenu.add(rentedOffers);
        returnMenu.add(returnB);
        returnMenu.add(userName);
        returnMenu.setSize(415,315);
        returnMenu.setLayout(null);
        returnMenu.setLocationRelativeTo(null);
        returnMenu.setVisible(true);
        returnMenu.setResizable(false);
        returnMenu.getContentPane().add(panel);
        returnMenu.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });


        returnB.addActionListener(e -> {
            try {
                Angebot offer = rentedOffers.getSelectedValue();
                rentedOffersList.removeElement(offer);
                OfferHandleing.returnOffer(verleihportal,offer,account);
                JOptionPane.showMessageDialog(returnMenu,"Das Modellflugzeug wurde zurückgegeben.");
            }catch (Exception exception){
                exception.printStackTrace();
                JOptionPane.showMessageDialog(returnMenu,"Kein Flugzeug ausgewählt.");
            }
        });

        backB.addActionListener(e -> {
            new AccountFrame(account);
            returnMenu.dispose();
        });
    }

    /**
     * Methode um das Verleihportal dem View hinzuzufuegen.
     * @param verleihportal Das Verleihportal.
     */
    public static void addVerleih(Verleihportal verleihportal){
        ReturnFrame.verleihportal = verleihportal;
    }
}
