package org.simple.clinic.outpatient;

import java.awt.EventQueue;

import javax.swing.JFrame;

import org.simple.clinic.outpatient.view.Login;
import org.simple.clinic.outpatient.view.MainFrame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MainApp {

    @Autowired
    private Login login;

    @Autowired
    private MainFrame mainFrame;

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
