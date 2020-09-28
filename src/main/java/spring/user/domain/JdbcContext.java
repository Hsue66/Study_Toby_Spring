package spring.user.domain;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcContext {
    DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        try{
            c = dataSource.getConnection();
            ps = stmt.makePrepareStatement(c);
            ps.executeUpdate();

        }catch(SQLException ex){
            throw ex;
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                }
                catch(SQLException ex){}
            }
            if(c!=null){
                try {
                    ps.close();
                }
                catch(SQLException ex){}
            }
        }
    }
}
