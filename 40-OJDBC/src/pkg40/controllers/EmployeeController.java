/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.controllers;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pkg40.daos.EmployeeDAO;
import pkg40.daos.idaos.IEmployeeDAO;
import pkg40.models.Employee;
import pkg40.tools.DBConnection;

/**
 *
 * @author asus
 */
public class EmployeeController {
    private IEmployeeDAO iedao;
    
    public EmployeeController() throws SQLException{
        this.iedao = new EmployeeDAO(new DBConnection().getConnection());
    }
    
    public List<Employee> getAllEmployees() throws SQLException{
        List<Employee> employees = iedao.getAllEmployees();
        return employees;
    }
    
    public boolean insertEmployee(Employee employee) throws SQLException{
        return iedao.insertEmployee(employee);
    } 

    public boolean deleteEmployee(int id) throws SQLException{
        return iedao.deleteEmployee(id);
    }
    
    public boolean updateEmployee(Employee employee) throws SQLException{
        return iedao.updateEmployee(employee);
    }
    
    public List<Employee> searchEmployees(String word) throws SQLException{
        if(word.isEmpty()){
            return iedao.getAllEmployees();
        } else {
            return iedao.searchEmployees(word);
        }
    }
}
