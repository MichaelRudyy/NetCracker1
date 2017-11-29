package com.netcracker.handlers;

/**
 * Class used for save type of generation , type of sort and sort time
 * @author Michael Rudyy
 * @version 1.0
 */
public class SortTimeHandler {

    /**
     * Type of array generation
     */
    private String typeOfArray;

    /**
     * Type of array sort
     */
    private String typeOfSort;

    /**
     * Sort time
     */
    private long timeOfExecution;

    /**
     * Constructor
     * @param typeOfArray - type of array generation
     * @param typeOfSort - Type of array sort
     * @param timeOfExecution - sort time
     */
    public SortTimeHandler(String typeOfArray, String typeOfSort, long timeOfExecution) {
        this.typeOfArray = typeOfArray;
        this.typeOfSort = typeOfSort;
        this.timeOfExecution = timeOfExecution;
    }

    /**
     * Method helps get type of array generation
     * @return type of array generation
     */
    public String getTypeOfArray() {
        return typeOfArray;
    }

    /**
     * Method helps get type of array sort
     * @return type of array sort
     */
    public String getTypeOfSort() {
        return typeOfSort;
    }

    /**
     * Method helps get sort time
     * @return sort time
     */
    public long getTimeOfExecution() {
        return timeOfExecution;
    }
}
