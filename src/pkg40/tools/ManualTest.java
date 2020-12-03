/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.tools;

import java.sql.SQLException;
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

    public static void getDataTesting(String id) throws SQLException {
        List<Employee> employees = ec.getData(id);
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " | " + employee.getLastName());
        }
    }

    public static void saveEmployeeTesting(Employee employee) throws SQLException {
        System.out.println(ec.saveEmplString(employee));
    }

    public static void deleteTesting(String id) throws SQLException {
        System.out.println(ec.deleteEmployee(id) ? "Berhasil" : "Gagal");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ec = new EmployeeController();
        Employee employee;
        employee = new Employee(208, "test", "test", "test", "112", "123", "AD_PRES", 1000, (float) 0.1, 90, 90);
        String keyword = "";

//        saveEmployeeTesting(employee);
        getDataTesting(keyword);
//        mt.saveRegionTesting(region);
//        mt.deleteTesting("6");
    }

}
