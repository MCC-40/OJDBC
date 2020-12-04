/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.daos.idaos;

import java.sql.SQLException;
import java.util.List;
import pkg40.models.Employee;

/**
 *
 * @author Mochamad Yusuf
 */
public interface IEmployeeDAO {
    public List<Employee> getAllEmployees() throws SQLException;
    
    public List<Employee> getAllEmployees(int sortByColumn) throws SQLException;
    
    public int getNewId() throws SQLException;
    
    public boolean insertEmployee(Employee employee) throws SQLException;
    
    public boolean updateEmployee(Employee employee) throws SQLException;
    
    public boolean deleteEmployee(int id) throws SQLException;
    
    public Employee getById(int id) throws SQLException;
        
    public List<Employee> search(String input, int columnIndex, int sortByColumn) throws SQLException;
}
