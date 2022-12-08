
package visao.form;

import Notification.Notification;
import UTIL.ManipularImagem;
import conexao.ConnectionFactory;
import controle.ImagensDao;
import controle.ScrollBarCustom;
import controleDao.DadosPessoais;
import controleDao.Visitante;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.MembroBean;
import modelo.VisitanteBean;
import org.springframework.util.StringUtils;
import visao.TelaPrincipal;


public class Form_Info extends javax.swing.JPanel {

    
    public Form_Info() throws SQLException {
        initComponents();
        
        jLabelPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        jLabelPesquisarVisitante.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
       
        //  add row table6
                
        spTable6.setVerticalScrollBar(new ScrollBarCustom());
        spTable6.setHorizontalScrollBar(new ScrollBarCustom());
         
        spTable6.getViewport().setBackground(Color.WHITE);
        JPanel p6 = new JPanel();
        p6.setBackground(Color.WHITE);
        spTable6.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p6);
        
        DefaultTableModel modelo6 = (DefaultTableModel) table6.getModel();
        table6.setRowSorter(new TableRowSorter (modelo6));
                  
        //  add row table7
                
        spTable7.setVerticalScrollBar(new ScrollBarCustom());
        spTable7.setHorizontalScrollBar(new ScrollBarCustom());
        spTable7.getViewport().setBackground(Color.WHITE);
        JPanel p7 = new JPanel();
        p7.setBackground(Color.WHITE);
        spTable7.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p7);
        
        DefaultTableModel modelo7 = (DefaultTableModel) table7.getModel();
        table7.setRowSorter(new TableRowSorter (modelo7));
     
        //  add row table8
                
        spTable8.setVerticalScrollBar(new ScrollBarCustom());
        spTable8.setHorizontalScrollBar(new ScrollBarCustom());
        spTable8.getViewport().setBackground(Color.WHITE);
        JPanel p8 = new JPanel();
        p8.setBackground(Color.WHITE);
        spTable8.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p8);
        
        DefaultTableModel modelo8 = (DefaultTableModel) table8.getModel();
        table8.setRowSorter(new TableRowSorter (modelo8));
        
     
        //  add row table9 Visitantes:
                
        spTable9.setVerticalScrollBar(new ScrollBarCustom());
        spTable9.setHorizontalScrollBar(new ScrollBarCustom());
         
        spTable9.getViewport().setBackground(Color.WHITE);
        JPanel v9 = new JPanel();
        v9.setBackground(Color.WHITE);
        spTable9.setCorner(JScrollPane.UPPER_RIGHT_CORNER, v9);
        
        DefaultTableModel modeloV9 = (DefaultTableModel) table9.getModel();
        table9.setRowSorter(new TableRowSorter (modeloV9));
                  
        //  add row table10 Visitantes
                
        spTable10.setVerticalScrollBar(new ScrollBarCustom());
        spTable10.setHorizontalScrollBar(new ScrollBarCustom());
        spTable10.getViewport().setBackground(Color.WHITE);
        JPanel v10 = new JPanel();
        v10.setBackground(Color.WHITE);
        spTable10.setCorner(JScrollPane.UPPER_RIGHT_CORNER, v10);
        
        DefaultTableModel modeloV10 = (DefaultTableModel) table10.getModel();
        table10.setRowSorter(new TableRowSorter (modeloV10));
     
        //  add row table11 Visitantes
                
        spTable11.setVerticalScrollBar(new ScrollBarCustom());
        spTable11.setHorizontalScrollBar(new ScrollBarCustom());
        spTable11.getViewport().setBackground(Color.WHITE);
        JPanel v11 = new JPanel();
        v11.setBackground(Color.WHITE);
        spTable11.setCorner(JScrollPane.UPPER_RIGHT_CORNER, v11);
        
        DefaultTableModel modeloV11 = (DefaultTableModel) table11.getModel();
        table11.setRowSorter(new TableRowSorter (modeloV11));
     
     
         Listar();
         ListarDC();
         ListarDR();
         ListarVisitante();
         ListarDCVisitante();
         ListarDRVisitante();
         
         
         
    }
    
    
    //Mostrar Membros na Tabela:
    
    private void Listar() throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table6.getModel(); 
       modelo.setNumRows(0);
       DadosPessoais jdao = new DadosPessoais();
       
        for(MembroBean p: jdao.Cadastro()) {
        
       modelo.addRow(new Object[]{
           
        p.getId(),
        p.getNomecompleto(),
        p.getGenero(),
        p.getData_de_nasc(),
        p.getNacionalidade(),
        p.getNaturalde(),
        p.getProvíncia(),
      
        });
        }
        
         }
    
      //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResult(String nomecompleto) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table6.getModel(); 
       modelo.setNumRows(0);
       DadosPessoais pdao = new DadosPessoais();

       for(MembroBean p: pdao.buscar(nomecompleto)) {
        
       modelo.addRow(new Object[]{
                     
        p.getId(),
        p.getNomecompleto(),
        p.getGenero(),
        p.getData_de_nasc(),
        p.getNacionalidade(),
        p.getNaturalde(),
        p.getProvíncia(),
       
        });
        }
    }
    
       //Mostrar Membros na Tabela:
    
    private void ListarDC() throws SQLException {
        
       DefaultTableModel modelo1 = (DefaultTableModel) table7.getModel(); 
       modelo1.setNumRows(0);
       DadosPessoais jdao = new DadosPessoais();
       
        for(MembroBean p: jdao.Cadastro()) {
        
       modelo1.addRow(new Object[]{
           
        p.getId(),
        p.getTelefone1(),
        p.getTelefone2(),
        p.getEmail(),
        p.getAcademico(),
        p.getBairro(),
        p.getRua(),
      
        });
        }
        
         }
    
      //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResultDC(String nomecompleto) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table7.getModel(); 
       modelo.setNumRows(0);
       DadosPessoais pdao = new DadosPessoais();

       for(MembroBean p: pdao.buscar(nomecompleto)) {
        
       modelo.addRow(new Object[]{
                     
        p.getId(),
        p.getTelefone1(),
        p.getTelefone2(),
        p.getEmail(),
        p.getAcademico(),
        p.getBairro(),
        p.getRua(),
       
        });
        }
    }
    
    //Mostrar Membros na Tabela:
    
    private void ListarDR() throws SQLException {
        
       DefaultTableModel modelo1 = (DefaultTableModel) table8.getModel(); 
       modelo1.setNumRows(0);
       DadosPessoais jdao = new DadosPessoais();
       
        for(MembroBean p: jdao.Cadastro()) {
        
       modelo1.addRow(new Object[]{
           
        p.getId(),
        p.getEstadocivil(),
        p.getPai(),
        p.getMae(),
        p.getCabeçafamilia(),
        p.getConjuge(),
        p.getQtdfilho(),
        p.getIgreja(),
        p.getCargo(),
        p.getBatizado(),
        
      
        });
        }
        
         }
    
    //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResultDR(String nomecompleto) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table8.getModel(); 
       modelo.setNumRows(0);
       DadosPessoais pdao = new DadosPessoais();

       for(MembroBean p: pdao.buscar(nomecompleto)) {
        
       modelo.addRow(new Object[]{
                     
        p.getId(),
        p.getEstadocivil(),
        p.getPai(),
        p.getMae(),
        p.getCabeçafamilia(),
        p.getConjuge(),
        p.getQtdfilho(),
        p.getIgreja(),
        p.getCargo(),
        p.getBatizado(),
       
        });
        }
    }
    
    //Mostrar Visitante na Tabela:
    
    private void ListarVisitante() throws SQLException {
        
       DefaultTableModel modelo3 = (DefaultTableModel) table9.getModel(); 
       modelo3.setNumRows(0);
       Visitante jdao = new Visitante();
       
        for(VisitanteBean p: jdao.CadastroV()) {
        
       modelo3.addRow(new Object[]{
           
        p.getId(),
        p.getNomecompleto(),
        p.getGenero(),
        p.getData_de_nasc(),
        p.getNacionalidade(),
        p.getNaturalde(),
        p.getProvíncia(),
      
        });
        }
        
         }
    
      //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResultVisitante(String nomecompleto) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table9.getModel(); 
       modelo.setNumRows(0);
       Visitante pdao = new Visitante();

       for(VisitanteBean p: pdao.buscar(nomecompleto)) {
        
       modelo.addRow(new Object[]{
                     
        p.getId(),
        p.getNomecompleto(),
        p.getGenero(),
        p.getData_de_nasc(),
        p.getNacionalidade(),
        p.getNaturalde(),
        p.getProvíncia(),
       
        });
        }
    }
    
       //Mostrar Visitante na Tabela:
    
    private void ListarDCVisitante() throws SQLException {
        
       DefaultTableModel modelo1 = (DefaultTableModel) table10.getModel(); 
       modelo1.setNumRows(0);
       Visitante jdao = new Visitante();
       
        for(VisitanteBean p: jdao.CadastroV()) {
        
       modelo1.addRow(new Object[]{
           
        p.getId(),
        p.getTelefone1(),
        p.getTelefone2(),
        p.getEmail(),
        p.getProfissao(),
        p.getBairro(),
        p.getRua(),
      
        });
        }
        
         }
    
      //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResultDCVisitante(String nomecompleto) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table10.getModel(); 
       modelo.setNumRows(0);
       Visitante pdao = new Visitante();

       for(VisitanteBean p: pdao.buscar(nomecompleto)) {
        
       modelo.addRow(new Object[]{
                     
        p.getId(),
        p.getTelefone1(),
        p.getTelefone2(),
        p.getEmail(),
        p.getProfissao(),
        p.getBairro(),
        p.getRua(),
       
        });
        }
    }
    
    //Mostrar Visitante na Tabela:
    
    private void ListarDRVisitante() throws SQLException {
        
       DefaultTableModel modelo5 = (DefaultTableModel) table11.getModel(); 
       modelo5.setNumRows(0);
       Visitante jdao = new Visitante();
       
        for(VisitanteBean p: jdao.CadastroV()) {
        
       modelo5.addRow(new Object[]{
           
        p.getId(),
        p.getEstadocivil(),
        p.getPai(),
        p.getMae(),
        p.getCabeçafamilia(),
        p.getConjuge(),
        p.getQtdfilho(),
        p.getIgreja(),
        p.getConheceuigreja(),
       
      
        });
        }
        
         }
    
    //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResultDRVisitante(String nomecompleto) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table11.getModel(); 
       modelo.setNumRows(0);
       Visitante pdaov = new Visitante();

       for(VisitanteBean p: pdaov.buscar(nomecompleto)) {
        
       modelo.addRow(new Object[]{
                     
        p.getId(),
        p.getEstadocivil(),
        p.getPai(),
        p.getMae(),
        p.getCabeçafamilia(),
        p.getConjuge(),
        p.getQtdfilho(),
        p.getIgreja(),
        p.getConheceuigreja(),
      
        });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        materialTabbed1 = new tabbed.MaterialTabbed();
        panelMembros = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnAtualizar = new swing.ButtonGradient();
        btnDeletar = new swing.ButtonGradient();
        jLabelPesquisar = new javax.swing.JLabel();
        txtProcurar = new controle.SearchText();
        spTable6 = new javax.swing.JScrollPane();
        table6 = new controle.Table();
        spTable7 = new javax.swing.JScrollPane();
        table7 = new controle.Table();
        spTable8 = new javax.swing.JScrollPane();
        table8 = new controle.Table();
        panelVisitantes = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btnAtualizarVisitante = new swing.ButtonGradient();
        btnDeletarVisitante = new swing.ButtonGradient();
        jLabelPesquisarVisitante = new javax.swing.JLabel();
        txtProcurarVisitante = new controle.SearchText();
        spTable9 = new javax.swing.JScrollPane();
        table9 = new controle.Table();
        spTable10 = new javax.swing.JScrollPane();
        table10 = new controle.Table();
        spTable11 = new javax.swing.JScrollPane();
        table11 = new controle.Table();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(14, 175, 239));

        materialTabbed1.setBackground(new java.awt.Color(255, 255, 255));
        materialTabbed1.setForeground(new java.awt.Color(14, 175, 239));
        materialTabbed1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N

        panelMembros.setBackground(new java.awt.Color(255, 255, 255));
        panelMembros.setPreferredSize(new java.awt.Dimension(720, 349));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-editar-20.png"))); // NOI18N
        btnAtualizar.setColor1(new java.awt.Color(126, 210, 244));
        btnAtualizar.setColor2(new java.awt.Color(14, 175, 239));
        btnAtualizar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
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
        txtProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarKeyReleased(evt);
            }
        });

        spTable6.setBackground(new java.awt.Color(255, 255, 255));
        spTable6.setBorder(null);

        table6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome Completo", "Gênero", "Data de Nasc", "Nacionalidade", "Natural de", "Província"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table6MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table6MouseReleased(evt);
            }
        });
        spTable6.setViewportView(table6);

        spTable7.setBackground(new java.awt.Color(255, 255, 255));
        spTable7.setBorder(null);

        table7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Telefone1", "Telefone2", "Email", "Academico", "Bairro", "Rua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table7MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table7MouseReleased(evt);
            }
        });
        spTable7.setViewportView(table7);

        spTable8.setBackground(new java.awt.Color(255, 255, 255));
        spTable8.setBorder(null);

        table8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado Civil", "Pai", "Mãe", "Cabeça Familiar", "Conjuge", "Qtd Filhos", "Igreja", "Cargo", "Batizado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, false, true, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table8MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table8MouseReleased(evt);
            }
        });
        spTable8.setViewportView(table8);
        if (table8.getColumnModel().getColumnCount() > 0) {
            table8.getColumnModel().getColumn(9).setHeaderValue("Batizado");
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spTable7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addComponent(spTable8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabelPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(spTable6, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable7, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable8, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelMembrosLayout = new javax.swing.GroupLayout(panelMembros);
        panelMembros.setLayout(panelMembrosLayout);
        panelMembrosLayout.setHorizontalGroup(
            panelMembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelMembrosLayout.setVerticalGroup(
            panelMembrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("Membros da Igreja", panelMembros);

        panelVisitantes.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btnAtualizarVisitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-editar-20.png"))); // NOI18N
        btnAtualizarVisitante.setColor1(new java.awt.Color(126, 210, 244));
        btnAtualizarVisitante.setColor2(new java.awt.Color(14, 175, 239));
        btnAtualizarVisitante.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAtualizarVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarVisitanteActionPerformed(evt);
            }
        });

        btnDeletarVisitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-lixo-20.png"))); // NOI18N
        btnDeletarVisitante.setColor1(new java.awt.Color(126, 210, 244));
        btnDeletarVisitante.setColor2(new java.awt.Color(14, 175, 239));
        btnDeletarVisitante.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDeletarVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarVisitanteActionPerformed(evt);
            }
        });

        jLabelPesquisarVisitante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPesquisarVisitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-20.png"))); // NOI18N
        jLabelPesquisarVisitante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPesquisarVisitanteMouseClicked(evt);
            }
        });

        txtProcurarVisitante.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProcurarVisitante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarVisitanteKeyReleased(evt);
            }
        });

        spTable9.setBackground(new java.awt.Color(255, 255, 255));
        spTable9.setBorder(null);

        table9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome Completo", "Gênero", "Data de Nasc", "Nacionalidade", "Natural de", "Província"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table9MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table9MouseReleased(evt);
            }
        });
        spTable9.setViewportView(table9);

        spTable10.setBackground(new java.awt.Color(255, 255, 255));
        spTable10.setBorder(null);

        table10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Telefone1", "Telefone2", "Email", "Profissão", "Bairro", "Rua"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table10MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table10MouseReleased(evt);
            }
        });
        spTable10.setViewportView(table10);

        spTable11.setBackground(new java.awt.Color(255, 255, 255));
        spTable11.setBorder(null);

        table11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Estado Civil", "Pai", "Mãe", "Cabeça Familiar", "Conjuge", "Qtd Filhos", "Igreja", "Conheceu como"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table11MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                table11MouseReleased(evt);
            }
        });
        spTable11.setViewportView(table11);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(txtProcurarVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPesquisarVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnAtualizarVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletarVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(182, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTable9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spTable10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 733, Short.MAX_VALUE)
                    .addComponent(spTable11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProcurarVisitante, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabelPesquisarVisitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtualizarVisitante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletarVisitante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(spTable9, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable10, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTable11, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelVisitantesLayout = new javax.swing.GroupLayout(panelVisitantes);
        panelVisitantes.setLayout(panelVisitantesLayout);
        panelVisitantesLayout.setHorizontalGroup(
            panelVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelVisitantesLayout.setVerticalGroup(
            panelVisitantesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("Visitantes", panelVisitantes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisarMouseClicked
        // TODO add your handling code here:

        if(txtProcurar.getText().equals("")){

            try {
                Listar();

            } catch (SQLException ex) {

            }
            try {
                ListarDC();

            } catch (SQLException ex) {

            }
            
            try {
                ListarDR();

            } catch (SQLException ex) {

            }

        }else {
            try {
                buscarResult(txtProcurar.getText());

                // JOptionPane.showMessageDialog(null, "Pesquisa feita com Sucesso!!");

            } catch (SQLException ex) {
                Logger.getLogger(Form_Pesquisa_Membros.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                buscarResultDC(txtProcurar.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                buscarResultDR(txtProcurar.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jLabelPesquisarMouseClicked

    private void txtProcurarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarKeyReleased
        // TODO add your handling code here:

      String fMaiuscula = StringUtils.capitalize(txtProcurar.getText());
      txtProcurar.setText(fMaiuscula);
        try {
            buscarResult(fMaiuscula);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Membros.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            buscarResultDC(fMaiuscula);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            buscarResultDR(fMaiuscula);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_txtProcurarKeyReleased

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        
            // TODO add your handling code here:
            
            MembroBean mb = new MembroBean();
            DadosPessoais dp = new DadosPessoais();
            
            if(table6.getSelectedRow() != -1  || table7.getSelectedRow() != -1 || table8.getSelectedRow() != -1){
                
                  mb.setId((int)table6.getValueAt(table6.getSelectedRow(), 0));
                  mb.setNomecompleto((String) table6.getValueAt(table6.getSelectedRow(), 1));
                  mb.setData_de_nasc((String) table6.getValueAt(table6.getSelectedRow(), 3));
                  mb.setNacionalidade((String) table6.getValueAt(table6.getSelectedRow(), 4));
                  mb.setNaturalde((String) table6.getValueAt(table6.getSelectedRow(), 5));
                  mb.setProvíncia((String) table6.getValueAt(table6.getSelectedRow(), 6));
                  
                  mb.setId((int) table7.getValueAt(table7.getSelectedRow(), 0));
                  mb.setTelefone1((String) table7.getValueAt(table7.getSelectedRow(), 1));
                  mb.setTelefone2((String) table7.getValueAt(table7.getSelectedRow(), 2));
                  mb.setEmail((String) table7.getValueAt(table7.getSelectedRow(), 3));
                  mb.setBairro((String) table7.getValueAt(table7.getSelectedRow(), 5));
                  mb.setRua((String) table7.getValueAt(table7.getSelectedRow(), 6));
                  
                  mb.setId((int) table8.getValueAt(table8.getSelectedRow(), 0));
                  mb.setPai((String) table8.getValueAt(table8.getSelectedRow(), 2));
                  mb.setMae((String) table8.getValueAt(table8.getSelectedRow(), 3));
                  mb.setConjuge((String) table8.getValueAt(table8.getSelectedRow(), 5));
                  mb.setIgreja((String) table8.getValueAt(table8.getSelectedRow(), 7));
                  
                 try {
                 dp.AtualizarMembros(mb);
                 } catch (SQLException ex) {
                 //JOptionPane.showMessageDialog(null, "Erro ao atualizar!/n Erro: !!"+ex.getMessage());
                 }
                 
        }
      
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:

        MembroBean esc = new MembroBean();
        DadosPessoais esdao = new DadosPessoais();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(table6.getSelectedRow() != -1){

            esc.setId((int) table6.getValueAt(table6.getSelectedRow(), 0));
          
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
            try {
                ListarDC();
            } catch (SQLException ex) {
            }
            try {
                ListarDR();
            } catch (SQLException ex) {
            }
        }

        txtProcurar.setText("");

    }//GEN-LAST:event_btnDeletarActionPerformed

    private void table6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table6MouseClicked
        // TODO add your handling code here:
        
        if(table6.getSelectedRow() != -1){

            txtProcurar.setText(table6.getValueAt(table6.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table6.getSelectedRow();
 
        table7.setRowSelectionInterval(indexs, indexs);
        table8.setRowSelectionInterval(indexs, indexs);
        
        
    }//GEN-LAST:event_table6MouseClicked

    private void table6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table6MouseReleased
        // TODO add your handling code here:
        
        if(table6.getSelectedRow() != -1){

            txtProcurar.setText(table6.getValueAt(table6.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table6.getSelectedRow();
 
        table7.setRowSelectionInterval(indexs, indexs);
        table8.setRowSelectionInterval(indexs, indexs);
        
        
    }//GEN-LAST:event_table6MouseReleased

    private void table7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table7MouseClicked
        // TODO add your handling code here:
        
        if(table7.getSelectedRow() != -1){

            txtProcurar.setText(table6.getValueAt(table7.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table7.getSelectedRow();
 
        table6.setRowSelectionInterval(indexs, indexs);
        table8.setRowSelectionInterval(indexs, indexs);
        
        
    }//GEN-LAST:event_table7MouseClicked

    private void table7MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table7MouseReleased
        // TODO add your handling code here:
        
          if(table7.getSelectedRow() != -1){

            txtProcurar.setText(table6.getValueAt(table7.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table7.getSelectedRow();
 
        table6.setRowSelectionInterval(indexs, indexs);
        table8.setRowSelectionInterval(indexs, indexs);
        
    }//GEN-LAST:event_table7MouseReleased

    private void table8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table8MouseClicked
        // TODO add your handling code here:
        
          if(table8.getSelectedRow() != -1){

            txtProcurar.setText(table6.getValueAt(table8.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table8.getSelectedRow();
 
        table7.setRowSelectionInterval(indexs, indexs);
        table6.setRowSelectionInterval(indexs, indexs);
        
        
    }//GEN-LAST:event_table8MouseClicked

    private void table8MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table8MouseReleased
        // TODO add your handling code here:
        
            if(table8.getSelectedRow() != -1){

            txtProcurar.setText(table6.getValueAt(table8.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table8.getSelectedRow();
 
        table7.setRowSelectionInterval(indexs, indexs);
        table6.setRowSelectionInterval(indexs, indexs);
     
    }//GEN-LAST:event_table8MouseReleased

    private void btnAtualizarVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarVisitanteActionPerformed
        // TODO add your handling code here:
        
            VisitanteBean mb = new VisitanteBean();
            Visitante dp = new Visitante();
            TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            if(table9.getSelectedRow() != -1  || table10.getSelectedRow() != -1 || table11.getSelectedRow() != -1){
                
                  mb.setId((int)table9.getValueAt(table9.getSelectedRow(), 0));
                  mb.setNomecompleto((String) table9.getValueAt(table9.getSelectedRow(), 1));
                  mb.setData_de_nasc((String) table9.getValueAt(table9.getSelectedRow(), 3));
                  mb.setNacionalidade((String) table9.getValueAt(table9.getSelectedRow(), 4));
                  mb.setNaturalde((String) table9.getValueAt(table9.getSelectedRow(), 5));
                  mb.setProvíncia((String) table9.getValueAt(table9.getSelectedRow(), 6));
                  
                  mb.setId((int) table10.getValueAt(table10.getSelectedRow(), 0));
                  mb.setTelefone1((String) table10.getValueAt(table10.getSelectedRow(), 1));
                  mb.setTelefone2((String) table10.getValueAt(table10.getSelectedRow(), 2));
                  mb.setEmail((String) table10.getValueAt(table10.getSelectedRow(), 3));
                  mb.setProfissao((String) table10.getValueAt(table10.getSelectedRow(), 4));
                  mb.setBairro((String) table10.getValueAt(table10.getSelectedRow(), 5));
                  mb.setRua((String) table10.getValueAt(table10.getSelectedRow(), 6));
                  
                  mb.setId((int) table11.getValueAt(table11.getSelectedRow(), 0));
                  mb.setPai((String) table11.getValueAt(table11.getSelectedRow(), 2));
                  mb.setMae((String) table11.getValueAt(table11.getSelectedRow(), 3));
                  mb.setConjuge((String) table11.getValueAt(table11.getSelectedRow(), 5));
                  mb.setIgreja((String) table11.getValueAt(table11.getSelectedRow(), 7));
                  mb.setConheceuigreja((String) table11.getValueAt(table11.getSelectedRow(), 8));
                  
                 try {
                 dp.AtualizarVisitante(mb);
                 
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, " Dados Atualizados com Sucesso em Grupo!");
         nt.showNotification();
                 
                 } catch (SQLException ex) {
                 //JOptionPane.showMessageDialog(null, "Erro ao atualizar!/n Erro: !!"+ex.getMessage());
                 }
                 
        }
        
    }//GEN-LAST:event_btnAtualizarVisitanteActionPerformed

    private void btnDeletarVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarVisitanteActionPerformed
        // TODO add your handling code here:
        
        VisitanteBean esc = new VisitanteBean();
        Visitante esdao = new Visitante();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(table9.getSelectedRow() != -1){

            esc.setId((int) table9.getValueAt(table9.getSelectedRow(), 0));
          
            // Deletar Visitante:

            try {
                esdao.deleteVisitante(esc);
                
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Excluído com Sucesso!!");
         nt.showNotification();
           
            } catch (SQLException ex) {

            }

            try {
                ListarVisitante();
            } catch (SQLException ex) {
            }
            try {
                ListarDCVisitante();
            } catch (SQLException ex) {
            }
            try {
                ListarDRVisitante();
            } catch (SQLException ex) {
            }
        }

        txtProcurarVisitante.setText("");

    }//GEN-LAST:event_btnDeletarVisitanteActionPerformed

    private void jLabelPesquisarVisitanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisarVisitanteMouseClicked
        // TODO add your handling code here:
        
        if(txtProcurarVisitante.getText().equals("")){

            try {
                ListarVisitante();

            } catch (SQLException ex) {

            }
            try {
                ListarDCVisitante();

            } catch (SQLException ex) {

            }
            
            try {
                ListarDRVisitante();

            } catch (SQLException ex) {

            }

        }else {
            try {
                buscarResultVisitante(txtProcurarVisitante.getText());

                // JOptionPane.showMessageDialog(null, "Pesquisa feita com Sucesso!!");

            } catch (SQLException ex) {
                Logger.getLogger(Form_Pesquisa_Membros.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                buscarResultDCVisitante(txtProcurarVisitante.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {
                buscarResultDRVisitante(txtProcurarVisitante.getText());
            } catch (SQLException ex) {
                Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }//GEN-LAST:event_jLabelPesquisarVisitanteMouseClicked

    private void txtProcurarVisitanteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarVisitanteKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtProcurarVisitante.getText());
      txtProcurarVisitante.setText(fMaiuscula);
            try {
            buscarResultVisitante(fMaiuscula);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Membros.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            buscarResultDCVisitante(fMaiuscula);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            buscarResultDRVisitante(fMaiuscula);
        } catch (SQLException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }//GEN-LAST:event_txtProcurarVisitanteKeyReleased

    private void table9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table9MouseClicked
        // TODO add your handling code here:
        
            if(table9.getSelectedRow() != -1){

            txtProcurarVisitante.setText(table9.getValueAt(table9.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table9.getSelectedRow();
 
        table10.setRowSelectionInterval(indexs, indexs);
        table11.setRowSelectionInterval(indexs, indexs);
     
        
    }//GEN-LAST:event_table9MouseClicked

    private void table9MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table9MouseReleased
        // TODO add your handling code here:
        
            if(table9.getSelectedRow() != -1){

            txtProcurarVisitante.setText(table6.getValueAt(table9.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table9.getSelectedRow();
 
        table10.setRowSelectionInterval(indexs, indexs);
        table11.setRowSelectionInterval(indexs, indexs);
     
        
    }//GEN-LAST:event_table9MouseReleased

    private void table10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table10MouseClicked
        // TODO add your handling code here:
        
            if(table10.getSelectedRow() != -1){

            txtProcurarVisitante.setText(table9.getValueAt(table10.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table10.getSelectedRow();
 
        table11.setRowSelectionInterval(indexs, indexs);
        table9.setRowSelectionInterval(indexs, indexs);
     
        
    }//GEN-LAST:event_table10MouseClicked

    private void table10MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table10MouseReleased
        // TODO add your handling code here:
        
            if(table10.getSelectedRow() != -1){

            txtProcurarVisitante.setText(table9.getValueAt(table10.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table10.getSelectedRow();
 
        table11.setRowSelectionInterval(indexs, indexs);
        table9.setRowSelectionInterval(indexs, indexs);
     
        
    }//GEN-LAST:event_table10MouseReleased

    private void table11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table11MouseClicked
        // TODO add your handling code here:
        
           if(table11.getSelectedRow() != -1){

            txtProcurarVisitante.setText(table9.getValueAt(table11.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table11.getSelectedRow();
 
        table10.setRowSelectionInterval(indexs, indexs);
        table9.setRowSelectionInterval(indexs, indexs);
      
    }//GEN-LAST:event_table11MouseClicked

    private void table11MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table11MouseReleased
        // TODO add your handling code here:
        
          if(table11.getSelectedRow() != -1){

            txtProcurarVisitante.setText(table9.getValueAt(table11.getSelectedRow(), 1).toString());  
        
          }
         
        int indexs =  table11.getSelectedRow();
 
        table10.setRowSelectionInterval(indexs, indexs);
        table9.setRowSelectionInterval(indexs, indexs);
      
        
    }//GEN-LAST:event_table11MouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient btnAtualizar;
    private swing.ButtonGradient btnAtualizarVisitante;
    private swing.ButtonGradient btnDeletar;
    private swing.ButtonGradient btnDeletarVisitante;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JLabel jLabelPesquisarVisitante;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel panelMembros;
    private javax.swing.JPanel panelVisitantes;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTable1;
    private javax.swing.JScrollPane spTable10;
    private javax.swing.JScrollPane spTable11;
    private javax.swing.JScrollPane spTable2;
    private javax.swing.JScrollPane spTable6;
    private javax.swing.JScrollPane spTable7;
    private javax.swing.JScrollPane spTable8;
    private javax.swing.JScrollPane spTable9;
    private controle.Table table;
    private controle.Table table1;
    private controle.Table table10;
    private controle.Table table11;
    private controle.Table table2;
    private controle.Table table6;
    private controle.Table table7;
    private controle.Table table8;
    private controle.Table table9;
    private controle.SearchText txtProcurar;
    private controle.SearchText txtProcurarVisitante;
    // End of variables declaration//GEN-END:variables
}
