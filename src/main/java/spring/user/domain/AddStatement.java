package spring.user.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStatement implements StatementStrategy{
    @Override
    public PreparedStatement makePrepareStatement(Connection c) throws SQLException {
        return c.prepareStatement("INSERT INTO users (id,name,password) VALUES (?,?,?)");
    }
}
