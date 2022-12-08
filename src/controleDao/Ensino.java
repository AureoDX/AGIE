
package controleDao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.EnsinoBean;
import modelo.GrupoBean;


public class Ensino {
    
    // Comando de Salvar os membros:
 
  public EnsinoBean Salvar(EnsinoBean Cad) throws SQLException{
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("INSERT INTO ensino (classe, nome, bairro, email, membro, licao, telefone1, data) values(?,?,?,?,?,?,?, TO_CHAR(current_date, 'DD-MM-YYYY'))");
        stmt.setString(1, Cad.getClasse());
        stmt.setString(2, Cad.getNome());
        stmt.setString(3, Cad.getBairro());
        stmt.setString(4, Cad.getEmail());
        stmt.setString(5, Cad.getMembro());
        stmt.setString(6, Cad.getLicao());
        stmt.setString(7, Cad.getTelefone1());
        //stmt.setBytes(8, Cad.getFoto());
        stmt.executeQuery();
        
        //JOptionPane.showMessageDialog(null, "Salvo com Sucesso em ensino! ");
        
         } catch (SQLException ex) {
       // JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em ensino!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return Cad;
        
     }   
    
    //Comando de Listar dados membros para Tabela: 
      
    public List<EnsinoBean> Cadastro() throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
     
        List<EnsinoBean> membro = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM ensino ORDER BY id, classe, nome, bairro, email, membro, licao, telefone1, data ASC");
         rst = stmt.executeQuery();
            
            
            while(rst.next()) {
            
            EnsinoBean listarj = new EnsinoBean();
            
            listarj.setId(rst.getInt("id"));
            listarj.setClasse(rst.getString("classe"));
            listarj.setNome(rst.getString("nome"));
            listarj.setBairro(rst.getString("bairro"));
            listarj.setEmail(rst.getString("email"));
            listarj.setMembro(rst.getString("membro"));
            listarj.setLicao(rst.getString("licao"));
            listarj.setTelefone1(rst.getString("telefone1"));
            listarj.setData(rst.getString("data"));
            membro.add(listarj);
            
            }
           
            //JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
        // JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em ensino!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  membro;
    }
    
    
    // Comando buscar membros na barra de pesquisa:
    
  public List<EnsinoBean> buscar(String classe) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
    
        List<EnsinoBean> ensino = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM ensino WHERE classe LIKE ? ");
         stmt.setString(1,"%"+classe+"%");
         rst = stmt.executeQuery();
            
            while(rst.next()) {
                
            EnsinoBean formulário = new EnsinoBean();
            
            formulário.setId(rst.getInt("id"));
            formulário.setClasse(rst.getString("classe"));
            formulário.setNome(rst.getString("nome"));
            formulário.setBairro(rst.getString("bairro"));
            formulário.setEmail(rst.getString("email"));
            formulário.setMembro(rst.getString("membro"));
            formulário.setLicao(rst.getString("licao"));
            formulário.setTelefone1(rst.getString("telefone1"));
            formulário.setData(rst.getString("data"));
            ensino.add(formulário);
            
            }
           
          //  JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  ensino;
   }
  
  
  //Comando de Deletar os membros da Tabela de Pesquisa:
    
      public void delete(EnsinoBean Cad) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     
        try {
         stmt = conn.prepareStatement("DELETE FROM ensino WHERE  id = ?");
          
            
            stmt.setInt(1, Cad.getId());
         
            stmt.execute(); 
          
           
         //JOptionPane.showMessageDialog(null, "Excluído com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluír !"+ ex);
        }finally{
        ConnectionFactory.closeConnection(conn, stmt);
        }
        }
      
       public EnsinoBean AtualizarEnsino(EnsinoBean at) throws SQLException{
        
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("UPDATE ensino SET classe = ?, nome = ?, bairro = ?, email = ?, licao = ?, telefone1 = ? WHERE id = ? ");
        stmt.setString(1, at.getClasse());
        stmt.setString(2, at.getNome());
        stmt.setString(3, at.getBairro());
        stmt.setString(4, at.getEmail());
        stmt.setString(5, at.getLicao());  
        stmt.setString(6, at.getTelefone1());   
        stmt.setInt(7, at.getId());
       
        stmt.executeUpdate();
        
       // JOptionPane.showMessageDialog(null, "Dados Atualizado com Sucesso em Ensino! ");
        
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados em Ensino!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return at;
        
     }   
    
}
