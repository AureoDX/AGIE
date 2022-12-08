

package visao.form;

import Atxy2k.CustomTextField.RestrictedTextField;
import Notification.Notification;
import controle.LimiteTexto;
import controle.ScrollBarCustom;
import controleDao.Ensino;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modelo.EnsinoBean;
import org.springframework.util.StringUtils;
import visao.TelaPrincipal;


public class Form_Ensino extends javax.swing.JPanel {

   
    public Form_Ensino() throws SQLException {
        initComponents();   
         setOpaque(false);
       
      Listar();  
         
      jLabelPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      btnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        
      txtProcurar.setDocument(new LimiteTexto(30));
   
      txtClasse.setDocument(new LimiteTexto(30)); 
      txtNome.setDocument(new LimiteTexto(25)); 
      limitarnum();
        
        //  add row table
                
        spTable.setVerticalScrollBar(new ScrollBarCustom());
        spTable.setHorizontalScrollBar(new ScrollBarCustom());
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
       
    }
    
      private void limitarnum(){ 
      
        RestrictedTextField r = new RestrictedTextField(txtLicao);
        r.setLimit(4);
        r.setOnlyNums(true);
        
   } 
    
 private void limparCamposEnsino () {
        
    txtClasse.setText("");
    txtNome.setText("");            
    txtBairro.setText("");            
    txtEmail.setText("");
    comboMembro.setSelectedIndex(-1);
    txtLicao.setText("");
    jFTelefone1.setText("");
   
     }
    
     //Mostrar Membros na Tabela:
    
    private void Listar() throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       Ensino jdao = new Ensino();
       
        for(EnsinoBean p: jdao.Cadastro()) {
        
       modelo.addRow(new Object[]{
           
        p.getId(),
        p.getClasse(),
        p.getNome(),
        p.getBairro(),
        p.getEmail(),
        p.getMembro(),
        p.getLicao(),
        p.getTelefone1(),
        p.getData(),
      
        });
        }
        
         }
    
    //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResult(String nomecompleto) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       Ensino pdao = new Ensino();
       
       for(EnsinoBean p: pdao.buscar(nomecompleto)) {
        
       modelo.addRow(new Object[]{
                     
        p.getId(),
        p.getClasse(),
        p.getNome(),
        p.getBairro(),
        p.getEmail(),
        p.getMembro(),
        p.getLicao(),
        p.getTelefone1(),
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
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        materialTabbed1 = new tabbed.MaterialTabbed();
        panelEscolaDominical = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtEmail = new textfield.TextField();
        txtLicao = new textfield.TextField();
        txtBairro = new textfield.TextField();
        txtNome = new textfield.TextField();
        jFTelefone1 = new textfield.jFormattedTextField();
        btnGuardar = new swing.ButtonGradient();
        btnCancelar = new swing.ButtonGradient();
        comboMembro = new combobox.Combobox();
        txtClasse = new textfield.TextField();
        panelListaAlunos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new JPanelRounder.PanelRound();
        spTable = new javax.swing.JScrollPane();
        table = new controle.Table();
        jSeparator1 = new javax.swing.JSeparator();
        btnAtualizar = new swing.ButtonGradient();
        btnRelatorio = new swing.ButtonGradient();
        btnDeletar = new swing.ButtonGradient();
        jLabelPesquisar = new javax.swing.JLabel();
        txtProcurar = new controle.SearchText();

        setForeground(new java.awt.Color(14, 175, 239));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        materialTabbed1.setBackground(new java.awt.Color(255, 255, 255));
        materialTabbed1.setForeground(new java.awt.Color(14, 175, 239));
        materialTabbed1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        materialTabbed1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                materialTabbed1StateChanged(evt);
            }
        });

        panelEscolaDominical.setBackground(new java.awt.Color(255, 255, 255));
        panelEscolaDominical.setPreferredSize(new java.awt.Dimension(720, 349));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(742, 656));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(126, 210, 244));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro");

        jSeparator3.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator3.setForeground(new java.awt.Color(145, 212, 238));

        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEmail.setLabelText("Email");
        txtEmail.setLineColor(new java.awt.Color(14, 175, 239));
        txtEmail.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtLicao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtLicao.setLabelText("Lição");
        txtLicao.setLineColor(new java.awt.Color(14, 175, 239));
        txtLicao.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtLicao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLicaoActionPerformed(evt);
            }
        });

        txtBairro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBairro.setLabelText("Bairro");
        txtBairro.setLineColor(new java.awt.Color(14, 175, 239));
        txtBairro.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBairroActionPerformed(evt);
            }
        });
        txtBairro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBairroKeyReleased(evt);
            }
        });

        txtNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNome.setLabelText("Nome");
        txtNome.setLineColor(new java.awt.Color(14, 175, 239));
        txtNome.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        txtNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeKeyReleased(evt);
            }
        });

        jFTelefone1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTelefone1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        try {
            jFTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTelefone1.setLabelText("Telefone 1");

        btnGuardar.setText("Guardar");
        btnGuardar.setColor1(new java.awt.Color(126, 210, 244));
        btnGuardar.setColor2(new java.awt.Color(14, 175, 239));
        btnGuardar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setColor1(new java.awt.Color(126, 210, 244));
        btnCancelar.setColor2(new java.awt.Color(14, 175, 239));
        btnCancelar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        comboMembro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Professor", "Aluno" }));
        comboMembro.setSelectedIndex(-1);
        comboMembro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboMembro.setLabeText("Membro");
        comboMembro.setLineColor(new java.awt.Color(14, 175, 239));

        txtClasse.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtClasse.setLabelText("Classe");
        txtClasse.setLineColor(new java.awt.Color(14, 175, 239));
        txtClasse.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtClasse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClasseActionPerformed(evt);
            }
        });
        txtClasse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtClasseKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClasse, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFTelefone1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboMembro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLicao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLicao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jFTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 641, Short.MAX_VALUE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(633, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelEscolaDominicalLayout = new javax.swing.GroupLayout(panelEscolaDominical);
        panelEscolaDominical.setLayout(panelEscolaDominicalLayout);
        panelEscolaDominicalLayout.setHorizontalGroup(
            panelEscolaDominicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(panelEscolaDominicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
        );
        panelEscolaDominicalLayout.setVerticalGroup(
            panelEscolaDominicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(panelEscolaDominicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Escola Dominical", panelEscolaDominical);

        panelListaAlunos.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(31, 159, 210));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-livro-100.png"))); // NOI18N

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
                "ID", "Classe", "Nome", "Bairro", "Email", "Membro", "Lição", "Telefone1", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, false, true, true, false
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

        jSeparator1.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator1.setForeground(new java.awt.Color(145, 212, 238));

        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-editar-20.png"))); // NOI18N
        btnAtualizar.setColor1(new java.awt.Color(126, 210, 244));
        btnAtualizar.setColor2(new java.awt.Color(14, 175, 239));
        btnAtualizar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtProcurarMouseClicked(evt);
            }
        });
        txtProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jSeparator1)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelListaAlunosLayout = new javax.swing.GroupLayout(panelListaAlunos);
        panelListaAlunos.setLayout(panelListaAlunosLayout);
        panelListaAlunosLayout.setHorizontalGroup(
            panelListaAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(panelListaAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelListaAlunosLayout.setVerticalGroup(
            panelListaAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(panelListaAlunosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaAlunosLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        materialTabbed1.addTab("Lista dos Alunos", panelListaAlunos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGap(0, 726, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtLicaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLicaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLicaoActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtClasseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClasseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClasseActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
          // Verificar os campos se estão vazios Ensino:
        
        EnsinoBean trn = new EnsinoBean();
        Ensino tdao = new Ensino();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Ensino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Ensino.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if (txtClasse.getText().trim().isEmpty()) {
             
        // JOptionPane.showMessageDialog(null, "Preencha o campo Classe! "); 
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Classe! ");
         nt.showNotification();
         
          txtClasse.requestFocus();  
         } 
         
         else if (txtNome.getText().trim().isEmpty()) {
             
        // JOptionPane.showMessageDialog(null, "Preencha o campo Nome! "); 
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Nome! ");
         nt.showNotification();
         
          txtNome.requestFocus();  
         } 
         
         else  if (txtBairro.getText().trim().isEmpty()) {
             
        // JOptionPane.showMessageDialog(null, "Preencha o campo Bairro! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Bairro! ");
         nt.showNotification();
         
          txtBairro.requestFocus();  
         } 
         
         else  if (txtEmail.getText().trim().isEmpty()) {
             
        // JOptionPane.showMessageDialog(null, "Preencha o campo Email! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Email!");
         nt.showNotification();
         
          txtEmail.requestFocus();  
         } 
              
         else if(comboMembro.getSelectedIndex() == -1) { 
            
       //  JOptionPane.showMessageDialog(null, "Preencha o campo Membro! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Membro! ");
         nt.showNotification();
         
         comboMembro.requestFocus();} 
          
         
        else if (txtLicao.getText().trim().isEmpty()) {
             
        // JOptionPane.showMessageDialog(null, "Preencha o campo Lição! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Lição! ");
         nt.showNotification();
         
          txtLicao.requestFocus();  
         }
          
          else if(jFTelefone1.getText().equals("           ")) {

            //JOptionPane.showMessageDialog(null, "Preencha o campo Telefone1! ");
            
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Telefone1! ");
         nt.showNotification();
            
            jFTelefone1.requestFocus();}
          
                
         else {
             
                trn.setClasse(txtClasse.getText().trim());           
                trn.setNome(txtNome.getText().trim());
                trn.setBairro(txtBairro.getText().trim());
                trn.setEmail(txtEmail.getText().trim());
                trn.setMembro((String) comboMembro.getSelectedItem());
                trn.setLicao(txtLicao.getText().trim());
                trn.setTelefone1(jFTelefone1.getValue().toString());
           
                //Enviar dados em Ensino:
                
                  try {
                      
                tdao.Salvar(trn);
                
               // JOptionPane.showMessageDialog(null, "Dados salvos com sucesso! ");
                
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Dados salvos com sucesso! ");
         nt.showNotification();
                
                
                } catch (SQLException ex) {
               
                }
              
                // Limpar todos os campos:
                
                limparCamposEnsino();       
                
               
        } 
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        
       limparCamposEnsino();  
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtProcurarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProcurarMouseClicked
        // TODO add your handling code here:
        
            if(table.getSelectedRow() != -1){

            txtProcurar.setText(table.getValueAt(table.getSelectedRow(), 0).toString());

    }  
    }//GEN-LAST:event_txtProcurarMouseClicked

    private void txtProcurarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarKeyReleased
        // TODO add your handling code here:
        
       String fMaiuscula = StringUtils.capitalize(txtProcurar.getText());
      txtProcurar.setText(fMaiuscula);
      
        try {
             buscarResult(fMaiuscula);
         } catch (SQLException ex) {
             
         } 
        
    }//GEN-LAST:event_txtProcurarKeyReleased

    private void materialTabbed1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_materialTabbed1StateChanged
        try {
            // TODO add your handling code here:

            Listar();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Ensino.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_materialTabbed1StateChanged

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        
        EnsinoBean esc = new EnsinoBean();       
        Ensino esdao = new Ensino();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Ensino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Ensino.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(table.getSelectedRow() != -1){

            esc.setId((int) table.getValueAt(table.getSelectedRow(), 0));
  

            // Deletar Membros:

            try {
                esdao.delete(esc);
                
              
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Excluído com Sucesso!");
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
                 Logger.getLogger(Form_Grupo.class.getName()).log(Level.SEVERE, null, ex);
             }

        }
        
    }//GEN-LAST:event_jLabelPesquisarMouseClicked

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        
        EnsinoBean mb = new EnsinoBean();
        Ensino dp = new Ensino();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Ensino.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Ensino.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(table.getSelectedRow() != -1){

            mb.setId((int)table.getValueAt(table.getSelectedRow(), 0));
            mb.setClasse((String) table.getValueAt(table.getSelectedRow(), 1));
            mb.setNome((String) table.getValueAt(table.getSelectedRow(), 2));
            mb.setBairro((String) table.getValueAt(table.getSelectedRow(), 3));
            mb.setEmail((String) table.getValueAt(table.getSelectedRow(), 4));
            mb.setLicao((String) table.getValueAt(table.getSelectedRow(), 6));
            mb.setTelefone1((String) table.getValueAt(table.getSelectedRow(), 7));
          
            try {
                dp.AtualizarEnsino(mb);
                
                        
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Dados Atualizados com Sucesso! ");
         nt.showNotification();
                
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, "Erro ao atualizar!/n Erro: !!"+ex.getMessage());
            }

        }
        
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        
        
        if(table.getSelectedRow() != -1){

            txtProcurar.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            }
        
    }//GEN-LAST:event_tableMouseClicked

    private void txtClasseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtClasseKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtClasse.getText());
      txtClasse.setText(fMaiuscula);
      
    }//GEN-LAST:event_txtClasseKeyReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtNome.getText());
      txtNome.setText(fMaiuscula);
      
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtBairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtBairro.getText());
      txtBairro.setText(fMaiuscula);
      
    }//GEN-LAST:event_txtBairroKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient btnAtualizar;
    private swing.ButtonGradient btnCancelar;
    private swing.ButtonGradient btnDeletar;
    private swing.ButtonGradient btnGuardar;
    private swing.ButtonGradient btnRelatorio;
    private combobox.Combobox comboMembro;
    private textfield.jFormattedTextField jFTelefone1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel panelEscolaDominical;
    private javax.swing.JPanel panelListaAlunos;
    private JPanelRounder.PanelRound panelRound1;
    private javax.swing.JScrollPane spTable;
    private controle.Table table;
    private textfield.TextField txtBairro;
    private textfield.TextField txtClasse;
    private textfield.TextField txtEmail;
    private textfield.TextField txtLicao;
    private textfield.TextField txtNome;
    private controle.SearchText txtProcurar;
    // End of variables declaration//GEN-END:variables
}
