package tuc.isse.view;

import tuc.isse.model.verleih.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Das Hauptmenue.
 * Von hier koennen alle anderen Menues erreicht werden.
 * Von hier kann man sich ausloggen.
 * @author Oliver Neumann
 * @version 1.0
 */
public class MainMenuFrame extends JFrame {

    private Account account;

    private final JFrame mainMenu = new JFrame("Main Menu");

    public MainMenuFrame(Account account){
        this.account = account;

        JButton logoutB = new JButton("Logout");
        JButton accountB = new JButton("Account");
        JButton verleihB = new JButton("Verleih");
        JLabel usernameL = new JLabel(account.getUsername());
        JLabel welcomeL = new JLabel("Hallo,");

        logoutB.setBounds (120, 120, 100, 25);
        accountB.setBounds (120, 50, 100, 25);
        verleihB.setBounds (120, 85, 100, 25);
        usernameL.setBounds (125, 5, 85, 25);
        welcomeL.setBounds (90, 5, 40, 25);

        JPanel panel = new JPanel();
        panel.setVisible (true);
        panel.setPreferredSize (new Dimension(345, 185));
        panel.setLayout (null);

        mainMenu.add(logoutB);
        mainMenu.add(accountB);
        mainMenu.add(verleihB);
        mainMenu.add(usernameL);
        mainMenu.add(welcomeL);
        mainMenu.setSize(345,185);
        mainMenu.setLayout(null);
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);
        mainMenu.setResizable(false);
        mainMenu.getContentPane().add(panel);
        mainMenu.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        logoutB.addActionListener(e -> {
            this.account = null;
            new LoginFrame();
            mainMenu.dispose();
        });

        accountB.addActionListener(e -> {
            new AccountFrame(account);
            mainMenu.dispose();

        });

        verleihB.addActionListener(e -> {
            new VerleihFrame(account);
            mainMenu.dispose();
        });
    }
}
