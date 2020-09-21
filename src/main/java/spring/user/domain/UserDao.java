package spring.user.domain;

import java.sql.*;

public class UserDao {
    public void add(User user) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?serverTimezone=UTC","root","1234");

        PreparedStatement stmt = c.prepareStatement("INSERT INTO users (id,name,password) VALUES (?,?,?)");
        stmt.setString(1,user.getId());
        stmt.setString(2,user.getName());
        stmt.setString(3,user.getPassword());

        stmt.executeUpdate();

        c.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?serverTimezone=UTC","root","1234");

        PreparedStatement stmt = c.prepareStatement("SELECT * FROM users WHERE id=?");
        stmt.setString(1,id);

        ResultSet rs = stmt.executeQuery();

        rs.next();
        User user = new User();
        user.setId(rs.getString(1));
        user.setName(rs.getString(2));
        user.setPassword(rs.getString(3));

        rs.close();
        c.close();
        return user;
    }
}
