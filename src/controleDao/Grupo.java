
package controleDao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AgendaBean;
import modelo.GrupoBean;

public class Grupo {
 
// Comando de Salvar os membros:
 
  public GrupoBean Salvar(GrupoBean Cad) throws SQLException{
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("INSERT INTO grupo (nomegrupo, igreja, bairro, frequencia, inicio, horario, nome, telefone1, membro, data) values(?,?,?,?,?,?,?,?,?, TO_CHAR(current_date, 'DD-MM-YYYY'))");
        stmt.setString(1, Cad.getNomegrupo());
        stmt.setString(2, Cad.getIgreja());
        stmt.setString(3, Cad.getBairro());
        stmt.setString(4, Cad.getFrequencia());
        stmt.setString(5, Cad.getInicio());
        stmt.setString(6, Cad.getHorario());
        stmt.setString(7, Cad.getNome());
        stmt.setString(8, Cad.getTelefone1());
        stmt.setString(9, Cad.getMembro());
        stmt.executeQuery();
        
        //JOptionPane.showMessageDialog(null, "Salvo com Sucesso em grupo! ");
        
         } catch (SQLException ex) {
       // JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em grupo!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return Cad;
        
     }   
    
    //Comando de Listar dados membros para Tabela: 
      
    public List<GrupoBean> Cadastro() throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
     
        List<GrupoBean> membro = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM grupo ORDER BY id, nomegrupo, igreja, bairro, frequencia, inicio, horario, nome, telefone1, membro, data ASC");
         rst = stmt.executeQuery();
            
            
            while(rst.next()) {
            
            GrupoBean listarj = new GrupoBean();
            
            listarj.setId(rst.getInt("id"));
            listarj.setNomegrupo(rst.getString("nomegrupo"));
            listarj.setIgreja(rst.getString("igreja"));
            listarj.setBairro(rst.getString("bairro"));
            listarj.setFrequencia(rst.getString("frequencia"));
            listarj.setInicio(rst.getString("inicio"));
            listarj.setHorario(rst.getString("horario"));
            listarj.setNome(rst.getString("nome"));
            listarj.setTelefone1(rst.getString("telefone1"));     
            listarj.setMembro(rst.getString("membro"));     
            listarj.setData(rst.getString("data"));
            membro.add(listarj);
            
            }
           
            //JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
        // JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em Grupo!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  membro;
    }
    
    
    // Comando buscar nomegrupo na barra de pesquisa:
    
  public List<GrupoBean> buscar(String nomegrupo) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
    
        List<GrupoBean> membro = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM grupo WHERE nomegrupo LIKE ? ");
         stmt.setString(1,"%"+nomegrupo+"%");
         rst = stmt.executeQuery();
            
            while(rst.next()) {
                
            GrupoBean formulário = new GrupoBean();
            
            formulário.setId(rst.getInt("id"));
            formulário.setNomegrupo(rst.getString("nomegrupo"));
            formulário.setIgreja(rst.getString("igreja"));
            formulário.setBairro(rst.getString("bairro"));
            formulário.setFrequencia(rst.getString("frequencia"));
            formulário.setInicio(rst.getString("inicio"));
            formulário.setHorario(rst.getString("horario"));
            formulário.setNome(rst.getString("nome"));
            formulário.setTelefone1(rst.getString("telefone1"));
            formulário.setMembro(rst.getString("membro"));
            formulário.setData(rst.getString("data"));
            membro.add(formulário);
            
            }
           
          //  JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
           //JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  membro;
   }
  
  
  //Comando de Deletar os membros da Tabela de Pesquisa:
    
      public void delete(GrupoBean Cad) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     
        try {
         stmt = conn.prepareStatement("DELETE FROM grupo WHERE  id = ?");
          
            
            stmt.setInt(1, Cad.getId());
         
            stmt.execute(); 
          
           
         //JOptionPane.showMessageDialog(null, "Excluído com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluír !"+ ex);
        }finally{
        ConnectionFactory.closeConnection(conn, stmt);
        }
        }
      
      
     public GrupoBean AtualizarGrupo(GrupoBean at) throws SQLException{
        
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("UPDATE grupo SET nomegrupo = ?, igreja = ?, bairro = ?, inicio = ?, horario = ?, nome = ?, telefone1 = ? WHERE id = ? ");
        stmt.setString(1, at.getNomegrupo());
        stmt.setString(2, at.getIgreja());
        stmt.setString(3, at.getBairro());
        stmt.setString(4, at.getInicio());
        stmt.setString(5, at.getHorario());  
        stmt.setString(6, at.getNome());  
        stmt.setString(7, at.getTelefone1());  
        stmt.setInt(8, at.getId());
       
        stmt.executeUpdate();
        
        //JOptionPane.showMessageDialog(null, "Dados Atualizado com Sucesso em Grupo! ");
        
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados em Grupo!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return at;
        
     }   
         
}
