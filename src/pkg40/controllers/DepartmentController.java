/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.controllers;

import java.sql.SQLException;
import java.util.List;
import pkg40.daos.DepartmenDAO;
import pkg40.models.Department;
import pkg40.daos.idaos.IDepartmentDAO;
import pkg40.tools.DBConnection;

/**
 *
 * @author Yoshua
 */
public class DepartmentController {
    private IDepartmentDAO iddao;
    
    public DepartmentController() throws SQLException {
       iddao = new DepartmenDAO(new DBConnection().getConnection());
    }
    public List<Department> getAllDepartments() throws SQLException {
        return iddao.getAllDepartments();
    }
}
