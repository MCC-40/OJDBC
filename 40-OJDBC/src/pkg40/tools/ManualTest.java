/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.tools;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.io.Console;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import pkg40.controllers.EmployeeController;
import pkg40.controllers.RegionController;
import pkg40.models.Employee;
import pkg40.models.Region;

/**
 *
 * @author asus
 */
public class ManualTest {

    private final RegionController rc;
    private final EmployeeController ec;

    public ManualTest() throws SQLException {
        rc = new RegionController();
        ec = new EmployeeController();
    }
    
    public void getAllTestingEmployee() throws SQLException{
        List<Employee> employees = ec.getAllEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " | " + employee.getFirstName() + " | " + employee.getLastName() + " | " + employee.getEmail() + " | " + employee.getPhoneNumber() + " | " + employee.getHireDate() + " | " + employee.getJobId() + " | " + employee.getSalary() + " | " + employee.getCommPct() + " | " + employee.getManagerId() + " | " + employee.getDepartmentId());
        }
    }
    
    public void getAllTestingRegion() throws SQLException {
        List<Region> regions = rc.getAllRegions();
        for (Region region : regions) {
            System.out.println(region.getId() + " | " + region.getName());
        }
    }

    public void insertTestingEmployee() throws SQLException, ParseException{
        
        
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String Format= format.format(Date.valueOf(LocalDate.now()));
        
        //print debugging
//        System.out.println(Date.valueOf(LocalDate.now()));
//        
        System.out.println(ec.insertEmployee(new Employee(211, "Crismon", "Manalu", "CRMAN", "321.456.7980", "IT_PROG", 6500, 0,  100, 100)) ? "Berhasil" : "Gagal");
    }
    
    public void insertTestingRegion() throws SQLException {
        System.out.println(rc.insertRegion(new Region(6, "South East Asia")) ? "Berhasil" : "Gagal");
    }

    //update region name
    public void updateTesting() throws SQLException {
        System.out.println(rc.updateRegion(new Region(6, "South Asia")) ? "Berhasil" : "Gagal");
    }
    
    //update first name
    public void updateEmployeeTesting() throws SQLException{
        System.out.println(ec.updateEmployee(new Employee(210, "Maniti", "Hasibuan", "MHAS", "123.456.7891", "AC_ACCOUNT", 5500, (float) 0.2, 100, 100)) ? "Berhasil" : "Gagal");
    }

    public void deleteTesting() throws SQLException {
        System.out.println(rc.deleteRegion(6) ? "Berhasil" : "Gagal");
    }
    
    public void deleteTestingEmployee() throws SQLException{
        System.out.println(ec.deleteEmployee(210) ? "Berhasil" : "Gagal");
    }

    public void searchTesting() throws SQLException {
        System.out.print("Keyword search : ");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        List<Region> regions = rc.searchRegion(input);
        if (regions.isEmpty()) {
            System.out.println("Data no found");
        }
        for (Region region : regions) {
            System.out.println(region.getId() + " | " + region.getName());
        }
    }
    
    public void searchTestingEmployees() throws SQLException{
        System.out.println("Keyword Search : ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Employee> employees = ec.searchEmployees(input);
        if (employees.isEmpty()){
            System.out.println("Data no found");
        }
        for (Employee employee : employees) {
            System.out.println(employee.getId() + " | " + employee.getFirstName());
        }
    }

    public void saveTesting() throws SQLException {
//        System.out.println(rc.saveRegion(new Region(6, "South East Asia")));
//        getAllTestingRegion();
        System.out.println(rc.saveRegion(new Region(6, "South Asia")));
        getAllTestingRegion();
    }
    
    public void saveTestingEmployee() throws SQLException{
        System.out.println(ec.saveEmployee(new Employee(210, "Maniti", "Hasibuan", "MHAS", "123.456.7891", "AC_ACCOUNT", 5500, (float) 0.2, 100, 100)));
        getAllTestingEmployee();
        System.out.println(ec.saveEmployee(new Employee(210, "AndMan", "Hasibuan", "MHAS", "123.456.7891", "AC_ACCOUNT", 5500, (float) 0.2, 100, 100)));
        getAllTestingEmployee();
    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException, ParseException {
        System.out.println(new DBConnection().getConnection());
        ManualTest mt = new ManualTest();

        Date date = new Date(System.currentTimeMillis());
        System.out.println(date);
        
//        region
//        mt.getAllTestingRegion();   
//        mt.updateTesting();
//        mt.deleteTesting();
//        mt.searchTesting();
//        mt.insertTestingRegion();
//        mt.saveTesting();

//        employee
//        mt.deleteTestingEmployee();
//        mt.getAllTestingEmployee();
//        mt.searchTestingEmployees();      //hanya memunculkan id dan firstname
//        mt.updateEmployeeTesting();
//        mt.insertTestingEmployee();
//        mt.saveTestingEmployee();
    }
}

