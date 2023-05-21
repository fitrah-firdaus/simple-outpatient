/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package org.simple.clinic.outpatient.view.doctor;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import javax.swing.JOptionPane;
import javax.swing.JViewport;
import javax.swing.table.DefaultTableModel;
import org.simple.clinic.outpatient.model.Doctor;
import org.simple.clinic.outpatient.model.DoctorSchedule;
import org.simple.clinic.outpatient.service.DoctorRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 *
 * @author fef339
 */
@Component
public class RegistrationDoctorPanel extends javax.swing.JPanel {
    
    private static final Logger logger = LoggerFactory.getLogger(RegistrationDoctorPanel.class);
    
    private final DoctorRegistrationService doctorRegistrationService;
    
    private RegistrationDoctorDataPanel registrationDoctorDataPanel;
    
    private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");

    /**
     * Creates new form RegistrationDoctorPanel
     * @param doctorRegistrationService
     */
    public RegistrationDoctorPanel(DoctorRegistrationService doctorRegistrationService) {
        initComponents();
        doctorIdLbl.setVisible(false);
        this.doctorRegistrationService = doctorRegistrationService;
    }

    public void setRegistrationDoctorDataPanel(RegistrationDoctorDataPanel registrationDoctorDataPanel) {
        this.registrationDoctorDataPanel = registrationDoctorDataPanel;
    }
    
    
    public void clearData() {
        doctorNameTxt.setText("");
        doctorSpecialistTxt.setText("");
        clearDataSchedule();
    }
    
    private void clearDataSchedule() {
        DefaultTableModel model = (DefaultTableModel) doctorScheduleTbl.getModel();
        model.setRowCount(0);
    }
    
    private void addDataSchedule() {
        DefaultTableModel model = (DefaultTableModel) doctorScheduleTbl.getModel();
        model.addRow(new Object[]{});
    }
    
    public void loadDataById(int id){
        Doctor doctor = doctorRegistrationService.findDoctorById(id);
        if(doctor != null){
            logger.info("SET DATA");
            setData(doctor);
        } else {
            logger.info("CLEAR DATA");
            clearData();
        }
    }
    
    private void setData(Doctor doctor){
        doctorNameTxt.setText(doctor.getDoctorName());
        doctorIdLbl.setText(doctor.getDoctorId().toString());
        doctorSpecialistTxt.setText(doctor.getSpecialist());
        setDataSchedule(doctor.getDoctorScheduleList());
    }
    
    private void setDataSchedule(List<DoctorSchedule> doctorScheduleList){
        clearDataSchedule();
        DefaultTableModel model = (DefaultTableModel) doctorScheduleTbl.getModel();
        for (int i = 0; i < doctorScheduleList.size(); i++) {
            DoctorSchedule get = doctorScheduleList.get(i);
            model.addRow(new Object[]{
                get.getDay(),
                get.getStartTime().toString(),
                get.getEndTime().toString()
            });
        }
    }
    
    private void loadRegistrationDoctorDataPanel() {
        logger.info(this.getParent().
                toString());
        JViewport viewport = (JViewport) this.
                getParent();
        viewport.removeAll();
        viewport.setView(registrationDoctorDataPanel);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        doctorNameLbl = new javax.swing.JLabel();
        doctorNameTxt = new javax.swing.JTextField();
        doctorSpecialistLbl = new javax.swing.JLabel();
        doctorSpecialistTxt = new javax.swing.JTextField();
        doctorRegistrationBtn = new javax.swing.JButton();
        doctorSchedulePane = new javax.swing.JScrollPane();
        doctorScheduleTbl = new javax.swing.JTable();
        doctorIdLbl = new javax.swing.JLabel();
        addScheduleBtn = new javax.swing.JButton();

        jButton1.setText("jButton1");

        doctorNameLbl.setText("Doctor Name");

        doctorSpecialistLbl.setText("Specialist");

        doctorRegistrationBtn.setText("Register Doctor");
        doctorRegistrationBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorRegistrationBtnActionPerformed(evt);
            }
        });

        doctorScheduleTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Day", "Start Date", "End Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        doctorSchedulePane.setViewportView(doctorScheduleTbl);

        addScheduleBtn.setText("Add Schedule");
        addScheduleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addScheduleBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(doctorRegistrationBtn)
                .addGap(412, 412, 412))
            .addGroup(layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doctorNameLbl)
                    .addComponent(doctorSpecialistLbl))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(doctorSpecialistTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(doctorNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(268, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addScheduleBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(doctorIdLbl)
                        .addGap(76, 76, 76)
                        .addComponent(doctorSchedulePane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(223, 223, 223))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doctorNameLbl)
                    .addComponent(doctorNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(doctorSpecialistLbl)
                    .addComponent(doctorSpecialistTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(doctorIdLbl)
                        .addGap(79, 79, 79))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addScheduleBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doctorSchedulePane, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)))
                .addComponent(doctorRegistrationBtn)
                .addContainerGap(364, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void doctorRegistrationBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorRegistrationBtnActionPerformed
        Doctor doctor = new Doctor();
        if(!doctorIdLbl.getText().isEmpty()){
            doctor = doctorRegistrationService.findDoctorById(Integer.parseInt(doctorIdLbl.getText()));
        }
        doctor.setDoctorName(doctorNameTxt.getText());
        doctor.setSpecialist(doctorSpecialistTxt.getText());
        
        DefaultTableModel model = (DefaultTableModel) doctorScheduleTbl.getModel();
        List<DoctorSchedule> doctorScheduleList = new LinkedList<>();
        for (int i = 0; i < model.getRowCount(); i++) {
            try {
                DoctorSchedule doctorSchedule = new DoctorSchedule();
                doctorSchedule.setDoctorId(doctor);
                doctorSchedule.setDay((String) model.getValueAt(i, 0));
                doctorSchedule.setStartTime(sdf.parse((String) model.getValueAt(i, 1)));
                doctorSchedule.setEndTime(sdf.parse((String) model.getValueAt(i, 2)));
                doctorSchedule.setDateCreated(new Date());
                doctorScheduleList.add(doctorSchedule);
            } catch (ParseException ex) {
                java.util.logging.Logger.getLogger(RegistrationDoctorPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        doctor.setDoctorScheduleList(doctorScheduleList);
        
        if(doctor.getDoctorId() != null){
            doctorRegistrationService.updateDoctor(doctor.getDoctorId(),
                    doctor.getDoctorName(), doctor.getSpecialist(), doctorScheduleList);
            JOptionPane.showMessageDialog(this, "Doctor updated with id " + doctor.getDoctorId());
            registrationDoctorDataPanel.loadData();
            loadRegistrationDoctorDataPanel();
        } else {
            Doctor savedDoctor = doctorRegistrationService.saveDoctor(
                    doctor.getDoctorName(), doctor.getSpecialist(), doctorScheduleList);
            JOptionPane.showMessageDialog(this, "Doctor created with id " + savedDoctor.getDoctorId());
            registrationDoctorDataPanel.loadData();
            loadRegistrationDoctorDataPanel();
        }
    }//GEN-LAST:event_doctorRegistrationBtnActionPerformed

    private void addScheduleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addScheduleBtnActionPerformed
        addDataSchedule();
    }//GEN-LAST:event_addScheduleBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addScheduleBtn;
    private javax.swing.JLabel doctorIdLbl;
    private javax.swing.JLabel doctorNameLbl;
    private javax.swing.JTextField doctorNameTxt;
    private javax.swing.JButton doctorRegistrationBtn;
    private javax.swing.JScrollPane doctorSchedulePane;
    private javax.swing.JTable doctorScheduleTbl;
    private javax.swing.JLabel doctorSpecialistLbl;
    private javax.swing.JTextField doctorSpecialistTxt;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
