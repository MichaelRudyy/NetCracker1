package com.netcracker.sorts;

import com.netcracker.annotations.SortInstance;
import com.netcracker.annotations.SortMethod;
import com.netcracker.sorts.abstracts.AbstractBubbleSort;
import com.netcracker.sorts.abstracts.Sort;

/**
 * The class implements Bubble sort - {@code BubbleSort]
 * Getting an instance of the class using {@code getInstance ()}, which implements the Singleton pattern
 *
 * @author Michael Rudyy
 * @version 1.2
 * @link https://en.wikipedia.org/wiki/Bubble_sort
 * @see Sort
 */


public class BubbleSort extends AbstractBubbleSort {

    /**
     * Class instance
     */
    @SortInstance
    private static BubbleSort instance = new BubbleSort() ;

    /**
     * The method implements Singleton pattern
     * This prevents the formation of identical classes
     *
     * @return instance of a class
     */

    public static BubbleSort getInstance() {
    return instance;
    }


    /**
     * The method implements Bubble sort
     *
     * @param array - input array of int's
     * @see Sort#sort(int[])
     */
    @SortMethod
    @Override
    public void sort(int[] array) {
        sort(array, true);
    }
}
