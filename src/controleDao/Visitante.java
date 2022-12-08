
package controleDao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.MembroBean;
import modelo.VisitanteBean;


public class Visitante {
 
 // Comando de Salvar os membros:
 
  public VisitanteBean Salvar(VisitanteBean Cad) throws SQLException{
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("INSERT INTO visitante (nomecompleto, genero, data_de_nasc, nacionalidade, naturalde, província, telefone1, telefone2, email, profissao, bairro, rua, estadocivil, pai, mae, cabeçafamilia, conjuge, qtdfilho, igreja, conheceuigreja, foto, data) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, TO_CHAR(current_date, 'DD-MM-YYYY'))");
        stmt.setString(1, Cad.getNomecompleto());
        stmt.setString(2, Cad.getGenero());
        stmt.setString(3, Cad.getData_de_nasc());
        stmt.setString(4, Cad.getNacionalidade());
        stmt.setString(5, Cad.getNaturalde());
        stmt.setString(6, Cad.getProvíncia());
        stmt.setString(7, Cad.getTelefone1());
        stmt.setString(8, Cad.getTelefone2());
        stmt.setString(9, Cad.getEmail());
        stmt.setString(10, Cad.getProfissao());
        stmt.setString(11, Cad.getBairro());
        stmt.setString(12, Cad.getRua());
        stmt.setString(13, Cad.getEstadocivil());
        stmt.setString(14, Cad.getPai());
        stmt.setString(15, Cad.getMae());
        stmt.setString(16, Cad.getCabeçafamilia());
        stmt.setString(17, Cad.getConjuge());
        stmt.setInt(18, Cad.getQtdfilho());
        stmt.setString(19, Cad.getIgreja());
        stmt.setString(20, Cad.getConheceuigreja());
        stmt.setBytes(21, Cad.getFoto());
        stmt.executeQuery();
        
        //JOptionPane.showMessageDialog(null, "Salvo com Sucesso em visitante! ");
        
         } catch (SQLException ex) {
        //JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em visitante!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return Cad;
        
     }   
    
    //Comando de Listar dados visitantes para Tabela: 
      
    public List<VisitanteBean> CadastroV() throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
     
        List<VisitanteBean> visitante = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM visitante ORDER BY id, nomecompleto, genero, data_de_nasc, nacionalidade, naturalde, província, telefone1, telefone2, email, profissao, bairro, rua, estadocivil, pai, mae, cabeçafamilia, conjuge, qtdfilho, igreja, conheceuigreja, foto, data ASC");
         rst = stmt.executeQuery();
            
            
            while(rst.next()) {
            
            VisitanteBean listarj = new VisitanteBean();
            
            listarj.setId(rst.getInt("id"));
            listarj.setNomecompleto(rst.getString("nomecompleto"));
            listarj.setGenero(rst.getString("genero"));
            listarj.setData_de_nasc(rst.getString("data_de_nasc"));
            listarj.setNacionalidade(rst.getString("nacionalidade"));
            listarj.setNaturalde(rst.getString("naturalde"));
            listarj.setProvíncia(rst.getString("província"));
            listarj.setTelefone1(rst.getString("telefone1"));
            listarj.setTelefone2(rst.getString("telefone2"));
            listarj.setEmail(rst.getString("email"));
            listarj.setProfissao(rst.getString("profissao"));
            listarj.setBairro(rst.getString("bairro"));
            listarj.setRua(rst.getString("rua"));
            listarj.setEstadocivil(rst.getString("estadocivil"));
            listarj.setPai(rst.getString("pai"));
            listarj.setMae(rst.getString("mae"));
            listarj.setCabeçafamilia(rst.getString("cabeçafamilia"));
            listarj.setConjuge(rst.getString("conjuge"));
            listarj.setQtdfilho(rst.getInt("qtdfilho"));
            listarj.setIgreja(rst.getString("igreja"));
            listarj.setConheceuigreja(rst.getString("conheceuigreja"));
            listarj.setFoto(rst.getBytes("foto"));
            listarj.setData(rst.getString("data"));
            visitante.add(listarj);
            
            }
           
            //JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em visitante!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  visitante;
    }
    
    
    // Comando buscar jogadores na barra de pesquisa:
    
  public List<VisitanteBean> buscar(String nomecompleto) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
    
        List<VisitanteBean> visitante = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM visitante WHERE nomecompleto LIKE ? ");
         stmt.setString(1,"%"+nomecompleto+"%");
         rst = stmt.executeQuery();
            
            while(rst.next()) {
                
            VisitanteBean formulário = new VisitanteBean();
            
            formulário.setId(rst.getInt("id"));
            formulário.setNomecompleto(rst.getString("nomecompleto"));
            formulário.setGenero(rst.getString("genero"));
            formulário.setData_de_nasc(rst.getString("data_de_nasc"));
            formulário.setNacionalidade(rst.getString("nacionalidade"));
            formulário.setNaturalde(rst.getString("naturalde"));
            formulário.setProvíncia(rst.getString("província"));
            formulário.setTelefone1(rst.getString("telefone1"));
            formulário.setTelefone2(rst.getString("telefone2"));
            formulário.setEmail(rst.getString("email"));
            formulário.setProfissao(rst.getString("profissao"));
            formulário.setBairro(rst.getString("bairro"));
            formulário.setRua(rst.getString("rua"));
            formulário.setEstadocivil(rst.getString("estadocivil"));
            formulário.setPai(rst.getString("pai"));
            formulário.setMae(rst.getString("mae"));
            formulário.setCabeçafamilia(rst.getString("cabeçafamilia"));
            formulário.setConjuge(rst.getString("conjuge"));
            formulário.setQtdfilho(rst.getInt("qtdfilho"));
            formulário.setIgreja(rst.getString("igreja"));
            formulário.setConheceuigreja(rst.getString("conheceuigreja"));
            formulário.setFoto(rst.getBytes("foto"));
            formulário.setData(rst.getString("data"));
            visitante.add(formulário);
            
            }
           
          //  JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  visitante;
   }
  
  
  //Comando de Deletar os membros da Tabela de Pesquisa:
    
      public void deleteVisitante(VisitanteBean Cad) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     
        try {
         stmt = conn.prepareStatement("DELETE FROM visitante WHERE  nomecompleto = ?");
          
            
            stmt.setString(1, Cad.getNomecompleto());
         
            stmt.execute(); 
          
           
         //JOptionPane.showMessageDialog(null, "Excluído com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao excluír !"+ ex);
        }finally{
        ConnectionFactory.closeConnection(conn, stmt);
        }
        }
      
      
     public VisitanteBean Atualizar(VisitanteBean at) throws SQLException{
        
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("UPDATE visitante SET foto = ? WHERE nomecompleto = ? ");
        
        stmt.setBytes(1, at.getFoto());
        stmt.setString(2, at.getNomecompleto());
   
        stmt.executeQuery();
        
        //JOptionPane.showMessageDialog(null, "Foto salva com Sucesso em visitante! ");
        
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar foto em visitante!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return at;
        
     }    
    
      public VisitanteBean AtualizarVisitante(VisitanteBean at) throws SQLException{
        
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("UPDATE visitante SET nomecompleto = ?, data_de_nasc = ?, nacionalidade = ?, naturalde = ?, província = ?, telefone1 = ?, telefone2 = ?, email = ?, profissao = ?, bairro = ?, rua = ?, pai = ?, mae = ?, conjuge = ?, igreja = ?, conheceuigreja = ? WHERE id = ? ");
        stmt.setString(1, at.getNomecompleto());
        //stmt.setString(2, at.getGenero());
        stmt.setString(2, at.getData_de_nasc());
        stmt.setString(3, at.getNacionalidade());
        stmt.setString(4, at.getNaturalde());
        stmt.setString(5, at.getProvíncia());
        stmt.setString(6, at.getTelefone1());
        stmt.setString(7, at.getTelefone2());
        stmt.setString(8, at.getEmail());
        stmt.setString(9, at.getProfissao());
        stmt.setString(10, at.getBairro());
        stmt.setString(11, at.getRua());
        //stmt.setString(13, at.getEstadocivil());
        stmt.setString(12, at.getPai());
        stmt.setString(13, at.getMae());
        //stmt.setString(16, at.getCabeçafamilia());
        stmt.setString(14, at.getConjuge());
        //stmt.setInt(14, at.getQtdfilho());
        stmt.setString(15, at.getIgreja());
        stmt.setString(16, at.getConheceuigreja());
       // stmt.setString(3, at.getBatizado());    
        stmt.setInt(17, at.getId());     
        
        stmt.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Dados salvo com Sucesso em Visitante! ");
        
         } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao atualizar dados em Visitante!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return at;
        
     }
    
}
