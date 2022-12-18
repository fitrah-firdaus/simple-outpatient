package org.simple.clinic.outpatient;

import org.simple.clinic.outpatient.view.Login;
import org.simple.clinic.outpatient.view.MainFrame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class MainApp {

    private final Login login;

    private final MainFrame mainFrame;

    public MainApp(Login login, MainFrame mainFrame) {
        this.login = login;
        this.mainFrame = mainFrame;
    }

    private void initComponents() {
        JFrame main = mainFrame.getFrame();
        main.setContentPane(login.createLayout());
        mainFrame.repaint();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(MainApp.class).headless(false).run(args);
        EventQueue.invokeLater(() -> {
            MainApp app = ctx.getBean(MainApp.class);
            app.initComponents();
        });
    }
}
