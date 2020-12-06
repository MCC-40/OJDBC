/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg40.models;

/**
 *
 * @author asus
 */
public class Job {
    private String id;
    private String title;
    private int minSalary;
    private int maxSalary;

    public Job() {
    }

    public Job(String id, String title, int minSalary, int maxSalary) {
        this.id = id;
        this.title = title;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the minSalary
     */
    public int getMinSalary() {
        return minSalary;
    }

    /**
     * @param minSalary the minSalary to set
     */
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }

    /**
     * @return the maxSalary
     */
    public int getMaxSalary() {
        return maxSalary;
    }

    /**
     * @param maxSalary the maxSalary to set
     */
    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }

}
