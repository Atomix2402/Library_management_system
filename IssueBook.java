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
public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }
    
    public void getBookDetails(){
        int bookId = Integer.parseInt(Issue_bookid.getText());
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1,bookId);
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
                lbl_bookid.setText(rs.getString("book_id"));
                lbl_bookname.setText(rs.getString("book_name"));
                lbl_category.setText(rs.getString("category"));
                lbl_author.setText(rs.getString("author"));
                lbl_quantity.setText(rs.getString("quantity"));
            }else{
                 lbl_bookError.setText("Invalid Book Id");
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
    }
    public void getCustomerDetails(){
        int custId = Integer.parseInt(issue_custid.getText());
        try{
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from customer_details where customer_id = ?");
            pst.setInt(1,custId);
            ResultSet rs = pst.executeQuery(); 
            if(rs.next()){
                lbl_custid.setText(rs.getString("customer_id"));
                lbl_custname.setText(rs.getString("name"));
                lbl_contact.setText(rs.getString("contact"));
                
            }else{
                lbl_CustomerError.setText("Invalid Customer Id");
            }
        }catch(Exception e){
            e.printStackTrace();
            
        }
        
    }
    
    // Insert Issue book details to database
    
    public boolean IssueBook(){
        boolean Issued = false;
        int bookId = Integer.parseInt(Issue_bookid.getText());
        int custId = Integer.parseInt(issue_custid.getText());
        String bookname = lbl_bookname.getText();
        String custname = lbl_custname.getText();
        
        Date uIssueDate = date_issue.getDatoFecha();
        Date uReturnDate = date_return.getDatoFecha();
        long l1 = uIssueDate.getTime();
        long l2 = uReturnDate.getTime();
        java.sql.Date sIssueDate = new java.sql.Date(l1);
        java.sql.Date sReturnDate = new java.sql.Date(l2);
        
        try{
            Connection con = DBConnection.getConnection();
            String sql = "insert into issue_book_details(book_id,book_name,customer_id,customer_name,issue_date,due_date,status) values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setString(2,bookname);
            pst.setInt(3,custId);
            pst.setString(4, custname);
            pst.setDate(5,sIssueDate);
            pst.setDate(6,sReturnDate);
            pst.setString(7,"pending");
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                Issued = true;
            }else{
                Issued = false;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return Issued;
    }
    //Updating Count of Books
    public void updateBookCount(){
        int bookId = Integer.parseInt(Issue_bookid.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql = "update book_details set quantity = quantity-1 where book_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            int rowCount = pst.executeUpdate();
            if(rowCount>0){
                JOptionPane.showMessageDialog(this, "book count updated");
                int iniCount = Integer.parseInt(lbl_quantity.getText());
                lbl_quantity.setText(Integer.toString(iniCount-1));
            }else{
                JOptionPane.showMessageDialog(this, "book count update failed");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    // checking duplicate customers
    public boolean isAlreadyIssued(){
        boolean Issued = false;
        int bookId = Integer.parseInt(Issue_bookid.getText());
        int custId = Integer.parseInt(issue_custid.getText());
        try{
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and customer_id  = ? and status = ?";
            PreparedStatement pst  = con.prepareStatement(sql);
            pst.setInt(1,bookId);
            pst.setInt(2,custId);
            pst.setString(3,"pending");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                Issued = true;
            }else{
                Issued = false;
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return Issued;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        lbl_contact = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_custname = new javax.swing.JLabel();
        lbl_custid = new javax.swing.JLabel();
        lbl_CustomerError = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lbl_author = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbl_quantity = new javax.swing.JLabel();
        lbl_bookname = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_bookid = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_category = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_bookError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        Issue_bookid = new app.bolivia.swing.JCTextField();
        jLabel32 = new javax.swing.JLabel();
        issue_custid = new app.bolivia.swing.JCTextField();
        jLabel33 = new javax.swing.JLabel();
        date_issue = new rojeru_san.componentes.RSDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        date_return = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMain.setBackground(new java.awt.Color(255, 255, 255));
        panelMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel12.setText("Customer Details");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 320, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 260, 5));

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Customer Name :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, 30));

        lbl_contact.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_contact.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 230, 30));

        jLabel16.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Contact :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, 30));

        jLabel17.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Customer ID :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, 30));

        lbl_custname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_custname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_custname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 230, 30));

        lbl_custid.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_custid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(lbl_custid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 230, 30));

        lbl_CustomerError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_CustomerError.setForeground(new java.awt.Color(255, 255, 102));
        jPanel1.add(lbl_CustomerError, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, 320, 30));

        panelMain.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 420, 800));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 60));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 260, 5));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText(" Book Name :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, 30));

        lbl_author.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_author.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_author, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 540, 230, 30));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Author Name :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, 30));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Book ID :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, -1, 30));

        lbl_quantity.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_quantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 230, 30));

        lbl_bookname.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookname.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 260, 60));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 230, 30));

        lbl_bookid.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookid.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 230, 30));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel5.setText(" Book Details");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 320, -1));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Category :");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, 30));

        lbl_category.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_category.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(lbl_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 230, 30));

        jLabel11.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Quantity :");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, -1, 30));

        lbl_bookError.setFont(new java.awt.Font("Yu Gothic UI", 0, 20)); // NOI18N
        lbl_bookError.setForeground(new java.awt.Color(255, 255, 102));
        jPanel2.add(lbl_bookError, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 670, 320, 30));

        panelMain.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 810));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 25)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 102, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel1.setText("Issue Book");
        panelMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 70, 180, 70));

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

        panelMain.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 140, -1, 5));

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

        Issue_bookid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 102)));
        Issue_bookid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Issue_bookid.setPlaceholder("Enter Book ID...");
        Issue_bookid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                Issue_bookidFocusLost(evt);
            }
        });
        Issue_bookid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Issue_bookidActionPerformed(evt);
            }
        });
        panelMain.add(Issue_bookid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 250, 310, 30));

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 102, 102));
        jLabel32.setText("Issue Date");
        panelMain.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 380, 100, -1));

        issue_custid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 102, 102)));
        issue_custid.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        issue_custid.setPlaceholder("Enter Customer ID...");
        issue_custid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                issue_custidFocusLost(evt);
            }
        });
        issue_custid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                issue_custidActionPerformed(evt);
            }
        });
        panelMain.add(issue_custid, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 290, 310, 30));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 102, 102));
        jLabel33.setText(" Customer ID :");
        panelMain.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, 120, -1));

        date_issue.setColorBackground(new java.awt.Color(255, 102, 102));
        date_issue.setColorForeground(new java.awt.Color(255, 102, 102));
        date_issue.setPlaceholder("Select Issue Date");
        panelMain.add(date_issue, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 370, 320, -1));

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 102, 102));
        jLabel34.setText(" Book ID :");
        panelMain.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 260, 100, -1));

        jLabel35.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 102, 102));
        jLabel35.setText("Return Date");
        panelMain.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, 100, -1));

        date_return.setColorBackground(new java.awt.Color(255, 102, 102));
        date_return.setColorForeground(new java.awt.Color(255, 102, 102));
        date_return.setPlaceholder("Select Return Date");
        panelMain.add(date_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 430, 320, -1));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 0, 0));
        rSMaterialButtonCircle2.setText("Issue Book");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        panelMain.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 530, 310, -1));

        getContentPane().add(panelMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1411, 803));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void Issue_bookidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Issue_bookidFocusLost
       if(!Issue_bookid.getText().equals(""))
           getBookDetails();
    }//GEN-LAST:event_Issue_bookidFocusLost

    private void Issue_bookidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Issue_bookidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Issue_bookidActionPerformed

    private void issue_custidFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_issue_custidFocusLost
       if(!issue_custid.getText().equals(""))
           getCustomerDetails();
    }//GEN-LAST:event_issue_custidFocusLost

    private void issue_custidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_issue_custidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_issue_custidActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if(!lbl_quantity.getText().equals("0")){
            if(isAlreadyIssued() == false){
             if(IssueBook() == true){
             JOptionPane.showMessageDialog(this,"Book Issued Successfully");
             updateBookCount();
         }else{
             JOptionPane.showMessageDialog(this,"Book Issued Failed");
         }
        }else{
            JOptionPane.showMessageDialog(this,"This customer already has this book");
        }
        }else{
            JOptionPane.showMessageDialog(this,"This Book is not Available");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.bolivia.swing.JCTextField Issue_bookid;
    private rojeru_san.componentes.RSDateChooser date_issue;
    private rojeru_san.componentes.RSDateChooser date_return;
    private app.bolivia.swing.JCTextField issue_custid;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lbl_CustomerError;
    private javax.swing.JLabel lbl_author;
    private javax.swing.JLabel lbl_bookError;
    private javax.swing.JLabel lbl_bookid;
    private javax.swing.JLabel lbl_bookname;
    private javax.swing.JLabel lbl_category;
    private javax.swing.JLabel lbl_contact;
    private javax.swing.JLabel lbl_custid;
    private javax.swing.JLabel lbl_custname;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JPanel panelMain;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    // End of variables declaration//GEN-END:variables
}
