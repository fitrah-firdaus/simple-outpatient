package org.simple.clinic.outpatient.view;

import org.simple.clinic.outpatient.service.HelloService;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class Login {

    private final HelloService helloService;

    private final JPanel panel = new JPanel();

    public Login(HelloService helloService) {
        this.helloService = helloService;
    }

    public JPanel createLayout() {
        setLayout();
        build();
        panel.setVisible(true);
        return panel;
    }

    private void setLayout() {
        GridLayout gridLayout = new GridLayout(0, 2);
        panel.setLayout(gridLayout);
    }

    private void build() {
        JLabel loginLabel = new JLabel("UserName");
        JTextField loginText = new JTextField();
        loginText.setColumns(20);

        JLabel passwordLabel = new JLabel("Password");
        JPasswordField passwordField = new JPasswordField();
        passwordField.setColumns(32);

        JButton okButton = new JButton("Login");
        okButton.setSize(0, 10);
        okButton.addActionListener(action -> JOptionPane.showMessageDialog(okButton, helloService.helloWorld()));

        panel.add(loginLabel);
        panel.add(loginText);

        panel.add(passwordLabel);
        panel.add(passwordField);

        JPanel panelButton = new JPanel();
        panelButton.setLayout(new GridLayout(0, 3));
        panelButton.setVisible(true);
        panelButton.add(okButton);
        panel.add(panelButton);
    }
}
