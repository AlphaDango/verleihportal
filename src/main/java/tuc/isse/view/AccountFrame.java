package tuc.isse.view;

import tuc.isse.controller.OfferHandleing;
import tuc.isse.model.Adress;
import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Angebot;
import tuc.isse.model.verleih.Verleihportal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * View ueber die Accountinformationen und angebotenen Modellflieger.
 * Eigene Angebote koennen hier entfernt werden.
 * @author Oliver Neumann
 * @version 1.0
 */
public class AccountFrame extends JFrame {

    private Account account;

    private static Verleihportal verleihportal;

    private final JFrame accountMenu = new JFrame("Accountinformationen von ");

    public AccountFrame(Account account){
        this.account = account;
        accountMenu.setTitle("Accountinformationen von " + account.getUsername());

        Adress adress = account.getAdress();
        JButton backB = new JButton("Zurück");
        JButton returnB = new JButton("Rückgabe");
        JButton removeOfferB = new JButton("Entfernen");
        JButton newOfferB = new JButton("Neu");
        JLabel name = new JLabel(account.getName());
        JLabel userName = new JLabel(account.getUsername());
        JLabel regionCode = new JLabel(adress.getLand());
        JLabel plz = new JLabel(Integer.toString(adress.getPlz()));
        JLabel city = new JLabel(adress.getStadt());
        JLabel streetHousenumber = new JLabel(adress.getStrasseHausnummer());
        JLabel bonusPoints = new JLabel("Bonus: "+ account.getBonusPoints()+ "pts");


        JList<Angebot> currentOffers = new JList<>();
        DefaultListModel<Angebot> currentOffersList = new DefaultListModel<>();
        currentOffers.setModel(currentOffersList);
        for (Angebot a: verleihportal.getOffers()){
            if(a.compareUser(account))
                currentOffersList.addElement(a);
        }


        backB.setBounds (135, 255, 100, 20);
        returnB.setBounds (310, 255, 100, 20);
        removeOfferB.setBounds (275, 200, 110, 20);
        newOfferB.setBounds (165, 200, 110, 20);
        name.setBounds (30, 80, 100, 25);
        userName.setBounds (145, 20, 125, 25);
        regionCode.setBounds (30, 105, 100, 25);
        plz.setBounds (30, 130, 100, 25);
        city.setBounds (30, 155, 100, 25);
        streetHousenumber.setBounds (30, 180, 100, 25);
        bonusPoints.setBounds (30, 205, 100, 25);
        currentOffers.setBounds (165, 85, 220, 115);


        JPanel panel = new JPanel();
        panel.setVisible (true);
        panel.setPreferredSize (new Dimension(415, 315));
        panel.setLayout (null);


        accountMenu.add(backB);
        accountMenu.add(returnB);
        accountMenu.add(bonusPoints);
        accountMenu.add(removeOfferB);
        accountMenu.add(newOfferB);
        accountMenu.add(name);
        accountMenu.add(userName);
        accountMenu.add(regionCode);
        accountMenu.add(plz);
        accountMenu.add(city);
        accountMenu.add(streetHousenumber);
        accountMenu.add(currentOffers);
        accountMenu.setSize(415,315);
        accountMenu.setLayout(null);
        accountMenu.setLocationRelativeTo(null);
        accountMenu.setVisible(true);
        accountMenu.setResizable(false);
        accountMenu.getContentPane().add(panel);
        accountMenu.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        newOfferB.addActionListener(e -> {
            new VerleihenFrame(account);
            accountMenu.dispose();
        });

        removeOfferB.addActionListener(e -> {
            try {
                Angebot offer = currentOffers.getSelectedValue();
                OfferHandleing.removeOffer(verleihportal,offer);
                currentOffersList.removeElement(offer);
            }catch (Exception exception){
                exception.printStackTrace();
                JOptionPane.showMessageDialog(accountMenu,"Kein Flugzeug ausgewählt.");
            }
        });

        returnB.addActionListener(e -> {
            new ReturnFrame(account);
            accountMenu.dispose();
        });

        backB.addActionListener(e -> {
            new MainMenuFrame(account);
            accountMenu.dispose();
        });
    }

    /**
     * Methode um das Verleihportal dem View hinzuzufuegen.
     * @param verleihportal Das Verleihportal.
     */
    public static void addVerleih(Verleihportal verleihportal){
        AccountFrame.verleihportal = verleihportal;
    }
}
