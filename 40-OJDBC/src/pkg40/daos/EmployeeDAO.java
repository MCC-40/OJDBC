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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static jdk.nashorn.internal.runtime.Debug.id;
import static jdk.nashorn.tools.ShellFunctions.input;
import pkg40.daos.idaos.IEmployeeDAO;
import pkg40.models.Department;
import pkg40.models.Employee;
import pkg40.models.Job;
import pkg40.models.tableOptionDropDown.EmployeeForeignTable;

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
            employee.setCommPct(result.getFloat(9));
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
        ps.setFloat(9, employee.getCommPct());
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
        int temp = 0;
        String sql = "UPDATE employees SET "
                + " first_name=?, "
                + " last_name=?, "
                + " email=?, "
                + " phone_number=?, "
                + " hire_date=?, "
                + " job_id=?, "
                + " salary=?, "
                + " commission_pct=?, "
                + " manager_id=?, "
                + " department_id=? WHERE employee_id=?";

        ps = this.connection.prepareStatement(sql);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	ps.setString(1, employee.getFirstName());
	ps.setString(2, employee.getLastName());
	ps.setString(3, employee.getEmail());
	ps.setString(4, employee.getPhoneNumber());
	ps.setDate(5, employee.getHireDate());
	ps.setString(6, employee.getJobId());
	ps.setInt(7, employee.getSalary());
//        ps.setFloat(8, employee.getCommPct());
//        ps.setInt(9, employee.getManagerId());
//        ps.setInt(10, employee.getDepartmentId());
        
	if (employee.getCommPct() == null) {      
		ps.setNull(8, java.sql.Types.FLOAT);   
	} else {      
		ps.setFloat(8, (Float) employee.getCommPct());
	}

	if (employee.getManagerId() == null) {
		ps.setNull(9, java.sql.Types.INTEGER);
	} else {
		ps.setInt(9, employee.getManagerId());
	}

	if (employee.getDepartmentId() == null) {
		ps.setNull(10, java.sql.Types.INTEGER);        
	} else {
		ps.setInt(10, employee.getDepartmentId());
	}

	ps.setInt(11, employee.getId());
 
        int result = ps.executeUpdate();
        ps.close();
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
    
    @Override
    public Employee getById(int id) throws SQLException{
        Employee employee = new Employee();
        String sql = "SELECT * FROM employees WHERE employee_id = ?";
        ps = this.connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        if(result.next()){
            employee.setId(result.getInt(1));
            employee.setFirstName(result.getString(2));
            employee.setLastName(result.getString(3));
            employee.setEmail(result.getString(4));
            employee.setPhoneNumber(result.getString(5));
            employee.setHireDate(result.getDate(6));
            employee.setJobId(result.getString(7));
            employee.setSalary(result.getInt(8));
            employee.setCommPct(result.getFloat(9));
            employee.setManagerId(result.getInt(10));
            employee.setDepartmentId(result.getInt(11));
        }else{
            return null;
        }
        return employee;
    }
    
    public <T> List<T> getForeignTable(EmployeeForeignTable table) throws SQLException {
        List<T> tList = new ArrayList<>();
        String sql;
        ResultSet result;
        switch (table) {
            case JOB:
                sql = "SELECT job_id, job_title FROM jobs";
                ps = connection.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next()) {
                    Job job = new Job();
                    job.setId(result.getString(1));
                    job.setTitle(result.getString(2));
                    tList.add((T) job);
                }
                break;
            case DEPARTMENT:
                sql = "SELECT department_id, department_name FROM departments";
                ps = connection.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next()) {
                    Department dept = new Department();
                    dept.setId(result.getInt(1));
                    dept.setName(result.getString(2));
                    tList.add((T) dept);
                }
                break;
            case MANAGER:
                sql = "SELECT employee_id, first_name, last_name FROM employees";
                ps = connection.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next()) {
                    Employee emp = new Employee();
                    emp.setId(result.getInt(1));
                    emp.setFirstName(result.getString(2));
                    emp.setLastName(result.getString(3));
                    tList.add((T) emp);
                }
                break;
            default:
                return null;
        }

        return tList;
    }
   
}

