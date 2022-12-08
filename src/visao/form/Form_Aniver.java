

package visao.form;

import conexao.ConnectionFactory;
import controle.LimiteTexto;
import controle.ScrollBarCustom;
import controleDao.Aniversario;
import controleDao.DadosPessoais;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modelo.AniversarianteBean;
import modelo.MembroBean;


public class Form_Aniver extends javax.swing.JPanel {

    /** Creates new form Form_Aniver */
    public Form_Aniver() throws SQLException {
        initComponents();
        
      jLabelPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      jLabelPesquisar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      table1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      
        //  add row table
                
        spTable.setVerticalScrollBar(new ScrollBarCustom());
        spTable.setHorizontalScrollBar(new ScrollBarCustom());
        spTable.getViewport().setBackground(Color.WHITE);
        
        spTable1.setVerticalScrollBar(new ScrollBarCustom());
        spTable1.setHorizontalScrollBar(new ScrollBarCustom());
        spTable1.getViewport().setBackground(Color.WHITE);
        
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p); 
        spTable1.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p); 
        
        aniverListar();
        //aniverListarMes();
        
    }

      //Mostrar valores de Aniversário na Tabela:
    
    public void aniverListar() throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       
       Aniversario bdao = new Aniversario();
       for(MembroBean p: bdao.Cadastro()) {
        
       modelo.addRow(new Object[]{
          
        p.getNomecompleto(),
        p.getCargo(),
        p.getTelefone1(),
        p.getBairro(),
        p.getEmail(),
        p.getData_de_nasc(),
        
        });
        }
         }
    
    
      //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResultAniversario(String data) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       Aniversario pdao = new Aniversario();
       
       for(MembroBean p: pdao.buscar(data)) {
        
       modelo.addRow(new Object[]{
                     
        p.getNomecompleto(),
        p.getCargo(),
        p.getTelefone1(),
        p.getBairro(),
        p.getEmail(),
        p.getData_de_nasc(),
        
        });
        }
    } 
    
      //Mostrar valores de Aniversário na Tabela:
    
    public void aniverListarMes() throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table1.getModel(); 
       modelo.setNumRows(0);
       
       Aniversario bdao = new Aniversario();
       for(MembroBean p: bdao.Cadastro()) {
        
       modelo.addRow(new Object[]{
          
        p.getNomecompleto(),
        p.getCargo(),
        p.getTelefone1(),
        p.getBairro(),
        p.getEmail(),
        p.getData_de_nasc(),
        
        });
        }
         }
    
    
      //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResultAniversarioMes(String data) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table1.getModel(); 
       modelo.setNumRows(0);
       Aniversario pdao = new Aniversario();
       
       for(MembroBean p: pdao.buscar(data)) {
        
       modelo.addRow(new Object[]{
                     
        p.getNomecompleto(),
        p.getCargo(),
        p.getTelefone1(),
        p.getBairro(),
        p.getEmail(),
        p.getData_de_nasc(),
        
        });
        }
    } 
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        materialTabbed1 = new tabbed.MaterialTabbed();
        panelListadeAniversariantes = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnADD = new swing.ButtonGradient();
        panelRound1 = new JPanelRounder.PanelRound();
        spTable = new javax.swing.JScrollPane();
        table = new controle.Table();
        jLabelPesquisar = new javax.swing.JLabel();
        txtProcurar = new controle.SearchText();
        jSeparator1 = new javax.swing.JSeparator();
        panelAniversariantesdomes = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        panelRound2 = new JPanelRounder.PanelRound();
        spTable1 = new javax.swing.JScrollPane();
        table1 = new controle.Table();
        jLabelPesquisar1 = new javax.swing.JLabel();
        txtProcurar1 = new controle.SearchText();
        jSeparator2 = new javax.swing.JSeparator();

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        materialTabbed1.setBackground(new java.awt.Color(255, 255, 255));
        materialTabbed1.setForeground(new java.awt.Color(14, 175, 239));
        materialTabbed1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        materialTabbed1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                materialTabbed1StateChanged(evt);
            }
        });

        panelListadeAniversariantes.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(31, 159, 210));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-presente-100.png"))); // NOI18N

        btnADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-gire-para-a-esquerda-20.png"))); // NOI18N
        btnADD.setColor1(new java.awt.Color(126, 210, 244));
        btnADD.setColor2(new java.awt.Color(14, 175, 239));
        btnADD.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cargo", "Telefone1", "Endereço", "Email", "Data de Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout panelRound1Layout = new javax.swing.GroupLayout(panelRound1);
        panelRound1.setLayout(panelRound1Layout);
        panelRound1Layout.setHorizontalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

        jLabelPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-20.png"))); // NOI18N
        jLabelPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPesquisarMouseClicked(evt);
            }
        });

        txtProcurar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator1.setForeground(new java.awt.Color(145, 212, 238));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnADD, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(btnADD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelListadeAniversariantesLayout = new javax.swing.GroupLayout(panelListadeAniversariantes);
        panelListadeAniversariantes.setLayout(panelListadeAniversariantesLayout);
        panelListadeAniversariantesLayout.setHorizontalGroup(
            panelListadeAniversariantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelListadeAniversariantesLayout.setVerticalGroup(
            panelListadeAniversariantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListadeAniversariantesLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Lista de Aniversariantes", panelListadeAniversariantes);

        panelAniversariantesdomes.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(31, 159, 210));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-presente-100.png"))); // NOI18N

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(10);
        panelRound2.setRoundBottomRight(10);
        panelRound2.setRoundTopLeft(10);
        panelRound2.setRoundTopRight(10);

        spTable1.setBackground(new java.awt.Color(255, 255, 255));
        spTable1.setBorder(null);

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cargo", "Telefone1", "Endereço", "Email", "Data de Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        spTable1.setViewportView(table1);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTable1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTable1, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

        jLabelPesquisar1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPesquisar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-20.png"))); // NOI18N
        jLabelPesquisar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPesquisar1MouseClicked(evt);
            }
        });

        txtProcurar1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProcurar1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurar1KeyReleased(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator2.setForeground(new java.awt.Color(145, 212, 238));

        javax.swing.GroupLayout panelAniversariantesdomesLayout = new javax.swing.GroupLayout(panelAniversariantesdomes);
        panelAniversariantesdomes.setLayout(panelAniversariantesdomesLayout);
        panelAniversariantesdomesLayout.setHorizontalGroup(
            panelAniversariantesdomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(panelRound2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelAniversariantesdomesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtProcurar1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabelPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 124, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panelAniversariantesdomesLayout.setVerticalGroup(
            panelAniversariantesdomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAniversariantesdomesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panelAniversariantesdomesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProcurar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPesquisar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        materialTabbed1.addTab("Aniversariantes do mês", panelAniversariantesdomes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:

        if(table.getSelectedRow() != -1){

            txtProcurar.setText(table.getValueAt(table.getSelectedRow(), 0).toString());

        }

    }//GEN-LAST:event_tableMouseClicked

    private void jLabelPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisarMouseClicked
        // TODO add your handling code here:

        if(txtProcurar.getText().equals("")){

            try {
                aniverListar();

            } catch (SQLException ex) {

            }

        }else {
            try {
                buscarResultAniversario(txtProcurar.getText());

                // JOptionPane.showMessageDialog(null, "Pesquisa feita com Sucesso!!");

            } catch (SQLException ex) {

            }

        }

    }//GEN-LAST:event_jLabelPesquisarMouseClicked

    private void txtProcurarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarKeyReleased
        // TODO add your handling code here:
        
        try {
            buscarResultAniversario(txtProcurar.getText());
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_txtProcurarKeyReleased

    private void materialTabbed1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_materialTabbed1StateChanged
        // TODO add your handling code here:
        try {

            aniverListar();
        } catch (SQLException ex) {

        }

    }//GEN-LAST:event_materialTabbed1StateChanged

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed
        // TODO add your handling code here:
        
        AniversarianteBean ab = new AniversarianteBean();
        
        Aniversario an = new Aniversario();
        
       
        
                if(txtProcurar.getText().equals("")){

                System.out.println("Campo Procurar está vazio!");

        }else {
                    
            if(table.getSelectedRow() != -1){

            txtProcurar.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
           // an.Salvar();
        }
            try {
                buscarResultAniversario(txtProcurar.getText());
                
                
               
            } catch (SQLException ex) {
                Logger.getLogger(Form_Aniver.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }//GEN-LAST:event_btnADDActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        // TODO add your handling code here:
        
        if(table1.getSelectedRow() != -1){

            txtProcurar.setText(table1.getValueAt(table1.getSelectedRow(), 0).toString());

        }
     
    }//GEN-LAST:event_table1MouseClicked

    private void jLabelPesquisar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisar1MouseClicked
        // TODO add your handling code here:
        
          if(txtProcurar.getText().equals("")){

            try {
                aniverListar();

            } catch (SQLException ex) {

            }

        }else {
            try {
                buscarResultAniversario(txtProcurar.getText());

                // JOptionPane.showMessageDialog(null, "Pesquisa feita com Sucesso!!");

            } catch (SQLException ex) {

            }

        }
        
    }//GEN-LAST:event_jLabelPesquisar1MouseClicked

    private void txtProcurar1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurar1KeyReleased
        // TODO add your handling code here:
        
          try {
            buscarResultAniversario(txtProcurar.getText());
        } catch (SQLException ex) {

        }
        
    }//GEN-LAST:event_txtProcurar1KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient btnADD;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JLabel jLabelPesquisar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel panelAniversariantesdomes;
    private javax.swing.JPanel panelListadeAniversariantes;
    private JPanelRounder.PanelRound panelRound1;
    private JPanelRounder.PanelRound panelRound2;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    private controle.Table table;
    private controle.Table table1;
    private controle.SearchText txtProcurar;
    private controle.SearchText txtProcurar1;
    // End of variables declaration//GEN-END:variables

}
