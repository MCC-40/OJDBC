/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.controllers;

import java.sql.SQLException;
import java.util.List;
import pkg40.daos.JobDAO;
import pkg40.daos.idaos.IJobDAO;
import pkg40.models.Job;
import pkg40.tools.DBConnection;

/**
 *
 * @author Yoshua
 */
public class JobController {

    private IJobDAO ijdao;

    public JobController() throws SQLException {
        ijdao = new JobDAO(new DBConnection().getConnection());
    }

    public List<Job> getAllJobs() throws SQLException {
        return ijdao.getAllJobs();
    }

    public String getIdByName(String title) throws SQLException {
        return ijdao.getIdByName(title);
    }
}
