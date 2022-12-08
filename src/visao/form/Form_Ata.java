
package visao.form;

import Notification.Notification;
import controle.ScrollBarCustom;
import controleDao.AtaDao;
import controleDao.DadosPessoais;
import controleDao.Visitante;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import modelo.AtaBean;
import modelo.MembroBean;
import modelo.VisitanteBean;
import org.springframework.util.StringUtils;
import visao.TelaPrincipal;


public class Form_Ata extends javax.swing.JPanel {

    
    public Form_Ata() throws SQLException {
        initComponents();
        
        jLabelPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
        sp.setVerticalScrollBar(new ScrollBarCustom());
        sp.setHorizontalScrollBar(new ScrollBarCustom());
        
        spTable.setVerticalScrollBar(new ScrollBarCustom());
        spTable.setHorizontalScrollBar(new ScrollBarCustom());
     
        //  add row table
                
        spTable.setVerticalScrollBar(sp.getVerticalScrollBar());
        spTable.setHorizontalScrollBar(sp.getHorizontalScrollBar());
         
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        DefaultTableModel modelo = (DefaultTableModel) table.getModel();
        table.setRowSorter(new TableRowSorter (modelo));
         
        Listar();
    }

     private void limparCampoAta () {
        
    jData.setText("");         
    jFHorario.setText("");         
    txtLocal.setText("");         
    txtObectivo.setText("");         
    txtNome.setText("");         
    comboCargo.setSelectedIndex(-1);
    txtAssuntoPauta.setText("");
    txtDecisao.setText("");
    txtObservação.setText("");
    
     }
     
     //Mostrar Membros na Tabela:
    
    private void Listar() throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       AtaDao jdao = new AtaDao();
       
        for(AtaBean p: jdao.Cadastro()) {
        
       modelo.addRow(new Object[]{
           
        p.getId(),
        p.getDatta(),
        p.getHorario(),
        p.getLocall(),
        p.getObjectivo(),
        p.getNome(),
        p.getCargo(),
        p.getAssunto(),
        p.getDecisao(),
        p.getObservação(),
       
      
        });
        }
        
         }
    
    //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResultAta(String datta) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       AtaDao pdao = new AtaDao();

       for(AtaBean p: pdao.buscar(datta)) {
        
       modelo.addRow(new Object[]{
                     
        p.getId(),
        p.getDatta(),
        p.getHorario(),
        p.getLocall(),
        p.getObjectivo(),
        p.getNome(),
        p.getCargo(),
        p.getAssunto(),
        p.getDecisao(),
        p.getObservação(),
       
        });
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        materialTabbed1 = new tabbed.MaterialTabbed();
        panelEscolaDominical = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtLocal = new textfield.TextField();
        btnCancelar = new swing.ButtonGradient();
        txtNome = new textfield.TextField();
        btnGuardar = new swing.ButtonGradient();
        ScrollMensagem = new textarea.TextAreaScroll();
        txtObectivo = new textarea.TextArea();
        jData = new textfield.jFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFHorario = new textfield.jFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        comboCargo = new combobox.Combobox();
        jLabel4 = new javax.swing.JLabel();
        txtObservação = new textfield.TextField();
        txtAssuntoPauta = new textfield.TextField();
        txtDecisao = new textfield.TextField();
        panelListaAtas = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        btnAtualizar = new swing.ButtonGradient();
        btnDeletar = new swing.ButtonGradient();
        sp = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        spTable = new javax.swing.JScrollPane();
        table = new controle.Table();
        jLabelPesquisar = new javax.swing.JLabel();
        txtProcurar = new controle.SearchText();

        jPanel2.setForeground(new java.awt.Color(14, 175, 239));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(742, 656));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(126, 210, 244));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pauta");

        jSeparator3.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator3.setForeground(new java.awt.Color(145, 212, 238));

        txtLocal.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtLocal.setLabelText("Local");
        txtLocal.setLineColor(new java.awt.Color(14, 175, 239));
        txtLocal.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLocalActionPerformed(evt);
            }
        });
        txtLocal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLocalKeyReleased(evt);
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

        btnGuardar.setText("Guardar");
        btnGuardar.setColor1(new java.awt.Color(126, 210, 244));
        btnGuardar.setColor2(new java.awt.Color(14, 175, 239));
        btnGuardar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        ScrollMensagem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ScrollMensagem.setLabelText("Objectivo");

        txtObectivo.setColumns(20);
        txtObectivo.setRows(5);
        txtObectivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtObectivoKeyReleased(evt);
            }
        });
        ScrollMensagem.setViewportView(txtObectivo);

        jData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jData.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        try {
            jData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jData.setLabelText("Data");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("DD/MM/AAAA");

        jFHorario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFHorario.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        try {
            jFHorario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFHorario.setLabelText("Horário");

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(126, 210, 244));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Modelo");

        comboCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pastor", "Presbítero", "Diácono", "Missionário", "Membro" }));
        comboCargo.setSelectedIndex(-1);
        comboCargo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboCargo.setLabeText("Cargo");
        comboCargo.setLineColor(new java.awt.Color(14, 175, 239));

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(126, 210, 244));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Participantes");

        txtObservação.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtObservação.setLabelText("Observação");
        txtObservação.setLineColor(new java.awt.Color(14, 175, 239));
        txtObservação.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtObservação.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObservaçãoActionPerformed(evt);
            }
        });
        txtObservação.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtObservaçãoKeyReleased(evt);
            }
        });

        txtAssuntoPauta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtAssuntoPauta.setLabelText("Assunto Verificado");
        txtAssuntoPauta.setLineColor(new java.awt.Color(14, 175, 239));
        txtAssuntoPauta.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtAssuntoPauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAssuntoPautaActionPerformed(evt);
            }
        });
        txtAssuntoPauta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAssuntoPautaKeyReleased(evt);
            }
        });

        txtDecisao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDecisao.setLabelText("Decisão/ Encaminhamento");
        txtDecisao.setLineColor(new java.awt.Color(14, 175, 239));
        txtDecisao.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtDecisao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDecisaoActionPerformed(evt);
            }
        });
        txtDecisao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDecisaoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollMensagem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtAssuntoPauta, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtDecisao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(79, 79, 79)
                        .addComponent(txtObservação, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jData, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jFHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jFHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ScrollMensagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtObservação, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAssuntoPauta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtDecisao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(633, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(631, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelEscolaDominicalLayout = new javax.swing.GroupLayout(panelEscolaDominical);
        panelEscolaDominical.setLayout(panelEscolaDominicalLayout);
        panelEscolaDominicalLayout.setHorizontalGroup(
            panelEscolaDominicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
            .addGroup(panelEscolaDominicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 759, Short.MAX_VALUE))
        );
        panelEscolaDominicalLayout.setVerticalGroup(
            panelEscolaDominicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(panelEscolaDominicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        materialTabbed1.addTab("Ata de Reunião", panelEscolaDominical);

        panelListaAtas.setBackground(new java.awt.Color(255, 255, 255));
        panelListaAtas.setPreferredSize(new java.awt.Dimension(720, 349));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

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

        sp.setBorder(null);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        spTable.setBackground(new java.awt.Color(255, 255, 255));
        spTable.setBorder(null);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data", "Horário", "Local", "Objectivo", "Nome", "Cargo", "Assunto", "Decisão", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        spTable.setViewportView(table);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
                .addGap(337, 337, 337))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(spTable, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addGap(108, 108, 108))
        );

        sp.setViewportView(jPanel6);

        jLabelPesquisar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-20.png"))); // NOI18N
        jLabelPesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPesquisarMouseClicked(evt);
            }
        });

        txtProcurar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProcurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcurarActionPerformed(evt);
            }
        });
        txtProcurar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtProcurar, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtProcurar, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabelPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(sp, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelListaAtasLayout = new javax.swing.GroupLayout(panelListaAtas);
        panelListaAtas.setLayout(panelListaAtasLayout);
        panelListaAtasLayout.setHorizontalGroup(
            panelListaAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelListaAtasLayout.setVerticalGroup(
            panelListaAtasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        materialTabbed1.addTab("Lista de Atas", panelListaAtas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 764, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 726, Short.MAX_VALUE)
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
            .addGap(0, 764, Short.MAX_VALUE)
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

    private void txtLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLocalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLocalActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:

       limparCampoAta();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

         // Verificar os campos se estão vazios Membros:
        
        AtaBean trn = new AtaBean();
        AtaDao tdao = new AtaDao();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Ata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Ata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         if (jData.getText().equals("  /  /    ")) {
             
        // JOptionPane.showMessageDialog(null, "Preencha o campo Data! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Data! ");
         nt.showNotification();
         
          jData.requestFocus();  
         } 
       
         else if(jFHorario.getText().equals("  :  ")) { 
            
         //JOptionPane.showMessageDialog(null, "Preencha o campo Horário! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Horário! ");
         nt.showNotification();
         
         jFHorario.requestFocus();} 
        
         else if(txtLocal.getText().trim().isEmpty()) { 
            
        // JOptionPane.showMessageDialog(null, "Preencha o campo Local! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Local! ");
         nt.showNotification();
         
         txtLocal.requestFocus();} 
         
         else if(txtObectivo.getText().trim().isEmpty()) { 
            
        // JOptionPane.showMessageDialog(null, "Preencha o campo Objectivo! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Objectivo! ");
         nt.showNotification();
         
         txtObectivo.requestFocus();} 
        
         else if(txtNome.getText().trim().isEmpty()) { 
            
        // JOptionPane.showMessageDialog(null, "Preencha o campo Nome! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Nome! ");
         nt.showNotification();
         
         txtNome.requestFocus();} 
         
         else if(comboCargo.getSelectedIndex() == -1) { 
            
         //JOptionPane.showMessageDialog(null, "Preencha o campo Cargo! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Cargo!");
         nt.showNotification();
         
         comboCargo.requestFocus();} 
        
         else if(txtAssuntoPauta.getText().trim().isEmpty()) { 
            
        // JOptionPane.showMessageDialog(null, "Preencha o campo Assunto! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Assunto! ");
         nt.showNotification();
         
         txtAssuntoPauta.requestFocus();} 
         
         else if(txtDecisao.getText().trim().isEmpty()) { 
            
         //JOptionPane.showMessageDialog(null, "Preencha o campo Decisão! ");
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Decisão! ");
         nt.showNotification();
         
         txtDecisao.requestFocus();} 
         
         else if(txtObservação.getText().trim().isEmpty()) { 
            
        // JOptionPane.showMessageDialog(null, "Preencha o campo Observação! "); 
         
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Observação! ");
         nt.showNotification();
         
         txtObservação.requestFocus();} 
         
         
         else {
             
                trn.setDatta(jData.getText().trim());           
                trn.setHorario(jFHorario.getText().trim());
                trn.setLocall(txtLocal.getText().trim());
                trn.setObjectivo(txtObectivo.getText().trim());
                trn.setNome(txtNome.getText().trim());
                trn.setCargo((String)comboCargo.getSelectedItem());
                trn.setAssunto(txtAssuntoPauta.getText().trim());
                trn.setDecisao(txtDecisao.getText().trim());
                trn.setObservação(txtObservação.getText().trim());
                
                //Enviar dados em Ata:
                
                try {
                    
                    tdao.Salvar(trn);
                   // JOptionPane.showMessageDialog(null, "Dados salvos com sucesso! "); 
                    
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Dados salvos com sucesso! ");
         nt.showNotification();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Form_Ata.class.getName()).log(Level.SEVERE, null, ex);
                }
                // Limpar o campo:
                
                limparCampoAta();
        }    

    }//GEN-LAST:event_btnGuardarActionPerformed

    private void materialTabbed1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_materialTabbed1StateChanged
        try {
            Listar();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Ata.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_materialTabbed1StateChanged

    private void txtObservaçãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObservaçãoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObservaçãoActionPerformed

    private void txtAssuntoPautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAssuntoPautaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAssuntoPautaActionPerformed

    private void txtDecisaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDecisaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDecisaoActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed

        // TODO add your handling code here:

        AtaBean mb = new AtaBean();
        AtaDao dp = new AtaDao();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Ata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Ata.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(table.getSelectedRow() != -1){

            mb.setId((int)table.getValueAt(table.getSelectedRow(), 0));
            mb.setDatta((String) table.getValueAt(table.getSelectedRow(), 1));
            mb.setHorario((String) table.getValueAt(table.getSelectedRow(), 2));
            mb.setLocall((String) table.getValueAt(table.getSelectedRow(), 3));
            mb.setObjectivo((String) table.getValueAt(table.getSelectedRow(), 4));
            mb.setNome((String) table.getValueAt(table.getSelectedRow(), 5));
            mb.setCargo((String) table.getValueAt(table.getSelectedRow(), 6));
            mb.setAssunto((String) table.getValueAt(table.getSelectedRow(), 7));
            mb.setDecisao((String) table.getValueAt(table.getSelectedRow(), 8));
            mb.setObservação((String) table.getValueAt(table.getSelectedRow(), 9));
           
 
            try {
                dp.AtualizarAta(mb);
                
          Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Dados Atualizados com Sucesso! ");
         nt.showNotification();
                
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(null, "Erro ao atualizar!/n Erro: !!"+ex.getMessage());
            }

        }

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:

        AtaBean esc = new AtaBean();
        AtaDao esdao = new AtaDao();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Ata.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Ata.class.getName()).log(Level.SEVERE, null, ex);
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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:

        if(table.getSelectedRow() != -1){

            txtProcurar.setText(table.getValueAt(table.getSelectedRow(), 1).toString());

        }

    }//GEN-LAST:event_tableMouseClicked

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased

        if(table.getSelectedRow() != -1){

            txtProcurar.setText(table.getValueAt(table.getSelectedRow(), 1).toString());

        }

    }//GEN-LAST:event_tableMouseReleased

    private void jLabelPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisarMouseClicked
        // TODO add your handling code here:

        if(txtProcurar.getText().equals("")){

            try {
                Listar();

            } catch (SQLException ex) {

            }
            

        }else {
           
          try {
            buscarResultAta(txtProcurar.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Form_Info.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_jLabelPesquisarMouseClicked

    private void txtProcurarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarKeyReleased
        // TODO add your handling code here:

        try {
            buscarResultAta(txtProcurar.getText().toUpperCase());
        } catch (SQLException ex) {
            Logger.getLogger(Form_Membros.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_txtProcurarKeyReleased

    private void txtProcurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProcurarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProcurarActionPerformed

    private void txtLocalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLocalKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtLocal.getText());
      txtLocal.setText(fMaiuscula);
    }//GEN-LAST:event_txtLocalKeyReleased

    private void txtObectivoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObectivoKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtObectivo.getText());
      txtObectivo.setText(fMaiuscula);
    }//GEN-LAST:event_txtObectivoKeyReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtNome.getText());
      txtNome.setText(fMaiuscula);
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtAssuntoPautaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAssuntoPautaKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtAssuntoPauta.getText());
      txtAssuntoPauta.setText(fMaiuscula);
    }//GEN-LAST:event_txtAssuntoPautaKeyReleased

    private void txtDecisaoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDecisaoKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtDecisao.getText());
      txtDecisao.setText(fMaiuscula);
    }//GEN-LAST:event_txtDecisaoKeyReleased

    private void txtObservaçãoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObservaçãoKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtObservação.getText());
      txtObservação.setText(fMaiuscula);
    }//GEN-LAST:event_txtObservaçãoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private textarea.TextAreaScroll ScrollMensagem;
    private swing.ButtonGradient btnAtualizar;
    private swing.ButtonGradient btnCancelar;
    private swing.ButtonGradient btnDeletar;
    private swing.ButtonGradient btnGuardar;
    private combobox.Combobox comboCargo;
    private textfield.jFormattedTextField jData;
    private textfield.jFormattedTextField jFHorario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JSeparator jSeparator3;
    private tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel panelEscolaDominical;
    private javax.swing.JPanel panelListaAtas;
    private javax.swing.JScrollPane sp;
    private javax.swing.JScrollPane spTable;
    private controle.Table table;
    private textfield.TextField txtAssuntoPauta;
    private textfield.TextField txtDecisao;
    private textfield.TextField txtLocal;
    private textfield.TextField txtNome;
    private textarea.TextArea txtObectivo;
    private textfield.TextField txtObservação;
    private controle.SearchText txtProcurar;
    // End of variables declaration//GEN-END:variables
}
