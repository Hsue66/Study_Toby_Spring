package spring.user.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteAllStatement implements StatementStrategy{
    @Override
    public PreparedStatement makePrepareStatement(Connection c) throws SQLException {
        return c.prepareStatement("DELETE FROM users");
    }
}
