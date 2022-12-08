
package conexao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnectionFactory {
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://localhost:5432/AGIE";
    private static final String USER = "postgres";
    private static final String PASS = "123";
    public static Connection getConnection;
    
    public static Connection getConnection() throws SQLException  {   
        
        try {
            Class.forName(DRIVER);
           
            return DriverManager.getConnection(URL, USER, PASS);
          
        } catch (ClassNotFoundException ex) {
         throw new RuntimeException("Erro na Conexão: ",ex);
        }
    }
    
    public static void closeConnection(Connection conn){
     
            try {
        if(conn != null){
             conn.close();
            } }
            
        catch (SQLException ex) {
          Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            
            
      }  
    
    public static void closeConnection(Connection conn, PreparedStatement stmt){
     
        
        closeConnection(conn);
        
            try {
        if(stmt != null){
             stmt.close();
            }   

         }catch (SQLException ex) {
          Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            
               
      }  
}
    public static void closeConnection(Connection conn, PreparedStatement stmt, ResultSet rst){
     
        
        closeConnection(conn,stmt);
        
            try {
        if(rst != null){
             rst.close();
            }   

         }catch (SQLException ex) {
          Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            
               
      }  
}
    }