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
import static jdk.nashorn.internal.runtime.Debug.id;
import static jdk.nashorn.tools.ShellFunctions.input;
import pkg40.daos.idaos.IEmployeeDAO;
import pkg40.models.Employee;

/**
 *
 * @author asus
 */
public class EmployeeDAO implements IEmployeeDAO{

    private Connection connection;
    private PreparedStatement ps;
    
    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public List<Employee> getAllEmployees() throws SQLException{
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees ORDER BY 1";
        ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Employee employee = new Employee();
            employee.setId(result.getInt(1));
            employee.setFirstName(result.getString(2));
            employee.setLastName(result.getString(3));
            employee.setEmail(result.getString(4));
            employee.setPhoneNumber(result.getString(5));
            employee.setHireDate(result.getDate(6));
            employee.setJobId(result.getString(7));
            employee.setSalary(result.getInt(8));
            employee.setCommPct(result.getInt(9));
            employee.setManagerId(result.getInt(10));
            employee.setDepartmentId(result.getInt(11));    
            
            employees.add(employee);
        }
        
        return employees;
    }
    
    @Override
    public boolean insertEmployee(Employee employee) throws SQLException{
        String sql = "INSERT INTO employees(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ps = this.connection.prepareStatement(sql);
        ps.setInt(1, employee.getId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setString(4, employee.getEmail());
        ps.setString(5, employee.getPhoneNumber());
        ps.setDate(6, employee.getHireDate());
        ps.setString(7, employee.getJobId());
        ps.setInt(8, employee.getSalary());
        ps.setInt(9, employee.getCommPct());
        ps.setInt(10, employee.getManagerId());
        ps.setInt(11, employee.getDepartmentId());
        
        int result = ps.executeUpdate();
        return result == 1;
    }
    
    @Override
    public boolean deleteEmployee(int id) throws SQLException{
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        ps = this.connection.prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result == 1;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException{
        String sql = "UPDATE regions SET first_name=? WHERE employee_id=?";
        ps = this.connection.prepareStatement(sql);
        ps.setString(1, employee.getFirstName());
        ps.setInt(2, employee.getId());
        int result = ps.executeUpdate();
        return result == 1;
    }
    
    @Override
    public List<Employee> searchEmployees(String input) throws SQLException{
        List<Employee> employees = new ArrayList<>();
        if (input.equals(""))
                return getAllEmployees();
        
        String sql = "SELECT * FROM employees WHERE employee_id = ? OR first_name LIKE ?";
        ps = this.connection.prepareStatement(sql);
        try{
            ps.setInt(1, Integer.parseInt(input));
        }catch(NumberFormatException e){
            ps.setInt(1, 0);
        }
        ps.setString(2, "%" + input + "%");
        
        ResultSet result = ps.executeQuery();
        while(result.next()){
            Employee employee = new Employee();
            employee.setId(result.getInt(1));
            employee.setFirstName(result.getString(2));   
            
            employees.add(employee);
        }
        return employees;
    }
}

