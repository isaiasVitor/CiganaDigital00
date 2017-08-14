package model.dao;

import connection.connectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Perguntas;

public class PerguntasDao {
    public void create(){
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("insert into perguntas(Pergunta,alternativaA,valorA,alternativaB,valorB,alternativaC,valorC,alternativaD,valorD) values ('um teste de pergunta, pergunta 2','A alternativa A',3,'B alternativa B',5,'C alternativa C',-6,'D alternativa D',-1);");
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PerguntasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionFactory.closeConnection(con,stmt);
        }
    }
    
    public List<Perguntas> read(){
        Connection con = connectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Perguntas> retorno = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from perguntas");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Perguntas pgnt = new Perguntas();
                pgnt.setId(rs.getInt("id"));
                pgnt.setPergunta(rs.getString("Pergunta"));
                pgnt.setAlternativaA(rs.getString("alternativaA"));
                pgnt.setValorA(rs.getInt("valorA"));
                pgnt.setAlternativaB(rs.getString("alternativaB"));
                pgnt.setValorB(rs.getInt("valorB"));
                pgnt.setAlternativaC(rs.getString("alternativaC"));
                pgnt.setValorC(rs.getInt("valorC"));
                pgnt.setAlternativaD(rs.getString("alternativaD"));
                pgnt.setValorD(rs.getInt("valorD"));
                retorno.add(pgnt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PerguntasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            connectionFactory.closeConnection(con, stmt, rs);
        }
        
        return retorno;
    }
          
}
