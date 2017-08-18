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
public class SignificadoNomeDao {
    
    public String buscaNome(String nome){
        
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String result = "";
         try {
                       
            stmt = con.prepareStatement("SELECT significado FROM tb_nomes where nome = ?");
            stmt.setString(1, nome);
            rs = stmt.executeQuery();
            while(rs.next()){               
                result = rs.getString("significado");
            }        
                                      
        }catch (SQLException exc){            
             JOptionPane.showMessageDialog(null,"NOME NAO EXISTE"+ exc);
        }finally{
            connectionFactory.closeConnection(con, stmt, rs);
        }        
        return result;
       
    }
    
    
    
    
}
