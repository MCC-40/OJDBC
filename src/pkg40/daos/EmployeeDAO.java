/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import pkg40.daos.idaos.IEmployeeDAO;
import pkg40.models.Employee;

/**
 *
 * @author Yoshua
 */
public class EmployeeDAO implements IEmployeeDAO {

    private Connection conn;
    private PreparedStatement ps;
    private String sql;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");

    //dependency
    public EmployeeDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        sql = "SELECT * FROM employees ORDER BY employee_id";
        ps = conn.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Employee employee = new Employee();
            employee.setId(result.getInt(1));
            employee.setFirstName(result.getString(2));
            employee.setLastName(result.getString(3));
            employee.setEmail(result.getString(4));
            employee.setPhoneNumber(result.getString(5));
            employee.setHireDate(result.getDate(6));
            employee.setJobId(result.getString(7));
            employee.setSalary(result.getInt(8));
            employee.setCommisionPCT(result.getFloat(9));
            employee.setManagerId(result.getInt(10));
            employee.setDepartmentId(result.getInt(11));

            employees.add(employee);
        }

        return employees;
    }

    public List<Employee> getById(int id) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        sql = "SELECT * FROM employees WHERE employee_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Employee employee = new Employee();
            employee.setId(result.getInt(1));
            employee.setFirstName(result.getString(2));
            employee.setLastName(result.getString(3));
            employee.setEmail(result.getString(4));
            employee.setPhoneNumber(result.getString(5));
            employee.setHireDate(result.getDate(6));
            employee.setJobId(result.getString(7));
            employee.setSalary(result.getInt(8));
            employee.setCommisionPCT(result.getFloat(9));
            employee.setManagerId(result.getInt(10));
            employee.setDepartmentId(result.getInt(11));
            employees.add(employee);
        }
        return employees;
    }
//
//    public List<Employee> search(String keyword) throws SQLException {
//        List<Region> regions = new ArrayList<>();
//        if (keyword.equals("")) {
//            return getAllEmployees();
//        }
//
//        String sql = "SELECT * FROM regions WHERE region_id=? OR lower(region_name) LIKE lower(?) || '%'";
//        ps = this.conn.prepareStatement(sql);
//        try {
//            ps.setInt(1, Integer.parseInt(keyword));
//        } catch (NumberFormatException e) {
//            ps.setInt(1, 0);
//        }
//        ps.setString(2, keyword);
//
//        ResultSet result = ps.executeQuery();
//        while (result.next()) {
//            Region region = new Region();
//            region.setId(result.getInt(1));
//            region.setName(result.getString(2));
//            regions.add(region);
//        }
//        return regions;
//    }

    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        sql = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, employee.getId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setString(4, employee.getEmail());
        ps.setString(5, employee.getPhoneNumber());
        ps.setDate(6, new Date(employee.getHireDate().getTime()));
        ps.setString(7, employee.getJobId());
        ps.setInt(8, employee.getSalary());
        ps.setFloat(9, employee.getCommisionPCT());
        ps.setInt(10, employee.getManagerId());
        ps.setInt(11, employee.getDepartmentId());
        return 1 == ps.executeUpdate();

    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try {
                    sql = "UPDATE employees SET "
                + "employee_id = ?, "
                + "first_name = ?, "
                + "last_name = ?, "
                + "email = ?, "
                + "phone_number = ?, "
                + "hire_date = ?, "
                + "job_id = ?, "
                + "salary = ?, "
                + "commission_pct = ?, "
                + "manager_id = ?, "
                + "department_id = ? "
                + "WHERE employee_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, employee.getId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setString(4, employee.getEmail());
        ps.setString(5, employee.getPhoneNumber());
        ps.setDate(6, new Date(employee.getHireDate().getTime()));
        ps.setString(7, employee.getJobId());
        ps.setInt(8, employee.getSalary());
        ps.setFloat(9, employee.getCommisionPCT());
        ps.setInt(10, employee.getManagerId());
        ps.setInt(11, employee.getDepartmentId());
        ps.setInt(12, employee.getId());
                return 1 == ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("this");
            System.out.println(e);
        }
return true;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        sql = "DELETE FROM employees WHERE employee_id = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        return 1 == ps.executeUpdate();
    }

    @Override
    public List<Employee> search(String input) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
