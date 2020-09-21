package spring.user.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class kDao extends UserDao{
    @Override
    Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection("jdbc:mysql://localhost/springbook?serverTimezone=UTC","root","1234");
        return c;
    }
}
