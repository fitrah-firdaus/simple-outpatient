package org.simple.clinic.outpatient.view;

import javax.swing.JFrame;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MainFrame {

    private final JFrame frame;

    public MainFrame(@Value("${application.name}") String appName) {
        frame = new JFrame();
        frame.setTitle(appName);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void repaint() {
        frame.setSize(1024, 768);
        frame.setVisible(true);
        frame.pack();
    }

}
