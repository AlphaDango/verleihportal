package tuc.isse.view;

import tuc.isse.controller.OfferHandleing;
import tuc.isse.controller.exceptions.OutOfSlots;
import tuc.isse.model.flugzeugteile.*;
import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Verleihportal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Das verleihen Menue.
 * Hier koennen Nutzer ihre Modellflugzeuge konfigurieren
 * und zum verleih anbieten.
 * @author Oliver Neumann
 * @version 1.0
 */
public class VerleihenFrame extends JFrame {

    private Account account;

    private static Verleihportal verleihportal;

    private final JFrame verleihenFrame = new JFrame("Angebot erstellen");

    private JList<Rahmen> frameList;
    private JList<Motor> motorList;
    private JList<Empfaenger> recieverList;
    private JList<Akku> batteryList;
    private JList<Flugzeugtyp> typeList;
    private JTextField frameSlotsT;
    private JTextArea descriptionBox;
    private JTextField priceT;

    public VerleihenFrame(Account account){
        this.account = account;
        //FrameList
        frameList = new JList<>();
        DefaultListModel<Rahmen> frameListItems = new DefaultListModel<>();
        frameList.setModel(frameListItems);
        frameListItems.addElement(new Rahmen(220,1,50f,"BasicFrame","Ein einfacher Aluminiumrahmen",3));
        frameListItems.addElement(new Rahmen(221,2,100f,"PremiumFrame","Ein einfacher Aluminiumrahmen \nmit einem extra Slot",6));
        frameListItems.addElement(new Rahmen(222,3,200f,"Professional","Ein Professioneller Carbonrahmen\n mit vielen Slots",8));
        frameListItems.addElement(new Rahmen(223,4,300f,"HighTec","Großer und leichter Rahmen bei denen \nes an nichts fehlt",10));


        //MotorList
        motorList = new JList<>();
        DefaultListModel<Motor> motorListItems = new DefaultListModel<>();
        motorList.setModel(motorListItems);
        motorListItems.addElement(new Motor(351,18,100f,"RotorBasic","Ein einfacher Propellermotor",1));
        motorListItems.addElement(new Motor(352,19,200f,"TwinTurbine","Ein zwei Turbinenantrieb",2));
        motorListItems.addElement(new Motor(353,20,500f,"QuadTurbine","Ein vier Turbinenantrieb",4));


        //ReciverList
        recieverList = new JList<>();
        DefaultListModel<Empfaenger> recieverListItems = new DefaultListModel<>();
        recieverList.setModel(recieverListItems);
        recieverListItems.addElement(new Empfaenger(444,12,10f,"LowRange","Empfänger mit niedriger Reichweite",1));
        recieverListItems.addElement(new Empfaenger(445,13,50f,"MidRange","Empfänger mit mittlerer Reichweite",2));
        recieverListItems.addElement(new Empfaenger(446,13,150f,"LongRange","Empfänger mit großer Reichweite",3));


        //BatteryList
        batteryList = new JList<>();
        DefaultListModel<Akku> batteryListItems = new DefaultListModel<>();
        batteryList.setModel(batteryListItems);
        batteryListItems.addElement(new Akku(575,32,50f,"LowCap","Akku mit 100Wh.",1));
        batteryListItems.addElement(new Akku(576,33,100f,"MediumCap","Akku mit 200Wh.",1));
        batteryListItems.addElement(new Akku(577,34,150f,"HighCap","Akku mit 300Wh.",2));
        batteryListItems.addElement(new Akku(578,35,200f,"DualMedCap","Zwei Medium Akkus parallel geschalten.\n400Wh.",2));


        //Type
        typeList = new JList<>();
        DefaultListModel<Flugzeugtyp> typeListItems = new DefaultListModel<>();
        typeList.setModel(typeListItems);
        for(Flugzeugtyp typ: Flugzeugtyp.values())
            typeListItems.addElement(typ);

        JTextField planeName = new JTextField(1);
        JLabel planeNameL = new JLabel("Flugzeugname");
        JLabel frameListL = new JLabel("Rahmen");
        JLabel motorListL = new JLabel("Motor");
        JLabel batteryListL = new JLabel("Akku");
        JLabel recieverListL = new JLabel("Empfänger");
        JLabel typeL = new JLabel("Fliegertyp");
        frameSlotsT = new JTextField(1);
        descriptionBox = new JTextArea(5, 5);
        JButton verleihenB = new JButton("Verleihen");
        JButton backB = new JButton("Zurück");
        priceT = new JTextField(1);
        JLabel priceL = new JLabel("Verleihpreis");
        JLabel descriptionL = new JLabel("Beschreibung");
        frameSlotsT.setEnabled (false);
        priceT.setEnabled (false);

        frameList.setBounds (35, 100, 100, 75);
        motorList.setBounds (35, 205, 100, 75);
        typeList.setBounds (225, 205, 100, 75);
        recieverList.setBounds (225, 320, 100, 75);
        batteryList.setBounds (35, 320, 100, 75);
        planeName.setBounds (35, 40, 100, 25);
        planeNameL.setBounds (35, 15, 90, 25);
        frameListL.setBounds (35, 75, 100, 25);
        motorListL.setBounds (35, 180, 100, 25);
        typeL.setBounds (225, 180, 100, 25);
        batteryListL.setBounds (35, 295, 100, 25);
        recieverListL.setBounds (225, 295, 100, 25);
        frameSlotsT.setBounds (145, 125, 25, 25);
        descriptionBox.setBounds (225, 40, 235, 120);
        verleihenB.setBounds (35, 430, 100, 25);
        backB.setBounds (350, 430, 100, 25);
        priceT.setBounds (350, 365, 100, 25);
        priceL.setBounds (350, 340, 100, 25);
        descriptionL.setBounds (225, 15, 100, 25);

        JPanel panel = new JPanel();
        panel.setVisible (true);
        panel.setPreferredSize (new Dimension(480, 500));
        panel.setLayout (null);

        verleihenFrame.add(typeL);
        verleihenFrame.add(frameList);
        verleihenFrame.add(motorList);
        verleihenFrame.add(typeList);
        verleihenFrame.add(recieverList);
        verleihenFrame.add(batteryList);
        verleihenFrame.add(planeName);
        verleihenFrame.add(planeNameL);
        verleihenFrame.add(frameList);
        verleihenFrame.add(frameListL);
        verleihenFrame.add(motorListL);
        verleihenFrame.add(batteryListL);
        verleihenFrame.add(recieverListL);
        verleihenFrame.add(frameSlotsT);
        verleihenFrame.add(descriptionBox);
        verleihenFrame.add(verleihenB);
        verleihenFrame.add(backB);
        verleihenFrame.add(priceT);
        verleihenFrame.add(priceL);
        verleihenFrame.add(descriptionL);
        verleihenFrame.setSize(480, 500);
        verleihenFrame.setLayout(null);
        verleihenFrame.setLocationRelativeTo(null);
        verleihenFrame.setVisible(true);
        verleihenFrame.setResizable(false);
        verleihenFrame.getContentPane().add(panel);
        verleihenFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        backB.addActionListener(e -> {
            new AccountFrame(account);
            verleihenFrame.dispose();
        });

        frameList.getSelectionModel().addListSelectionListener(e ->{
            update();
            descriptionBox.setText(frameList.getSelectedValue().getBeschreibung());
        });

        typeList.getSelectionModel().addListSelectionListener(e -> update());

        motorList.getSelectionModel().addListSelectionListener(e -> {
            update();
            descriptionBox.setText(motorList.getSelectedValue().getBeschreibung());
        });

        recieverList.getSelectionModel().addListSelectionListener(e -> {
            update();
            descriptionBox.setText(recieverList.getSelectedValue().getBeschreibung());
        });

        batteryList.getSelectionModel().addListSelectionListener(e -> {
            update();
            descriptionBox.setText(batteryList.getSelectedValue().getBeschreibung());
        });

        verleihenB.addActionListener(e -> {

            if(frameList.getSelectedIndex()<0||motorList.getSelectedIndex()<0||recieverList.getSelectedIndex()<0||
                    batteryList.getSelectedIndex()<0||typeList.getSelectedIndex()<0){
                JOptionPane.showMessageDialog(verleihenFrame,"Es wurde noch überall etwas ausgewählt!");
                return;
            }else if(planeName.getText().isEmpty()){
                JOptionPane.showMessageDialog(verleihenFrame,"Flugzeugname fehlt!");
                return;
            }

            Rahmen rahmen = frameList.getSelectedValue();
            Motor motor = motorList.getSelectedValue();
            Empfaenger empfaenger = recieverList.getSelectedValue();
            Akku akku = batteryList.getSelectedValue();
            Flugzeugtyp typ = typeList.getSelectedValue();
            Ferncontroller ferncontroller;

            switch (typ){
                case Hybrid:
                    ferncontroller = new Ferncontroller(81,100,300f,"Hybridcontroller","Fernsteuerung für einen Hybriden Flieger");
                    break;
                case Autonom:
                    ferncontroller = new Ferncontroller(82,101,200f,"Autonomcontroller","Fernsteuerung für einen Autonomen Flieger");
                    break;
                case Ferngesteuert:
                    ferncontroller = new Ferncontroller(82,103,100f,"Standardcontroller","Fernsteuerung für einen Flieger");
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + typ);
            }

            try {
                OfferHandleing.createNewOffer(verleihportal,account,planeName.getText(),rahmen,motor,empfaenger,akku,typ,ferncontroller);
            } catch (OutOfSlots outOfSlots) {
                outOfSlots.printStackTrace();
                JOptionPane.showMessageDialog(verleihenFrame,outOfSlots.toString());
                return;
            }

            JOptionPane.showMessageDialog(verleihenFrame,"Anzeige erstellt!");
            new AccountFrame(account);
            verleihenFrame.dispose();

        });

    }

    private void update(){
        int freeSlots = 0;
        float price = 0f;

        if(frameList.getSelectedIndex()>=0){
            freeSlots += frameList.getSelectedValue().getFreeCompSlots();
            price += frameList.getSelectedValue().getPreis();
        }

        if(motorList.getSelectedIndex()>=0){
            freeSlots -= motorList.getSelectedValue().getTakingSlots();
            price += motorList.getSelectedValue().getPreis();
        }

        if(recieverList.getSelectedIndex()>=0){
            freeSlots -= recieverList.getSelectedValue().getTakingSlots();
            price += recieverList.getSelectedValue().getPreis();
        }

        if(batteryList.getSelectedIndex()>=0){
            freeSlots -= batteryList.getSelectedValue().getTakingSlots();
            price += batteryList.getSelectedValue().getPreis();
        }

        if(typeList.getSelectedIndex()>=0)
            price += 100*(typeList.getSelectedIndex()+1);

        priceT.setText(Float.toString(price/10));
        frameSlotsT.setText(Integer.toString(freeSlots));
    }

    /**
     * Methode um das Verleihportal dem View hinzuzufuegen.
     * @param verleihportal Das Verleihportal.
     */
    public static void addVerleih(Verleihportal verleihportal){
        VerleihenFrame.verleihportal = verleihportal;
    }
}
