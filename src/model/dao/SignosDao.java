package model.dao;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author leandro
 */
public class SignosDao {
    
     public String buscaSigno(String signo){
        
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String result = "";
         try {
                       
            stmt = con.prepareStatement("SELECT significado FROM tb_signo where signo = ?");
            stmt.setString(1, signo);
            rs = stmt.executeQuery();
            
            while(rs.next()){               
                result = rs.getString("significado");
            }        
                                      
        }catch (SQLException exc){            
             JOptionPane.showMessageDialog(null,"Erro na busca de Signo"+ exc);
        }finally{
            connectionFactory.closeConnection(con, stmt, rs);
        }        
        return result;
       
    }
    
    
    
    
}
