package DAO.JDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataUtility {
    public final static String URL = "jdbc:mysql://localhost:3306/detective";
    public final static String USER_NAME = "root";
    public final static String PASS = "123456";
    public static ComboPooledDataSource getDataSource(){
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setJdbcUrl(URL);
        cpds.setUser(USER_NAME);
        cpds.setPassword(PASS);
        cpds.setInitialPoolSize(5);
        cpds.setAcquireIncrement(5);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(100);
        return cpds;
    }
}
