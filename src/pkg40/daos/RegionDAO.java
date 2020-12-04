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
import pkg40.models.Department;
import pkg40.models.Region;

/**
 *
 * @author Yoshua
 */
public class RegionDAO implements IRegionDAO {

    private final Connection CONN;
    private PreparedStatement ps;
    private String sql;

    //dependency
    public RegionDAO(Connection conn) {
        this.CONN = conn;
    }

    @Override
    public List<Region> getAllRegions() throws SQLException {
        List<Region> regions = new ArrayList<>();
        sql = "SELECT * FROM regions ORDER BY region_id";
        ps = CONN.prepareStatement(sql);
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
    public List<Region> getById(int id) throws SQLException {
        List<Region> regions = new ArrayList<>();
        sql = "SELECT * FROM regions WHERE region_id = ?";
        ps = CONN.prepareStatement(sql);
        ps.setInt(1, id);
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
    public List<Region> search(String keyword) throws SQLException {
        List<Region> regions = new ArrayList<>();
        if (keyword.equals("")) {
            return getAllRegions();
        }

        String sql = "SELECT * FROM regions WHERE region_id=? OR lower(region_name) LIKE lower(?) || '%'";
        ps = this.CONN.prepareStatement(sql);
        try {
            ps.setInt(1, Integer.parseInt(keyword));
        } catch (NumberFormatException e) {
            ps.setInt(1, 0);
        }
        ps.setString(2, keyword);

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
        sql = "INSERT INTO regions VALUES (?,?)";
        ps = CONN.prepareStatement(sql);
        ps.setInt(1, region.getId());
        ps.setString(2, region.getName());
        return 1 == ps.executeUpdate();

    }

    @Override
    public boolean updateRegion(Region region) throws SQLException {
        sql = "UPDATE regions SET region_id = ?, region_name = ? WHERE region_id = ?";
        ps = CONN.prepareStatement(sql);
        ps.setInt(1, region.getId());
        ps.setString(2, region.getName());
        ps.setInt(3, region.getId());
        return 1 == ps.executeUpdate();
    }

    @Override
    public boolean deleteRegion(int id) throws SQLException {
        sql = "DELETE FROM regions WHERE region_id = ?";
        ps = CONN.prepareStatement(sql);
        ps.setInt(1, id);
        return 1 == ps.executeUpdate();
    }

}
