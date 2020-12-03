/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.controllers;

import java.sql.SQLException;
import java.util.List;
import pkg40.daos.EmployeeDAO;
import pkg40.daos.idaos.IEmployeeDAO;
import pkg40.models.Employee;
import pkg40.tools.DBConnection;

/**
 *
 * @author Yoshua
 */
public class EmployeeController {
    
    private IEmployeeDAO iedao;

    private static boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    public EmployeeController() throws SQLException {
        this.iedao = new EmployeeDAO(new DBConnection().getConnection());
    }

    public List<Employee> getData(String searchType, String keyword) throws SQLException {
        if (isNullOrEmpty(keyword)) {
            return iedao.getAllEmployees();
        }
        if (isNullOrEmpty(searchType)) {
            searchType = "last_name";
        }
        return iedao.search(searchType ,keyword);
    }

    public String saveEmployee(Employee employee) throws SQLException {
        if (iedao.getById(employee.getId()).isEmpty()) {
            return (iedao.insertEmployee(employee) ? "Inserted" : "Failed");
        }
        return (iedao.updateEmployee(employee) ? "Updated" : "Failed");
    }

    public boolean deleteEmployee(String id) throws SQLException {
        return iedao.deleteEmployee(Integer.parseInt(id));
    }
}
