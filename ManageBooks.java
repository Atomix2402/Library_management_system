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
public class ManageBooks extends javax.swing.JFrame {
     
    /**
     * Creates new form ManageBooks
     */
    String book_name,author,category;
    int book_Id,quantity,rating;
    DefaultTableModel model;
    public ManageBooks() {
        initComponents();
        setBookDetailsToTable();
    }
     public void setBookDetailsToTable(){
        try{
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms","root","");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from book_details");
             
             while(rs.next()){
                 String bookID = rs.getString("book_id");
                 String bookName = rs.getString("book_name");
                 String Category = rs.getString("category");
                 String author = rs.getString("author");
                 int quantity = rs.getInt("quantity");                 
                 int rating = rs.getInt("rating");
                 Object[] obj = {bookID,bookName,Category,author,quantity,rating};
                 model = (DefaultTableModel) BookTable.getModel();
                 model.addRow(obj);
             }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
      public boolean addBook(){
        book_Id = Integer.parseInt(text_bookID.getText());
        book_name = txt_bookname.getText();
        category = txt_category.getText();
        author = txt_authname.getText();
        quantity = Integer.parseInt(txt_quantity.getText());
        rating = Integer.parseInt(txt_rating.getText());
        boolean isAdded = false;
         try{
        Connection con = DBConnection.getConnection();
        String sql = "insert into book_details values(?,?,?,?,?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,book_Id);
        pst.setString(2,book_name);
        pst.setString(3,category);
        pst.setString(4,author);
        pst.setInt(5,quantity);
        pst.setInt(6,rating);
        pst.setInt(7,0);
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
      
      public boolean updateBook(){
        boolean isUpdated = false;
        book_Id = Integer.parseInt(text_bookID.getText());
        book_name = txt_bookname.getText();
        category = txt_category.getText();
        author = txt_authname.getText();
        quantity = Integer.parseInt(txt_quantity.getText());
        rating = Integer.parseInt(txt_rating.getText());
        
        try{
           Connection con = DBConnection.getConnection();
           String sql =  "update book_details set book_name = ?,category = ?,author = ?,quantity = ? where book_id = ?";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setString(1,book_name);
           pst.setString(2,category);
           pst.setString(3,author);
           pst.setInt(4,quantity);
           pst.setInt(5,book_Id);
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
      public boolean deleteBook(){
          boolean isDeleted = false;
          book_Id = Integer.parseInt(text_bookID.getText());
          try{
              Connection con = DBConnection.getConnection();
              String sql = "delete from book_details where book_id = ?";
              PreparedStatement pst = con.prepareStatement(sql);
              pst.setInt(1,book_Id);
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
          DefaultTableModel model = (DefaultTableModel) BookTable.getModel();
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
        txt_authname = new app.bolivia.swing.JCTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txt_quantity = new app.bolivia.swing.JCTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        text_bookID = new app.bolivia.swing.JCTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txt_bookname = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txt_category = new app.bolivia.swing.JCTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        txt_rating = new app.bolivia.swing.JCTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        BookTable = new rojeru_san.complementos.RSTableMetro();
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
        jLabel28.setText("Author Name");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, 20));

        jLabel27.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 50, 40));

        txt_authname.setBackground(new java.awt.Color(153, 102, 255));
        txt_authname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_authname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_authname.setPlaceholder("Enter Author Name...");
        txt_authname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_authnameFocusLost(evt);
            }
        });
        txt_authname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_authnameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_authname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 310, 30));

        jLabel29.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 50, 40));

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Quantity");
        jPanel1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, 20));

        txt_quantity.setBackground(new java.awt.Color(153, 102, 255));
        txt_quantity.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_quantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_quantity.setPlaceholder("Enter quantity...");
        txt_quantity.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_quantityFocusLost(evt);
            }
        });
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 310, 30));

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 60, 40));

        jLabel32.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Enter Book ID");
        jPanel1.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 110, 20));

        text_bookID.setBackground(new java.awt.Color(153, 102, 255));
        text_bookID.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        text_bookID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        text_bookID.setPlaceholder("Enter Book ID...");
        text_bookID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_bookIDFocusLost(evt);
            }
        });
        text_bookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_bookIDActionPerformed(evt);
            }
        });
        jPanel1.add(text_bookID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 310, 30));

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel1.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 50, 40));

        jLabel34.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Enter Book Name");
        jPanel1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, -1, 20));

        txt_bookname.setBackground(new java.awt.Color(153, 102, 255));
        txt_bookname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_bookname.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_bookname.setPlaceholder("Enter Book Name...");
        txt_bookname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_booknameFocusLost(evt);
            }
        });
        txt_bookname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_booknameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_bookname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 310, 30));

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

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 60, 50));

        jLabel36.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Category");
        jPanel1.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, 20));

        txt_category.setBackground(new java.awt.Color(153, 102, 255));
        txt_category.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_category.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_category.setPlaceholder("Enter Category...");
        txt_category.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_categoryFocusLost(evt);
            }
        });
        txt_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_categoryActionPerformed(evt);
            }
        });
        jPanel1.add(txt_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 310, 30));

        jLabel37.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 490, 50, 40));

        jLabel38.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Rating");
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, 20));

        txt_rating.setBackground(new java.awt.Color(153, 102, 255));
        txt_rating.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        txt_rating.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_rating.setPlaceholder("Enter Rating...");
        txt_rating.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_ratingFocusLost(evt);
            }
        });
        txt_rating.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ratingActionPerformed(evt);
            }
        });
        jPanel1.add(txt_rating, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 310, 30));

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

        BookTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book ID", "Name", "Category", "Author", "Quantity", "Rating"
            }
        ));
        BookTable.setColorBackgoundHead(new java.awt.Color(153, 102, 255));
        BookTable.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        BookTable.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        BookTable.setFont(new java.awt.Font("Yu Gothic UI Light", 0, 25)); // NOI18N
        BookTable.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        BookTable.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        BookTable.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        BookTable.setRowHeight(40);
        BookTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BookTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(BookTable);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 1070, 590));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel1.setText(" Manage Books");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel5.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 105, 300, 5));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 1150, 820));

        setSize(new java.awt.Dimension(1724, 824));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_quantityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_quantityFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityFocusLost

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

    private void text_bookIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_bookIDFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_text_bookIDFocusLost

    private void text_bookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_bookIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_bookIDActionPerformed

    private void txt_booknameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_booknameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_booknameFocusLost

    private void txt_booknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_booknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_booknameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(deleteBook() == true){
          JOptionPane.showMessageDialog(this,"Book Deleted");
          clearTable();
          setBookDetailsToTable();
      }else{
          JOptionPane.showMessageDialog(this,"Book deletion Failed");
      }    
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
      if(addBook() == true){
          JOptionPane.showMessageDialog(this,"Book Added");
          clearTable();
          setBookDetailsToTable();
      }else{
          JOptionPane.showMessageDialog(this,"Book Addition Failed");
      }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
      if(updateBook()==true){
          JOptionPane.showMessageDialog(this,"Book Updated");
          clearTable();
          setBookDetailsToTable();
      }else{
          JOptionPane.showMessageDialog(this,"Book Updation Failed");        
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

    private void BookTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BookTableMouseClicked
      int rowNo = BookTable.getSelectedRow();
      TableModel model = BookTable.getModel();
      
      text_bookID.setText(model.getValueAt(rowNo,0).toString());
      txt_bookname.setText(model.getValueAt(rowNo, 1).toString());
      txt_category.setText(model.getValueAt(rowNo,2).toString());
      txt_authname.setText(model.getValueAt(rowNo, 3).toString());
      txt_quantity.setText(model.getValueAt(rowNo, 4).toString());
      txt_rating.setText(model.getValueAt(rowNo, 5).toString());
      
      
    }//GEN-LAST:event_BookTableMouseClicked

    private void txt_categoryFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_categoryFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoryFocusLost

    private void txt_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_categoryActionPerformed

    private void txt_ratingFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_ratingFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ratingFocusLost

    private void txt_ratingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ratingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ratingActionPerformed

    private void txt_authnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_authnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authnameFocusLost

    private void txt_authnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_authnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_authnameActionPerformed

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
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageBooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.complementos.RSTableMetro BookTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private app.bolivia.swing.JCTextField text_bookID;
    private app.bolivia.swing.JCTextField txt_authname;
    private app.bolivia.swing.JCTextField txt_bookname;
    private app.bolivia.swing.JCTextField txt_category;
    private app.bolivia.swing.JCTextField txt_quantity;
    private app.bolivia.swing.JCTextField txt_rating;
    // End of variables declaration//GEN-END:variables
}