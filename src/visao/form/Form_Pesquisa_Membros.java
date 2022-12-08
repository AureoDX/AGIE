
package visao.form;

import Notification.Notification;
import UTIL.ManipularImagem;
import conexao.ConnectionFactory;
import controle.ImagensDao;
import controle.LimiteTexto;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import controle.ScrollBarCustom;
import controleDao.DadosPessoais;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.MembroBean;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.util.StringUtils;
import visao.TelaPrincipal;
import static visao.TelaPrincipal.main;

public class Form_Pesquisa_Membros extends javax.swing.JPanel {
    
    
    BufferedImage imagem;
    
    public Form_Pesquisa_Membros() throws SQLException {
        initComponents();
        setOpaque(false);
        
        
        txtProcurar.setDocument(new LimiteTexto(30));
        jLabelPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        btnAtualizarImagem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        btnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        
        //  add row table
                
        spTable.setVerticalScrollBar(new ScrollBarCustom());
        spTable.setHorizontalScrollBar(new ScrollBarCustom());
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
         DefaultTableModel modelo = (DefaultTableModel) table.getModel();
         table.setRowSorter(new TableRowSorter (modelo));
     
        // this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/Igreja.png")).getImage()); 
       
     Listar();
     setarFoto();
    }
  //Mostrar Membros na Tabela:
    
    private void Listar() throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       DadosPessoais jdao = new DadosPessoais();
       
        for(MembroBean p: jdao.Cadastro()) {
        
       modelo.addRow(new Object[]{
           
        p.getNomecompleto(),
        p.getBairro(),
        p.getTelefone1(),
        p.getCargo(),
        p.getData(),
      
        });
        }
        
         }
    
    //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResult(String nomecompleto) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       DadosPessoais pdao = new DadosPessoais();

       for(MembroBean p: pdao.buscar(nomecompleto)) {
        
       modelo.addRow(new Object[]{
                     
        p.getNomecompleto(),
        p.getBairro(),
        p.getTelefone1(),
        p.getCargo(),
        p.getData(),
       
        });
        }
    }
     //Gerar Relatório Lista de Jogadores:
    /* private void gerarRelatórioListaE() throws SQLException, JRException {  
         
       Connection conn = ConnectionFactory.getConnection();
       
       String sql =" SELECT ORDER BY nome, sobrenome, conhecido_como, data_de_nasc, altura, nome_pai, nome_mae, nivel_acad, n_tlf, província, morada ASC from escolinha";
       
       JasperPrint jaspertPrint = null;
       
       //Caminho Relatório:
     
      InputStream caminhoRelatório = this.getClass().getClassLoader().getResourceAsStream("relatórios/RelatórioListaJogadores Escolinha.jasper");
      try {
          jaspertPrint = JasperFillManager.fillReport(caminhoRelatório, null, conn);
          
      } catch (JRException ex) {
          
       JOptionPane.showMessageDialog(null, "Error:"+ex.getMessage());
      }
      JasperViewer view = new JasperViewer(jaspertPrint, false);
      view.setVisible(true);
      
     } */
    
     private void setarFoto () {
    
    ImageIcon foto = new ImageIcon(getClass().getResource("/imagens/icons8-convidado-masculino-100.png")); 
    jFoto.setIcon(foto);
    
     }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jFoto = new javax.swing.JLabel();
        btnAtualizarImagem = new swing.ButtonGradient();
        panelRound1 = new JPanelRounder.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        spTable = new javax.swing.JScrollPane();
        table = new controle.Table();
        btnRelatorio = new swing.ButtonGradient();
        btnDeletar = new swing.ButtonGradient();
        jLabelPesquisar = new javax.swing.JLabel();
        txtProcurar = new controle.SearchText();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jFoto.setBackground(new java.awt.Color(31, 159, 210));
        jFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnAtualizarImagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/picture_photo_image_icon_131252.png"))); // NOI18N
        btnAtualizarImagem.setColor1(new java.awt.Color(126, 210, 244));
        btnAtualizarImagem.setColor2(new java.awt.Color(14, 175, 239));
        btnAtualizarImagem.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAtualizarImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarImagemActionPerformed(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(255, 255, 255));
        panelRound1.setRoundBottomLeft(10);
        panelRound1.setRoundBottomRight(10);
        panelRound1.setRoundTopLeft(10);
        panelRound1.setRoundTopRight(10);

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(14, 175, 239));
        jLabel1.setText("Lista dos membros da Igreja");

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome Completo", "Endereço", "Telefone 1", "Igreja", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-gire-para-a-esquerda-20.png"))); // NOI18N
        btnRelatorio.setColor1(new java.awt.Color(126, 210, 244));
        btnRelatorio.setColor2(new java.awt.Color(14, 175, 239));
        btnRelatorio.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioActionPerformed(evt);
            }
        });

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-lixo-20.png"))); // NOI18N
        btnDeletar.setColor1(new java.awt.Color(126, 210, 244));
        btnDeletar.setColor2(new java.awt.Color(14, 175, 239));
        btnDeletar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        jLabelPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-20.png"))); // NOI18N
        jLabelPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPesquisarMouseClicked(evt);
            }
        });

        txtProcurar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProcurar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtProcurarMouseReleased(evt);
            }
        });
        txtProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator1.setForeground(new java.awt.Color(145, 212, 238));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 317, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(jSeparator1)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAtualizarImagem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabelPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addComponent(jFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAtualizarImagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 735, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
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
            .addGap(0, 735, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAtualizarImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarImagemActionPerformed
        // TODO add your handling code here:

        MembroBean cab = null;
        ImagensDao dao = new ImagensDao();
        DadosPessoais cadao = new DadosPessoais();

        JFrame framePrincipal = new JFrame();
        framePrincipal.setIconImage(new ImageIcon(getClass().getResource("/imagens/Igreja.png")).getImage());

        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("AGIE");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter fl = new FileNameExtensionFilter("JPEG", "jpg");
        fc.setFileFilter(fl);
        int res = fc.showOpenDialog(framePrincipal);

        if (res == JFileChooser.APPROVE_OPTION) {
            File arquivo = fc.getSelectedFile();

            try {
                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 240, 190);

                jFoto.setIcon(new ImageIcon(imagem));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Voce não selecionou nenhum arquivo." + ex);
            }

            if (table.getSelectedRow() != -1){

                txtProcurar.setText(table.getValueAt(table.getSelectedRow(), 0).toString());

                String nome = txtProcurar.getText();

                try {
                    cab = dao.buscarFoto(nome);

                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Erro ao Buscar foto ! "+ex.getMessage()) ;
                }

                cab.setFoto(ManipularImagem.getImgBytes(imagem));

                try {
                    cadao.Atualizar(cab);

                    JOptionPane.showMessageDialog(null, "Foto atualizada com sucesso! ");

                } catch (SQLException ex) {

                }

            }
        }

    }//GEN-LAST:event_btnAtualizarImagemActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:

        ImagensDao dao = new ImagensDao();
        MembroBean exe = null;

        if(table.getSelectedRow() != -1){

            txtProcurar.setText(table.getValueAt(table.getSelectedRow(), 0).toString());

            String nome = txtProcurar.getText();

            try {
                exe = dao.buscarFoto(nome);

            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "Erro ao Buscar foto! "+ex.getMessage()) ;
            }

            ManipularImagem.exibiImagemLabel(exe.getFoto(), jFoto);

        }

    }//GEN-LAST:event_tableMouseClicked

    private void btnRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioActionPerformed
        // TODO add your handling code here:

        /*  final TelaAguardeEscolinha carregando = new TelaAguardeEscolinha();
        carregando.setVisible(true);
        Thread t = new Thread() {

            @Override
            public void run () {
                //Método de imprimir:

                try {
                    try {

                        gerarRelatórioListaE();

                        carregando.dispose();

                    } catch (JRException ex) {
                        Logger.getLogger(TelaJogadoresEscolinha.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (SQLException ex) {

                }

            }

        };

        t.start();*/

    }//GEN-LAST:event_btnRelatorioActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:

        MembroBean esc = new MembroBean();
        DadosPessoais esdao = new DadosPessoais();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Pesquisa_Membros.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Pesquisa_Membros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(table.getSelectedRow() != -1){

            esc.setNomecompleto((String) table.getValueAt(table.getSelectedRow(), 0));

            // Deletar Membros:

            try {
                esdao.delete(esc);
                
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Excluído com Sucesso!!");
         nt.showNotification();   
                
            } catch (SQLException ex) {

            }

            try {
                Listar();
            } catch (SQLException ex) {
            }
        }

        txtProcurar.setText("");

    }//GEN-LAST:event_btnDeletarActionPerformed

    private void jLabelPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisarMouseClicked
        // TODO add your handling code here:

        if(txtProcurar.getText().equals("")){

            try {
                Listar();

            } catch (SQLException ex) {

            }

        }else {
            try {
                buscarResult(txtProcurar.getText());

                // JOptionPane.showMessageDialog(null, "Pesquisa feita com Sucesso!!");

            } catch (SQLException ex) {
                Logger.getLogger(Form_Pesquisa_Visitante.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_jLabelPesquisarMouseClicked

    private void txtProcurarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProcurarMouseReleased
        // TODO add your handling code here:

      String fMaiuscula = StringUtils.capitalize(txtProcurar.getText());
      txtProcurar.setText(fMaiuscula);
        
        try {
            buscarResult(fMaiuscula);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Membros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_txtProcurarMouseReleased

    private void txtProcurarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarKeyReleased
        // TODO add your handling code here:
       String fMaiuscula = StringUtils.capitalize(txtProcurar.getText());
       txtProcurar.setText(fMaiuscula);
        try {
            buscarResult(fMaiuscula);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Membros.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_txtProcurarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient btnAtualizarImagem;
    private swing.ButtonGradient btnDeletar;
    private swing.ButtonGradient btnRelatorio;
    private javax.swing.JLabel jFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private JPanelRounder.PanelRound panelRound1;
    private javax.swing.JScrollPane spTable;
    private controle.Table table;
    private controle.SearchText txtProcurar;
    // End of variables declaration//GEN-END:variables
}
