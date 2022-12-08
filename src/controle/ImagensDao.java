
package controle;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.MembroBean;
import modelo.VisitanteBean;

public class ImagensDao {
    
  
    public MembroBean buscarFoto(String foto) throws SQLException
    {
        
        Connection conn = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null; 
        MembroBean retorno = null;
        
        String sql = "SELECT nomecompleto,foto from membros where nomecompleto = ? ";
        stmt = conn.prepareStatement(sql);
        
        try {
            stmt.setString(1, foto);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                retorno = new MembroBean();
                
                retorno.setNomecompleto(rs.getString("nomecompleto"));
                retorno.setFoto(rs.getBytes("foto"));
            
            }
            
        } catch (SQLException e) {
            retorno = null;
        }
     
        return retorno;
    }
    
    public VisitanteBean buscarFotoVisitante(String foto) throws SQLException
    {
        
        Connection conn = ConnectionFactory.getConnection(); 
        PreparedStatement stmt = null; 
        VisitanteBean retorno = null;
        
        String sql = "SELECT nomecompleto,foto from visitante where nomecompleto = ? ";
        stmt = conn.prepareStatement(sql);
        
        try {
            stmt.setString(1, foto);
            ResultSet rs = stmt.executeQuery();
            if(rs.next())
            {
                retorno = new VisitanteBean();
                
                retorno.setNomecompleto(rs.getString("nomecompleto"));
                retorno.setFoto(rs.getBytes("foto"));
            
            }
            
        } catch (SQLException e) {
            retorno = null;
        }
     
        return retorno;
    }
}
