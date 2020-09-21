package spring.user.domain;

import java.sql.Connection;
import java.sql.SQLException;

public class nCon implements ConnectionMaker{
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        return null;
    }
}
