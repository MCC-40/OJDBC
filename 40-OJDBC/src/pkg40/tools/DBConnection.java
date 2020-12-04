/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.tools;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author asus
 */
public class DBConnection {

    private Connection connection;

    public Connection getConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setDriverType("thin");
        ods.setServerName("localhost");
        ods.setPortNumber(1521);
        ods.setServiceName("XE");
        ods.setUser("system");
        ods.setPassword("B0o7c4mp");
        connection = ods.getConnection();
        connection.setSchema("HR");
        return connection;
    }
}
