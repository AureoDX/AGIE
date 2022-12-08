package visao.form;

import conexao.ConnectionFactory;
import controle.ScrollBarCustom;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.PieChart;
import javaswingdev.chart.ModelPieChart;
import javaswingdev.chart.PieChart.PeiChartType;
import modelo.MembroBean;
import swing.CircleProgressBar;

public class Form_Home extends javax.swing.JPanel {

    public Form_Home() throws SQLException, ParseException {
        initComponents();
        setOpaque(false);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        sp.setHorizontalScrollBar(new ScrollBarCustom());
        
      pieChartt();
    }
    
     // Total Geral de Dízimo:
    
     
     private void pieChartt () throws SQLException, ParseException{
  
        //  try {
  
       /*  Connection conn = ConnectionFactory.getConnection();
        
        String sql = (" SELECT  count (cargo) as total  FROM membros where cargo like = ?"); 
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        
        MembroBean mb = new MembroBean();
        
        stmt.setString(1, "%"+Pastor+"%");
        
        //stmt.setInt(2, "total");
       /* stmt.setString(3, Cad.getData_de_nasc());
        stmt.setString(4, Cad.getNacionalidade());
        stmt.setString(5, Cad.getNaturalde());
        stmt.setString(6, Cad.getProvíncia());
        stmt.setString(7, Cad.getTelefone1());
        stmt.setString(8, Cad.getTelefone2());
        stmt.setString(9, Cad.getEmail());
        stmt.setString(10, Cad.getAcademico());
        stmt.setString(11, Cad.getBairro());
        stmt.setString(12, Cad.getRua());
        stmt.setString(13, Cad.getEstadocivil());
        stmt.setString(14, Cad.getPai());
        stmt.setString(15, Cad.getMae());
        stmt.setString(16, Cad.getCabeçafamilia());
        stmt.setString(17, Cad.getConjuge());
        stmt.setInt(18, Cad.getQtdfilho());
        stmt.setString(19, Cad.getIgreja());
        stmt.setString(20, Cad.getCargo());
        stmt.setString(21, Cad.getBatizado());
        stmt.setBytes(22, Cad.getFoto());*/
       // stmt.executeQuery();
       
       // while (rs.next()){
        // capturando o valor que retorna (a soma)
     
      // String nome = rs.getString(1);
       //int total = rs.getInt("total");
     
  
       
     //   }
       //  JOptionPane.showMessageDialog(null, "Valores somados com Sucesso!!");
       
    //} catch (SQLException ex) {
        
      //JOptionPane.showMessageDialog(null, "Erro ao somar valores do Banco de Dados!/n Erro: !!"+ex.getMessage());
    //}  
     } 
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 175, 239));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FORM HOME");
        jLabel1.setToolTipText("");

        sp.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        sp.setViewportView(jPanel1);

        jSeparator1.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator1.setForeground(new java.awt.Color(145, 212, 238));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(sp, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JScrollPane sp;
    // End of variables declaration//GEN-END:variables
}
