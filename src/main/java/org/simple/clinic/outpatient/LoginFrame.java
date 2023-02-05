/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.simple.clinic.outpatient;

import java.util.function.Consumer;
import javax.swing.JOptionPane;
import org.simple.clinic.outpatient.model.Permission;
import org.simple.clinic.outpatient.model.User;
import org.simple.clinic.outpatient.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author fef339
 */
@SpringBootApplication
public class LoginFrame extends javax.swing.JFrame {
    
    private static final Logger logger = LoggerFactory.getLogger(LoginFrame.class);

    @Autowired
    private MainOutpatientFrame mainOutpatientFrame;

    @Autowired
    private UserService userService;

    /**
     * Creates new form LoginFrame
     *
     */
    public LoginFrame() {
        initComponents();
    }
    
    public void clearData() {
        userNameFld.setText("");
        passwordFld.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userNameLbl = new javax.swing.JLabel();
        passwordLbl = new javax.swing.JLabel();
        userNameFld = new javax.swing.JTextField();
        passwordFld = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplikasi Rawat Jalan");

        userNameLbl.setText("Username");

        passwordLbl.setText("Password");

        loginBtn.setText("Login");
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameLbl)
                    .addComponent(passwordLbl))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(loginBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addComponent(clearBtn))
                    .addComponent(userNameFld)
                    .addComponent(passwordFld))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userNameLbl)
                    .addComponent(userNameFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLbl)
                    .addComponent(passwordFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginBtn)
                    .addComponent(clearBtn))
                .addContainerGap(267, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
        User user = userService.login(userNameFld.getText(), new String(passwordFld.getPassword()));
        if (user != null) {
            if(user.getRoleId() != null && user.getRoleId().getPermissionList() != null && !user.getRoleId().getPermissionList().isEmpty()) {
                user.getRoleId().getPermissionList().forEach((Permission t) -> {
                    logger.info(t.getMenuId().toString());
                });
            }
            mainOutpatientFrame.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Username and password didn't match");
        }
    }//GEN-LAST:event_loginBtnMouseClicked

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        clearData();
    }//GEN-LAST:event_clearBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordFld;
    private javax.swing.JLabel passwordLbl;
    private javax.swing.JTextField userNameFld;
    private javax.swing.JLabel userNameLbl;
    // End of variables declaration//GEN-END:variables
}
