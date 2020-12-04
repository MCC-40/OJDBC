/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pkg40.daos.RegionDAO;
import pkg40.daos.idaos.IRegionDAO;
import pkg40.models.Region;
import pkg40.tools.DBConnection;

/**
 *
 * @author asus
 */
public class RegionController {

    private IRegionDAO irdao;

    public RegionController() throws SQLException{
        this.irdao = new RegionDAO(new DBConnection().getConnection());
    }    
    
    public List<Region> getAllRegions() throws SQLException{
        List<Region> regions = irdao.getAllRegions();
        return regions;
    }
    
    
    public boolean insertRegion(Region region) throws SQLException{
        return irdao.insertRegion(region);
    }
    
    
    public boolean updateRegion(Region region) throws SQLException{
        return irdao.updateRegion(region);
    }
    
    
    public boolean deleteRegion(int id) throws SQLException{
        return irdao.deleteRegion(id);
    }
    
    
    public List<Region> searchRegion(String word) throws SQLException{
        if (word.isEmpty())
            return irdao.getAllRegions();
        else{
//            List<Region> regions = new ArrayList<>();
//            regions.add(irdao.getById(Integer.parseInt(word)));
            return irdao.search(word); 
        }
    }
    
    public String saveRegion(Region region) throws SQLException{
         if (irdao.getById(region.getId()) == null)
             return (irdao.insertRegion(region) ? "Inserted" : "Failed");
         else
             return (irdao.updateRegion(region) ? "Updated" : "Failed"); 
    }
}
