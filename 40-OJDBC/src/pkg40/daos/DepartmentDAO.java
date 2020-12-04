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
import pkg40.models.Job;

/**
 *
 * @author Mochamad Yusuf
 */
public class DepartmentDAO implements IDepartmentDAO {

    private Connection connection;
    private PreparedStatement ps;

    public DepartmentDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Department> getAllDepartments() throws SQLException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM departments ORDER BY 1";
        ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Department department = new Department();
            department.setId(result.getInt(1));
            department.setName(result.getString(2));
            department.setManagerId(result.getInt(3));
            department.setLocationId(result.getInt(4));
            departments.add(department);
        }
        ps.close();
        return departments;
    }

    @Override
    public List<Department> getAllDepartments(int sortByColumn) throws SQLException {
        List<Department> departments = new ArrayList<>();
        String sql = "SELECT * FROM departments ORDER BY " + sortByColumn;
        ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Department department = new Department();
            department.setId(result.getInt(1));
            department.setName(result.getString(2));
            department.setManagerId(result.getInt(3));
            department.setLocationId(result.getInt(4));
            departments.add(department);
        }
        ps.close();
        return departments;
    }

    @Override
    public Department getById(int id) throws SQLException {
        String sql = "SELECT * FROM departments WHERE department_id=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            Department department = new Department(
                    result.getInt(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4)
            );
            ps.close();
            return department;
        } else {
            return null;
        }
    }

    @Override
    public List<Department> search(String input, String searchByColumn) throws SQLException {
        List<Department> departments = new ArrayList<>();
        if (input.equals("")) {
            return getAllDepartments();
        }

        String sql = "SELECT * FROM departments WHERE " + searchByColumn + " LIKE '%" + input + "%'";
        ps = this.connection.prepareStatement(sql);
//        ps.setString(1, "%" + input + "%");

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Department department = new Department(
                    result.getInt(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4)
            );
            departments.add(department);
        }
        ps.close();
        return departments;
    }

}
