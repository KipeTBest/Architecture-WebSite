package ru.kpfu.itis.datasource;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Logger;

public class MySimpleDataSource implements DataSource{

    private Connection connection;
    private String dbUsername;
    private String dbPassword;
    private String url;
    private final String driverClassNamePostgres = "org.postgresql.Driver";

    public MySimpleDataSource(String dbUsername, String dbPassword, String url) {
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword;
        this.url = url;

        openConnection();
    }

    private void openConnection(){
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ArchitectureDB", dbUsername,
                    dbPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(connection.isClosed() || connection == null){
            openConnection();
        }
        return connection;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
