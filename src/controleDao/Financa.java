
package controleDao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.FinancaBean;


public class Financa {
 
       //Depósito em Finança: 
    
   public FinancaBean salvarFinanca (FinancaBean boo) throws SQLException{
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            
        stmt = conn.prepareStatement("INSERT INTO financa (nome, igreja, cargo, telefone1, bairro, referencia, dizimo, oferta, moeda, data) values(?,?,?,?,?,?,?,?,?, TO_CHAR(current_date, 'DD-MM-YYYY'))");      
       
        stmt.setString(1, boo.getNome());
        stmt.setString(2, boo.getIgreja());
        stmt.setString(3, boo.getCargo());
        stmt.setString(4, boo.getTelefone1());
        stmt.setString(5, boo.getBairro());
        stmt.setString(6, boo.getReferencia());
        stmt.setInt(7, boo.getDizimo());
        stmt.setInt(8, boo.getOferta());
        stmt.setString(9, boo.getMoeda());
        
        stmt.executeQuery();
        
       // JOptionPane.showMessageDialog(null, "Salvo com Sucesso! ");
        
         } catch (SQLException ex) {
        //JOptionPane.showMessageDialog(null, "Erro ao inserir  o Dados!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        }
        
        return boo;
        
      }
    
   // Listar Finança na Tabela:
   
   public List<FinancaBean> Financiar() throws SQLException{
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;    
     
        List<FinancaBean> financiamento = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM financa ORDER BY nome, igreja, cargo, telefone1, bairro, referencia, dizimo, oferta, moeda, data ASC");
         
         rst = stmt.executeQuery();
            
            while(rst.next()) {
            
            FinancaBean crj = new FinancaBean();
            
            crj.setNome(rst.getString("nome"));
            crj.setIgreja(rst.getString("igreja"));
            crj.setCargo(rst.getString("cargo"));
            crj.setTelefone1(rst.getString("telefone1"));
            crj.setBairro(rst.getString("bairro"));
            crj.setReferencia(rst.getString("referencia"));
            crj.setDizimo(rst.getInt("dizimo"));
            crj.setOferta(rst.getInt("oferta"));
            crj.setMoeda(rst.getString("moeda"));
            crj.setData(rst.getString("data"));
            
            financiamento.add(crj);
            
            }
           
       // JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso no Booster!!");
            
        } catch (SQLException ex) {
       // JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
    
        return  financiamento;
     }  
   
     // Comando buscar finança na barra de pesquisa:
    
  public List<FinancaBean> buscar(String nome) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
    
        List<FinancaBean> buscaFinanca = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM financa WHERE nome LIKE ? ");
         stmt.setString(1,"%"+nome+"%");
         rst = stmt.executeQuery();
            
            while(rst.next()) {
                
            FinancaBean formulário = new FinancaBean();
            
            formulário.setNome(rst.getString("nome"));
            formulário.setIgreja(rst.getString("igreja"));
            formulário.setCargo(rst.getString("cargo"));
            formulário.setTelefone1(rst.getString("telefone1"));
            formulário.setBairro(rst.getString("bairro"));
            formulário.setReferencia(rst.getString("referencia"));
            formulário.setDizimo(rst.getInt("dizimo"));
            formulário.setOferta(rst.getInt("oferta"));
            formulário.setMoeda(rst.getString("moeda"));
            formulário.setData(rst.getString("data"));
     
            buscaFinanca.add(formulário);
            
            }
           
          //  JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  buscaFinanca;
      }

   
      //Comando de Deletar da Tabela Finança:
    
      public void delete(FinancaBean dlb) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     
        try {
         stmt = conn.prepareStatement("DELETE FROM financa where nome = ? ");
          
        stmt.setString(1, dlb.getNome());
          
         stmt.execute(); 
          
           
       // JOptionPane.showMessageDialog(null, "Deletado com Sucesso!!");
            
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao excluír !"+ ex);
        }finally{
        ConnectionFactory.closeConnection(conn, stmt);
        }
        }    
     
}
