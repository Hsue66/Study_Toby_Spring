package spring.user.domain;

import com.mysql.cj.protocol.Resultset;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    DataSource dataSource;

    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO users (id,name,password) VALUES (?,?,?)");
        ps.setString(1,user.getId());
        ps.setString(2,user.getName());
        ps.setString(3,user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("SELECT * FROM users WHERE id=?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();

        rs.next();
        User user = new User();
        user.setId(rs.getString(1));
        user.setName(rs.getString(2));
        user.setPassword(rs.getString(3));

        ps.close();
        rs.close();
        c.close();

        return user;
    }

    public int count() throws SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("SELECT COUNT(*) FROM users");

        ResultSet rs = ps.executeQuery();
        rs.next();
        int cnt = rs.getInt(1);

        rs.close();
        ps.close();
        c.close();
        return cnt;
    }

    public void delete() throws SQLException {
        Connection c = dataSource.getConnection();
        PreparedStatement ps = c.prepareStatement("DELETE FROM users");

        ps.executeUpdate();
        ps.close();
        c.close();
    }
}
