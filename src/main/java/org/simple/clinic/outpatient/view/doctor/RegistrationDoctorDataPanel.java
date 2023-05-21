/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.simple.clinic.outpatient.view.doctor;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import org.simple.clinic.outpatient.model.Doctor;
import org.simple.clinic.outpatient.repository.DoctorRepository;
import org.simple.clinic.outpatient.service.DoctorRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author fef339
 */
@Component
public class RegistrationDoctorDataPanel extends javax.swing.JPanel {
    
    private static final Logger logger = LoggerFactory.getLogger(RegistrationDoctorDataPanel.class);
    
    private final DoctorRegistrationService doctorRegistrationService;
    
    private final RegistrationDoctorPanel registrationDoctorPanel;

    /**
     * Creates new form RegistrationDoctorDataPanel
     * @param doctorRegistrationService
     * @param registrationDoctorPanel
     */
    public RegistrationDoctorDataPanel(DoctorRegistrationService doctorRegistrationService, RegistrationDoctorPanel registrationDoctorPanel) {
        initComponents();
        this.doctorRegistrationService = doctorRegistrationService;
        this.registrationDoctorPanel = registrationDoctorPanel;
    }
    
    private void clearDataDoctorTable(){
        DefaultTableModel model = (DefaultTableModel) doctorTbl.getModel();
        model.setRowCount(0);
    }
    
    public void loadData() {
        List<Doctor> doctorList = doctorRegistrationService.findAll();
        clearDataDoctorTable();
        DefaultTableModel model = (DefaultTableModel) doctorTbl.getModel();
        for (int i = 0; i < doctorList.size(); i++) {
            Doctor get = doctorList.get(i);
            model.addRow(new Object[]{
                get.getDoctorId().toString(),
                get.getDoctorName(),
                get.getSpecialist()
            });
        }
    }
    
    private void showRegistrationDoctorPanel() {
        registrationDoctorPanel.setRegistrationDoctorDataPanel(this);
        registrationDoctorPanel.clearData();
        JViewport viewport = (JViewport) 
                this.getParent();
        viewport.removeAll();
        viewport.setView(registrationDoctorPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addDoctorBtn = new javax.swing.JButton();
        updateDoctorBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        doctorTbl = new javax.swing.JTable();
        deleteDoctorBtn = new javax.swing.JButton();

        addDoctorBtn.setText("Add Doctor");
        addDoctorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoctorBtnActionPerformed(evt);
            }
        });

        updateDoctorBtn.setText("Update Doctor");
        updateDoctorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDoctorBtnActionPerformed(evt);
            }
        });

        doctorTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Doctor Id", "Doctor Name", "Specialist"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(doctorTbl);

        deleteDoctorBtn.setText("Delete Doctor");
        deleteDoctorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDoctorBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addDoctorBtn)
                .addGap(18, 18, 18)
                .addComponent(updateDoctorBtn)
                .addGap(18, 18, 18)
                .addComponent(deleteDoctorBtn))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDoctorBtn)
                    .addComponent(updateDoctorBtn)
                    .addComponent(deleteDoctorBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addDoctorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoctorBtnActionPerformed
        showRegistrationDoctorPanel();
    }//GEN-LAST:event_addDoctorBtnActionPerformed

    private void updateDoctorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateDoctorBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) doctorTbl.getModel();
        int rowSelected = doctorTbl.getSelectedRow();
        
        String id = (String) model.getValueAt(rowSelected, 0);
        showRegistrationDoctorPanel();
        registrationDoctorPanel.loadDataById(Integer.parseInt(id));
    }//GEN-LAST:event_updateDoctorBtnActionPerformed

    private void deleteDoctorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDoctorBtnActionPerformed
        DefaultTableModel model = (DefaultTableModel) doctorTbl.getModel();
        int rowSelected = doctorTbl.getSelectedRow();
        
        String id = (String) model.getValueAt(rowSelected, 0);
        int optionChoose = JOptionPane.showConfirmDialog(this, "Are You sure want to delete the data", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if(optionChoose == 0){
            Doctor doctor = doctorRegistrationService.deleteDoctor(Integer.parseInt(id));
            if(doctor.getIsDeleted()){
                JOptionPane.showMessageDialog(this, "You have deleted the data");
                loadData();
            }
        }
    }//GEN-LAST:event_deleteDoctorBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDoctorBtn;
    private javax.swing.JButton deleteDoctorBtn;
    private javax.swing.JTable doctorTbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton updateDoctorBtn;
    // End of variables declaration//GEN-END:variables
}
