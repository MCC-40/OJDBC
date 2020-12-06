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
import java.util.ArrayList;
import java.util.List;
import pkg40.daos.idaos.IJobDAO;
import pkg40.models.Job;


/**
 *
 * @author asus
 */
public class JobDAO implements IJobDAO{
    private Connection connection;
    private PreparedStatement ps;
    
    public JobDAO(Connection connection){
        this.connection = connection;
    }
    
    public List<Job> getAllJobs() throws SQLException {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs ORDER BY 1";
        ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Job job = new Job(
                    result.getString(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4)
            );
            jobs.add(job);
        }
        ps.close();
        return jobs;
    }

    public List<Job> getAllJobs(int sortByColumn) throws SQLException {
        List<Job> jobs = new ArrayList<>();
        String sql = "SELECT * FROM jobs ORDER BY " + sortByColumn;
        ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Job job = new Job(
                    result.getString(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4)
            );
            jobs.add(job);
        }
        ps.close();
        return jobs;
    }

    public Job getById(String id) throws SQLException {
        String sql = "SELECT * FROM jobs WHERE job_id=?";
        ps = connection.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            Job job = new Job(
                    result.getString(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4)
            );
            ps.close();
            return job;
        } else {
            return null;
        }
    }
    
    public List<Job> search(String input, String searchByColumn) throws SQLException {
        List<Job> jobs = new ArrayList<>();
        if (input.equals("")) {
            return getAllJobs();
        }

        String sql = "SELECT * FROM jobs WHERE " + searchByColumn + " LIKE '%" + input + "%'";
        ps = this.connection.prepareStatement(sql);
//        ps.setString(1, "%" + input + "%");

        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Job job = new Job(
                    result.getString(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4)
            );
            jobs.add(job);
        }
        ps.close();
        return jobs;
    }
}
