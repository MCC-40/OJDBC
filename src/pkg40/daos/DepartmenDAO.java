/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg40.daos.idaos.IDepartmentDAO;
import pkg40.models.Department;

/**
 *
 * @author Yoshua
 */
public class DepartmenDAO implements IDepartmentDAO{
    private final Connection conn;
    private PreparedStatement ps;
    private String sql;

    //dependency
    public DepartmenDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        sql = "SELECT * FROM departments";
        ps = conn.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Department department = new Department();
            department.setId(result.getInt(1));
            department.setName(result.getString(2));
            department.setManagerId(result.getInt(3));
            department.setLocationId(result.getInt(3));
            departments.add(department);
        }
        return departments;
    }
    
}
