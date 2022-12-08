
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
import modelo.AtaBean;


public class Agenda {
   
     // Comando de Salvar os membros:
 
  public AgendaBean Salvar(AgendaBean Cad) throws SQLException{
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("INSERT INTO agenda (igreja, evento, horario, nome, membro, telefone1, data) values(?,?,?,?,?,?, TO_CHAR(current_date, 'DD-MM-YYYY'))");
        stmt.setString(1, Cad.getIgreja());
        stmt.setString(2, Cad.getEvento());
        stmt.setString(3, Cad.getHorario());
        stmt.setString(4, Cad.getNome());
        stmt.setString(5, Cad.getMembro());
        stmt.setString(6, Cad.getTelefone1());
        stmt.executeQuery();
        
        //JOptionPane.showMessageDialog(null, "Salvo com Sucesso em ensino! ");
        
         } catch (SQLException ex) {
        //JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em agenda!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return Cad;
        
     }   
    
    //Comando de Listar dados Agenda para Tabela: 
      
    public List<AgendaBean> Cadastro() throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
     
        List<AgendaBean> agenda = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM agenda ORDER BY id, igreja, evento, horario, nome, membro, telefone1, data ASC");
         rst = stmt.executeQuery();
            
            
            while(rst.next()) {
            
            AgendaBean listarj = new AgendaBean();
            
            listarj.setId(rst.getInt("id"));
            listarj.setIgreja(rst.getString("igreja"));
            listarj.setEvento(rst.getString("evento"));
            listarj.setHorario(rst.getString("horario"));
            listarj.setNome(rst.getString("nome"));
            listarj.setMembro(rst.getString("membro"));
            listarj.setTelefone1(rst.getString("telefone1"));
            listarj.setData(rst.getString("data"));
            agenda.add(listarj);
            
            }
           
            //JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
        // JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em agenda!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  agenda;
    }
    
    
    // Comando buscar membros na barra de pesquisa:
    
  public List<AgendaBean> buscar(String igreja) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
    
        List<AgendaBean> agendamento = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM agenda WHERE igreja LIKE ? ");
         stmt.setString(1,"%"+igreja+"%");
         rst = stmt.executeQuery();
            
            while(rst.next()) {
                
            AgendaBean formulário = new AgendaBean();
            
            formulário.setId(rst.getInt("id"));
            formulário.setIgreja(rst.getString("igreja"));
            formulário.setEvento(rst.getString("evento"));
            formulário.setHorario(rst.getString("horario"));
            formulário.setNome(rst.getString("nome"));
            formulário.setMembro(rst.getString("membro"));
            formulário.setTelefone1(rst.getString("telefone1"));
            formulário.setData(rst.getString("data"));
            agendamento.add(formulário);
            
            }
           
          //  JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  agendamento;
   }
  
  
  //Comando de Deletar os membros da Tabela de Pesquisa:
    
      public void delete(AgendaBean Cad) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     
        try {
         stmt = conn.prepareStatement("DELETE FROM agenda WHERE  id = ?");
          
            
            stmt.setInt(1, Cad.getId());
         
            stmt.execute(); 
          
           
         //JOptionPane.showMessageDialog(null, "Excluído com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluír !"+ ex);
        }finally{
        ConnectionFactory.closeConnection(conn, stmt);
        }
        }
      
      
       public AgendaBean AtualizarAgenda(AgendaBean at) throws SQLException{
        
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("UPDATE agenda SET igreja = ?, evento = ?, horario = ?, nome = ?, telefone1 = ? WHERE id = ? ");
        stmt.setString(1, at.getIgreja());
        stmt.setString(2, at.getEvento());
        stmt.setString(3, at.getHorario());
        stmt.setString(4, at.getNome());
       // stmt.setString(5, at.getMembro());
        stmt.setString(5, at.getTelefone1());  
        stmt.setInt(6, at.getId());
       
        stmt.executeUpdate();
        
       // JOptionPane.showMessageDialog(null, "Dados Atualizado com Sucesso em Agenda! ");
        
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados em Agenda!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return at;
        
     }
}
