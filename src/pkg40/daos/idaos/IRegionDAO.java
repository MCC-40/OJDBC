/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.daos.idaos;

import java.sql.SQLException;
import java.util.List;
import pkg40.models.Region;

/**
 *
 * @author Yoshua
 */
public interface IRegionDAO {

    public List<Region> getAllRegions() throws SQLException;

    public List<Region> getById(int id) throws SQLException;
    
    public List<Region> search(String input) throws SQLException ;
    
    public boolean insertRegion(Region region) throws SQLException;

    public boolean updateRegion(Region region) throws SQLException;

    public boolean deleteRegion(int id) throws SQLException;
 
}
