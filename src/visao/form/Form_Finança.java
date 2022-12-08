
package visao.form;

import Atxy2k.CustomTextField.RestrictedTextField;
import Notification.Notification;
import conexao.ConnectionFactory;
import controle.LimiteTexto;
import controle.ScrollBarCustom;
import controleDao.Agenda;
import controleDao.Contas;
import controleDao.Financa;
import controleDao.TotalGeralDao;
import java.awt.Color;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import modelo.AgendaBean;
import modelo.ContasBean;
import modelo.FinancaBean;
import modelo.TotalGeralBean;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.util.StringUtils;
import visao.TelaPrincipal;


public class Form_Finança extends javax.swing.JPanel {

   
    public Form_Finança() throws SQLException, ParseException {
        initComponents();
        setOpaque(false);
        
        limitarnum();
        
      jLabelPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      table.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      
      jLabelPesquisarContas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      tableContas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      
      btnRelatorioContas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      btnRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      btnDeletar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      btnDeletarContas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR) );
      
      txtProcurar.setDocument(new LimiteTexto(30));
      txtProcurarContas.setDocument(new LimiteTexto(30));
   
      txtNome.setDocument(new LimiteTexto(25)); 
      txtIgreja.setDocument(new LimiteTexto(35)); 
      txtIgrejaContas.setDocument(new LimiteTexto(35)); 
  
      txtNome.setDocument(new LimiteTexto(30));
     
        //  add row table Financas
                
        spTable.setVerticalScrollBar(new ScrollBarCustom());
        spTable.setHorizontalScrollBar(new ScrollBarCustom());
        spTable.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
        
        //  add row table Contas
                
        spTableContas.setVerticalScrollBar(new ScrollBarCustom());
        spTableContas.setHorizontalScrollBar(new ScrollBarCustom());
        spTableContas.getViewport().setBackground(Color.WHITE);
        JPanel c = new JPanel();
        c.setBackground(Color.WHITE);
        spTableContas.setCorner(JScrollPane.UPPER_RIGHT_CORNER, c);
        
        fListar();
        cListar();
        
        somarTotalDízimo();
        somarTotalOferta();
        somarTotalGeralContas();
        mostrarTotaGeral();
            
        String dizimo = "0";
        String oferta = "0";
        String valor = "0";
        
      
    }

     private void limitarnum(){ 
       
        RestrictedTextField d = new RestrictedTextField(txtDizimo);
        RestrictedTextField o = new RestrictedTextField(txtOferta);
        RestrictedTextField v = new RestrictedTextField(txtValor);
        d.setLimit(7);
        d.setOnlyNums(true);
        o.setLimit(7);
        o.setOnlyNums(true);
        v.setLimit(7);
        v.setOnlyNums(true);
        
   }
     
  
    private void limparCamposFinanca () {
        
    txtNome.setText("");            
    txtIgreja.setText("");            
    comboCargo.setSelectedIndex(-1);
    jFTelefone1.setText("");
    txtBairro.setText("");
    comboReferencia.setSelectedIndex(-1);   
    txtDizimo.setText("0");
    txtOferta.setText("0");
     } 
    
    private void limparCamposContas () {
        
    txtIgrejaContas.setText("");                      
    comboContas.setSelectedIndex(-1);
    comboReferenciaContas.setSelectedIndex(-1);
    txtValor.setText("0");
    
    
     } 
    
    // Total Geral de Dízimo:
    
     
     private void somarTotalDízimo () throws SQLException, ParseException{
  
          try {
  
         Connection conn = ConnectionFactory.getConnection();
        
        String sql = (" SELECT SUM (dizimo) FROM financa "); 
        
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){
        // capturando o valor que retorna (a soma)
     
       double valor = rs.getDouble(1);
     
     
        // setando para a textField, fazendo a conversão para String
        
       String padrao = "###,###.00";
       
       DecimalFormat df = new DecimalFormat(padrao);
        
        
        txtSaldoDizimo.setText(df.format(valor));
      
           
        }
       //  JOptionPane.showMessageDialog(null, "Valores somados com Sucesso!!");
       
    } catch (SQLException ex) {
        
      //JOptionPane.showMessageDialog(null, "Erro ao somar valores do Banco de Dados!/n Erro: !!"+ex.getMessage());
    }  
     } 
    
     // Total de Oferta:
     
     private void somarTotalOferta () throws SQLException, ParseException{
  
          try {
  
         Connection conn = ConnectionFactory.getConnection();
        
        String sql = ("SELECT SUM (oferta) FROM financa "); 
        
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){
        // capturando o valor que retorna (a soma)
     
       double valor = rs.getDouble(1);
       
     
        // setando para a textField, fazendo a conversão para String
        
       String padrao = "###,###.00";
       
       DecimalFormat df = new DecimalFormat(padrao);
        
        
        txtSaldoOferta.setText(df.format(valor));  
        
        
        }
       //  JOptionPane.showMessageDialog(null, "Valores somados com Sucesso!!");
       
    } catch (SQLException ex) {
        
      //JOptionPane.showMessageDialog(null, "Erro ao somar valores do Banco de Dados!/n Erro: !!"+ex.getMessage());
    }  
     } 
     
     // Total Geral de Dízimo e Oferta:
     
     private void somarTotalGeral () throws SQLException, ParseException{
  
          try {
  
         Connection conn = ConnectionFactory.getConnection();
        
        String sql = ("SELECT SUM (dizimo) + SUM (oferta) FROM financa"); 
        
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){
        // capturando o valor que retorna (a soma)
     
       double valor = rs.getDouble(1);
       
     
       String padrao = "###,###.00";
       
       DecimalFormat df = new DecimalFormat(padrao);
       
       
        // setando para a textField, fazendo a conversão para String
         
        txtSaldoGeral.setText(df.format(valor));
            
        }
       //  JOptionPane.showMessageDialog(null, "Valores somados com Sucesso!!");
       
    } catch (SQLException ex) {
        
      JOptionPane.showMessageDialog(null, "Erro ao somar valores do Banco de Dados!/n Erro: !!"+ex.getMessage());
    } 
       
     } 
     
     
     // Total Geral de Dízimo e Oferta:
     
     private void subtrairTotalGeral () throws SQLException, ParseException{
  
         // try {
  
       /*  Connection conn = ConnectionFactory.getConnection();
        
        String sql = ("SELECT SUM (dizimo) + SUM (oferta) -"+txtValor.getText()+" FROM financa"); 
        
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){
        // capturando o valor que retorna (a soma)
     
       double valor = rs.getDouble(1);*/
       
       
       int num1 = Integer.parseInt(txtValor.getText());
       int num2 = Integer.parseInt(txtSaldoGeral.getText());
       int res = num1 - num2;
       
       String padrao = "###,###.00";
       
       DecimalFormat df = new DecimalFormat(padrao);
       
        txtSaldoGeral.setText((df.format(res)));
            
      //  }
      
       //  JOptionPane.showMessageDialog(null, "Valores somados com Sucesso!!");
       
   // } catch (SQLException ex) {
        
     // JOptionPane.showMessageDialog(null, "Erro ao somar valores do Banco de Dados!/n Erro: !!"+ex.getMessage());
    } 
      
    // } 
    
   
     // Total Geral de Dízimo e Oferta:
     
     private void mostrarTotaGeral () throws SQLException, ParseException{
  
          try {
  
         Connection conn = ConnectionFactory.getConnection();
        
        String sql = ("SELECT * FROM totalgeral"); 
        
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){
      
       
       String valor = rs.getString(1);
     
     
       String padrao = "###,###.00";
       
       DecimalFormat df = new DecimalFormat(padrao);
      
        // setando para a textField, fazendo a conversão para String
         
        txtSaldoGeral.setText(valor);
        
        }
       //  JOptionPane.showMessageDialog(null, "Valores somados com Sucesso!!");
       
    } catch (SQLException ex) {
        
      JOptionPane.showMessageDialog(null, "Erro ao somar valores do Banco de Dados!/n Erro: !!"+ex.getMessage());
    }  
     } 
   
     
     //Mostrar valores de Finanças na Tabela:
    
    public void fListar() throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       
       Financa bdao = new Financa();
       for(FinancaBean b: bdao.Financiar()) {
        
       modelo.addRow(new Object[]{
          
        b.getNome(),
        b.getIgreja(),
        b.getCargo(),
        b.getTelefone1(),
        b.getBairro(),
        b.getReferencia(),
        b.getDizimo(),
        b.getOferta(),
        b.getMoeda(),
        b.getData(),
        });
        }
         }
    
    
      //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResult(String nome) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) table.getModel(); 
       modelo.setNumRows(0);
       Financa pdao = new Financa();
       
       for(FinancaBean p: pdao.buscar(nome)) {
        
       modelo.addRow(new Object[]{
                     
        p.getNome(),
        p.getIgreja(),
        p.getCargo(),
        p.getTelefone1(),
        p.getBairro(),
        p.getReferencia(),
        p.getDizimo(),
        p.getOferta(),
        p.getMoeda(),
        p.getData(),
       
        
        });
        }
    }
    
    //Mostrar valores de Contas na Tabela:
    
    public void cListar() throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) tableContas.getModel(); 
       modelo.setNumRows(0);
       
       Contas bdao = new Contas();
       for(ContasBean b: bdao.listarContas()) {
        
       modelo.addRow(new Object[]{
          
        b.getIgreja(),
        b.getConta(),
        b.getReferencia(),
        b.getValor(),
        b.getMoeda(),
        b.getData(),
        });
        }
         }
    
      //Buscar o Resultado da Tabela de Pesquisa:
    
    public void buscarResultContas(String nome) throws SQLException {
        
       DefaultTableModel modelo = (DefaultTableModel) tableContas.getModel(); 
       modelo.setNumRows(0);
       Contas pdao = new Contas();
       
       for(ContasBean p: pdao.buscar(nome)) {
        
       modelo.addRow(new Object[]{
                     
        p.getIgreja(),
        p.getConta(),
        p.getReferencia(),
        p.getValor(),
        p.getMoeda(),
        p.getData(),
       
        
        });
        }
    }
    
     
    // Total Geral de Contas:
    
     
     private void somarTotalGeralContas () throws SQLException, ParseException{
  
          try {
  
         Connection conn = ConnectionFactory.getConnection();
        
        String sql = (" SELECT SUM (valor) FROM contas "); 
        
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()){
        // capturando o valor que retorna (a soma)
     
       double valor = rs.getDouble(1);
     
     
        // setando para a textField, fazendo a conversão para String
        
       String padrao = "###,###.00";
       
       DecimalFormat df = new DecimalFormat(padrao);
        
        
        txtSaldoGeralContas.setText(df.format(valor));
      
           
        }
       //  JOptionPane.showMessageDialog(null, "Valores somados com Sucesso!!");
       
    } catch (SQLException ex) {
        
      //JOptionPane.showMessageDialog(null, "Erro ao somar valores do Banco de Dados!/n Erro: !!"+ex.getMessage());
    }  
     } 
        
    //Gerar Relatório Financa:
    
     private void gerarRelatórioFinanca() throws SQLException, JRException {  
         
       Connection conn = ConnectionFactory.getConnection();
       
       String sql ="select id, descricao, nome, valor_da_compra, moeda, unidade, data from financa";
       
       JasperPrint jaspertPrint = null;
       
       //Caminho Relatório:
     
      InputStream caminhoRelatório = this.getClass().getClassLoader().getResourceAsStream("relatórioADXBAR/relatórioCucaADXBAR.jasper");
      try {
          jaspertPrint = JasperFillManager.fillReport(caminhoRelatório, null, conn);
          
      } catch (JRException ex) {
          
       JOptionPane.showMessageDialog(null, "Error:"+ex.getMessage());
      }
      JasperViewer view = new JasperViewer(jaspertPrint, false);
      view.setVisible(true);
     }
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        materialTabbed1 = new tabbed.MaterialTabbed();
        panelFinança = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        txtNome = new textfield.TextField();
        txtBairro = new textfield.TextField();
        jFTelefone1 = new textfield.jFormattedTextField();
        btnGuardar = new swing.ButtonGradient();
        btnCancelarF = new swing.ButtonGradient();
        comboReferencia = new combobox.Combobox();
        comboCargo = new combobox.Combobox();
        txtIgreja = new textfield.TextField();
        panelRound2 = new JPanelRounder.PanelRound();
        txtDizimo = new textfield.TextField();
        txtOferta = new textfield.TextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSaldoDizimo = new textfield.TextField();
        jLabel12 = new javax.swing.JLabel();
        txtSaldoOferta = new textfield.TextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        panelListaPagamento = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panelRound1 = new JPanelRounder.PanelRound();
        spTable = new javax.swing.JScrollPane();
        table = new controle.Table();
        btnRelatorio = new swing.ButtonGradient();
        btnDeletar = new swing.ButtonGradient();
        jLabelPesquisar = new javax.swing.JLabel();
        txtProcurar = new controle.SearchText();
        jSeparator1 = new javax.swing.JSeparator();
        panelContaApagar = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        txtIgrejaContas = new textfield.TextField();
        btnConfirmar = new swing.ButtonGradient();
        comboReferenciaContas = new combobox.Combobox();
        jLabelTotalGeral = new javax.swing.JLabel();
        comboContas = new combobox.Combobox();
        txtValor = new textfield.TextField();
        jLabel14 = new javax.swing.JLabel();
        btnCancelarC = new swing.ButtonGradient();
        panelRound4 = new JPanelRounder.PanelRound();
        txtSaldoGeral = new textfield.TextField();
        jLabel13 = new javax.swing.JLabel();
        txtSaldoGeralContas = new textfield.TextField();
        jLabel16 = new javax.swing.JLabel();
        jLabelTotalGeral1 = new javax.swing.JLabel();
        panelListaContas = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        panelRound3 = new JPanelRounder.PanelRound();
        spTableContas = new javax.swing.JScrollPane();
        tableContas = new controle.Table();
        btnRelatorioContas = new swing.ButtonGradient();
        btnDeletarContas = new swing.ButtonGradient();
        jLabelPesquisarContas = new javax.swing.JLabel();
        txtProcurarContas = new controle.SearchText();
        jSeparator2 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        materialTabbed1.setBackground(new java.awt.Color(255, 255, 255));
        materialTabbed1.setForeground(new java.awt.Color(14, 175, 239));
        materialTabbed1.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        materialTabbed1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                materialTabbed1StateChanged(evt);
            }
        });

        panelFinança.setBackground(new java.awt.Color(255, 255, 255));
        panelFinança.setPreferredSize(new java.awt.Dimension(720, 349));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(742, 656));

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(126, 210, 244));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Formulário");

        jSeparator3.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator3.setForeground(new java.awt.Color(145, 212, 238));

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

        btnCancelarF.setText("Cancelar");
        btnCancelarF.setColor1(new java.awt.Color(126, 210, 244));
        btnCancelarF.setColor2(new java.awt.Color(14, 175, 239));
        btnCancelarF.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelarF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarFActionPerformed(evt);
            }
        });

        comboReferencia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Via Bancária" }));
        comboReferencia.setSelectedIndex(-1);
        comboReferencia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboReferencia.setLabeText("Referência");
        comboReferencia.setLineColor(new java.awt.Color(14, 175, 239));

        comboCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pastor", "Presbítero", "Diácono", "Missionário", "Membro" }));
        comboCargo.setSelectedIndex(-1);
        comboCargo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboCargo.setLabeText("Cargo");
        comboCargo.setLineColor(new java.awt.Color(14, 175, 239));

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

        panelRound2.setBackground(new java.awt.Color(255, 255, 255));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);

        txtDizimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDizimo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDizimo.setLabelText("Dízimo");
        txtDizimo.setLineColor(new java.awt.Color(14, 175, 239));
        txtDizimo.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtDizimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDizimoActionPerformed(evt);
            }
        });
        txtDizimo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtDizimoKeyReleased(evt);
            }
        });

        txtOferta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtOferta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtOferta.setLabelText("Oferta");
        txtOferta.setLineColor(new java.awt.Color(14, 175, 239));
        txtOferta.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOfertaActionPerformed(evt);
            }
        });
        txtOferta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOfertaKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("KZ");

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("KZ");

        txtSaldoDizimo.setEditable(false);
        txtSaldoDizimo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoDizimo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSaldoDizimo.setLabelText("Saldo");
        txtSaldoDizimo.setLineColor(new java.awt.Color(14, 175, 239));
        txtSaldoDizimo.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtSaldoDizimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoDizimoActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("KZ");

        txtSaldoOferta.setEditable(false);
        txtSaldoOferta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoOferta.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSaldoOferta.setLabelText("Saldo");
        txtSaldoOferta.setLineColor(new java.awt.Color(14, 175, 239));
        txtSaldoOferta.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtSaldoOferta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoOfertaActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("KZ");

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(txtSaldoDizimo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtSaldoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15))
                    .addGroup(panelRound2Layout.createSequentialGroup()
                        .addComponent(txtDizimo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtDizimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSaldoDizimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtSaldoOferta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(126, 210, 244));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Pagamento");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(249, 249, 249)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelarF, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelRound2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator3, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIgreja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jFTelefone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelarF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(173, Short.MAX_VALUE))
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

        javax.swing.GroupLayout panelFinançaLayout = new javax.swing.GroupLayout(panelFinança);
        panelFinança.setLayout(panelFinançaLayout);
        panelFinançaLayout.setHorizontalGroup(
            panelFinançaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(panelFinançaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
        );
        panelFinançaLayout.setVerticalGroup(
            panelFinançaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(panelFinançaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Financiamento", panelFinança);

        panelListaPagamento.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setBackground(new java.awt.Color(31, 159, 210));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-venda-loja-financiamento-finanças-dinheiro-pagamento-compras-10-100.png"))); // NOI18N

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
                "Nome", "Igreja", "Cargo", "Telefone1", "Endereço", "Referência", "Dízimo", "Oferta", "Moeda", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false, false
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelListaPagamentoLayout = new javax.swing.GroupLayout(panelListaPagamento);
        panelListaPagamento.setLayout(panelListaPagamentoLayout);
        panelListaPagamentoLayout.setHorizontalGroup(
            panelListaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(panelListaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelListaPagamentoLayout.setVerticalGroup(
            panelListaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(panelListaPagamentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaPagamentoLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        materialTabbed1.addTab("Lista de Pagamento", panelListaPagamento);

        panelContaApagar.setBackground(new java.awt.Color(255, 255, 255));
        panelContaApagar.setPreferredSize(new java.awt.Dimension(720, 349));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(742, 656));

        jLabel8.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(126, 210, 244));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Formulário");

        jSeparator4.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator4.setForeground(new java.awt.Color(145, 212, 238));

        txtIgrejaContas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtIgrejaContas.setLabelText("Igreja");
        txtIgrejaContas.setLineColor(new java.awt.Color(14, 175, 239));
        txtIgrejaContas.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtIgrejaContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIgrejaContasActionPerformed(evt);
            }
        });
        txtIgrejaContas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIgrejaContasKeyReleased(evt);
            }
        });

        btnConfirmar.setText("Confirmar");
        btnConfirmar.setColor1(new java.awt.Color(126, 210, 244));
        btnConfirmar.setColor2(new java.awt.Color(14, 175, 239));
        btnConfirmar.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnConfirmar.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnConfirmarStateChanged(evt);
            }
        });
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        comboReferenciaContas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dinheiro", "Via Bancária" }));
        comboReferenciaContas.setSelectedIndex(-1);
        comboReferenciaContas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboReferenciaContas.setLabeText("Referência");
        comboReferenciaContas.setLineColor(new java.awt.Color(14, 175, 239));

        jLabelTotalGeral.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelTotalGeral.setForeground(new java.awt.Color(126, 210, 244));
        jLabelTotalGeral.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalGeral.setText("Total Geral");

        comboContas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Água", "Energia", "Internet", "Limpeza", "Manutenção" }));
        comboContas.setSelectedIndex(-1);
        comboContas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        comboContas.setLabeText("Conta");
        comboContas.setLineColor(new java.awt.Color(14, 175, 239));

        txtValor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtValor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtValor.setLabelText("Valor");
        txtValor.setLineColor(new java.awt.Color(14, 175, 239));
        txtValor.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        txtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtValorKeyReleased(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("KZ");

        btnCancelarC.setText("Cancelar");
        btnCancelarC.setColor1(new java.awt.Color(126, 210, 244));
        btnCancelarC.setColor2(new java.awt.Color(14, 175, 239));
        btnCancelarC.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnCancelarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarCActionPerformed(evt);
            }
        });

        panelRound4.setBackground(new java.awt.Color(255, 255, 255));
        panelRound4.setRoundBottomLeft(20);
        panelRound4.setRoundBottomRight(20);
        panelRound4.setRoundTopLeft(20);
        panelRound4.setRoundTopRight(20);

        txtSaldoGeral.setEditable(false);
        txtSaldoGeral.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoGeral.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSaldoGeral.setLabelText("Saldo disponíveis");
        txtSaldoGeral.setLineColor(new java.awt.Color(14, 175, 239));
        txtSaldoGeral.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtSaldoGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoGeralActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("KZ");

        txtSaldoGeralContas.setEditable(false);
        txtSaldoGeralContas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSaldoGeralContas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtSaldoGeralContas.setLabelText("Saldo disponíveis");
        txtSaldoGeralContas.setLineColor(new java.awt.Color(14, 175, 239));
        txtSaldoGeralContas.setSelectionColor(new java.awt.Color(126, 210, 244));
        txtSaldoGeralContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoGeralContasActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("KZ");

        javax.swing.GroupLayout panelRound4Layout = new javax.swing.GroupLayout(panelRound4);
        panelRound4.setLayout(panelRound4Layout);
        panelRound4Layout.setHorizontalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRound4Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(txtSaldoGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtSaldoGeralContas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        panelRound4Layout.setVerticalGroup(
            panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRound4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSaldoGeralContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRound4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSaldoGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );

        jLabelTotalGeral1.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabelTotalGeral1.setForeground(new java.awt.Color(126, 210, 244));
        jLabelTotalGeral1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTotalGeral1.setText("Total Geral das Contas");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(txtIgrejaContas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(49, 49, 49)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(comboContas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(49, 49, 49)
                                    .addComponent(comboReferenciaContas, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelarC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel14)))))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(129, 129, 129)
                            .addComponent(jLabelTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(64, 64, 64)
                            .addComponent(jLabelTotalGeral1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIgrejaContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboContas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboReferenciaContas, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotalGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTotalGeral1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(panelRound4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 641, Short.MAX_VALUE)))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(633, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout panelContaApagarLayout = new javax.swing.GroupLayout(panelContaApagar);
        panelContaApagar.setLayout(panelContaApagarLayout);
        panelContaApagarLayout.setHorizontalGroup(
            panelContaApagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(panelContaApagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 755, Short.MAX_VALUE))
        );
        panelContaApagarLayout.setVerticalGroup(
            panelContaApagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(panelContaApagarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
        );

        materialTabbed1.addTab("Contas à Apagar", panelContaApagar);

        panelListaContas.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setBackground(new java.awt.Color(31, 159, 210));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-venda-loja-financiamento-finanças-dinheiro-pagamento-compras-10-100.png"))); // NOI18N

        panelRound3.setBackground(new java.awt.Color(255, 255, 255));
        panelRound3.setRoundBottomLeft(10);
        panelRound3.setRoundBottomRight(10);
        panelRound3.setRoundTopLeft(10);
        panelRound3.setRoundTopRight(10);

        spTableContas.setBackground(new java.awt.Color(255, 255, 255));
        spTableContas.setBorder(null);
        spTableContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spTableContasMouseClicked(evt);
            }
        });

        tableContas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Igreja", "Conta", "Referência", "Valor", "Moeda", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableContasMouseClicked(evt);
            }
        });
        spTableContas.setViewportView(tableContas);

        javax.swing.GroupLayout panelRound3Layout = new javax.swing.GroupLayout(panelRound3);
        panelRound3.setLayout(panelRound3Layout);
        panelRound3Layout.setHorizontalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTableContas, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelRound3Layout.setVerticalGroup(
            panelRound3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(spTableContas, javax.swing.GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
        );

        btnRelatorioContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-gire-para-a-esquerda-20.png"))); // NOI18N
        btnRelatorioContas.setColor1(new java.awt.Color(126, 210, 244));
        btnRelatorioContas.setColor2(new java.awt.Color(14, 175, 239));
        btnRelatorioContas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnRelatorioContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRelatorioContasActionPerformed(evt);
            }
        });

        btnDeletarContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-lixo-20.png"))); // NOI18N
        btnDeletarContas.setColor1(new java.awt.Color(126, 210, 244));
        btnDeletarContas.setColor2(new java.awt.Color(14, 175, 239));
        btnDeletarContas.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        btnDeletarContas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarContasActionPerformed(evt);
            }
        });

        jLabelPesquisarContas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPesquisarContas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons8-pesquisar-20.png"))); // NOI18N
        jLabelPesquisarContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPesquisarContasMouseClicked(evt);
            }
        });

        txtProcurarContas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtProcurarContas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtProcurarContasMouseClicked(evt);
            }
        });
        txtProcurarContas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtProcurarContasKeyReleased(evt);
            }
        });

        jSeparator2.setBackground(new java.awt.Color(145, 212, 238));
        jSeparator2.setForeground(new java.awt.Color(145, 212, 238));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(panelRound3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(txtProcurarContas, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabelPesquisarContas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 337, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnRelatorioContas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btnDeletarContas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProcurarContas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPesquisarContas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRelatorioContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletarContas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelRound3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelListaContasLayout = new javax.swing.GroupLayout(panelListaContas);
        panelListaContas.setLayout(panelListaContasLayout);
        panelListaContasLayout.setHorizontalGroup(
            panelListaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 755, Short.MAX_VALUE)
            .addGroup(panelListaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelListaContasLayout.setVerticalGroup(
            panelListaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
            .addGroup(panelListaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListaContasLayout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        materialTabbed1.addTab("Lista de Contas", panelListaContas);

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

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtIgrejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgrejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgrejaActionPerformed

    private void txtDizimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDizimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDizimoActionPerformed

    private void txtOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOfertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOfertaActionPerformed

    private void txtIgrejaContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIgrejaContasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIgrejaContasActionPerformed

    private void txtSaldoGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoGeralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoGeralActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void txtSaldoDizimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoDizimoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoDizimoActionPerformed

    private void txtSaldoOfertaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoOfertaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoOfertaActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        
        FinancaBean bb = new FinancaBean();
        Financa bdao = new Financa();
        TotalGeralBean tb = new TotalGeralBean();
        TotalGeralDao td = new TotalGeralDao();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }
        String moeda = "AKZ";
      
        if(txtNome.getText().trim().isEmpty()) {

           // JOptionPane.showMessageDialog(null, "Preencha o campo Nome!");
            
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Nome!");
         nt.showNotification();

        } else if(txtIgreja.getText().trim().isEmpty()){
        //JOptionPane.showMessageDialog(null, "Preencha o campo Igreja!");
        
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Igreja!");
         nt.showNotification();

        }
        
         else if(comboCargo.getSelectedIndex()== -1){
       // JOptionPane.showMessageDialog(null, "Preencha o campo Cargo!");
        
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Cargo!");
         nt.showNotification();

        }
        
         else if(jFTelefone1.getText().equals("           ")){
      //  JOptionPane.showMessageDialog(null, "Preencha o campo Telefone1!");
        
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Telefone1!");
         nt.showNotification();

        }
         else if(txtBairro.getText().trim().isEmpty()){
       // JOptionPane.showMessageDialog(null, "Preencha o campo Bairro!");
        
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Bairro!");
         nt.showNotification();

        }

         else if(comboReferencia.getSelectedIndex()== -1){
       // JOptionPane.showMessageDialog(null, "Preencha o campo Referência!");
        
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Referência!");
         nt.showNotification();

        }

         else if(txtDizimo.getText().trim().isEmpty()){
       //  JOptionPane.showMessageDialog(null, "Preencha o campo Dízimo!");
         
          Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Dízimo!");
         nt.showNotification();

        }

         else if(txtOferta.getText().trim().isEmpty()){
       //  JOptionPane.showMessageDialog(null, "Preencha o campo Oferta!");
         
          Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Oferta!");
         nt.showNotification();

        }

           
            else {

                bb.setNome(txtNome.getText().trim());
                bb.setIgreja(txtIgreja.getText().trim());
                bb.setCargo((String) comboCargo.getSelectedItem());
                bb.setTelefone1(jFTelefone1.getValue().toString());
                bb.setBairro(txtBairro.getText().trim());
                bb.setReferencia((String) comboReferencia.getSelectedItem());
                bb.setDizimo(Integer.parseInt(txtDizimo.getText()));
                bb.setOferta(Integer.parseInt(txtOferta.getText()));
                bb.setMoeda((moeda));
                //tb.setGerall(Integer.parseInt(txtSaldoGeral.getText().replaceAll("\\,", "").replaceAll("\\.", "").replaceAll("\\00", "")));
               
                
                try {

                    bdao.salvarFinanca(bb);

                   // JOptionPane.showMessageDialog(null, "Guardado com Sucesso! ");
                    
         Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Dados salvos com Sucesso!");
         nt.showNotification();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao Enviar! /n  Erro: !!"+ex.getMessage());
                }
               
              /*   try {
                td.Salvar(tb);
                 } catch (SQLException ex) {
                Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
                
                 }*/
             
                
                try {
                    somarTotalDízimo();
                } catch (SQLException ex) {
                    Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
                }
                             
                try {
                    somarTotalOferta();
                } catch (SQLException ex) {
                    Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                 try {
                somarTotalGeral();
                } catch (SQLException ex) {
                Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                  limparCamposFinanca();
                  
                } 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnCancelarFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarFActionPerformed
        // TODO add your handling code here:
        
        limparCamposFinanca();
        
        
    }//GEN-LAST:event_btnCancelarFActionPerformed

    private void btnCancelarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarCActionPerformed
        // TODO add your handling code here:
        
        limparCamposContas();
              
    }//GEN-LAST:event_btnCancelarCActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        
        ContasBean bb = new ContasBean();
        Contas bdao = new Contas();
        TotalGeralBean tb = new TotalGeralBean();
        TotalGeralDao td = new TotalGeralDao();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }
        String moeda ="AKZ";

        if(txtIgrejaContas.getText().trim().isEmpty()) {

           // JOptionPane.showMessageDialog(null, "Preencha o campo Igreja!");
            
         Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Igreja!");
         nt.showNotification();

        }  
         else if(comboContas.getSelectedIndex()== -1){
      //  JOptionPane.showMessageDialog(null, "Preencha o campo Contas!");
        
        Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Contas!");
        nt.showNotification();

        }

         else if(comboReferenciaContas.getSelectedIndex()== -1){
      //  JOptionPane.showMessageDialog(null, "Preencha o campo Referência!");
        
        Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Referência!");
        nt.showNotification();

        }

         else if(txtValor.getText().trim().isEmpty()){
       // JOptionPane.showMessageDialog(null, "Preencha o campo Valor!");
        
        Notification nt = new Notification(frame, Notification.Type.INFO, Notification.Location.BOTTOM_CENTER, "Preencha o campo Valor!");
        nt.showNotification();

        }
        
            else {
             
           
                bb.setIgreja(txtIgrejaContas.getText().trim());
                bb.setConta((String) comboContas.getSelectedItem());
                bb.setReferencia((String) comboReferenciaContas.getSelectedItem());
                bb.setValor(Integer.parseInt(txtValor.getText().trim()));
                bb.setMoeda((moeda));
                
                 

                try {

                    bdao.salvarContas(bb);

                  //  JOptionPane.showMessageDialog(null, "Guardado com Sucesso! ");
                    
        Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Dados salvos com Sucesso! ");
        nt.showNotification();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao Enviar! /n  Erro: !!"+ex.getMessage());
                }
                
            try {
                mostrarTotaGeral();
            } catch (SQLException ex) {
                Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            tb.setGeral(txtSaldoGeral.getText());     
               
               
            try {
                td.Salvar(tb);
            } catch (SQLException ex) {
                Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
            }
          
             limparCamposContas();
             
           }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnDeletarContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarContasActionPerformed
        // TODO add your handling code here:
        
        ContasBean esc = new ContasBean();       
        Contas esdao = new Contas();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(tableContas.getSelectedRow() != -1){

            esc.setIgreja((String) tableContas.getValueAt(tableContas.getSelectedRow(), 0));
  

            // Deletar Membros:

            try {
                esdao.delete(esc);
                
        Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Excluído com Sucesso!");
        nt.showNotification();
                
            } catch (SQLException ex) {
            
            }

            try {
                cListar();
            } catch (SQLException ex) {
            }
        }

        
        txtProcurarContas.setText("");       
        
    }//GEN-LAST:event_btnDeletarContasActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        
        FinancaBean esc = new FinancaBean();       
        Financa esdao = new Financa();
        TelaPrincipal frame = null;
        try {
            frame = new TelaPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(table.getSelectedRow() != -1){

            esc.setNome((String) table.getValueAt(table.getSelectedRow(), 0));
  

            // Deletar Membros:

            try {
                esdao.delete(esc);
                
                
        Notification nt = new Notification(frame, Notification.Type.SUCCESS, Notification.Location.CENTER, "Excluído com Sucesso!");
        nt.showNotification();
            } catch (SQLException ex) {
            
            }

            try {
                fListar();
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

    private void btnRelatorioContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRelatorioContasActionPerformed
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
        
    }//GEN-LAST:event_btnRelatorioContasActionPerformed

    private void jLabelPesquisarContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisarContasMouseClicked
        // TODO add your handling code here:
        
         if(txtProcurarContas.getText().equals("")){

            try {
                cListar();
                
            } catch (SQLException ex) {
             
            }

        }else {
             try {
                 buscarResultContas(txtProcurarContas.getText()); 
                 
                 // JOptionPane.showMessageDialog(null, "Pesquisa feita com Sucesso!!");
                 
             } catch (SQLException ex) {
          
             }

        } 
    }//GEN-LAST:event_jLabelPesquisarContasMouseClicked

    private void jLabelPesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPesquisarMouseClicked
        // TODO add your handling code here:
        
         if(txtProcurar.getText().equals("")){

            try {
                fListar();
                
            } catch (SQLException ex) {
             
            }

        }else {
             try {
                 buscarResult(txtProcurar.getText()); 
                 
                 // JOptionPane.showMessageDialog(null, "Pesquisa feita com Sucesso!!");
                 
             } catch (SQLException ex) {
  
             }

        }  
           
    }//GEN-LAST:event_jLabelPesquisarMouseClicked

    private void txtProcurarContasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtProcurarContasKeyReleased
        // TODO add your handling code here:
        
       String fMaiuscula = StringUtils.capitalize(txtProcurarContas.getText());
       txtProcurarContas.setText(fMaiuscula);
      
          try {
             buscarResultContas(fMaiuscula);
         } catch (SQLException ex) {
            
         }
          
    }//GEN-LAST:event_txtProcurarContasKeyReleased

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
        // TODO add your handling code here:
        try {
                    
            fListar();
        } catch (SQLException ex) {
           
        }
        
         try {
           
            
            cListar();
        } catch (SQLException ex) {
           
        }  
         
        try {
            somarTotalDízimo();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        try {
            somarTotalOferta();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            somarTotalGeralContas();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_materialTabbed1StateChanged

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        
           if(table.getSelectedRow() != -1){

            txtProcurar.setText(table.getValueAt(table.getSelectedRow(), 0).toString());

    }           
    }//GEN-LAST:event_tableMouseClicked

    private void tableContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableContasMouseClicked
        // TODO add your handling code here:
        
           if(tableContas.getSelectedRow() != -1){

            txtProcurarContas.setText(tableContas.getValueAt(tableContas.getSelectedRow(), 0).toString());

    }            
    }//GEN-LAST:event_tableContasMouseClicked

    private void txtProcurarContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtProcurarContasMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProcurarContasMouseClicked

    private void spTableContasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spTableContasMouseClicked
        // TODO add your handling code here:     
    }//GEN-LAST:event_spTableContasMouseClicked

    private void txtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBairroActionPerformed

    private void btnConfirmarStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnConfirmarStateChanged
        // TODO add your handling code here: 
    }//GEN-LAST:event_btnConfirmarStateChanged

    private void txtDizimoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDizimoKeyReleased
      /*  try {
            
            somarTotalDízimoRealease();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
      /*  if(txtDizimo.getText().length() > 0){
       try {
            somarTotalGeral();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }
       }*/
    }//GEN-LAST:event_txtDizimoKeyReleased

    private void txtOfertaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOfertaKeyReleased
       /* try {
          
            somarTotalOfertaRealease();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }*/
                  
       
       /* try {
            somarTotalGeral();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
    }//GEN-LAST:event_txtOfertaKeyReleased

    private void txtValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorKeyReleased
        try {
       
            subtrairTotalGeral();
        } catch (SQLException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Form_Finança.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }//GEN-LAST:event_txtValorKeyReleased

    private void txtNomeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNomeKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtNome.getText());
      txtNome.setText(fMaiuscula);
    }//GEN-LAST:event_txtNomeKeyReleased

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

    private void txtIgrejaContasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIgrejaContasKeyReleased
        // TODO add your handling code here:
        
      String fMaiuscula = StringUtils.capitalize(txtIgrejaContas.getText());
      txtIgrejaContas.setText(fMaiuscula);
      
    }//GEN-LAST:event_txtIgrejaContasKeyReleased

    private void txtSaldoGeralContasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoGeralContasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoGeralContasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing.ButtonGradient btnCancelarC;
    private swing.ButtonGradient btnCancelarF;
    private swing.ButtonGradient btnConfirmar;
    private swing.ButtonGradient btnDeletar;
    private swing.ButtonGradient btnDeletarContas;
    private swing.ButtonGradient btnGuardar;
    private swing.ButtonGradient btnRelatorio;
    private swing.ButtonGradient btnRelatorioContas;
    private combobox.Combobox comboCargo;
    private combobox.Combobox comboContas;
    private combobox.Combobox comboReferencia;
    private combobox.Combobox comboReferenciaContas;
    private textfield.jFormattedTextField jFTelefone1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPesquisar;
    private javax.swing.JLabel jLabelPesquisarContas;
    private javax.swing.JLabel jLabelTotalGeral;
    private javax.swing.JLabel jLabelTotalGeral1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private tabbed.MaterialTabbed materialTabbed1;
    private javax.swing.JPanel panelContaApagar;
    private javax.swing.JPanel panelFinança;
    private javax.swing.JPanel panelListaContas;
    private javax.swing.JPanel panelListaPagamento;
    private JPanelRounder.PanelRound panelRound1;
    private JPanelRounder.PanelRound panelRound2;
    private JPanelRounder.PanelRound panelRound3;
    private JPanelRounder.PanelRound panelRound4;
    private javax.swing.JScrollPane spTable;
    private javax.swing.JScrollPane spTableContas;
    private controle.Table table;
    private controle.Table tableContas;
    private textfield.TextField txtBairro;
    private textfield.TextField txtDizimo;
    private textfield.TextField txtIgreja;
    private textfield.TextField txtIgrejaContas;
    private textfield.TextField txtNome;
    private textfield.TextField txtOferta;
    private controle.SearchText txtProcurar;
    private controle.SearchText txtProcurarContas;
    private textfield.TextField txtSaldoDizimo;
    private textfield.TextField txtSaldoGeral;
    private textfield.TextField txtSaldoGeralContas;
    private textfield.TextField txtSaldoOferta;
    private textfield.TextField txtValor;
    // End of variables declaration//GEN-END:variables
}
