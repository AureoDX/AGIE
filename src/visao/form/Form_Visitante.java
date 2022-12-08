
package visao.form;

import Notification.Notification;
import UTIL.ManipularImagem;
import controle.LimiteTexto;
import controleDao.Visitante;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import modelo.VisitanteBean;
import org.springframework.util.StringUtils;
import visao.TelaPrincipal;


public class Form_Visitante extends javax.swing.JPanel {

   BufferedImage imagem;
   
    public Form_Visitante() {
        initComponents();
       setOpaque(false);
        
        materialTabbed1.setEnabledAt(1, false);
        materialTabbed1.setEnabledAt(2, false);
        materialTabbed1.setEnabledAt(3, false);
        
        
      txtNome.setDocument(new LimiteTexto(30)); 
      txtNacionalidade.setDocument(new LimiteTexto(25)); 
      txtNatural.setDocument(new LimiteTexto(25)); 
      txtProvincia.setDocument(new LimiteTexto(25));
      
      //txtEmail.setDocument(new LimiteTexto(30)); 
     // txtBairro.setDocument(new LimiteTexto(25)); 
     // txtRua.setDocument(new LimiteTexto(25));
      
      txtCônjuge.setDocument(new LimiteTexto(30)); 
      txtPai.setDocument(new LimiteTexto(25)); 
      txtMãe.setDocument(new LimiteTexto(25)); 
      //txtIgreja.setDocument(new LimiteTexto(25)); 
      
       setarFoto();
    }

  private void limparCamposDadosPessoais () {
        
    txtNome.setText("");
    txtNacionalidade.setText("");            
    jDate.setText("");
    txtNatural.setText("");
    combogenero.setSelectedIndex(-1);
    txtProvincia.setText("");
    
    setarFoto();
    
     }
  private void limparCamposComplementares () {
        
   jFTelefone1.setValue("");           
   jFTelefone2.setValue("");
   txtEmail.setText("");
   txtProfissão.setText("");
   txtBairro.setText("");         
   txtRua.setText("");
    
   setarFoto();
   
     }
  private void limparCamposRelacionamento () {
        
    comboCivil.setSelectedIndex(-1);
    txtPai.setText("");         
    txtMãe.setText("");
    comboFamilia.setSelectedIndex(-1);
    txtCônjuge.setText("");
    spinnerFilhos.setValue(0);
    
    setarFoto();
    
     }
  private void limparCamposIgrejas () {
        
    txtIgreja.setText("");         
    txtComoConheceuIgreja.setText("");
    
    
    setarFoto();
    
     }
    
    private void setarFoto () {
    
    ImageIcon foto = new ImageIcon(getClass().getResource("/imagens/icons8-convidado-masculino-100.png")); 
    jFoto.setIcon(foto);
    
     }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        btnSelecioneImagem = new swing.ButtonGradient();
        jFoto = new javax.swing.JLabel();
        materialTabbed1 = new tabbed.MaterialTabbed();
        panelPessoais = new javax.swing.JPanel();
        txtNome = new textfield.TextField();
        combogenero = new combobox.Combobox();
        txtNatural = new textfield.TextField();
        txtProvincia = new textfield.TextField();
        txtNacionalidade = new textfield.TextField();
        btnCancelarPessoais = new swing.ButtonGradient();
        jLabel3 = new javax.swing.JLabel();
        jDate = new textfield.jFormattedTextField();
        btnProxímoPessoais = new swing.ButtonGradient();
        panelComplementares = new javax.swing.JPanel();
        txtBairro = new textfield.TextField();
        txtEmail = new textfield.TextField();
        txtRua = new textfield.TextField();
        jFTelefone2 = new textfield.jFormattedTextField();
        jFTelefone1 = new textfield.jFormattedTextField();
        btnProxímoComplementares = new swing.ButtonGradient();
        btnCancelarComplementares = new swing.ButtonGradient();
        jLabel7 = new javax.swing.JLabel();
        txtProfissão = new textfield.TextField();
        panelRelacionamentos = new javax.swing.JPanel();
        txtMãe = new textfield.TextField();
        comboCivil = new combobox.Combobox();
        txtCônjuge = new textfield.TextField();
        comboFamilia = new combobox.Combobox();
        spinnerFilhos = new spinner.Spinner();
        txtPai = new textfield.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnProxímoRelacionamento = new swing.ButtonGradient();
        btnCancelarRelacionamento = new swing.ButtonGradient();
        panelIgreja = new javax.swing.JPanel();
        txtIgreja = new textfield.TextField();
        btnGuardarDados = new swing.ButtonGradient();
        btnCancelarIgreja = new swing.ButtonGradient();
        txtComoConheceuIgreja = new textfield.TextField();

        setForeground(new java.awt.Color(14, 175, 239));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(14, 175, 239));
        jPanel2.setPreferredSize(new java.awt.Dimension(741, 656));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(126, 210, 244));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cadastro de Visitantes");

        jSeparator2.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator2.setForeground(new java.awt.Color(145, 212, 238));

        jSeparator3.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator3.setForeground(new java.awt.Color(145, 212, 238));

        btnSelecioneImagem.setText("Selecione uma imagem");
        btnSelecioneImagem.setColor1(new java.awt.Color(126, 210, 244));
        btnSelecioneImagem.setColor2(new java.awt.Color(14, 175, 239));
        btnSelecioneImagem.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnSelecioneImagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecioneImagemActionPerformed(evt);
            }
        });

        jFoto.setBackground(new java.awt.Color(255, 255, 255));
        jFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        materialTabbed1.setBackground(new java.awt.Color(255, 255, 255));
        materialTabbed1.setForeground(new java.awt.Color(14, 175, 239));
        materialTabbed1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        materialTabbed1.setPreferredSize(new java.awt.Dimension(741, 397));

        panelPessoais.setBackground(new java.awt.Color(255, 255, 255));
        panelPessoais.setPreferredSize(new java.awt.Dimension(720, 349));

        txtNome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNome.setLabelText("Nome Completo");
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

        combogenero.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
        combogenero.setSelectedIndex(-1);
        combogenero.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        combogenero.setLabeText("Gênero");
        combogenero.setLineColor(new java.awt.Color(14, 175, 239));

        txtNatural.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNatural.setLabelText("Natural de");
        txtNatural.setLineColor(new java.awt.Color(14, 175, 239));
        txtNatural.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtNatural.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNaturalActionPerformed(evt);
            }
        });
        txtNatural.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNaturalKeyReleased(evt);
            }
        });

        txtProvincia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtProvincia.setLabelText("Província");
        txtProvincia.setLineColor(new java.awt.Color(14, 175, 239));
        txtProvincia.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvinciaActionPerformed(evt);
            }
        });
        txtProvincia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProvinciaKeyReleased(evt);
            }
        });

        txtNacionalidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNacionalidade.setLabelText("Nacionalidade");
        txtNacionalidade.setLineColor(new java.awt.Color(14, 175, 239));
        txtNacionalidade.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtNacionalidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNacionalidadeActionPerformed(evt);
            }
        });
        txtNacionalidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNacionalidadeKeyReleased(evt);
            }
        });

        btnCancelarPessoais.setText("Cancelar");
        btnCancelarPessoais.setColor1(new java.awt.Color(126, 210, 244));
        btnCancelarPessoais.setColor2(new java.awt.Color(14, 175, 239));
        btnCancelarPessoais.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelarPessoais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPessoaisActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setText("DD/MM/AAAA");

        jDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jDate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        try {
            jDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jDate.setLabelText("Data de Nascimento");

        btnProxímoPessoais.setText("Proxímo");
        btnProxímoPessoais.setColor1(new java.awt.Color(126, 210, 244));
        btnProxímoPessoais.setColor2(new java.awt.Color(14, 175, 239));
        btnProxímoPessoais.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnProxímoPessoais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxímoPessoaisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPessoaisLayout = new javax.swing.GroupLayout(panelPessoais);
        panelPessoais.setLayout(panelPessoaisLayout);
        panelPessoaisLayout.setHorizontalGroup(
            panelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPessoaisLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNacionalidade, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPessoaisLayout.createSequentialGroup()
                        .addComponent(btnProxímoPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnCancelarPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(combogenero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNatural, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtProvincia, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPessoaisLayout.setVerticalGroup(
            panelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPessoaisLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addComponent(txtProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPessoaisLayout.createSequentialGroup()
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(txtNacionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelPessoaisLayout.createSequentialGroup()
                        .addGroup(panelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combogenero, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addComponent(txtNatural, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(panelPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnProxímoPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        materialTabbed1.addTab("Dados Pessoais", panelPessoais);

        panelComplementares.setBackground(new java.awt.Color(255, 255, 255));

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

        txtEmail.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtEmail.setLabelText("Email");
        txtEmail.setLineColor(new java.awt.Color(14, 175, 239));
        txtEmail.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtRua.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtRua.setLabelText("Rua");
        txtRua.setLineColor(new java.awt.Color(14, 175, 239));
        txtRua.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRuaActionPerformed(evt);
            }
        });
        txtRua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRuaKeyReleased(evt);
            }
        });

        jFTelefone2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTelefone2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        try {
            jFTelefone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTelefone2.setLabelText("Telefone 2");

        jFTelefone1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jFTelefone1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        try {
            jFTelefone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("### ### ###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        jFTelefone1.setLabelText("Telefone 1");

        btnProxímoComplementares.setText("Proxímo");
        btnProxímoComplementares.setColor1(new java.awt.Color(126, 210, 244));
        btnProxímoComplementares.setColor2(new java.awt.Color(14, 175, 239));
        btnProxímoComplementares.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnProxímoComplementares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxímoComplementaresActionPerformed(evt);
            }
        });

        btnCancelarComplementares.setText("Cancelar");
        btnCancelarComplementares.setColor1(new java.awt.Color(126, 210, 244));
        btnCancelarComplementares.setColor2(new java.awt.Color(14, 175, 239));
        btnCancelarComplementares.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelarComplementares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarComplementaresActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-mail-20.png"))); // NOI18N

        txtProfissão.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtProfissão.setLabelText("Profissão");
        txtProfissão.setLineColor(new java.awt.Color(14, 175, 239));
        txtProfissão.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtProfissão.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProfissãoActionPerformed(evt);
            }
        });
        txtProfissão.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProfissãoKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelComplementaresLayout = new javax.swing.GroupLayout(panelComplementares);
        panelComplementares.setLayout(panelComplementaresLayout);
        panelComplementaresLayout.setHorizontalGroup(
            panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComplementaresLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFTelefone1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(txtProfissão, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComplementaresLayout.createSequentialGroup()
                        .addComponent(btnProxímoComplementares, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnCancelarComplementares, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelComplementaresLayout.createSequentialGroup()
                        .addGroup(panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtBairro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jFTelefone2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelComplementaresLayout.createSequentialGroup()
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(48, 48, 48))
        );
        panelComplementaresLayout.setVerticalGroup(
            panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelComplementaresLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jFTelefone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelComplementaresLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProfissão, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(panelComplementaresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProxímoComplementares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarComplementares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        materialTabbed1.addTab("Dados Complementares", panelComplementares);

        panelRelacionamentos.setBackground(new java.awt.Color(255, 255, 255));

        txtMãe.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtMãe.setLabelText("Mãe");
        txtMãe.setLineColor(new java.awt.Color(14, 175, 239));
        txtMãe.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtMãe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMãeActionPerformed(evt);
            }
        });
        txtMãe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMãeKeyReleased(evt);
            }
        });

        comboCivil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Solteiro", "União de Facto", "Casado(a)" }));
        comboCivil.setSelectedIndex(-1);
        comboCivil.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboCivil.setLabeText("Estado Civil");
        comboCivil.setLineColor(new java.awt.Color(14, 175, 239));

        txtCônjuge.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCônjuge.setLabelText("Nome do Cônjuge");
        txtCônjuge.setLineColor(new java.awt.Color(14, 175, 239));
        txtCônjuge.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtCônjuge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCônjugeActionPerformed(evt);
            }
        });
        txtCônjuge.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCônjugeKeyReleased(evt);
            }
        });

        comboFamilia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Sim", "Não" }));
        comboFamilia.setSelectedIndex(-1);
        comboFamilia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboFamilia.setLabeText("Cabeça da Família?");
        comboFamilia.setLineColor(new java.awt.Color(14, 175, 239));

        spinnerFilhos.setBorder(null);
        spinnerFilhos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 1));
        spinnerFilhos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        spinnerFilhos.setLabelText("Qtd  de Filhos");

        txtPai.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPai.setLabelText("Pai");
        txtPai.setLineColor(new java.awt.Color(14, 175, 239));
        txtPai.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtPai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaiActionPerformed(evt);
            }
        });
        txtPai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPaiKeyReleased(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon user.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon user.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon user.png"))); // NOI18N

        btnProxímoRelacionamento.setText("Proxímo");
        btnProxímoRelacionamento.setColor1(new java.awt.Color(126, 210, 244));
        btnProxímoRelacionamento.setColor2(new java.awt.Color(14, 175, 239));
        btnProxímoRelacionamento.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnProxímoRelacionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProxímoRelacionamentoActionPerformed(evt);
            }
        });

        btnCancelarRelacionamento.setText("Cancelar");
        btnCancelarRelacionamento.setColor1(new java.awt.Color(126, 210, 244));
        btnCancelarRelacionamento.setColor2(new java.awt.Color(14, 175, 239));
        btnCancelarRelacionamento.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelarRelacionamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarRelacionamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRelacionamentosLayout = new javax.swing.GroupLayout(panelRelacionamentos);
        panelRelacionamentos.setLayout(panelRelacionamentosLayout);
        panelRelacionamentosLayout.setHorizontalGroup(
            panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRelacionamentosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboCivil, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(comboFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRelacionamentosLayout.createSequentialGroup()
                        .addComponent(btnProxímoRelacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnCancelarRelacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRelacionamentosLayout.createSequentialGroup()
                        .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtPai, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtCônjuge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelRelacionamentosLayout.createSequentialGroup()
                                .addComponent(txtMãe, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))))
                .addGap(109, 109, 109))
        );
        panelRelacionamentosLayout.setVerticalGroup(
            panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRelacionamentosLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtMãe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(spinnerFilhos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCônjuge, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addGroup(panelRelacionamentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProxímoRelacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarRelacionamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        materialTabbed1.addTab("Relacionamentos", panelRelacionamentos);

        panelIgreja.setBackground(new java.awt.Color(255, 255, 255));

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

        btnGuardarDados.setText("Guardar");
        btnGuardarDados.setColor1(new java.awt.Color(126, 210, 244));
        btnGuardarDados.setColor2(new java.awt.Color(14, 175, 239));
        btnGuardarDados.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnGuardarDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarDadosActionPerformed(evt);
            }
        });

        btnCancelarIgreja.setText("Cancelar");
        btnCancelarIgreja.setColor1(new java.awt.Color(126, 210, 244));
        btnCancelarIgreja.setColor2(new java.awt.Color(14, 175, 239));
        btnCancelarIgreja.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelarIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarIgrejaActionPerformed(evt);
            }
        });

        txtComoConheceuIgreja.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtComoConheceuIgreja.setLabelText("Como conheceu a Igreja?");
        txtComoConheceuIgreja.setLineColor(new java.awt.Color(14, 175, 239));
        txtComoConheceuIgreja.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtComoConheceuIgreja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtComoConheceuIgrejaActionPerformed(evt);
            }
        });
        txtComoConheceuIgreja.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtComoConheceuIgrejaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout panelIgrejaLayout = new javax.swing.GroupLayout(panelIgreja);
        panelIgreja.setLayout(panelIgrejaLayout);
        panelIgrejaLayout.setHorizontalGroup(
            panelIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIgrejaLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(txtIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelIgrejaLayout.createSequentialGroup()
                        .addComponent(btnGuardarDados, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnCancelarIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtComoConheceuIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(306, 306, 306))
        );
        panelIgrejaLayout.setVerticalGroup(
            panelIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIgrejaLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(panelIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComoConheceuIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                .addGroup(panelIgrejaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        materialTabbed1.addTab("Igreja", panelIgreja);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jSeparator3)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSelecioneImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 735, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSelecioneImagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(materialTabbed1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(256, 256, 256)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(398, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 741, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 656, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, 0)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSelecioneImagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecioneImagemActionPerformed
        // TODO add your handling code here:

        JFrame framePrincipal = new JFrame();
        framePrincipal.setIconImage(new ImageIcon(getClass().getResource("/imagens/Igreja.png")).getImage());

        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("AGIE");
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter fl = new FileNameExtensionFilter("JPEG", "jpg");
        fc.setFileFilter(fl);
        int res = fc.showOpenDialog(framePrincipal);

        if (res == JFileChooser.APPROVE_OPTION) {

            try {

                File arquivo = fc.getSelectedFile();

                imagem = ManipularImagem.setImagemDimensao(arquivo.getAbsolutePath(), 240, 190);

                jFoto.setIcon(new ImageIcon(imagem));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Voce não selecionou nenhum arquivo." + ex);
            }
        }

    }//GEN-LAST:event_btnSelecioneImagemActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtNaturalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNaturalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNaturalActionPerformed

    private void txtProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvinciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvinciaActionPerformed

    private void txtNacionalidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNacionalidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNacionalidadeActionPerformed

    private void btnCancelarPessoaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPessoaisActionPerformed
        // TODO add your handling code here:

        limparCamposDadosPessoais();

    }//GEN-LAST:event_btnCancelarPessoaisActionPerformed

    private void btnProxímoPessoaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxímoPessoaisActionPerformed
        // TODO add your handling code here:

        // Verificar os campos se estão vazios Membros:
        TelaPrincipal frame = null;
       try {
           frame = new TelaPrincipal();
       } catch (SQLException ex) {
           Logger.getLogger(Form_Visitante.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParseException ex) {
           Logger.getLogger(Form_Visitante.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        if(txtNome.getText().trim().isEmpty())

        { //JOptionPane.showMessageDialog(null, "Preencha o campo Nome Completo! ");
        
        Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Nome Completo! ");
        nt.showNotification();
        
            txtNome.requestFocus();}

        else if(combogenero.getSelectedIndex()== -1) {

            //JOptionPane.showMessageDialog(null, "Preencha o campo Gênero! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Gênero! ");
            nt.showNotification();
            
            combogenero.requestFocus();}

        else if(jDate.getText().equals("  /  /    ")){

            //JOptionPane.showMessageDialog(null, "Preencha o campo Data de Nascimento! ");
            
             Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Data de Nascimento! ");
             nt.showNotification();
            
            jDate.requestFocus();}

        else if(txtNacionalidade.getText().trim().isEmpty()) {

            //JOptionPane.showMessageDialog(null, "Preencha o campo Nacionalidade! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Nacionalidade! ");
            nt.showNotification();
            
            txtNacionalidade.requestFocus();}

        else if(txtNatural.getText().trim().isEmpty()) {

            //JOptionPane.showMessageDialog(null, "Preencha o campo Natural de! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Natural de! ");
            nt.showNotification();
            
            txtNatural.requestFocus();}

        else if (txtProvincia.getText().trim().isEmpty()) {

            //JOptionPane.showMessageDialog(null, "Selecione a Província! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Selecione a Província! ");
            nt.showNotification();
            
            txtProvincia.requestFocus();
        }

        else {

            materialTabbed1.setEnabledAt(1, true);
            materialTabbed1.setSelectedIndex(1);
        }
    }//GEN-LAST:event_btnProxímoPessoaisActionPerformed

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRuaActionPerformed

    private void btnProxímoComplementaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxímoComplementaresActionPerformed
        // TODO add your handling code here:

        // Verificar os campos se estão vazios Membros:
        TelaPrincipal frame = null;
       try {
           frame = new TelaPrincipal();
       } catch (SQLException ex) {
           Logger.getLogger(Form_Visitante.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParseException ex) {
           Logger.getLogger(Form_Visitante.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        if(jFTelefone1.getText().equals("           "))

        {
            //JOptionPane.showMessageDialog(null, "Preencha o campo Telefone1! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Telefone1! ");
            nt.showNotification();
            
            jFTelefone1.requestFocus();}

        else if(jFTelefone2.getText().equals("           ")) {

           // JOptionPane.showMessageDialog(null, "Preencha o campo Telefone2! ");
            
             Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Telefone2! ");
             nt.showNotification();
            
            jFTelefone2.requestFocus();}

        else if (txtEmail.getText().trim().isEmpty()) {

           // JOptionPane.showMessageDialog(null, "Preencha o campo Email! ");
            
             Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Email! ");
             nt.showNotification();
            
            txtEmail.requestFocus();
        }

        else if(txtProfissão.getText().isEmpty()) {

           // JOptionPane.showMessageDialog(null, "Preencha o campo Profissão! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Profissão! ");
            nt.showNotification();
            
            txtProfissão.requestFocus();}

        else if (txtBairro.getText().trim().isEmpty()) {

           // JOptionPane.showMessageDialog(null, "Preencha o campo Bairro! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Bairro! ");
            nt.showNotification();
            
            txtBairro.requestFocus();
        }

        else if (txtRua.getText().trim().isEmpty()) {

            //JOptionPane.showMessageDialog(null, "Preencha o campo Rua! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Rua! ");
            nt.showNotification();
            
            txtRua.requestFocus();
        }

        else {

            materialTabbed1.setEnabledAt(2, true);
            materialTabbed1.setSelectedIndex(2);
        }
    }//GEN-LAST:event_btnProxímoComplementaresActionPerformed

    private void btnCancelarComplementaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarComplementaresActionPerformed
        // TODO add your handling code here:

        limparCamposComplementares();

    }//GEN-LAST:event_btnCancelarComplementaresActionPerformed

    private void txtMãeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMãeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMãeActionPerformed

    private void txtCônjugeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCônjugeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCônjugeActionPerformed

    private void txtPaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaiActionPerformed

    private void btnProxímoRelacionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProxímoRelacionamentoActionPerformed
        // TODO add your handling code here:

        // Verificar os campos se estão vazios Membros:
        TelaPrincipal frame = null;
       try {
           frame = new TelaPrincipal();
       } catch (SQLException ex) {
           Logger.getLogger(Form_Visitante.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParseException ex) {
           Logger.getLogger(Form_Visitante.class.getName()).log(Level.SEVERE, null, ex);
       }
        if(comboCivil.getSelectedIndex()== -1)

        {
            //JOptionPane.showMessageDialog(null, "Preencha o campo Estado Civil! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Estado Civil! ");
            nt.showNotification();
            
            comboCivil.requestFocus();}

        else if(txtPai.getText().trim().isEmpty()) {

            //JOptionPane.showMessageDialog(null, "Preencha o campo Pai! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Pai! ");
            nt.showNotification();
            
            txtPai.requestFocus();}

        else if (txtMãe.getText().trim().isEmpty()) {

           // JOptionPane.showMessageDialog(null, "Preencha o campo Mãe! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Mãe! ");
            nt.showNotification();
            
            txtMãe.requestFocus();
        }

        else if(comboFamilia.getSelectedIndex()== -1) {

            //JOptionPane.showMessageDialog(null, "Preencha o campo Cabeça da Família! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Cabeça da Família! ");
            nt.showNotification();
            
            comboFamilia.requestFocus();}

        else {

            materialTabbed1.setEnabledAt(3, true);
            materialTabbed1.setSelectedIndex(3);
        }

    }//GEN-LAST:event_btnProxímoRelacionamentoActionPerformed

    private void btnCancelarRelacionamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarRelacionamentoActionPerformed
        // TODO add your handling code here:

        limparCamposRelacionamento();
    }//GEN-LAST:event_btnCancelarRelacionamentoActionPerformed

    private void txtIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgrejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgrejaActionPerformed

    private void btnGuardarDadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarDadosActionPerformed
        // TODO add your handling code here:

        // Verificar os campos se estão vazios Visitante:

        VisitanteBean trn = new VisitanteBean();
        Visitante tdao = new Visitante();
        TelaPrincipal frame = null;
       try {
           frame = new TelaPrincipal();
       } catch (SQLException ex) {
           Logger.getLogger(Form_Visitante.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParseException ex) {
           Logger.getLogger(Form_Visitante.class.getName()).log(Level.SEVERE, null, ex);
       }

        if (txtIgreja.getText().trim().isEmpty()) {

           // JOptionPane.showMessageDialog(null, "Preencha o campo Igreja! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Igreja! ");
            nt.showNotification();
            
            txtIgreja.requestFocus();
        }

        else if(txtComoConheceuIgreja.getText().isEmpty()) {

            //JOptionPane.showMessageDialog(null, "Preencha o campo Como conheceu a Igreja! ");
            
            Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Como conheceu a Igreja! ");
            nt.showNotification();
            
            txtComoConheceuIgreja.requestFocus();}


        else {

            trn.setNomecompleto(txtNome.getText().trim());
            trn.setGenero((String) combogenero.getSelectedItem());
            trn.setData_de_nasc(jDate.getValue().toString());
            trn.setNacionalidade(txtNacionalidade.getText().trim());
            trn.setNaturalde(txtNatural.getText().trim());
            trn.setProvíncia(txtProvincia.getText().trim());

            trn.setTelefone1(jFTelefone1.getValue().toString());
            trn.setTelefone2(jFTelefone2.getValue().toString());
            trn.setEmail(txtEmail.getText().trim());
            trn.setProfissao(txtProfissão.getText().trim());
            trn.setBairro(txtBairro.getText().trim());
            trn.setRua(txtRua.getText().trim());

            trn.setEstadocivil((String)comboCivil.getSelectedItem());
            trn.setPai(txtPai.getText().trim());
            trn.setMae(txtMãe.getText().trim());
            trn.setCabeçafamilia((String)comboFamilia.getSelectedItem());
            trn.setConjuge(txtCônjuge.getText().trim());
            trn.setQtdfilho((int)spinnerFilhos.getValue());

            trn.setIgreja(txtIgreja.getText().trim());
            trn.setConheceuigreja(txtComoConheceuIgreja.getText().trim());
           

            try {

                // Enviar foto para Tabela Mmebros :

                if(jFoto != null){

                    Image img = ((ImageIcon)jFoto.getIcon()).getImage();
                    BufferedImage bi = new BufferedImage(//é a imagem na memória e que pode ser alterada
                        img.getWidth(null),
                        img.getHeight(null),
                        BufferedImage.TYPE_INT_RGB);
                    Graphics2D g2 = bi.createGraphics();
                    g2.drawImage(img, 0, 0, null);
                    ByteArrayOutputStream buffer1 = new ByteArrayOutputStream();
                    ImageIO.write(bi, "jpg", buffer1);

                    trn.setFoto(buffer1.toByteArray());

                }

                //Enviar dados em Membros:

                try {

                    tdao.Salvar(trn);
                    
                    //JOptionPane.showMessageDialog(null, "Dados salvos com sucesso! ");
                    
                    Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Dados salvos com sucesso! ");
                    nt.showNotification();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Form_Visitante.class.getName()).log(Level.SEVERE, null, ex);
                }

                // Limpar os campos e a Imagem:

                setarFoto();

                // Limpar todos os campos:

                limparCamposIgrejas();
                limparCamposDadosPessoais();
                limparCamposComplementares();
                limparCamposRelacionamento();

            }  catch (IOException ex) {
                Logger.getLogger(Form_Membros.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGuardarDadosActionPerformed

    private void btnCancelarIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarIgrejaActionPerformed
        // TODO add your handling code here:

        limparCamposIgrejas();

    }//GEN-LAST:event_btnCancelarIgrejaActionPerformed

    private void txtProfissãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProfissãoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProfissãoActionPerformed

    private void txtComoConheceuIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtComoConheceuIgrejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtComoConheceuIgrejaActionPerformed

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtNome.getText());
      txtNome.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtNomeKeyReleased

    private void txtNacionalidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNacionalidadeKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtNacionalidade.getText());
      txtNacionalidade.setText(fMaiuscula); 
        
    }//GEN-LAST:event_txtNacionalidadeKeyReleased

    private void txtNaturalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNaturalKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtNatural.getText());
      txtNatural.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtNaturalKeyReleased

    private void txtProvinciaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProvinciaKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtProvincia.getText());
      txtProvincia.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtProvinciaKeyReleased

    private void txtProfissãoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProfissãoKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtProfissão.getText());
      txtProfissão.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtProfissãoKeyReleased

    private void txtBairroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBairroKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtBairro.getText());
      txtBairro.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtBairroKeyReleased

    private void txtRuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRuaKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtRua.getText());
      txtRua.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtRuaKeyReleased

    private void txtPaiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaiKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtPai.getText());
      txtPai.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtPaiKeyReleased

    private void txtMãeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMãeKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtMãe.getText());
      txtMãe.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtMãeKeyReleased

    private void txtCônjugeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCônjugeKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtCônjuge.getText());
      txtCônjuge.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtCônjugeKeyReleased

    private void txtIgrejaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgrejaKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtIgreja.getText());
      txtIgreja.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtIgrejaKeyReleased

    private void txtComoConheceuIgrejaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComoConheceuIgrejaKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtComoConheceuIgreja.getText());
      txtComoConheceuIgreja.setText(fMaiuscula);
        
    }//GEN-LAST:event_txtComoConheceuIgrejaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient btnCancelarComplementares;
    private swing.ButtonGradient btnCancelarIgreja;
    private swing.ButtonGradient btnCancelarPessoais;
    private swing.ButtonGradient btnCancelarRelacionamento;
    private swing.ButtonGradient btnGuardarDados;
    private swing.ButtonGradient btnProxímoComplementares;
    private swing.ButtonGradient btnProxímoPessoais;
    private swing.ButtonGradient btnProxímoRelacionamento;
    private swing.ButtonGradient btnSelecioneImagem;
    private combobox.Combobox comboCivil;
    private combobox.Combobox comboFamilia;
    private combobox.Combobox combogenero;
    private textfield.jFormattedTextField jDate;
    private textfield.jFormattedTextField jFTelefone1;
    private textfield.jFormattedTextField jFTelefone2;
    private javax.swing.JLabel jFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel panelComplementares;
    private javax.swing.JPanel panelIgreja;
    private javax.swing.JPanel panelPessoais;
    private javax.swing.JPanel panelRelacionamentos;
    private spinner.Spinner spinnerFilhos;
    private textfield.TextField txtBairro;
    private textfield.TextField txtComoConheceuIgreja;
    private textfield.TextField txtCônjuge;
    private textfield.TextField txtEmail;
    private textfield.TextField txtIgreja;
    private textfield.TextField txtMãe;
    private textfield.TextField txtNacionalidade;
    private textfield.TextField txtNatural;
    private textfield.TextField txtNome;
    private textfield.TextField txtPai;
    private textfield.TextField txtProfissão;
    private textfield.TextField txtProvincia;
    private textfield.TextField txtRua;
    // End of variables declaration//GEN-END:variables
}
