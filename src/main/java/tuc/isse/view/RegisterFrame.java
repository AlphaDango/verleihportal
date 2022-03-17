package tuc.isse.view;

import tuc.isse.controller.exceptions.PasswordNotIdentical;
import tuc.isse.controller.AccountHandleing;
import tuc.isse.controller.exceptions.UserNameAlreadyTaken;
import tuc.isse.model.Adress;
import tuc.isse.model.verleih.Verleihportal;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * Das registrierungs Menue.
 * Hier koennen User sich ein neues Nutzerkonto anlegen.
 * @author Oliver Neumann
 * @version 1.0
 */
public class RegisterFrame extends JFrame{

    private static Verleihportal verleihportal;

    private final JFrame registerFrame = new JFrame("Register Frame");

    public RegisterFrame() {
        //ínit labels
        JLabel usernameL = new JLabel("Username");
        JLabel passwordL = new JLabel("Password");
        JLabel passwordReL = new JLabel("PasswordRe");
        JLabel landL = new JLabel("Land");
        JLabel plzL = new JLabel("PLZ");
        JLabel strasse_HausnummerL = new JLabel("Straße und Haus Nr.");
        JLabel stadtL = new JLabel("Stadt");
        JLabel nameL = new JLabel("Name");
        usernameL.setBounds (40, 45, 100, 25);
        passwordL.setBounds (40, 80, 100, 25);
        passwordReL.setBounds (25, 115, 100, 25);
        landL.setBounds (260, 80, 35, 25);
        plzL.setBounds (260, 115, 35, 25);
        strasse_HausnummerL.setBounds (180, 185, 120, 25);
        stadtL.setBounds (260, 150, 45, 25);
        nameL.setBounds (260, 45, 45, 20);

        //Buttons
        JButton zurueckB = new JButton("Zurück");
        JButton registerB = new JButton("Register");
        zurueckB.setBounds (400, 250, 100, 20);
        registerB.setBounds (205, 240, 100, 20);

        //Textfields
        JTextField landT = new JTextField(1);
        JTextField plzT = new JTextField(1);
        JTextField stadtT = new JTextField(1);
        JTextField strasseT = new JTextField(1);
        JTextField nameT = new JTextField(1);
        JTextField hausnumerT = new JTextField(1);
        JTextField usernameT = new JTextField(1);
        JPasswordField passwordT = new JPasswordField(1);
        JPasswordField passwordReT = new JPasswordField(1);
        landT.setBounds (325, 80, 100, 25);
        plzT.setBounds (325, 115, 100, 25);
        stadtT.setBounds (325, 150, 100, 25);
        strasseT.setBounds (325, 185, 100, 25);
        nameT.setBounds (325, 45, 100, 25);
        hausnumerT.setBounds (435, 185, 35, 25);
        usernameT.setBounds (110, 45, 100, 25);
        passwordT.setBounds (110, 80, 100, 25);
        passwordReT.setBounds (110, 115, 100, 25);

        //Panel
        JPanel panel = new JPanel();
        panel.setVisible (true);
        panel.setPreferredSize (new Dimension(530, 325));
        panel.setLayout (null);

        registerFrame.add (usernameT);
        registerFrame.add (nameT);
        registerFrame.add (passwordT);
        registerFrame.add (passwordReT);
        registerFrame.add (usernameL);
        registerFrame.add (passwordL);
        registerFrame.add (passwordReL);
        registerFrame.add (nameL);
        registerFrame.add (registerB);
        registerFrame.add (zurueckB);
        registerFrame.add(stadtL);
        registerFrame.add(stadtT);
        registerFrame.add(landL);
        registerFrame.add(landT);
        registerFrame.add(strasse_HausnummerL);
        registerFrame.add(strasseT);
        registerFrame.add(hausnumerT);
        registerFrame.add(plzL);
        registerFrame.add(plzT);
        registerFrame.add(zurueckB);
        registerFrame.setSize(530, 325);
        registerFrame.setLayout(null);
        registerFrame.setLocationRelativeTo(null);
        registerFrame.setVisible(true);
        registerFrame.setResizable(false);
        registerFrame.getContentPane().add(panel);
        registerFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        registerB.addActionListener(e -> {
            int plz = 0;
            try {
                plz = Integer.parseInt(plzT.getText());
            }catch (Exception exception){
                exception.printStackTrace();
            }
            Adress adress;
            try {
                adress = AccountHandleing.createNewAdress(landT.getText(),strasseT.getText(),stadtT.getText(),hausnumerT.getText(),plz);
                String[] passwordFields = {String.valueOf(passwordT.getPassword()), String.valueOf(passwordReT.getPassword())};
                AccountHandleing.createNewUser(verleihportal,adress,nameT.getText(),usernameT.getText(),passwordFields);
            } catch (PasswordNotIdentical | UserNameAlreadyTaken exception) {
                exception.printStackTrace();
            }
            JOptionPane.showMessageDialog(registerFrame,"Erfolgreich registriert.");
            new LoginFrame();
            registerFrame.dispose();
        });

        zurueckB.addActionListener(e -> {
            new LoginFrame();
            registerFrame.dispose();
        });
    }

    /**
     * Methode um das Verleihportal dem View hinzuzufuegen.
     * @param verleihportal Das Verleihportal.
     */
    public static void addVerleih(Verleihportal verleihportal){
        RegisterFrame.verleihportal = verleihportal;
    }
}
