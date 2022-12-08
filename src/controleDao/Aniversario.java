
package controleDao;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelo.AniversarianteBean;
import modelo.MembroBean;


public class Aniversario {
    
  // Comando de Salvar Aniversariante:
 
  public AniversarianteBean Salvar(AniversarianteBean Cad) throws SQLException{
        
        Connection conn = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
        stmt = conn.prepareStatement("insert into  aniversariante (nome, cargo, telefone1, bairro, email, data_de_nasc) values (?,?,?,?,?,?)");
    
        stmt.setString(1, Cad.getNome());
        stmt.setString(2, Cad.getCargo());
        stmt.setString(3, Cad.getTelefone1());
        stmt.setString(4, Cad.getBairro());
        stmt.setString(5, Cad.getEmail());
        stmt.setString(6, Cad.getData_de_nasc());
       
     
        stmt.executeQuery();
        
        JOptionPane.showMessageDialog(null, "Salvo com Sucesso em Aniversariante! ");
        
         } catch (SQLException ex) {
        //JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em totalgeral!/n Erro: !!"+ex.getMessage());
        }
        finally{
        ConnectionFactory.closeConnection(conn, stmt);
        
        }
        return Cad;
        
     } 
    
    //Comando de Listar dados membros para Tabela: 
      
    public List<MembroBean> Cadastro() throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
     
        List<MembroBean> membros = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM membros ORDER BY nomecompleto, genero, data_de_nasc, nacionalidade, naturalde, província, telefone1, telefone2, email, academico, bairro, rua, estadocivil, pai, mae, cabeçafamilia, conjuge, qtdfilho, igreja, cargo, batizado, foto, data ASC");
         rst = stmt.executeQuery();
            
            
            while(rst.next()) {
            
            MembroBean listarj = new MembroBean();
            
            listarj.setNomecompleto(rst.getString("nomecompleto"));
            listarj.setGenero(rst.getString("genero"));
            listarj.setData_de_nasc(rst.getString("data_de_nasc"));
            listarj.setNacionalidade(rst.getString("nacionalidade"));
            listarj.setNaturalde(rst.getString("naturalde"));
            listarj.setProvíncia(rst.getString("província"));
            listarj.setTelefone1(rst.getString("telefone1"));
            listarj.setTelefone2(rst.getString("telefone2"));
            listarj.setEmail(rst.getString("email"));
            listarj.setAcademico(rst.getString("academico"));
            listarj.setBairro(rst.getString("bairro"));
            listarj.setRua(rst.getString("rua"));
            listarj.setEstadocivil(rst.getString("estadocivil"));
            listarj.setPai(rst.getString("pai"));
            listarj.setMae(rst.getString("mae"));
            listarj.setCabeçafamilia(rst.getString("cabeçafamilia"));
            listarj.setConjuge(rst.getString("conjuge"));
            listarj.setQtdfilho(rst.getInt("qtdfilho"));
            listarj.setIgreja(rst.getString("igreja"));
            listarj.setCargo(rst.getString("cargo"));
            listarj.setBatizado(rst.getString("batizado"));
            listarj.setFoto(rst.getBytes("foto"));
            listarj.setData(rst.getString("data"));
            membros.add(listarj);
            
            }
           
            //JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(null, "Erro ao inserir Dados em membros!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  membros;
    }
    
    
    // Comando buscar membros na barra de pesquisa:
    
  public List<MembroBean> buscar(String data) throws SQLException{
        
     Connection conn = ConnectionFactory.getConnection();
     PreparedStatement stmt = null;   
     ResultSet rst = null;  
    
        List<MembroBean> membros = new ArrayList<>();
        try {
         stmt = conn.prepareStatement("SELECT * FROM membros WHERE data_de_nasc  LIKE ? ");
         stmt.setString(1,"%"+data+"%");
         rst = stmt.executeQuery();
            
            while(rst.next()) {
            
            MembroBean formulário = new MembroBean();
            
            formulário.setNomecompleto(rst.getString("nomecompleto"));
            formulário.setGenero(rst.getString("genero"));
            formulário.setData_de_nasc(rst.getString("data_de_nasc"));
            formulário.setNacionalidade(rst.getString("nacionalidade"));
            formulário.setNaturalde(rst.getString("naturalde"));
            formulário.setProvíncia(rst.getString("província"));
            formulário.setTelefone1(rst.getString("telefone1"));
            formulário.setTelefone2(rst.getString("telefone2"));
            formulário.setEmail(rst.getString("email"));
            formulário.setAcademico(rst.getString("academico"));
            formulário.setBairro(rst.getString("bairro"));
            formulário.setRua(rst.getString("rua"));
            formulário.setEstadocivil(rst.getString("estadocivil"));
            formulário.setPai(rst.getString("pai"));
            formulário.setMae(rst.getString("mae"));
            formulário.setCabeçafamilia(rst.getString("cabeçafamilia"));
            formulário.setConjuge(rst.getString("conjuge"));
            formulário.setQtdfilho(rst.getInt("qtdfilho"));
            formulário.setIgreja(rst.getString("igreja"));
            formulário.setCargo(rst.getString("cargo"));
            formulário.setBatizado(rst.getString("batizado"));
            formulário.setFoto(rst.getBytes("foto"));
            formulário.setData(rst.getString("data"));
            membros.add(formulário);
            
            }
           
          //  JOptionPane.showMessageDialog(null, "Dados inseridos com Sucesso!!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao inserir Dados!/n Erro: !!"+ex.getMessage());
        }finally{
        ConnectionFactory.closeConnection(conn, stmt, rst);
        }
        return  membros;
   }   
    
   
}
