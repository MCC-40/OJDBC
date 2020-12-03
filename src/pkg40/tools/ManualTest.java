/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.tools;

import java.sql.SQLException;
import java.util.List;
import pkg40.controllers.RegionController;
import pkg40.daos.RegionDAO;
import pkg40.daos.idaos.IRegionDAO;
import pkg40.models.Region;

/**
 *
 * @author Yoshua
 */
public class ManualTest {

    private static RegionController rc;

    public static void getDataTesting(String id) throws SQLException {
        List<Region> regions = rc.getData(id);
        for (Region region : regions) {
            System.out.println(region.getId() + " | " + region.getName());
        }
    }

    public static void saveRegionTesting(Region region) throws SQLException {
        System.out.println(rc.saveRegion(region));
    }

    public static void deleteTesting(String id) throws SQLException {
        System.out.println(rc.deleteRegion(id) ? "Berhasil" : "Gagal");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        rc = new RegionController();
        Region region = new Region(6, "South Asia");
        String keyword = "E";
        
        getDataTesting(keyword);
//        mt.saveRegionTesting(region);
//        mt.deleteTesting("6");
    }

}
