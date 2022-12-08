
package controleDao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.ContasBean;


public class Contas {
  
       //Depósito em Contas: 
    
   public ContasBean salvarContas (ContasBean boo) throws SQLException{
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            
        stmt = conn.prepareStatement("INSERT INTO contas (igreja, conta, referencia, valor, moeda, data) values(?,?,?,?,?, TO_CHAR(current_date, 'DD-MM-YYYY'))");      
       
        stmt.setString(1, boo.getIgreja());
        stmt.setString(2, boo.getConta());
        stmt.setString(3, boo.getReferencia());
        stmt.setInt(4, boo.getValor());
        stmt.setString(5, boo.getMoeda());
        
        stmt.executeQuery();
        
       // JOptionPane.showMessageDialog(null, "Salvo com Sucesso! ");
        
         } catch (SQLException ex) {
       // JOptionPane.showMessageDialog(null, "Erro ao inserir  o Dados!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        }
        
        return boo;
        
      }
    
   // Listar Contas na Tabela:
   
   public List<ContasBean> listarContas() throws SQLException{
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;    
     
        List<ContasBean> listaC = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM contas ORDER BY igreja, conta, referencia, valor, moeda, data ASC");
         
         rst = stmt.executeQuery();
            
            while(rst.next()) {
            
            ContasBean crj = new ContasBean();
            
            crj.setIgreja(rst.getString("igreja"));
            crj.setConta(rst.getString("conta"));
            crj.setReferencia(rst.getString("referencia"));
            crj.setValor(rst.getInt("valor"));
            crj.setMoeda(rst.getString("moeda"));
            crj.setData(rst.getString("data"));
            
            listaC.add(crj);
            
            }
           
       // JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso no Booster!!");
            
        } catch (SQLException ex) {
       // JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
    
        return  listaC;
     }  
   
     // Comando buscar contas na barra de pesquisa:
    
  public List<ContasBean> buscar(String conta) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
    
        List<ContasBean> buscaContas = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM contas WHERE conta LIKE ? ");
         stmt.setString(1,"%"+conta+"%");
         rst = stmt.executeQuery();
            
            while(rst.next()) {
                
            ContasBean formulário = new ContasBean();
                   
            formulário.setIgreja(rst.getString("igreja"));
            formulário.setConta(rst.getString("conta"));
            formulário.setReferencia(rst.getString("referencia"));
            formulário.setValor(rst.getInt("valor"));
            formulário.setMoeda(rst.getString("moeda"));
            formulário.setData(rst.getString("data"));
     
            buscaContas.add(formulário);
            
            }
           
          //  JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  buscaContas;
      }
   
      //Comando de Deletar da Tabela Contas:
    
      public void delete(ContasBean dlb) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     
        try {
         stmt = conn.prepareStatement("DELETE FROM contas where igreja= ? ");
          
        stmt.setString(1, dlb.getIgreja());
          
         stmt.execute(); 
          
           
       // JOptionPane.showMessageDialog(null, "Deletado com Sucesso!!");
            
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao excluír !"+ ex);
        }finally{
        ConnectionFactory.closeConnection(conn, stmt);
        }
        } 
}
