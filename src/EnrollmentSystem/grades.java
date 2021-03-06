/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EnrollmentSystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Viver
 */
public class grades extends javax.swing.JFrame {

    /**
     * Creates new form grades
     */
    

    public grades() {
        initComponents();
    }
    
    public void updateGradesTable(){
        DefaultTableModel gradesTableModel = (DefaultTableModel) gradesTable.getModel();
        
        gradesTableModel.setRowCount(0);
        
        int idx = subjectTable.getSelectedRow();

        try{
            ResultSet rsGradesTable = EnrollmentSystem.con.createStatement().executeQuery(String.format("SELECT students.student_id, student_name, prelim, midterm, prefinal, final "
                    + "FROM enroll INNER JOIN grades ON enroll.enroll_id = grades.enroll_id AND enroll.subject_id = %s INNER JOIN students ON enroll.student_id = students.student_id;", subjectTable.getValueAt(idx, 0).toString()));
            
            while (rsGradesTable.next()){
                String id = rsGradesTable.getString("student_id");
                String nm = rsGradesTable.getString("student_name");
                String pr = rsGradesTable.getString("prelim");
                String md = rsGradesTable.getString("midterm");
                String pf = rsGradesTable.getString("prefinal");
                String fi = rsGradesTable.getString("final");
                
//                
                
                gradesTableModel.addRow(new String[]{id, nm, pr, md, pf, fi});
                
            }
  
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
    
    public void updateTableSubjects(){
        DefaultTableModel subjectTableModel = (DefaultTableModel) subjectTable.getModel();

        subjectTableModel.setRowCount(0);
        

       
        
//        System.out.println(pickedId);
        
        try{
            ResultSet rsSubjectTable = EnrollmentSystem.con.createStatement().executeQuery(String.format("SELECT subjects.subject_id, subject_code, subject_desc, subject_units, subject_sched, COUNT(enroll.student_id) AS studentCount "
                    + "FROM subjects INNER JOIN assign ON subjects.subject_id = assign.subject_id AND assign.teacher_id = %s LEFT OUTER JOIN enroll ON enroll.subject_id = subjects.subject_id GROUP BY enroll.subject_id;", Login.pickedId));
            
            while (rsSubjectTable.next()){
                String idd = rsSubjectTable.getString("subject_id");
                String cd = rsSubjectTable.getString("subject_code");
                String ds = rsSubjectTable.getString("subject_desc");
                String un = rsSubjectTable.getString("subject_units");
                String sc = rsSubjectTable.getString("subject_sched");
                String ct = rsSubjectTable.getString("studentCount");
                
                subjectTableModel.addRow(new String[]{idd, cd, ds, un, sc, ct});
                
            }
  
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        gradesTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        studentIdTF = new javax.swing.JTextField();
        studentNameTF = new javax.swing.JTextField();
        prelimCB = new javax.swing.JComboBox<String>();
        midtermCB = new javax.swing.JComboBox<String>();
        preFinalCB = new javax.swing.JComboBox<String>();
        finalCB = new javax.swing.JComboBox<String>();
        saveBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Teacher Class List/Grades Encoding Form");

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject ID", "Subject Code", "Description", "Units", "Schedule", "No. of Students"
            }
        ));
        subjectTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subjectTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(subjectTable);

        gradesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", "Student Name", "Prelim", "Midterm", "Pre-Final", "Final"
            }
        ));
        gradesTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gradesTableMouseClicked(evt);
            }
        });
        gradesTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                gradesTableKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(gradesTable);

        jLabel2.setText("Student ID");

        jLabel3.setText("Student Name");

        jLabel4.setText("Prelim");

        jLabel5.setText("Midterm ");

        jLabel6.setText("Pre-Final");

        jLabel7.setText("Final");

        studentIdTF.setEditable(false);
        studentIdTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentIdTFActionPerformed(evt);
            }
        });

        studentNameTF.setEditable(false);
        studentNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameTFActionPerformed(evt);
            }
        });

        prelimCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B+", "B", "C+", "C", "D", "F", "FD" }));
        prelimCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prelimCBActionPerformed(evt);
            }
        });

        midtermCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B+", "B", "C+", "C", "D", "F", "FD" }));

        preFinalCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B+", "B", "C+", "C", "D", "F", "FD" }));

        finalCB.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "", "A", "B+", "B", "C+", "C", "D", "F", "FD" }));

        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(studentIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(studentNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prelimCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(midtermCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(preFinalCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(finalCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(saveBtn)
                        .addGap(243, 243, 243)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(217, 217, 217))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(studentIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(prelimCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(preFinalCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(studentNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(midtermCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(finalCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveBtn)
                        .addGap(40, 40, 40)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentIdTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentIdTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentIdTFActionPerformed

    private void studentNameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentNameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_studentNameTFActionPerformed

    private void subjectTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subjectTableMouseClicked
        updateGradesTable();
    }//GEN-LAST:event_subjectTableMouseClicked

    private void prelimCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prelimCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prelimCBActionPerformed

    private void gradesTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_gradesTableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_gradesTableKeyPressed

    private void gradesTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gradesTableMouseClicked
        int idx = gradesTable.getSelectedRow();
         
        studentIdTF.setText(gradesTable.getValueAt(idx, 0).toString());
        studentNameTF.setText(gradesTable.getValueAt(idx, 1).toString());
        
        if (gradesTable.getValueAt(idx, 2) == null){
            prelimCB.setSelectedIndex(0);
        }else{
            prelimCB.setSelectedItem(gradesTable.getValueAt(idx, 2));
        }
        
        if (gradesTable.getValueAt(idx, 3) == null){
            midtermCB.setSelectedIndex(0);
        }else{
            midtermCB.setSelectedItem(gradesTable.getValueAt(idx, 3));
        }
        
        if (gradesTable.getValueAt(idx, 4) == null){
            preFinalCB.setSelectedIndex(0);
        }else{
            preFinalCB.setSelectedItem(gradesTable.getValueAt(idx, 4));
        }
        
        if (gradesTable.getValueAt(idx, 5) == null){
           finalCB.setSelectedIndex(0);
        }else{
            finalCB.setSelectedItem(gradesTable.getValueAt(idx, 5));
        }

    }//GEN-LAST:event_gradesTableMouseClicked

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        int idx = gradesTable.getSelectedRow();
        int idx2 = subjectTable.getSelectedRow();
        
        if (gradesTable.getSelectedRowCount() > 0){
            try{
                String query = "UPDATE enroll INNER JOIN grades ON enroll.enroll_id = grades.enroll_id INNER JOIN students ON enroll.student_id = students.student_id SET prelim = ?, midterm = ?, prefinal = ?, final = ? WHERE enroll.student_id = ? AND enroll.subject_id = ?";
                PreparedStatement st = EnrollmentSystem.con.prepareStatement(query);
                st.setString(1, prelimCB.getSelectedItem().toString());
                st.setString(2, midtermCB.getSelectedItem().toString());
                st.setString(3, preFinalCB.getSelectedItem().toString());
                st.setString(4, finalCB.getSelectedItem().toString());
                st.setString(5, gradesTable.getValueAt(idx, 0).toString());
                st.setString(6, subjectTable.getValueAt(idx2, 0).toString());

                st.executeUpdate();

                updateGradesTable();

                JOptionPane.showMessageDialog(this,"Grade Successfully edited");  

            }catch(Exception ex){
                System.out.println(ex);
            }
        }else{
            JOptionPane.showMessageDialog(this,"Please select a row from the Grades Table", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_saveBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new grades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> finalCB;
    private javax.swing.JTable gradesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> midtermCB;
    private javax.swing.JComboBox<String> preFinalCB;
    private javax.swing.JComboBox<String> prelimCB;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField studentIdTF;
    private javax.swing.JTextField studentNameTF;
    private javax.swing.JTable subjectTable;
    // End of variables declaration//GEN-END:variables
}
