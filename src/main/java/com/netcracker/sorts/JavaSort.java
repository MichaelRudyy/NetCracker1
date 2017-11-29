package com.netcracker.sorts;

import com.netcracker.annotations.SortMethod;
import com.netcracker.sorts.abstracts.Sort;

import java.util.Arrays;

/**
 * The class wrap Array.Sort
 * Getting an instance of the class using {@code getInstance()}, which implements the Singleton pattern
 *
 * @author Michael Rudyy
 * @version 1.2
 * @see Arrays#sort(int[])
 */

public class JavaSort extends Sort {

    static {
        Sort.addInstance(new JavaSort());
    }

    /**
     * Class instance
     */
    private static JavaSort instance = new JavaSort();

    /**
     * The method implements Singleton pattern
     * This prevents the formation of identical classes
     *
     * @return instance of a class
     */
    public static JavaSort getInstance() {
        return instance;
    }

    /**
     * The sort method that use Arrays.sort
     *
     * @param array - input array of int's
     */
    @SortMethod
    @Override
    public void sort(int[] array) {
        if((array == null)&&(array.length == 0)){
            return;
        }

        Arrays.sort(array);
    }
}
