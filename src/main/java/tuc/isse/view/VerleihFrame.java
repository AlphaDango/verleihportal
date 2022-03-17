package tuc.isse.view;

import tuc.isse.controller.BasketHandleing;
import tuc.isse.model.flugzeugteile.Akku;
import tuc.isse.model.flugzeugteile.Empfaenger;
import tuc.isse.model.flugzeugteile.Hauptkomponente;
import tuc.isse.model.flugzeugteile.Motor;
import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Angebot;
import tuc.isse.model.verleih.Verleihportal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

/**
 * Das verleih Menue.
 * Hier koennen Nutzer zum verleih stehende Modellflieger ausleihen.
 * @author Oliver Neumann
 * @version 1.0
 */
public class VerleihFrame extends JFrame {

    private Account account;

    private static Verleihportal verleihportal;

    private final JFrame verleihFrame = new JFrame("Verleih");

    private JLabel user;
    private JLabel frame;
    private JLabel motor;
    private JLabel battery;
    private JLabel type;
    private JLabel reciever;
    private JLabel price;
    private JLabel totalPrice;
    private JList<Angebot> basektList;
    private JList<Angebot> verleihList;

    public VerleihFrame(Account account){
        this.account = account;

        verleihList = new JList<>();
        DefaultListModel<Angebot> verleihListItems = new DefaultListModel<>();
        verleihList.setModel(verleihListItems);
        for (Angebot a: verleihportal.getOffers())
            verleihListItems.addElement(a);


        basektList = new JList<>();
        DefaultListModel<Angebot> basektListItems = new DefaultListModel<>();
        basektList.setModel(basektListItems);
        for (Angebot a: account.getBasket().getOffers())
            basektListItems.addElement(a);


        JButton backB = new JButton("Zurück");
        JButton addB = new JButton("Hinzufügen");
        JButton removeB = new JButton("Entfernen");
        JButton checkoutB = new JButton("Checkout");
        JLabel basketL = new JLabel("Einkaufswagen");
        JLabel verleihL = new JLabel("Verleih");


        user = new JLabel();
        frame = new JLabel();
        motor = new JLabel();
        battery = new JLabel();
        type = new JLabel();
        reciever = new JLabel();
        price = new JLabel();
        totalPrice = new JLabel();


        user.setBounds(750,35,100,25);
        frame.setBounds(750,60,100,25);
        type.setBounds(750,85,100,25);
        motor.setBounds(750,110,100,25);
        battery.setBounds(750,135,100,25);
        reciever.setBounds(750,160,100,25);
        price.setBounds(750,185,100,25);
        totalPrice.setBounds(100, 375,100,25);


        verleihList.setBounds (495, 50, 200, 300);
        basektList.setBounds (80, 50, 200, 300);
        backB.setBounds (520, 490, 100, 25);
        addB.setBounds (520, 350, 100, 25);
        removeB.setBounds (100, 350, 100, 25);
        checkoutB.setBounds (95, 485, 100, 25);
        basketL.setBounds (105, 25, 100, 25);
        verleihL.setBounds (540, 25, 45, 25);

        JPanel panel = new JPanel();
        panel.setVisible (true);
        panel.setPreferredSize (new Dimension(945, 575));
        panel.setLayout (null);


        verleihFrame.add(frame);
        verleihFrame.add(type);
        verleihFrame.add(motor);
        verleihFrame.add(battery);
        verleihFrame.add(reciever);
        verleihFrame.add(price);
        verleihFrame.add(totalPrice);
        verleihFrame.add(user);
        verleihFrame.add(verleihList);
        verleihFrame.add(basektList);
        verleihFrame.add(backB);
        verleihFrame.add(removeB);
        verleihFrame.add(addB);
        verleihFrame.add(basketL);
        verleihFrame.add(verleihL);
        verleihFrame.add(checkoutB);
        verleihFrame.setSize(945, 575);
        verleihFrame.setLayout(null);
        verleihFrame.setLocationRelativeTo(null);
        verleihFrame.setVisible(true);
        verleihFrame.setResizable(false);
        verleihFrame.getContentPane().add(panel);
        verleihFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        verleihList.getSelectionModel().addListSelectionListener(e -> update());

        backB.addActionListener(e -> {
            new MainMenuFrame(account);
            verleihFrame.dispose();
        });

        checkoutB.addActionListener(e -> {
            if(!basektListItems.isEmpty()){
                float price = BasketHandleing.checkout(account);
                basektListItems.removeAllElements();
                update();
                JOptionPane.showMessageDialog(verleihFrame,"Das Verleihportal wird Ihnen eine Rechnung von " +price+"€ schicken.\n" +
                        "Für diese Transaktion gab es " + (int)price/10+ " Bonuspunkte.");
            }else{
                JOptionPane.showMessageDialog(verleihFrame,"Warenkorb ist leer.");
            }

        });

        addB.addActionListener(e -> {
            if(verleihList.getSelectedIndex()<0){
                JOptionPane.showMessageDialog(verleihFrame,"Kein Angebot ausgewählt!");
                return;
            }
            Angebot a = verleihList.getSelectedValue();
            BasketHandleing.addToBasket(verleihportal,a,account);
            verleihListItems.removeElement(a);
            basektListItems.addElement(a);
            update();
        });

        removeB.addActionListener(e -> {
            if(basektList.getSelectedIndex()<0){
                JOptionPane.showMessageDialog(verleihFrame,"Kein Angebot im Warenkorb ausgewählt!");
                return;
            }
            Angebot a = basektList.getSelectedValue();
            BasketHandleing.removeFromBasket(verleihportal,a,account);
            basektListItems.removeElement(a);
            verleihListItems.addElement(a);
            update();
        });
    }

    private void update() {
        if(verleihList.getSelectedIndex()<0){
            user.setText("");
            frame.setText("");
            motor.setText("");
            battery.setText("");
            type.setText("");
            reciever.setText("");
            price.setText("");
            totalPrice.setText(account.getBasket().getTotalPrice()+"€");
            return;
        }

        Angebot offer = verleihList.getSelectedValue();
        ArrayList<Hauptkomponente> hauptkomponenten = offer.getModellflugzeug().getRahmen().getHauptkomponenten();
        user.setText(offer.getUsername());
        frame.setText(offer.getModellflugzeug().getRahmen().toString());
        for(Hauptkomponente comp: hauptkomponenten){
            if(comp instanceof Motor){
                motor.setText(comp.toString());
            }else if(comp instanceof Akku){
                battery.setText(comp.toString());
            }else if(comp instanceof Empfaenger){
                reciever.setText(comp.toString());
            }
            type.setText(offer.getModellflugzeug().getFerncontroller().toString());
            price.setText(offer.getRentingPrice()+"€");

            totalPrice.setText(account.getBasket().getTotalPrice()+"€");
        }


    }

    /**
     * Methode um das Verleihportal dem View hinzuzufuegen.
     * @param verleihportal Das Verleihportal.
     */
    public static void addVerleih(Verleihportal verleihportal){
        VerleihFrame.verleihportal = verleihportal;
    }
}
