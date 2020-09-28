package spring.user.domain;

import com.mysql.cj.protocol.Resultset;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public void add(final User user) throws SQLException {
        this.jdbcTemplate.update("INSERT INTO users (id,name,password) VALUES (?,?,?)",user.getId(),user.getName(),user.getPassword());
    }

    public User get(String id) throws SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE id=?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        User user = null;
        if(rs.next()) {
            user = new User();
            user.setId(rs.getString(1));
            user.setName(rs.getString(2));
            user.setPassword(rs.getString(3));
        }

        ps.close();
        rs.close();
        c.close();

        if(user ==null) {
            throw new EmptyResultDataAccessException(1);
        }
        return user;
    }

    public int count() throws SQLException {
        return this.jdbcTemplate.query("SELECT COUNT(*) FROM users",
                rs -> {
            rs.next();
            return rs.getInt(1);
        });
    }

    public void delete() throws SQLException {
        this.jdbcTemplate.update("DELETE FROM users");
    }
}
