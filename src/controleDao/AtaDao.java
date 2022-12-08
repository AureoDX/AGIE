
package controleDao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AtaBean;
import modelo.GrupoBean;


public class AtaDao {
    
  // Comando de Salvar em Ata:
 
  public AtaBean Salvar(AtaBean Cad) throws SQLException{
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("INSERT INTO ata (datta, horario, locall, objectivo, nome, cargo, assunto, decisao, observacao) values(?,?,?,?,?,?,?,?,?)");
        stmt.setString(1, Cad.getDatta());
        stmt.setString(2, Cad.getHorario());
        stmt.setString(3, Cad.getLocall());
        stmt.setString(4, Cad.getObjectivo());
        stmt.setString(5, Cad.getNome());
        stmt.setString(6, Cad.getCargo());
        stmt.setString(7, Cad.getAssunto());
        stmt.setString(8, Cad.getDecisao());
        stmt.setString(9, Cad.getObservação());
        stmt.executeQuery();
        
        //JOptionPane.showMessageDialog(null, "Salvo com Sucesso em Ata! ");
        
         } catch (SQLException ex) {
        //JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em Ata!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return Cad;
        
     }   
    
    //Comando de Listar dados Ata para Tabela: 
      
    public List<AtaBean> Cadastro() throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
     
        List<AtaBean> ata = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM ata ORDER BY id, datta, horario, locall, objectivo, nome, cargo, assunto, decisao, observacao ASC");
         rst = stmt.executeQuery();
            
            
            while(rst.next()) {
            
            AtaBean listarj = new AtaBean();
            
            listarj.setId(rst.getInt("id"));
            listarj.setDatta(rst.getString("datta"));
            listarj.setHorario(rst.getString("horario"));
            listarj.setLocall(rst.getString("locall"));
            listarj.setObjectivo(rst.getString("objectivo"));
            listarj.setNome(rst.getString("nome"));
            listarj.setCargo(rst.getString("cargo"));
            listarj.setAssunto(rst.getString("assunto"));
            listarj.setDecisao(rst.getString("decisao"));     
            listarj.setObservação(rst.getString("observacao"));     
            ata.add(listarj);
            
            }
           
            //JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em Ata!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  ata;
    }
    
    
    // Comando buscar nomegrupo na barra de pesquisa:
    
  public List<AtaBean> buscar(String datta) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
    
        List<AtaBean> ata = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM ata WHERE datta LIKE ? ");
         stmt.setString(1,"%"+datta+"%");
         rst = stmt.executeQuery();
            
            while(rst.next()) {
                
            AtaBean formulário = new AtaBean();
            
            formulário.setId(rst.getInt("id"));
            formulário.setDatta(rst.getString("datta"));
            formulário.setHorario(rst.getString("horario"));
            formulário.setLocall(rst.getString("locall"));
            formulário.setObjectivo(rst.getString("objectivo"));
            formulário.setNome(rst.getString("nome"));
            formulário.setCargo(rst.getString("cargo"));
            formulário.setAssunto(rst.getString("assunto"));
            formulário.setDecisao(rst.getString("decisao"));
            formulário.setObservação(rst.getString("observacao"));
            
            ata.add(formulário);
            
            }
           
          //  JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  ata;
   }
    
  //Comando de Deletar a Ata da Tabela de Pesquisa:
    
      public void delete(AtaBean Cad) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     
        try {
         stmt = conn.prepareStatement("DELETE FROM ata WHERE  id = ?");
          
            
            stmt.setInt(1, Cad.getId());
         
            stmt.execute(); 
          
           
         //JOptionPane.showMessageDialog(null, "Excluído com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluír !"+ ex);
        }finally{
        ConnectionFactory.closeConnection(conn, stmt);
        }
        }
      
      
       public AtaBean AtualizarAta(AtaBean at) throws SQLException{
        
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("UPDATE ata SET datta = ?, horario = ?, locall = ?, objectivo = ?, nome = ?, cargo = ?, assunto = ?, decisao = ?, observacao = ? WHERE id = ? ");
        stmt.setString(1, at.getDatta());
        stmt.setString(2, at.getHorario());
        stmt.setString(3, at.getLocall());
        stmt.setString(4, at.getObjectivo());
        stmt.setString(5, at.getNome());
        stmt.setString(6, at.getCargo());
        stmt.setString(7, at.getAssunto());
        stmt.setString(8, at.getDecisao());
        stmt.setString(9, at.getObservação());
        stmt.setInt(10, at.getId());
       
        stmt.executeUpdate();
        
      //  JOptionPane.showMessageDialog(null, "Dados Atualizado com Sucesso em Ata! ");
        
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados em Ata!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return at;
        
     } 
}
