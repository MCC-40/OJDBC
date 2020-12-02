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

    private RegionController rc;

    public ManualTest() throws SQLException {
        this.rc = new RegionController();
    }

    public void getDataTesting(String id) throws SQLException {
        List<Region> regions = rc.getData(id);
        for (Region region : regions) {
            System.out.println(region.getId() + " | " + region.getName());
        }
    }

    public void saveRegion(Region region) throws SQLException {
        System.out.println(rc.saveRegion(region) ? "Berhasil" : "Gagal");
    }

    public void deleteTesting(String id) throws SQLException {
        System.out.println(rc.deleteRegion(id) ? "Berhasil" : "Gagal");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ManualTest mt = new ManualTest();
        Region region = new Region(6, "South East Asia");
//        mt.deleteTesting("6");
//        mt.saveRegion(region);
//        mt.getDataTesting("1");
    }

}
