/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.tools;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import pkg40.controllers.EmployeeController;
import pkg40.controllers.EmployeeController;
import pkg40.daos.EmployeeDAO;
import pkg40.daos.idaos.IEmployeeDAO;
import pkg40.models.Employee;

/**
 *
 * @author Yoshua
 */
public class ManualTest {

    private static EmployeeController ec;

    public static void getDataTesting(String searchType, String keyword) throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        List<Employee> employees = ec.getData(searchType, keyword);
        for (Employee employee : employees) {
            System.out.println(employee.getId());
            System.out.println(employee.getFirstName());
            System.out.println(employee.getLastName());
            System.out.println(employee.getEmail());
            System.out.println(employee.getPhoneNumber());
            System.out.println(simpleDateFormat.format(employee.getHireDate()));
            System.out.println(employee.getJobId());
            System.out.println(employee.getSalary());
            System.out.println(employee.getCommisionPCT());
            System.out.println(employee.getManager());
            System.out.println(employee.getDepartment());
        }
    }

    public static void getAllManagers() throws SQLException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        List<Employee> employees = ec.getALlManagers();
        for (Employee employee : employees) {
            System.out.println(employee.getId());
            System.out.println(employee.getFirstName());
            System.out.println(employee.getLastName());
            System.out.println(employee.getEmail());
            System.out.println(employee.getPhoneNumber());
            System.out.println(simpleDateFormat.format(employee.getHireDate()));
            System.out.println(employee.getJobId());
            System.out.println(employee.getSalary());
            System.out.println(employee.getCommisionPCT());
            System.out.println(employee.getManager());
            System.out.println(employee.getDepartment());
        }
    }

    public static void saveEmployeeTesting(Employee employee) throws SQLException {
        System.out.println(ec.saveEmployee(employee));
    }

    public static void deleteTesting(String id) throws SQLException {
        System.out.println(ec.deleteEmployee(id) ? "Berhasil" : "Gagal");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ParseException {
        ec = new EmployeeController();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Employee employee;
//        employee = new Employee(208, "test", "rrr", "qwe", "112", simpleDateFormat.parse("2021-09-30"), "AD_PRES", 1000, (float
//        ) 0.1, 100, 90);
        String keyword = "";
//        saveEmployeeTesting(employee);
//        deleteTesting("208");
//        getDataTesting("", keyword);
        getAllManagers();

    }

}
