package spring.user.domain;

import com.mysql.cj.protocol.Resultset;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class UserDao {
    JdbcTemplate jdbcTemplate;

    RowMapper<User> userMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int i) throws SQLException {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    };

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(final User user) {
        this.jdbcTemplate.update("INSERT INTO users (id,name,password) VALUES (?,?,?)",user.getId(),user.getName(),user.getPassword());
    }

    public User get(String id) {
        return this.jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?",
                new Object[]{id}, this.userMapper);
    }

    public List<User> getAll(){
        return this.jdbcTemplate.query("SELECT * FROM users ORDER BY id", new Object[]{}, this.userMapper);
    }

    public int count() {
        return this.jdbcTemplate.queryForInt("SELECT COUNT(*) FROM users");
    }

    public void delete() {
        this.jdbcTemplate.update("DELETE FROM users");
    }
}
