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
 * @author Yoshua
 */
public class JobDAO implements IJobDAO{
    private final Connection conn;
    private PreparedStatement ps;
    private String sql;

    //dependency
    public JobDAO(Connection conn) {
        this.conn = conn;
    }
    
    @Override
    public List<Job> getAllJobs() throws SQLException {
        List<Job> jobs = new ArrayList<>();
        sql = "SELECT * FROM jobs";
        ps = conn.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Job job  = new Job();
            job.setId(result.getString(1));
            job.setTitle(result.getString(2));
            job.setMinSalary(result.getInt(3));
            job.setMaxSalary(result.getInt(4));
            jobs.add(job);
        }
        return jobs;
    }
    

    @Override
    public String getIdByName(String title) throws SQLException {
        String id = "";
        sql = "SELECT job_id FROM jobs WHERE job_title = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, title);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            id = result.getString(1);
        }
        return id;
    }
}
