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
 * @author Yoshua
 */
public interface IDepartmentDAO {

    public List<Department> getAllDepartments() throws SQLException;
    
    public int getIdByName(String name) throws SQLException;
}
