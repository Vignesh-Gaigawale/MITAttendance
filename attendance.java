/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sarth
 */
import java.awt.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
//import static feedback.system.Login.Roll_no;
public class attendance extends javax.swing.JFrame {

    /**
     * Creates new form attendance
     */
    public attendance() throws SQLException {
        initComponents();
        //JOptionPane.showMessageDialog(null,Login.Roll_no,"", JOptionPane.ERROR_MESSAGE);
        
        Connection conn=null;
                try {
                    //DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                    DefaultTableModel dtm = (DefaultTableModel) attendance_table.getModel();
                    conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sarth\\OneDrive - MIT Art, Design & Technology University, Pune\\Documents\\Study Material\\SEM 4\\PBL\\MIT Smart Attendance\\My_Database.db");
                    Statement stmt=conn.createStatement();
                    ResultSet rs=stmt.executeQuery("select * from attendance WHERE Roll_no="+Login.Roll_no);
                    //testResultSet(rs);
                    ResultSetMetaData meta = rs.getMetaData();
                    int numberOfColumns;
                    numberOfColumns = meta.getColumnCount();
                    Object [] rowData = new Object[numberOfColumns];
                 
                    for (int i = 0; i < rowData.length; ++i)
                    {
                        rowData[i] = rs.getObject(i+1);
                        
                        //JOptionPane.showMessageDialog(null,""+rowData[i],"", JOptionPane.ERROR_MESSAGE);
                    }
                    if((Double)rowData[7]<75)
                    {
                        String text=notice_label.getText();
                        notice_label.setText(text+" Your attendance is below 75%, you need to attend lectures regularly!");
                        //notice_label.setBackground(Color.red);
                        notice_label.setForeground(Color.red);
                    }
                    dtm.addRow(rowData);
                    //dtm.addRow(new Object[]{"Column 1", "Column 2", "Column 3","Column 1", "Column 2", "Column 3"});
                    dtm.fireTableDataChanged();
                    //dtm.fireTableStructureChanged();
                   
                    //Genratng bar graph
                    
                   
                    
                } catch (SQLException ex) {
                    Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
                conn.close();
                
                //display_graph();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        attendance_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        notice_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Attendance");

        attendance_table.setBackground(new java.awt.Color(153, 204, 255));
        attendance_table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        attendance_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Roll No", "Subject1 Attended", "Subject1 Total", "Subject2 Attended", "Subject2 Total", "Subject3 Attended", "Subject3 Total", "Attendance(%)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(attendance_table);
        if (attendance_table.getColumnModel().getColumnCount() > 0) {
            attendance_table.getColumnModel().getColumn(6).setHeaderValue("Subject3 Total");
            attendance_table.getColumnModel().getColumn(7).setHeaderValue("Attendance(%)");
        }

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setText("NOTE :");

        jLabel2.setText("- 75 % Attendance (Theory as well as Practical ) is compulsory.");

        jLabel3.setText("- This is an electronically generated document based on uploading of attendance-record by concerned faculty of the respective Departments.");

        jLabel4.setText("- Discrepancy related to attendance-record should be communicated to the CASERP section through Subject-Incharge, Class-Incharge and Head of the Department.");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Show Visualization");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        notice_label.setForeground(new java.awt.Color(0, 51, 51));
        notice_label.setText("NOTICE: ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(415, 415, 415)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(78, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addComponent(notice_label, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(notice_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(89, 89, 89)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            display_graph();
        } catch (SQLException ex) {
            Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void testResultSet(ResultSet res){
        System.out.println("Test");
        try{
            while(res.next()){
                System.out.println("Roll No: "+ res.getInt("Roll_no"));
                System.out.println("Subject1 : "+ res.getString("Subject1"));
                System.out.println("Attendance: "+ res.getString("Attendance"));
            }        
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }*/
    
    
    
    void display_graph() throws SQLException
    {
      
      JFreeChart barChart = ChartFactory.createBarChart("Attendance","Subjects","Number of Lectures",createDataset(),PlotOrientation.VERTICAL,true, true, false);
         
      //ChartPanel chartPanel = new ChartPanel( barChart );        
      //chartPanel.setPreferredSize(new java.awt.Dimension( 560 , 367 ) );        
      //chartPanel.setVisible(true);
      //setContentPane( chartPanel ); 
      
       ChartFrame frame=new ChartFrame("",barChart);
       frame.setVisible(true);
       frame.setSize(900,600);
        //this.add(chartPanel); 
              //getContentPane().add(chartPanel);
      //jPanel1.add(chartPanel);
    }
    CategoryDataset createDataset() throws SQLException
    {
        Connection conn=null;
        conn=DriverManager.getConnection("jdbc:sqlite:C:\\Users\\sarth\\OneDrive - MIT Art, Design & Technology University, Pune\\Documents\\Study Material\\SEM 4\\PBL\\MIT Smart Attendance\\My_Database.db");
        Statement stmt=conn.createStatement();
        ResultSet rs=stmt.executeQuery("select * from attendance where Roll_no="+Login.Roll_no);
        
        int subject1=0,subject1_total=0,subject2=0,subject2_total=0,subject3=0,subject3_total=0,row_count=0;
        while(rs.next())
        {
            subject1+=rs.getInt(2);
            subject1_total+=rs.getInt(3);
            subject2+=rs.getInt(4);
            subject2_total+=rs.getInt(5);
            subject3+=rs.getInt(6);
            subject3_total+=rs.getInt(7);
            row_count++;
        }
        conn.close();
        
        
        //System.out.println(s1_lectures_attended+"\t"+s1_total_lectures+"\n"+s2_lectures_attended+"\t"+s2_total_lectures+"\n"+s3_lectures_attended+"\t"+s3_total_lectures);
        
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
        dataset.addValue( subject1 , "Attended Lectures" , "Subject1");        
        dataset.addValue( subject2 , "Attended Lectures" , "Subject2" );
        dataset.addValue( subject3 , "Attended Lectures" , "Subject3" );

        dataset.addValue( subject1_total , "Total Lectures" , "Subject1" );        
        dataset.addValue( subject2_total , "Total Lectures" , "Subject2" );
        dataset.addValue( subject3_total , "Total Lectures" , "Subject3" );
        

        
        return dataset;
    }
    
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
            java.util.logging.Logger.getLogger(attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(attendance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new attendance().setVisible(true);
                    
                    //JOptionPane.showMessageDialog(null, "Connection Established");
                } catch (SQLException ex) {
                    Logger.getLogger(attendance.class.getName()).log(Level.SEVERE, null, ex);
                }
                
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendance_table;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel notice_label;
    // End of variables declaration//GEN-END:variables
}
