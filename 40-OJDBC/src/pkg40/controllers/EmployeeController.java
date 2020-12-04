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
 * @author Mochamad Yusuf
 */
public class EmployeeController {

    private IEmployeeDAO iedao;

    public EmployeeController() throws SQLException {
        this.iedao = new EmployeeDAO(new DBConnection().getConnection());
    }

    public List<Employee> getAllEmployees(int sortByColumn) throws SQLException {
        List<Employee> employees = iedao.getAllEmployees(sortByColumn);
        return employees;
    }

    public boolean insertEmployee(Employee employee) throws SQLException {
        return iedao.insertEmployee(employee);
    }

    public boolean updateEmployee(Employee employee) throws SQLException {
        return iedao.updateEmployee(employee);
    }

    public boolean deleteEmployee(int id) throws SQLException {
        return iedao.deleteEmployee(id);
    }
    
    public Employee getById(int id) throws SQLException{
        return iedao.getById(id);
    }

    public List<Employee> searchEmployee(String keyword, int columnIndex, int sortByColumn) throws SQLException {
        if (keyword.isEmpty()) {
            return iedao.getAllEmployees(sortByColumn);
        } else {
//            List<Employee> employees = new ArrayList<>();
//            employees.add(irdao.getById(Integer.parseInt(word)));
            return iedao.search(keyword, columnIndex, sortByColumn);
        }
    }

    public String saveEmployee(Employee employee) throws SQLException {
        if (iedao.getById(employee.getId()) == null) {
            return (iedao.insertEmployee(employee) ? "Inserted" : "Failed");
        } else {
            return (iedao.updateEmployee(employee) ? "Updated" : "Failed");
        }
    }
}
