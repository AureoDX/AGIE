
package visao.form;

import Notification.Notification;
import controle.LimiteTexto;
import controle.ScrollBarCustom;
import controleDao.Agenda;
import controleDao.Grupo;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modelo.AgendaBean;
import modelo.GrupoBean;
import org.springframework.util.StringUtils;
import visao.TelaPrincipal;


public class Form_Grupo extends javax.swing.JPanel {

    
    public Form_Grupo() throws SQLException {
        initComponents();
        setOpaque(false);
        
      jLabelPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      btnAtualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      btnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        
      txtProcurar.setDocument(new LimiteTexto(30));
   
      txtNomeGrupo.setDocument(new LimiteTexto(30)); 
       
      txtNome.setDocument(new LimiteTexto(30));
      
        //  add row table
                
        spTable.setVerticalScrollBar(new ScrollBarCustom());
        spTable.setHorizontalScrollBar(new ScrollBarCustom());
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        Listar();
        
    }

    private void limparCamposGrupo () {
        
    txtNomeGrupo.setText("");
    txtIgreja.setText("");            
    txtBairro.setText("");            
    jFDataInicio.setText("");
    jFHorario.setText("");
    txtNome.setText("");
    jFTelefone1.setText("");
    comboFrequencia.setSelectedIndex(-1);
    comboMembro.setSelectedIndex(-1);
   
     }
    
     //Mostrar Membros na Tabela:
    
    private void Listar() throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       Grupo jdao = new Grupo();
       
        for(GrupoBean p: jdao.Cadastro()) {
        
       modelo.addRow(new Object[]{
           
        p.getId(),
        p.getNomegrupo(),
        p.getIgreja(),
        p.getBairro(),
        p.getFrequencia(),
        p.getInicio(),
        p.getHorario(),
        p.getNome(),
        p.getTelefone1(),
        p.getMembro(),
        p.getData(),
      
        });
        }
        
         }
    
    //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResult(String nomecompleto) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       Grupo pdao = new Grupo();
       
       for(GrupoBean p: pdao.buscar(nomecompleto)) {
        
       modelo.addRow(new Object[]{
                     
        p.getId(),
        p.getNomegrupo(),
        p.getIgreja(),
        p.getBairro(),
        p.getFrequencia(),
        p.getInicio(),
        p.getHorario(),
        p.getNome(),
        p.getTelefone1(),
        p.getMembro(),
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

        materialTabbed1 = new tabbed.MaterialTabbed();
        panelMembrosGrupos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtNomeGrupo = new textfield.TextField();
        txtNome = new textfield.TextField();
        txtBairro = new textfield.TextField();
        txtIgreja = new textfield.TextField();
        jFDataInicio = new textfield.jFormattedTextField();
        comboMembro = new combobox.Combobox();
        jFTelefone1 = new textfield.jFormattedTextField();
        jFHorario = new textfield.jFormattedTextField();
        btnGuardarGrupo = new swing.ButtonGradient();
        btnCancelarGrupo = new swing.ButtonGradient();
        comboFrequencia = new combobox.Combobox();
        panelListaGrupos = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new JPanelRounder.PanelRound();
        spTable = new javax.swing.JScrollPane();
        table = new controle.Table();
        btnAtualizar = new swing.ButtonGradient();
        btnRelatorio = new swing.ButtonGradient();
        btnDeletar = new swing.ButtonGradient();
        jLabelPesquisar = new javax.swing.JLabel();
        txtProcurar = new controle.SearchText();
        jSeparator1 = new javax.swing.JSeparator();

        materialTabbed1.setBackground(new java.awt.Color(255, 255, 255));
        materialTabbed1.setForeground(new java.awt.Color(14, 175, 239));
        materialTabbed1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        materialTabbed1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                materialTabbed1StateChanged(evt);
            }
        });

        panelMembrosGrupos.setBackground(new java.awt.Color(255, 255, 255));
        panelMembrosGrupos.setPreferredSize(new java.awt.Dimension(720, 349));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(742, 656));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(126, 210, 244));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulário");

        jSeparator3.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator3.setForeground(new java.awt.Color(145, 212, 238));

        txtNomeGrupo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNomeGrupo.setLabelText("Nome do Grupo");
        txtNomeGrupo.setLineColor(new java.awt.Color(14, 175, 239));
        txtNomeGrupo.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtNomeGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeGrupoActionPerformed(evt);
            }
        });
        txtNomeGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNomeGrupoKeyReleased(evt);
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

        txtIgreja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtIgreja.setLabelText("Igreja");
        txtIgreja.setLineColor(new java.awt.Color(14, 175, 239));
        txtIgreja.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgrejaActionPerformed(evt);
            }
        });
        txtIgreja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIgrejaKeyReleased(evt);
            }
        });

        jFDataInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFDataInicio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        try {
            jFDataInicio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFDataInicio.setLabelText("Data de Início");

        comboMembro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Líder", "Participante" }));
        comboMembro.setSelectedIndex(-1);
        comboMembro.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboMembro.setLabeText("Membro");
        comboMembro.setLineColor(new java.awt.Color(14, 175, 239));

        jFTelefone1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTelefone1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        try {
            jFTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTelefone1.setLabelText("Telefone 1");

        jFHorario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFHorario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        try {
            jFHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFHorario.setLabelText("Horário");

        btnGuardarGrupo.setText("Guardar");
        btnGuardarGrupo.setColor1(new java.awt.Color(126, 210, 244));
        btnGuardarGrupo.setColor2(new java.awt.Color(14, 175, 239));
        btnGuardarGrupo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnGuardarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarGrupoActionPerformed(evt);
            }
        });

        btnCancelarGrupo.setText("Cancelar");
        btnCancelarGrupo.setColor1(new java.awt.Color(126, 210, 244));
        btnCancelarGrupo.setColor2(new java.awt.Color(14, 175, 239));
        btnCancelarGrupo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelarGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarGrupoActionPerformed(evt);
            }
        });

        comboFrequencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Segunda Feira", "Terça Feira", "Quarta Feira", "Quinta Feira", "Sexta Feira" }));
        comboFrequencia.setSelectedIndex(-1);
        comboFrequencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboFrequencia.setLabeText("Frequência");
        comboFrequencia.setLineColor(new java.awt.Color(14, 175, 239));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnGuardarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnCancelarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtIgreja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jFDataInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jFTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jFHorario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboMembro, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMembro, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardarGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 641, Short.MAX_VALUE)))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(633, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelMembrosGruposLayout = new javax.swing.GroupLayout(panelMembrosGrupos);
        panelMembrosGrupos.setLayout(panelMembrosGruposLayout);
        panelMembrosGruposLayout.setHorizontalGroup(
            panelMembrosGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(panelMembrosGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
        );
        panelMembrosGruposLayout.setVerticalGroup(
            panelMembrosGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(panelMembrosGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Grupo", panelMembrosGrupos);

        panelListaGrupos.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(31, 159, 210));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-grupos-de-usuários-100.png"))); // NOI18N

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
                "ID", "Nome do Grupo", "Igreja", "Bairro", "Frequência", "Início", "Horário", "Nome", "Telefone1", "Membro", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false, true, true, true, true, false, false
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
            .addComponent(spTable, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelRound1Layout.setVerticalGroup(
            panelRound1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

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
        txtProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator1.setForeground(new java.awt.Color(145, 212, 238));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(panelRound1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 337, Short.MAX_VALUE))
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

        javax.swing.GroupLayout panelListaGruposLayout = new javax.swing.GroupLayout(panelListaGrupos);
        panelListaGrupos.setLayout(panelListaGruposLayout);
        panelListaGruposLayout.setHorizontalGroup(
            panelListaGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(panelListaGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelListaGruposLayout.setVerticalGroup(
            panelListaGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(panelListaGruposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaGruposLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        materialTabbed1.addTab("Lista dos Membros dos Grupos", panelListaGrupos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtNomeGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeGrupoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgrejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgrejaActionPerformed

    private void btnCancelarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarGrupoActionPerformed
        // TODO add your handling code here:
        
        limparCamposGrupo();      
        
    }//GEN-LAST:event_btnCancelarGrupoActionPerformed

    private void btnGuardarGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarGrupoActionPerformed
        // TODO add your handling code here:
        
         // Verificar os campos se estão vazios Membros:
        
        GrupoBean trn = new GrupoBean();
        Grupo tdao = new Grupo();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Grupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Grupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if (txtNomeGrupo.getText().trim().isEmpty()) {
             
         //JOptionPane.showMessageDialog(null, "Preencha o campo Nome do Grupo! ");
         
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Nome do Grupo! ");
            nt.showNotification();
         
          txtNomeGrupo.requestFocus();  
         } 
         
         else if (txtIgreja.getText().trim().isEmpty()) {
             
         //JOptionPane.showMessageDialog(null, "Preencha o campo Igreja! ");
         
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Igreja! ");
            nt.showNotification();
         
          txtIgreja.requestFocus();  
         } 
         
         else  if (txtBairro.getText().trim().isEmpty()) {
             
         //JOptionPane.showMessageDialog(null, "Preencha o campo Bairro! "); 
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Bairro! ");
         nt.showNotification();
         
          txtBairro.requestFocus();  
         } 
              
         else if(comboFrequencia.getSelectedIndex() == -1) { 
            
         //JOptionPane.showMessageDialog(null, "Preencha o campo Frequência! "); 
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Frequência! ");
         nt.showNotification();
         
         comboFrequencia.requestFocus();} 
         
        
         else if(jFDataInicio.getText().equals("  /  /    ")){ 
            
         //JOptionPane.showMessageDialog(null, "Preencha o campo Data de início! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Data de início! ");
         nt.showNotification();
         
         jFDataInicio.requestFocus();}
         
         else if(jFHorario.getText().equals("  :  ")){ 
            
        // JOptionPane.showMessageDialog(null, "Preencha o campo Horário! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Horário! ");
         nt.showNotification();
         
         jFHorario.requestFocus();} 
         
        else if (txtNome.getText().trim().isEmpty()) {
             
         //JOptionPane.showMessageDialog(null, "Preencha o campo Nome! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Nome! ");
         nt.showNotification();
         
          txtNome.requestFocus();  
         }
          
          else if(jFTelefone1.getText().equals("           ")) {

           // JOptionPane.showMessageDialog(null, "Preencha o campo Telefone1! ");
            
             Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Telefone1! ");
             nt.showNotification();
            
            jFTelefone1.requestFocus();}
          
        
         else if(comboMembro.getSelectedIndex() == -1) { 
            
        // JOptionPane.showMessageDialog(null, "Preencha o campo É Membro! "); 
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo É Membro! ");
         nt.showNotification();
         
         comboMembro.requestFocus();} 
                
         else {
             
                trn.setNomegrupo(txtNomeGrupo.getText().trim());           
                trn.setIgreja(txtIgreja.getText().trim());
                trn.setBairro(txtBairro.getText().trim());
                trn.setFrequencia((String) comboFrequencia.getSelectedItem());
                trn.setInicio(jFDataInicio.getValue().toString());
                trn.setHorario(jFHorario.getValue().toString());
                trn.setNome(txtNome.getText().trim());
                trn.setTelefone1(jFTelefone1.getValue().toString());
                trn.setMembro((String) comboMembro.getSelectedItem());
                
                
                //Enviar dados em Grupo:
                
                  try {
                      
                tdao.Salvar(trn);
                
                //JOptionPane.showMessageDialog(null, "Dados salvos com sucesso! ");
                
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Dados salvos com sucesso! ");
         nt.showNotification();
                
                
                } catch (SQLException ex) {
               
                }
              
                // Limpar todos os campos:
                
                limparCamposGrupo();       
                
               
        }       
    }//GEN-LAST:event_btnGuardarGrupoActionPerformed

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

    private void txtProcurarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarKeyReleased
        // TODO add your handling code here:
      String fMaiuscula = StringUtils.capitalize(txtProcurar.getText());
      txtProcurar.setText(fMaiuscula);
         try {
             buscarResult(fMaiuscula);
         } catch (SQLException ex) {
             Logger.getLogger(Form_Grupo.class.getName()).log(Level.SEVERE, null, ex);
         } 
        
    }//GEN-LAST:event_txtProcurarKeyReleased

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        
        GrupoBean esc = new GrupoBean();       
        Grupo esdao = new Grupo();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Grupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Grupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(table.getSelectedRow() != -1){

            esc.setId((int) table.getValueAt(table.getSelectedRow(), 0));
  

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

    private void materialTabbed1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_materialTabbed1StateChanged
        try {
            // TODO add your handling code here:

            Listar();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Grupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_materialTabbed1StateChanged

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:
        
        GrupoBean mb = new GrupoBean();
        Grupo dp = new Grupo();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Grupo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Grupo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(table.getSelectedRow() != -1){

            mb.setId((int)table.getValueAt(table.getSelectedRow(), 0));
            mb.setNomegrupo((String) table.getValueAt(table.getSelectedRow(), 1));
            mb.setIgreja((String) table.getValueAt(table.getSelectedRow(), 2));
            mb.setBairro((String) table.getValueAt(table.getSelectedRow(), 3));
            mb.setInicio((String) table.getValueAt(table.getSelectedRow(), 5));
            mb.setHorario((String) table.getValueAt(table.getSelectedRow(), 6));
            mb.setNome((String) table.getValueAt(table.getSelectedRow(), 7));
            mb.setTelefone1((String) table.getValueAt(table.getSelectedRow(), 8));
         
            try {
                dp.AtualizarGrupo(mb);
               
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, " Dados Atualizados com Sucesso em Grupo!");
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

    private void txtNomeGrupoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeGrupoKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtNomeGrupo.getText());
      txtNomeGrupo.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtNomeGrupoKeyReleased

    private void txtIgrejaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgrejaKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtIgreja.getText());
      txtIgreja.setText(fMaiuscula);
    }//GEN-LAST:event_txtIgrejaKeyReleased

    private void txtBairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtBairro.getText());
      txtBairro.setText(fMaiuscula);
    }//GEN-LAST:event_txtBairroKeyReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtNome.getText());
      txtNome.setText(fMaiuscula);
    }//GEN-LAST:event_txtNomeKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient btnAtualizar;
    private swing.ButtonGradient btnCancelarGrupo;
    private swing.ButtonGradient btnDeletar;
    private swing.ButtonGradient btnGuardarGrupo;
    private swing.ButtonGradient btnRelatorio;
    private combobox.Combobox comboFrequencia;
    private combobox.Combobox comboMembro;
    private textfield.jFormattedTextField jFDataInicio;
    private textfield.jFormattedTextField jFHorario;
    private textfield.jFormattedTextField jFTelefone1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel panelListaGrupos;
    private javax.swing.JPanel panelMembrosGrupos;
    private JPanelRounder.PanelRound panelRound1;
    private javax.swing.JScrollPane spTable;
    private controle.Table table;
    private textfield.TextField txtBairro;
    private textfield.TextField txtIgreja;
    private textfield.TextField txtNome;
    private textfield.TextField txtNomeGrupo;
    private controle.SearchText txtProcurar;
    // End of variables declaration//GEN-END:variables
}
