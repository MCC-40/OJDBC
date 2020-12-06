/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.daos.idaos;

import java.sql.SQLException;
import java.util.List;
import pkg40.models.Department;

/**
 *
 * @author asus
 */
public interface IDepartmentDAO {
    public List<Department> getAllDepartments() throws SQLException;
     
    public List<Department> getAllDepartments(int sortByColumn) throws SQLException;
     
    public Department getById(int id) throws SQLException;
     
    public List<Department> search(String input, String searchByColumn) throws SQLException;
}
