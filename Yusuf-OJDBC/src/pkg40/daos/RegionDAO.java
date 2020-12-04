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
import pkg40.daos.idaos.IRegionDAO;
import pkg40.models.Region;

/**
 *
 * @author Mochamad Yusuf
 */
public class RegionDAO implements IRegionDAO {

    private Connection connection;
    private PreparedStatement ps;

    // depedency / ketergantungan
    public RegionDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Region> getAllRegions() throws SQLException {
        List<Region> regions = new ArrayList<>();
        String sql = "SELECT * FROM regions ORDER BY 1";
        ps = connection.prepareStatement(sql);
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Region region = new Region();
            region.setId(result.getInt(1));
            region.setName(result.getString(2));
            regions.add(region);
        }
        return regions;
    }

    @Override
    public boolean insertRegion(Region region) throws SQLException {
        String sql = "INSERT INTO regions(region_id, region_name) VALUES (?, ?)";
        ps = this.connection.prepareStatement(sql);
        ps.setInt(1, region.getId());
        ps.setString(2, region.getName());
        int result = ps.executeUpdate();
        return result == 1;
    }

    @Override
    public boolean updateRegion(Region region) throws SQLException {
        String sql = "UPDATE regions SET region_name=? WHERE region_id=?";
        ps = this.connection.prepareStatement(sql);
        ps.setString(1, region.getName());
        ps.setInt(2, region.getId());
        int result = ps.executeUpdate();
        return result == 1;
    }

    @Override
    public boolean deleteRegion(int id) throws SQLException {
        String sql = "Delete FROM regions WHERE region_id=?";
        ps = this.connection.prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        return result == 1;
    }

    @Override
    public Region getById(int id) throws SQLException {
        String sql = "SELECT * FROM regions WHERE region_id=?";
        ps = this.connection.prepareStatement(sql);
        ps.setInt(1, id);
        ResultSet result = ps.executeQuery();
        if (result.next()) {
            Region region = new Region();
            region.setId(result.getInt(1));
            region.setName(result.getString(2));
            return region;
        } else {
            return null;
        }
    }
    
    @Override
    public List<Region> search(String input) throws SQLException {
        List<Region> regions = new ArrayList<>();
        if (input.equals(""))
            return getAllRegions();
        
        String sql = "SELECT * FROM regions WHERE region_id=? OR region_name LIKE ?";
        ps = this.connection.prepareStatement(sql);
        try {
            ps.setInt(1, Integer.parseInt(input));
        } catch (NumberFormatException e) {
            ps.setInt(1, 0);
        }
        ps.setString(2, "%" + input + "%");
                
        ResultSet result = ps.executeQuery();
        while (result.next()) {
            Region region = new Region();
            region.setId(result.getInt(1));
            region.setName(result.getString(2));
            regions.add(region);
        }
        return regions;
    }
}
