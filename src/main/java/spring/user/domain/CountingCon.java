package spring.user.domain;

import java.sql.Connection;
import java.sql.SQLException;

public class CountingCon implements ConnectionMaker{
    ConnectionMaker connectionMaker;
    int count;

    CountingCon(ConnectionMaker connectionMaker){
        count = 0;
        this.connectionMaker = connectionMaker;
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        count++;
        return connectionMaker.getConnection();
    }

    public int getCount() {
        return count;
    }
}
