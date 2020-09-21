package spring.user.domain;

import java.sql.Connection;
import java.sql.SQLException;

public class nDao extends UserDao{
    @Override
    Connection getConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}
