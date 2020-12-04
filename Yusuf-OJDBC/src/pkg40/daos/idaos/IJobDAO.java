/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.daos.idaos;

import java.sql.SQLException;
import java.util.List;
import pkg40.models.Employee;
import pkg40.models.Job;

/**
 *
 * @author Mochamad Yusuf
 */
public interface IJobDAO {

    public List<Job> getAllJobs() throws SQLException;

    public List<Job> getAllJobs(int sortByColumn) throws SQLException;

    public Job getById(String id) throws SQLException;

    public List<Job> search(String input, String searchByColumn) throws SQLException;
}
