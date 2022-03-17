package tuc.isse.view;

import tuc.isse.controller.exceptions.InvalidPassword;
import tuc.isse.controller.exceptions.UnkownUser;
import tuc.isse.controller.AccountHandleing;
import tuc.isse.model.verleih.Account;
import tuc.isse.model.verleih.Verleihportal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Das Anmeldefenster.
 * @author Oliver Neumann
 * @version 1.0
 */
public class LoginFrame extends JFrame {

    private static Verleihportal verleihportal;

    private final JFrame loginFrame = new JFrame("Login Frame");

    public LoginFrame() {

        //Init Labels
        JLabel panelLabel = new JLabel("Loginpanel");
        JLabel usernameL = new JLabel("Username");
        JLabel passwordL = new JLabel("Password");
        panelLabel.setBounds (115, 10, 100, 25);
        usernameL.setBounds (45, 90, 70, 25);
        passwordL.setBounds (45, 120, 70, 25);

        //Init buttons
        JButton loginButton = new JButton("Login");
        JButton regsiterButton = new JButton("Register");
        loginButton.setBounds (115, 155, 100, 20);
        regsiterButton.setBounds (225, 155, 140, 20);

        //Init TextFields
        JPasswordField passwordTF = new JPasswordField(1);
        JTextField userNameTF = new JTextField(1);
        passwordTF.setBounds (115, 120, 250, 25);
        userNameTF.setBounds (115, 90, 250, 25);

        //add components


        //init panel
        JPanel panel = new JPanel();
        panel.setVisible (true);
        panel.setPreferredSize (new Dimension(481, 286));
        panel.setLayout (null);

        //init frame
        loginFrame.add(loginButton);
        loginFrame.add(regsiterButton);
        loginFrame.add(passwordTF);
        loginFrame.add(userNameTF);
        loginFrame.add(panelLabel);
        loginFrame.add(usernameL);
        loginFrame.add(passwordL);
        loginFrame.setSize(481,286);
        loginFrame.setLayout(null);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        loginFrame.setResizable(false);
        loginFrame.getContentPane().add(panel);
        loginFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        regsiterButton.addActionListener(e -> {
            new RegisterFrame();
            loginFrame.dispose();
        });

        loginButton.addActionListener(e -> {
            try {
                Account user = AccountHandleing.loginUser(verleihportal,userNameTF.getText(),String.valueOf(passwordTF.getPassword()));
                new MainMenuFrame(user);
                loginFrame.dispose();
            } catch (InvalidPassword | UnkownUser exception) {
                JOptionPane.showMessageDialog(loginFrame,exception.toString());
            }
        });
    }

    /**
     * Methode um das Verleihportal dem View hinzuzufuegen.
     * @param verleihportal Das Verleihportal.
     */
    public static void addVerleih(Verleihportal verleihportal){
        LoginFrame.verleihportal = verleihportal;
    }
}
