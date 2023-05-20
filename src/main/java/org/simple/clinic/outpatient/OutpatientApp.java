/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.simple.clinic.outpatient;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 *
 * @author fef339
 */
public class OutpatientApp {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(
                LoginFrame.class).headless(false).run(args);
        java.awt.EventQueue.invokeLater(() -> {
            LoginFrame outpatient = ctx.getBean(LoginFrame.class);
            outpatient.setVisible(true);
        });
    }
}
