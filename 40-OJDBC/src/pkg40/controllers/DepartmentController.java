/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.controllers;

import java.sql.SQLException;
import java.util.List;
import pkg40.daos.DepartmentDAO;
import pkg40.daos.idaos.IDepartmentDAO;
import pkg40.models.Department;
import pkg40.tools.DBConnection;

/**
 *
 * @author asus
 */
public class DepartmentController {
    private IDepartmentDAO iddao;

    public DepartmentController() throws SQLException {
        iddao = new DepartmentDAO(new DBConnection().getConnection());
    }

    public List<Department> getAllDepartments() throws SQLException {
        return iddao.getAllDepartments();
    }

    public List<Department> getAllDepartments(int sortByColumn) throws SQLException {
        return iddao.getAllDepartments(sortByColumn);
    }

    public Department getById(int id) throws SQLException{
        return iddao.getById(id);
    }
    
    public List<Department> searchDepartment(String keyword, String searchByColumn) throws SQLException{
        return iddao.search(keyword, searchByColumn);
    }
}
