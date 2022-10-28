/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
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
import java.util.*;
/**
 *
 * @author sbkum
 */
public class ReturnBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public ReturnBook() {
        initComponents();
    }
    // fetching issueBookDetails
    public void issueBookDetails(){
        int bookid = Integer.parseInt(return_bookid.getText());
        int custid = Integer.parseInt(return_custid.getText());
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and customer_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookid);
            pst.setInt(2,custid);
            pst.setString(3,"pending");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
               
               jLabel10.setText(rs.getString("id"));
               lbl_bookname.setText(rs.getString("book_name"));
               lbl_custname.setText(rs.getString("customer_name"));
               lbl_issuedate.setText(rs.getString("issue_date"));
               lbl_returndate.setText(rs.getString("due_date"));
               lbl_bookError.setText("");
            }else{
                lbl_bookError.setText("No record Found");
                jLabel10.setText("");
               lbl_bookname.setText("");
               lbl_custname.setText("");
               lbl_issuedate.setText("");
               lbl_returndate.setText("");
            }            
        }catch(Exception e){
            e.printStackTrace();
        }
      
    }
   
    // return book
    public boolean returnBook(){
        boolean returned = false;
        int bookid = Integer.parseInt(return_bookid.getText());
        int custid = Integer.parseInt(return_custid.getText());
         try{
            Connection con = DBConnection.getConnection();
            String sql = "update issue_book_details set status = ? where customer_id = ? and book_id = ? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,"returned");
            pst.setInt(2,custid);
            pst.setInt(3,bookid);
            pst.setString(4,"pending");
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                returned = true;
            }
            else{
                returned = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         return returned;
    }
   
    
   
    //Updating Count of Books
    public void updateBookCount(){
        int bookId = Integer.parseInt(return_bookid.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity+1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "book count updated");               
            }else{
                JOptionPane.showMessageDialog(this, "book count update failed");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // Update Rating of the book
    public boolean updateRating(){
        boolean isRatingUpdated = false;
        int bookId = Integer.parseInt(return_bookid.getText()); 
        int rating = Integer.parseInt(return_newrating.getText()); 
        int new_rating,oldRating=0,ratecount=0;        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from book_details where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookId);
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                oldRating = rs.getInt("rating");
                ratecount = rs.getInt("rate_count");                
            }
            new_rating = ((oldRating * ratecount)+rating)/(ratecount+1);
            String sql1 = "update book_details set rating = ?, rate_count = rate_count+1 where book_id = ?";
            PreparedStatement pst1 = con.prepareStatement(sql1);
            pst1.setInt(1,new_rating);
            pst1.setInt(2,bookId);
            int rowCount = pst1.executeUpdate();
            if(rowCount >0){
            isRatingUpdated = true;
            
        }else{
            isRatingUpdated = false;
        }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return isRatingUpdated;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_issuedate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_returndate = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_custname = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        return_bookid = new app.bolivia.swing.JCTextField();
        return_custid = new app.bolivia.swing.JCTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        return_updaterating = new rojerusan.RSMaterialButtonCircle();
        return_find = new rojerusan.RSMaterialButtonCircle();
        jLabel12 = new javax.swing.JLabel();
        return_newrating = new app.bolivia.swing.JCTextField();
        jLabel35 = new javax.swing.JLabel();
        return_returnbook = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 320, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 320, 5));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Book Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, -1, 30));

        lbl_issuedate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_issuedate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_issuedate, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 230, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Issue Date");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, -1, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Issue ID :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, 30));

        lbl_returndate.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_returndate.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_returndate, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 510, 230, 30));

        lbl_bookname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 340, 60));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 230, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel5.setText(" Book Details");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 320, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Customer Name");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, 30));

        lbl_custname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_custname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_custname, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 400, 270, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Return Date");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, -1, 30));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 102));
        jPanel2.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 580, 320, 30));

        jPanel3.setBackground(new java.awt.Color(153, 102, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 130, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, -1));

        panelMain.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 810));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel1.setText("Return Book");
        panelMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 220, 70));

        jPanel7.setBackground(new java.awt.Color(255, 102, 51));
        jPanel7.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        panelMain.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, -1, 5));

        jPanel4.setBackground(new java.awt.Color(255, 0, 51));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("X");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelMain.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 0, 100, 50));

        return_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 102)));
        return_bookid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        return_bookid.setPlaceholder("Enter Book ID...");
        return_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                return_bookidFocusLost(evt);
            }
        });
        return_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_bookidActionPerformed(evt);
            }
        });
        panelMain.add(return_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 260, 250, 30));

        return_custid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 102)));
        return_custid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        return_custid.setPlaceholder("Enter Customer ID...");
        return_custid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                return_custidFocusLost(evt);
            }
        });
        return_custid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_custidActionPerformed(evt);
            }
        });
        panelMain.add(return_custid, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 300, 250, 30));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 102, 102));
        jLabel33.setText(" Customer ID :");
        panelMain.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 310, 120, -1));

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 102, 102));
        jLabel34.setText(" Book ID :");
        panelMain.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 270, 100, -1));

        return_updaterating.setBackground(new java.awt.Color(51, 51, 255));
        return_updaterating.setText("Update Rating");
        return_updaterating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_updateratingActionPerformed(evt);
            }
        });
        panelMain.add(return_updaterating, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 590, 300, 90));

        return_find.setBackground(new java.awt.Color(204, 102, 255));
        return_find.setText("Find");
        return_find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_findActionPerformed(evt);
            }
        });
        panelMain.add(return_find, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 410, 300, 90));

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Issue ID :");
        panelMain.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, 30));

        return_newrating.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 102)));
        return_newrating.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        return_newrating.setPlaceholder("Enter Rating...");
        return_newrating.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                return_newratingFocusLost(evt);
            }
        });
        return_newrating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_newratingActionPerformed(evt);
            }
        });
        panelMain.add(return_newrating, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 350, 250, 30));

        jLabel35.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 102, 102));
        jLabel35.setText("Book Rating");
        panelMain.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 360, 100, -1));

        return_returnbook.setBackground(new java.awt.Color(255, 0, 0));
        return_returnbook.setText("Return Book");
        return_returnbook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                return_returnbookActionPerformed(evt);
            }
        });
        panelMain.add(return_returnbook, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 500, 300, 90));

        getContentPane().add(panelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void return_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_return_bookidFocusLost
     
    }//GEN-LAST:event_return_bookidFocusLost

    private void return_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_bookidActionPerformed

    private void return_custidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_return_custidFocusLost
    
    }//GEN-LAST:event_return_custidFocusLost

    private void return_custidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_custidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_custidActionPerformed

    private void return_updateratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_updateratingActionPerformed
                
         if(updateRating() == true){
           JOptionPane.showMessageDialog(this,"Book Rating Updated Successfully");
           
       }else{
           JOptionPane.showMessageDialog(this,"Book Rating update Failed");
       }
       
    }//GEN-LAST:event_return_updateratingActionPerformed

    private void return_findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_findActionPerformed
        issueBookDetails();
    }//GEN-LAST:event_return_findActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void return_newratingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_return_newratingFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_return_newratingFocusLost

    private void return_newratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_newratingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_return_newratingActionPerformed

    private void return_returnbookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_return_returnbookActionPerformed
       if(returnBook() == true){
           JOptionPane.showMessageDialog(this,"Book Returned Successfully");
           updateBookCount();
       }else{
           JOptionPane.showMessageDialog(this,"Book Returning Failed");
       }
    }//GEN-LAST:event_return_returnbookActionPerformed

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
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReturnBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReturnBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_custname;
    private javax.swing.JLabel lbl_issuedate;
    private javax.swing.JLabel lbl_returndate;
    private javax.swing.JPanel panelMain;
    private app.bolivia.swing.JCTextField return_bookid;
    private app.bolivia.swing.JCTextField return_custid;
    private rojerusan.RSMaterialButtonCircle return_find;
    private app.bolivia.swing.JCTextField return_newrating;
    private rojerusan.RSMaterialButtonCircle return_returnbook;
    private rojerusan.RSMaterialButtonCircle return_updaterating;
    // End of variables declaration//GEN-END:variables
}
