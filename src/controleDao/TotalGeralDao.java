
package controleDao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.TotalGeralBean;


public class TotalGeralDao {
    
    
  // Comando de Salvar TotalGeral:
 
  public TotalGeralBean Salvar(TotalGeralBean Cad) throws SQLException{
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("insert into  totalgeral (geral) values (?)");
    
        stmt.setString(1, Cad.getGeral());
       
     
        stmt.executeQuery();
        
        JOptionPane.showMessageDialog(null, "Salvo com Sucesso em totalgeral! ");
        
         } catch (SQLException ex) {
        //JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em totalgeral!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return Cad;
        
     }     
    
      
     public TotalGeralBean Atualizar(TotalGeralBean at) throws SQLException{
        
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("UPDATE totalgeral SET gerall = ? ");
        
        stmt.setString(1, at.getGeral());
        //stmt.setInt(2, at.getId());
   
        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Atualizado com Sucesso em totalgeral! ");
        
         } catch (SQLException ex) {
        //JOptionPane.showMessageDialog(null, "Erro ao atualizar totalgeral!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return at;
        
     } 
}
