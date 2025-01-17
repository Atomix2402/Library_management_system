/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

//import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;
import static jframe.DBConnection.con;
import javax.swing.table.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 *
 * @author sbkum
 */
public class ManageCustomer extends javax.swing.JFrame {
     
    /**
     * Creates new form ManageBooks
     */
    String cust_name,contact;
    int cust_Id;
    DefaultTableModel model;
    public ManageCustomer() {
        initComponents();
        setCustomerDetailsToTable();
    }
     public void setCustomerDetailsToTable(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from customer_details");
             
             while(rs.next()){
                 String customerID = rs.getString("customer_id");
                 String custName = rs.getString("name");
                 String contact = rs.getString("contact");
                 Object[] obj = {customerID,custName,contact};
                 model = (DefaultTableModel) CustomerTable.getModel();
                 model.addRow(obj);
             }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
      public boolean addCustomerDetails(){
        cust_Id = Integer.parseInt(text_customerID.getText());
        cust_name = txt_customername.getText();
        contact = txt_contact.getText();               
        boolean isAdded = false;
         try{
        Connection con = DBConnection.getConnection();
        String sql = "insert into customer_details values(?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,cust_Id);
        pst.setString(2,cust_name);
        pst.setString(3,contact);        
        int rowCount = pst.executeUpdate();
        if(rowCount >0){
            isAdded = true;
            
        }else{
            isAdded = false;
        }
        
    }catch(Exception e){
        e.printStackTrace();
    }
         return isAdded;
}
      
      public boolean updateCustomerDetails(){
        boolean isUpdated = false;
        cust_Id = Integer.parseInt(text_customerID.getText());
        cust_name = txt_customername.getText();
        contact = txt_contact.getText();
        
        
        
        try{
           Connection con = DBConnection.getConnection();
           String sql =  "update customer_details set name = ?,contact = ? where customer_id = ?";
           PreparedStatement pst = con.prepareStatement(sql);           
           pst.setString(1,cust_name);
           pst.setString(2,contact);
           pst.setInt(3,cust_Id);
           int rowCount = pst.executeUpdate();
            if(rowCount >0){
            isUpdated = true;
            
        }else{
            isUpdated = false;
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return isUpdated;
      } 
      public boolean deleteCustomerDetails(){
          boolean isDeleted = false;
          cust_Id = Integer.parseInt(text_customerID.getText());
          try{
              Connection con = DBConnection.getConnection();
              String sql = "delete from customer_details where customer_id = ?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1,cust_Id);
              int rowCount = pst.executeUpdate();
              if(rowCount > 0){
                  isDeleted = true;
              }             
              else{
                  isDeleted = false;
              }
          }catch (Exception e){
              e.printStackTrace();
          }
          return isDeleted;
      }
      public void clearTable(){
          DefaultTableModel model = (DefaultTableModel) CustomerTable.getModel();
          model.setRowCount(0);
      }
    
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        txt_contact = new app.bolivia.swing.JCTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        text_customerID = new app.bolivia.swing.JCTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txt_customername = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CustomerTable = new rojeru_san.complementos.RSTableMetro();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 51));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 60));

        jLabel28.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Contact");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, -1, 20));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 50, 40));

        txt_contact.setBackground(new java.awt.Color(153, 102, 255));
        txt_contact.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_contact.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_contact.setPlaceholder("Enter Contact...");
        txt_contact.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_contactFocusLost(evt);
            }
        });
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel1.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 310, 30));

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 60, 40));

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Enter Customer ID");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, 20));

        text_customerID.setBackground(new java.awt.Color(153, 102, 255));
        text_customerID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        text_customerID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_customerID.setPlaceholder("Enter Customer ID...");
        text_customerID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_customerIDFocusLost(evt);
            }
        });
        text_customerID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_customerIDActionPerformed(evt);
            }
        });
        jPanel1.add(text_customerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 310, 30));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 50, 40));

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Enter Customer Name");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, -1, 20));

        txt_customername.setBackground(new java.awt.Color(153, 102, 255));
        txt_customername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_customername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_customername.setPlaceholder("Enter Customer Name...");
        txt_customername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_customernameFocusLost(evt);
            }
        });
        txt_customername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customernameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_customername, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 310, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle1.setText("Delete");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 590, 160, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle2.setText("Add");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 590, 160, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle3.setText("Update");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 590, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 0, 51));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 100, 50));

        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Name", "Contact"
            }
        ));
        CustomerTable.setColorBackgoundHead(new java.awt.Color(153, 102, 255));
        CustomerTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        CustomerTable.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        CustomerTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        CustomerTable.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        CustomerTable.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        CustomerTable.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        CustomerTable.setRowHeight(40);
        CustomerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CustomerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(CustomerTable);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 1070, 590));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel1.setText(" Manage Customer");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 390, 90));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, 360, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1150, 820));

        setSize(new java.awt.Dimension(1724, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void text_customerIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_customerIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_text_customerIDFocusLost

    private void text_customerIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_customerIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_customerIDActionPerformed

    private void txt_customernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_customernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customernameFocusLost

    private void txt_customernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customernameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(deleteCustomerDetails() == true){
          JOptionPane.showMessageDialog(this,"Customer Details Deleted");
          clearTable();
          setCustomerDetailsToTable();
      }else{
          JOptionPane.showMessageDialog(this,"Customer Details deletion Failed");
      }    
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
      if(addCustomerDetails() == true){
          JOptionPane.showMessageDialog(this,"Customer Details Added");
          clearTable();
          setCustomerDetailsToTable();
      }else{
          JOptionPane.showMessageDialog(this,"Customer Details Addition Failed");
      }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
      if(updateCustomerDetails()==true){
          JOptionPane.showMessageDialog(this,"Customer Details Updated");
          clearTable();
          setCustomerDetailsToTable();
      }else{
          JOptionPane.showMessageDialog(this,"Customer Details Updation Failed");        
      }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       HomePage home = new HomePage();
       home.setVisible(true);
       dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void CustomerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CustomerTableMouseClicked
      int rowNo = CustomerTable.getSelectedRow();
      TableModel model = CustomerTable.getModel();
      
      text_customerID.setText(model.getValueAt(rowNo,0).toString());
      txt_customername.setText(model.getValueAt(rowNo, 1).toString());
      txt_contact.setText(model.getValueAt(rowNo, 3).toString());
      
      
      
      
    }//GEN-LAST:event_CustomerTableMouseClicked

    private void txt_contactFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_contactFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactFocusLost

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

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
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro CustomerTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private app.bolivia.swing.JCTextField text_customerID;
    private app.bolivia.swing.JCTextField txt_contact;
    private app.bolivia.swing.JCTextField txt_customername;
    // End of variables declaration//GEN-END:variables
}