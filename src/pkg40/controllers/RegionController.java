/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.controllers;

import java.sql.SQLException;
import java.util.List;
import pkg40.daos.RegionDAO;
import pkg40.daos.idaos.IRegionDAO;
import pkg40.models.Region;
import pkg40.tools.DBConnection;

/**
 *
 * @author Yoshua
 */
public class RegionController {

    private IRegionDAO irdao;

    private static boolean isNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()) {
            return false;
        }
        return true;
    }

    public RegionController() throws SQLException {
        this.irdao = new RegionDAO(new DBConnection().getConnection());
    }

    public List<Region> getData(String keyword) throws SQLException {
        if (isNullOrEmpty(keyword)) {
            return irdao.getAllRegions();
        }
        return irdao.search(keyword);
    }

    public String saveRegion(Region region) throws SQLException {
        if (irdao.getById(region.getId()).isEmpty()) {
            return (irdao.insertRegion(region) ? "Inserted" : "Failed");
        }
        return (irdao.updateRegion(region) ? "Updated" : "Failed");
    }

    public boolean deleteRegion(String id) throws SQLException {
        return irdao.deleteRegion(Integer.parseInt(id));
    }
}
