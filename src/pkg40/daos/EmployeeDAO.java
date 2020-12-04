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
import java.util.ArrayList;
import java.util.List;
import pkg40.daos.idaos.IEmployeeDAO;
import pkg40.models.Department;
import pkg40.models.Employee;
import pkg40.models.Job;
import pkg40.models.modelEnum.ForeignTable;

//enum ForeignTable {
//  DEPARTMENT,
//  JOB,
//  MANAGER
//}
/**
 *
 * @author Yoshua
 */
public class EmployeeDAO implements IEmployeeDAO {

    private final Connection CONN;
    private PreparedStatement ps;
    private String sql;

    //dependency
    public EmployeeDAO(Connection conn) throws SQLException {
        this.CONN = conn;
    }

    private Employee setEmployee(ResultSet result) throws SQLException {
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
        employee.setManager(result.getString(10));
        employee.setDepartment(result.getString(11));
        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        sql = "SELECT e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, e.hire_date, job_title, "
                + "e.salary, e.commission_pct, m.last_name, d.department_name "
                + "FROM employees e "
                + "NATURAL JOIN jobs "
                + "LEFT OUTER JOIN employees m "
                + "ON (e.manager_id = m.employee_id) "
                + "LEFT OUTER JOIN departments d "
                + "ON (e.department_id = d.department_id) "
                + "ORDER BY employee_id";
        ps = CONN.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            employees.add(setEmployee(result));
        }

        return employees;
    }

    @Override
    public List<Employee> getById(int id) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        sql = "SELECT * FROM employees WHERE employee_id = ?";
        ps = CONN.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            employees.add(setEmployee(result));
        }
        return employees;
    }

    @Override
    public List<Employee> search(String searchType, String keyword) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        if (keyword.equals("")) {
            return getAllEmployees();
        }

        String sql = "SELECT e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, e.hire_date, job_title, "
                + "e.salary, e.commission_pct, m.last_name, d.department_name "
                + "FROM employees e "
                + "NATURAL JOIN jobs "
                + "LEFT OUTER JOIN employees m "
                + "ON (e.manager_id = m.employee_id) "
                + "LEFT OUTER JOIN departments d "
                + "ON (e.department_id = d.department_id) "
                + "WHERE lower(e." + searchType + ") LIKE '%' || lower(?) || '%'";
        ps = this.CONN.prepareStatement(sql);
        ps.setString(1, keyword);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            employees.add(setEmployee(result));
        }
        return employees;
    }

//    @Override
//    public List<Employee> getAllManagers() throws SQLException {
//        List<Employee> managers = new ArrayList<>();
//        sql = "SELECT * FROM employees "
//                + "WHERE employee_id IN "
//                + "(SELECT manager_id FROM employees "
//                + "WHERE manager_id IS NOT NULL "
//                + "GROUP BY manager_id) "
//                + "ORDER BY employee_id";
//        ps = CONN.prepareStatement(sql);
//        ResultSet result = ps.executeQuery();
//        while (result.next()) {
//            managers.add(setEmployee(result));
//        }
//
//        return managers;
//    }
    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {

        System.out.println(employee.getId());
        System.out.println(employee.getFirstName());
        System.out.println(employee.getLastName());
        System.out.println(employee.getEmail());
        System.out.println(employee.getPhoneNumber());
        System.out.println(employee.getHireDate());
        System.out.println(employee.getJobId());
        System.out.println(employee.getSalary());
        System.out.println(employee.getCommisionPCT());
        System.out.println(employee.getManagerId());
        System.out.println(employee.getDepartmentId());

        sql = "INSERT INTO employees VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        ps = CONN.prepareStatement(sql);
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
                    //                + "job_id = ?, "
                    + "salary = ?, "
                    + "commission_pct = ?, "
                    + "manager_id = ? "
                    //                + "department_id = ? "
                    + "WHERE employee_id = ?";
            ps = CONN.prepareStatement(sql);
            ps.setInt(1, employee.getId());
            ps.setString(2, employee.getFirstName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getEmail());
            ps.setString(5, employee.getPhoneNumber());
            ps.setDate(6, new Date(employee.getHireDate().getTime()));
//        ps.setString(7, employee.getJobId());
            ps.setInt(7, employee.getSalary());
            ps.setFloat(8, employee.getCommisionPCT());
            ps.setInt(9, employee.getManagerId());
//        ps.setInt(10, employee.getDepartmentId());
            ps.setInt(10, employee.getId());
            return 1 == ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return true;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        sql = "DELETE FROM job_history WHERE employee_id = ?";
        ps = CONN.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();

        sql = "DELETE FROM employees WHERE employee_id = ?";
        ps = CONN.prepareStatement(sql);
        ps.setInt(1, id);

        return 1 == ps.executeUpdate();
    }

    @Override
//    public int getManagerIdByName(String last_name) throws SQLException {
//        int id = 0;
//        sql = "SELECT employee_id FROM employees WHERE last_name = ? AND employee_id IN (SELECT manager_id FROM employees)";
//        ps = CONN.prepareStatement(sql);
//        ps.setString(1, last_name);
//        ResultSet result = ps.executeQuery();
//        while (result.next()) {
//            id = result.getInt(1);
//        }
//        return id;
//    }
    public <T> T getIdByName(ForeignTable table, String name) throws SQLException {
        String id = null;
        ResultSet result;
        switch (table) {
            case DEPARTMENT:
                sql = "SELECT department_id FROM departments WHERE department_name = ?";
                ps = CONN.prepareStatement(sql);
                ps.setString(1, name);
                result = ps.executeQuery();
                while (result.next()) {
                    id = result.getString(1);
                }
                break;
            case JOB:
                sql = "SELECT job_id FROM jobs WHERE job_title = ?";
                ps = CONN.prepareStatement(sql);
                ps.setString(1, name);
                result = ps.executeQuery();
                while (result.next()) {
                    id = result.getString(1);
                }
                break;
            case MANAGER:
                sql = "SELECT employee_id FROM employees WHERE last_name = ? AND employee_id IN (SELECT manager_id FROM employees)";
                ps = CONN.prepareStatement(sql);
                ps.setString(1, name);
                result = ps.executeQuery();
                while (result.next()) {
                    id = result.getString(1);
                }
                break;
        }
        return (T) id;
    }

    public <T> List<T> getForeignTable(ForeignTable table) throws SQLException {
        List<T> data = new ArrayList<>();
        ResultSet result;
        switch (table) {
            case DEPARTMENT:
                sql = "SELECT * FROM departments";
                ps = CONN.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next()) {
                    Department department = new Department();
                    department.setId(result.getInt(1));
                    department.setName(result.getString(2));
                    department.setManagerId(result.getInt(3));
                    department.setLocationId(result.getInt(3));
                    data.add((T) department);
                }
                break;
            case JOB:
                sql = "SELECT * FROM jobs";
                ps = CONN.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next()) {
                    Job job = new Job();
                    job.setId(result.getString(1));
                    job.setTitle(result.getString(2));
                    job.setMinSalary(result.getInt(3));
                    job.setMaxSalary(result.getInt(4));
                    data.add((T) job);
                }
                break;
            case MANAGER:
                sql = "SELECT * FROM employees "
                        + "WHERE employee_id IN "
                        + "(SELECT manager_id FROM employees "
                        + "WHERE manager_id IS NOT NULL "
                        + "GROUP BY manager_id) "
                        + "ORDER BY employee_id";
                ps = CONN.prepareStatement(sql);
                result = ps.executeQuery();
                while (result.next()) {
                    data.add((T) setEmployee(result));
                }
                break;
        }
        return data;
    }
}
