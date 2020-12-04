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
import pkg40.daos.idaos.IEmployeeDAO;
import pkg40.models.Employee;

// SELECT '"'||LOWER(COLUMN_NAME)||'",' FROM ALL_COL_COMMENTS WHERE TABLE_NAME = 'EMPLOYEES'
/**
 *
 * @author Mochamad Yusuf
 */
public class EmployeeDAO implements IEmployeeDAO {

    private Connection connection;
    private PreparedStatement ps;
    private final String[] COLUMN_NAMES = {
        "employee_id",
        "first_name",
        "last_name",
        "email",
        "phone_number",
        "hire_date",
        "job_id",
        "salary",
        "commission_pct",
        "manager_id",
        "department_id"
    };

    public EmployeeDAO(Connection connection) throws SQLException {
        this.connection = connection;
    }

    private String getColumnName(int index) {
        return COLUMN_NAMES[index - 1];
    }

    @Override
    public int getNewId() throws SQLException {
        String sql = "SELECT MAX(employee_id) FROM employees";
        ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            return result.getInt(1) + 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees ORDER BY 1";
        ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Employee employee = new Employee(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getDate(6),
                    result.getString(7),
                    result.getInt(8),
                    result.getObject(9) == null ? null : result.getFloat(9),
                    result.getObject(10) == null ? null : result.getInt(10),
                    result.getObject(11) == null ? null : result.getInt(11));
            employees.add(employee);
        }
        ps.close();
        return employees;
    }

    @Override
    public List<Employee> getAllEmployees(int sortByColumn) throws SQLException {
        if (sortByColumn < 0 || sortByColumn > 12) {
            sortByColumn = 1;
        }

        List<Employee> employees = new ArrayList<>();
        String sql = "SELECT * FROM employees ORDER BY " + sortByColumn;
        ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Employee employee = new Employee(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getDate(6),
                    result.getString(7),
                    result.getInt(8),
                    result.getObject(9) == null ? null : result.getFloat(9),
                    result.getObject(10) == null ? null : result.getInt(10),
                    result.getObject(11) == null ? null : result.getInt(11));
            employees.add(employee);
        }
        return employees;
    }

    @Override
    public boolean insertEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO employees VALUES (?, ?, ?, ?,"
                + " ?, ?, ?, ?, "
                + "?, ?, ?)";
        ps = this.connection.prepareStatement(sql);

        ps.setInt(1, employee.getId());
        ps.setString(2, employee.getFirstName());
        ps.setString(3, employee.getLastName());
        ps.setString(4, employee.getEmail());
        ps.setString(5, employee.getPhoneNumber());
        ps.setDate(6, employee.getHireDate());
        ps.setString(7, employee.getJobId());
        ps.setInt(8, employee.getSalary());
        if (employee.getCommissionPct() == null) {
            ps.setNull(9, java.sql.Types.FLOAT);
        } else {
            ps.setFloat(9, employee.getCommissionPct());
        }

        if (employee.getManagerId() == null) {
            ps.setNull(10, java.sql.Types.INTEGER);
        } else {
            ps.setInt(10, employee.getManagerId());
        }

        if (employee.getDepartmentId() == null) {
            ps.setNull(11, java.sql.Types.INTEGER);
        } else {
            ps.setInt(11, employee.getDepartmentId());
        }
        int result = ps.executeUpdate();
        ps.close();
        return result == 1;
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
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
        if (employee.getCommissionPct() == null) {
            ps.setNull(8, java.sql.Types.FLOAT);
        } else {
            ps.setFloat(8, employee.getCommissionPct());
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
    public boolean deleteEmployee(int id) throws SQLException {
        String sql = "Delete FROM employees WHERE employee_id=?";
        ps = this.connection.prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        ps.close();
        return result == 1;
    }

    @Override
    public Employee getById(int id) throws SQLException {
        String sql = "SELECT * FROM employees WHERE employee_id=?";
        ps = connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            Employee employee = new Employee(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getDate(6),
                    result.getString(7),
                    result.getInt(8),
                    result.getObject(9) == null ? null : result.getFloat(9),
                    result.getObject(10) == null ? null : result.getInt(10),
                    result.getObject(11) == null ? null : result.getInt(11)
            );
            ps.close();
            return employee;
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> search(String input, int columnIndex, int sortByColumn) throws SQLException {
        List<Employee> employees = new ArrayList<>();
        if (input.equals("")) {
            return getAllEmployees();
        }

        String column;
        switch (columnIndex) {
            case 7:
                column = "j.job_title";
                break;
            case 10:
                column = "m.last_name";
                break;
            case 11:
                column = "d.department_name";
                break;
            default:
                column = "e." + getColumnName(columnIndex);
                break;
        }

        String sql = "SELECT ";
        for (int i = 1; i < 11; i++) {
            sql += "e." + getColumnName(i) + ", ";
        }
        sql += "e." + getColumnName(11);
        sql += " FROM employees e "
                + "JOIN employees m ON (e.manager_id = m.employee_id)"
                + "JOIN departments d ON (e.department_id=d.department_id) "
                + "JOIN jobs j ON (e.job_id=j.job_id)"
                + "WHERE " + column + " LIKE '%" + input + "%' "
                + "ORDER BY " + sortByColumn;
        System.out.println(sql);
        ps = this.connection.prepareStatement(sql);

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Employee employee = new Employee(
                    result.getInt(1),
                    result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getDate(6),
                    result.getString(7),
                    result.getInt(8),
                    result.getObject(9) == null ? null : result.getFloat(9),
                    result.getObject(10) == null ? null : result.getInt(10),
                    result.getObject(11) == null ? null : result.getInt(11)
            );
            employees.add(employee);
        }
        ps.close();
        return employees;
    }
}
