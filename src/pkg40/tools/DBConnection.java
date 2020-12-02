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
 * @author Yoshua
 */
public class DBConnection {
    private Connection conneection;
    
    public Connection getConnection() throws SQLException{
        OracleDataSource ods = new OracleDataSource();
        ods.setDriverType("thin");
        ods.setServerName("localhost");
        ods.setPortNumber(1521);
        ods.setServiceName("XE");
        ods.setUser("system");
        ods.setPassword("351580");
        conneection = ods.getConnection();
        conneection.setSchema("HR");
        return conneection;
    }
}
