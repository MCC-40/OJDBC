/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.tools;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import pkg40.controllers.RegionController;
import pkg40.models.Region;

/**
 *
 * @author Mochamad Yusuf
 */
public class ManualTest {

    private final RegionController rc;

    public ManualTest() throws SQLException {
        rc = new RegionController();
    }

    public void getAllTesting() throws SQLException {
        List<Region> regions = rc.getAllRegions();
        for (Region region : regions) {
            System.out.println(region.getId() + " | " + region.getName());
        }
    }

    public void insertTesting() throws SQLException {
        System.out.println(rc.insertRegion(new Region(6, "South East Asia")) ? "Berhasil" : "Gagal");
    }

    public void updateTesting() throws SQLException {
        System.out.println(rc.updateRegion(new Region(6, "South Asia")) ? "Berhasil" : "Gagal");
    }

    public void deleteTesting() throws SQLException {
        System.out.println(rc.deleteRegion(6) ? "Berhasil" : "Gagal");
    }

    public void searchTesting() throws SQLException {
        System.out.print("Kata kunci = ");
        Scanner myObj = new Scanner(System.in);
        String input = myObj.nextLine();
        List<Region> regions = rc.searchRegion(input);
        if (regions.isEmpty()) {
            System.out.println("No match");
        }
        for (Region region : regions) {
            System.out.println(region.getId() + " | " + region.getName());
        }
    }

    public void saveTesting() throws SQLException {
        System.out.println(rc.saveRegion(new Region(6, "South East Asia")));
        getAllTesting();
        System.out.println(rc.saveRegion(new Region(6, "South Asia")));
        getAllTesting();
    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        System.out.println(new DBConnection().getConnection());
        ManualTest mt = new ManualTest();
//        mt.insertTesting();
//        mt.getAllTesting();
//        
//        mt.updateTesting();
//        mt.getAllTesting();

//        mt.deleteTesting();
        mt.getAllTesting();
        
//        mt.searchTesting();
//        mt.saveTesting();
    }

}
