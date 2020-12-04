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
 * @author Yoshua
 */
public interface IEmployeeDAO {

    public List<Employee> getAllEmployees() throws SQLException;

    public List<Employee> getById(int id) throws SQLException;

    public List<Employee> search(String searchType, String keyword) throws SQLException;

    public List<Employee> getAllManagers() throws SQLException;

    public int getManagerIdByName(String last_name) throws SQLException;

    public boolean insertEmployee(Employee employee) throws SQLException;

    public boolean updateEmployee(Employee employee) throws SQLException;

    public boolean deleteEmployee(int id) throws SQLException;
}