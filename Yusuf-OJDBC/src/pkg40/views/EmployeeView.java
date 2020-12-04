/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.views;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import pkg40.controllers.DepartmentController;
import pkg40.controllers.EmployeeController;
import pkg40.controllers.JobController;
import pkg40.models.Department;
import pkg40.models.Employee;
import pkg40.models.Job;

/**
 *
 * @author Mochamad Yusuf
 */
public class EmployeeView extends javax.swing.JFrame {

    EmployeeController ec;
    DepartmentController dc;
    JobController jc;
    int searchColumn = 1;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd yyyy");
    DateFormatter dateFormatter = new DateFormatter(simpleDateFormat);
    String[] headers = {"No", "ID", "First Name", "Last Name", "Email", "Phone Number", "Hire Date",
        "Job", "Salary", "Commission", "Manager", "Deparment"};
    String[] columns = {"ID", "First Name", "Last Name", "Email", "Phone Number", "Hire Date",
        "Job", "Salary", "Commission", "Manager", "Deparment"};

    /**
     * Creates new form EmployeeView
     */
    public EmployeeView() {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        try {
            ec = new EmployeeController();
            jc = new JobController();
            dc = new DepartmentController();

            employeeTable.setModel(loadData("", 1, 1));
            // Manager Combo Box
            List<Employee> employees = ec.searchEmployee("", 1, 2);
            String employeeNames[] = new String[employees.size() + 1];

            employeeNames[0] = "No Manager";
            for (int i = 1; i < employeeNames.length; i++) {
                employeeNames[i] = employees.get(i - 1).getFirstName() + " " + employees.get(i - 1).getLastName();
            }
            managerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(employeeNames));

            // Department Combo Box
            List<Department> departments = dc.getAllDepartments(1);
            String departmentNames[] = new String[departments.size() + 1];

            departmentNames[0] = "No Department";
            for (int i = 1; i < departmentNames.length; i++) {
                departmentNames[i] = departments.get(i - 1).getName();
            }
            departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(departmentNames));

            // Job Combo Box
            List<Job> jobs = jc.getAllJobs(1);
            String jobNames[] = new String[jobs.size()];
            for (int i = 0; i < jobNames.length; i++) {
                jobNames[i] = jobs.get(i).getTitle();
            }
            jobComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(jobNames));

            // Search Combo Box
            searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(columns));

            // Date Picker
            hireDatePicker.setFormats("MMM dd, yyyy");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jFrame1 = new javax.swing.JFrame();
        jButton2 = new javax.swing.JButton();
        jDatePickerUtil1 = new org.jdatepicker.util.JDatePickerUtil();
        jDateComponentFactory1 = new org.jdatepicker.JDateComponentFactory();
        jDateComponentFactory2 = new org.jdatepicker.JDateComponentFactory();
        jDatePickerUtil2 = new org.jdatepicker.util.JDatePickerUtil();
        idTextField = new javax.swing.JTextField();
        firstNameTextField = new javax.swing.JTextField();
        lastNameTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        phoneTextField = new javax.swing.JTextField();
        jobComboBox = new javax.swing.JComboBox<>();
        commissionTextField = new javax.swing.JTextField();
        managerComboBox = new javax.swing.JComboBox<>();
        departmentComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        salaryField = new javax.swing.JSpinner();
        jScrollPane2 = new javax.swing.JScrollPane();
        employeeTable = new javax.swing.JTable();
        searchComboBox = new javax.swing.JComboBox<>();
        newIdButton = new javax.swing.JButton();
        hireDatePicker = new org.jdesktop.swingx.JXDatePicker();
        clearFieldsButton = new javax.swing.JButton();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 500));

        idTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTextFieldActionPerformed(evt);
            }
        });

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        phoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneTextFieldActionPerformed(evt);
            }
        });

        jobComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        managerComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        managerComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                managerComboBoxActionPerformed(evt);
            }
        });

        departmentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Employee id");

        jLabel2.setText("First name");

        jLabel3.setText("Last name");

        jLabel4.setText("Email");

        jLabel5.setText("Phone number");

        jLabel6.setText("Hire date");

        jLabel7.setText("Job");

        jLabel8.setText("Salary");

        jLabel9.setText("Commission Percentage");

        jLabel10.setText("Manager");

        jLabel11.setText("Department");

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        employeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        employeeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                employeeTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(employeeTable);

        searchComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        searchComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchComboBoxActionPerformed(evt);
            }
        });

        newIdButton.setText("New Id");
        newIdButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newIdButtonActionPerformed(evt);
            }
        });

        clearFieldsButton.setText("Clear Fields");
        clearFieldsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFieldsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(clearFieldsButton)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(deleteButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(saveButton, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(emailTextField)
                        .addComponent(phoneTextField)
                        .addComponent(commissionTextField)
                        .addComponent(managerComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(departmentComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addComponent(jLabel11)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(lastNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                        .addComponent(salaryField)
                        .addComponent(jobComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(idTextField))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(newIdButton))
                        .addComponent(hireDatePicker, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(searchButton)
                        .addComponent(searchComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(newIdButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addGap(0, 0, 0)
                        .addComponent(phoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addComponent(hireDatePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(jobComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(0, 0, 0)
                        .addComponent(salaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(0, 0, 0)
                        .addComponent(commissionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addGap(0, 0, 0)
                        .addComponent(managerComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(0, 0, 0)
                        .addComponent(departmentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearFieldsButton))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneTextFieldActionPerformed

    private void idTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTextFieldActionPerformed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        Employee employee;
        System.out.println("Job: " + jobComboBox.getSelectedItem().toString());
        System.out.println("Man: " + managerComboBox.getSelectedItem().toString());
        System.out.println("Dep: " + departmentComboBox.getSelectedItem().toString());
        try {
            employee = new Employee(
                    Integer.parseInt(idTextField.getText()),
                    firstNameTextField.getText(),
                    lastNameTextField.getText(),
                    emailTextField.getText(),
                    phoneTextField.getText(),
                    new Date(hireDatePicker.getDate().getTime()),
                    getJobId(),
                    Integer.parseInt(salaryField.getValue().toString()),
                    commissionTextField.getText().isEmpty() ? null : Float.parseFloat(commissionTextField.getText()),
                    getManagerId(),
                    getDepartmentId()
            );

            ec.saveEmployee(employee);
            employeeTable.setModel(loadData("", 1, 1));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void managerComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_managerComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_managerComboBoxActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        try {
            // TODO add your handling code here:
            employeeTable.setModel(loadData(searchTextField.getText(), 1, searchColumn));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchComboBoxActionPerformed
        // TODO add your handling code here:
        searchColumn = searchComboBox.getSelectedIndex() + 1;
        System.out.println(searchColumn);
    }//GEN-LAST:event_searchComboBoxActionPerformed

    private void newIdButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newIdButtonActionPerformed
        try {
            // TODO add your handling code here:
            idTextField.setText(ec.getNewId() + "");
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_newIdButtonActionPerformed

    private void employeeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_employeeTableMouseClicked
        // TODO add your handling code here:
        try {
            // TODO add your handling code here:
            int row = employeeTable.getSelectedRow();
            String id = employeeTable.getModel().getValueAt(row, 1).toString();
            Employee employee = ec.getById(Integer.parseInt(id));

            idTextField.setText(id);
            firstNameTextField.setText(employee.getFirstName());
            lastNameTextField.setText(employee.getLastName());
            emailTextField.setText(employee.getEmail());
            phoneTextField.setText(employee.getPhoneNumber());
            hireDatePicker.setDate(employee.getHireDate());
//            hireDateTextField.setText(simpleDateFormat.format(employee.getHireDate()));
            jobComboBox.setSelectedItem(employeeTable.getModel().getValueAt(row, 7).toString());
            salaryField.setValue(employee.getSalary());
            if (employee.getCommissionPct() != null) {
                commissionTextField.setText(employee.getCommissionPct() + "");
            } else {
                commissionTextField.setText("");
            }

            if (employee.getManagerId() != null) {
                Employee manager = ec.getById(employee.getManagerId());
                managerComboBox.setSelectedItem(manager.getFirstName()
                        + " " + manager.getLastName());
            } else {
                managerComboBox.setSelectedIndex(0);
            }
            if (employeeTable.getModel().getValueAt(row, 11) != "-") {
                departmentComboBox.setSelectedItem(employeeTable.getModel().getValueAt(row, 11));
            } else {
                departmentComboBox.setSelectedIndex(0);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_employeeTableMouseClicked

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        try {
            // TODO add your handling code here:
            ec.deleteEmployee(Integer.parseInt(idTextField.getText()));
            employeeTable.setModel(loadData("", 1, 1));
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void clearFieldsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFieldsButtonActionPerformed
        // TODO add your handling code here:
        idTextField.setText("");
        firstNameTextField.setText("");
        lastNameTextField.setText("");
        emailTextField.setText("");
        phoneTextField.setText("");
        hireDatePicker.setDate(new Date(System.currentTimeMillis()));
        //            hireDateTextField.setText(simpleDateFormat.format(employee.getHireDate()));
        jobComboBox.setSelectedIndex(0);
        salaryField.setValue(0);
        commissionTextField.setText("0.0");

        managerComboBox.setSelectedIndex(0);
        departmentComboBox.setSelectedIndex(0);
    }//GEN-LAST:event_clearFieldsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearFieldsButton;
    private javax.swing.JTextField commissionTextField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JComboBox<String> departmentComboBox;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JTable employeeTable;
    private javax.swing.JTextField firstNameTextField;
    private org.jdesktop.swingx.JXDatePicker hireDatePicker;
    private javax.swing.JTextField idTextField;
    private javax.swing.JButton jButton2;
    private org.jdatepicker.JDateComponentFactory jDateComponentFactory1;
    private org.jdatepicker.JDateComponentFactory jDateComponentFactory2;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil1;
    private org.jdatepicker.util.JDatePickerUtil jDatePickerUtil2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jobComboBox;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JComboBox<String> managerComboBox;
    private javax.swing.JButton newIdButton;
    private javax.swing.JTextField phoneTextField;
    private javax.swing.JSpinner salaryField;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JComboBox<String> searchComboBox;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel loadData(String keyword, int sortIndex, int searchIndex) throws SQLException {

        List<Employee> employees = ec.searchEmployee(keyword, searchIndex - 1, sortIndex);

        String[][] employeeCells = new String[employees.size()][12];
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd yyyy");
        for (int i = 0; i < employeeCells.length; i++) {
            employeeCells[i][0] = (i + 1) + "";
            employeeCells[i][1] = employees.get(i).getId() + "";
            employeeCells[i][2] = employees.get(i).getFirstName() + "";
            employeeCells[i][3] = employees.get(i).getLastName() + "";
            employeeCells[i][4] = employees.get(i).getEmail() + "";
            employeeCells[i][5] = employees.get(i).getPhoneNumber() + "";
            employeeCells[i][6] = dateFormat.format(employees.get(i).getHireDate()) + "";
            if (employees.get(i).getJobId() != null) {
                employeeCells[i][7] = jc.getById(employees.get(i).getJobId()).getTitle() + "";
            } else {
                employeeCells[i][7] = "";
            }
            employeeCells[i][8] = employees.get(i).getSalary() + "";
            if (employees.get(i).getCommissionPct() != null) {
                employeeCells[i][9] = employees.get(i).getCommissionPct() + "";
            } else {
                employeeCells[i][9] = "-";
            }
            if (employees.get(i).getManagerId() != null) {
                employeeCells[i][10] = ec.getById(employees.get(i).getManagerId()).getLastName() + "";
            } else {
                employeeCells[i][10] = "-";
            }
            if (employees.get(i).getDepartmentId() != null) {
                employeeCells[i][11] = dc.getById(employees.get(i).getDepartmentId()).getName() + "";
            } else {
                employeeCells[i][11] = "-";
            }
        }
        DefaultTableModel dtm = new DefaultTableModel(employeeCells, headers);
        return dtm;
    }

    private Integer getManagerId() throws SQLException {
        List<Employee> employees = ec.searchEmployee("", 1, 2);
        int index = managerComboBox.getSelectedIndex();
        if (index == 0) {
            return null;
        } else {
            return employees.get(index - 1).getId();
        }

    }

    private String getJobId() throws SQLException {
        List<Job> jobs = jc.getAllJobs(1);
        return jobs.get(jobComboBox.getSelectedIndex()).getId();
    }

    private Integer getDepartmentId() throws SQLException {
        List<Department> departments = dc.getAllDepartments(1);
        int index = departmentComboBox.getSelectedIndex();
        if (index == 0) {
            return null;
        } else {
            return departments.get(index - 1).getId();
        }
    }
}