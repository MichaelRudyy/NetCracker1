package com.netcracker.sorts;

import com.netcracker.annotations.SortMethod;
import com.netcracker.sorts.abstracts.AbstractBubbleSort;
import com.netcracker.sorts.abstracts.Sort;

/**
 * The class implements Reverse Bubble sort - {@code BubbleSortReverse}
 * Getting an instance of the class using (@code getInstance ()), which implements the Singleton pattern
 *
 * @author Michael Rudyy
 * @version 1.0
 * @link https://en.wikipedia.org/wiki/Bubble_sort
 * @see Sort
 */

public class BubbleSortReverse extends AbstractBubbleSort {

    static {
        Sort.addInstance(new BubbleSortReverse());
    }

    /**
     * Class instance
     */
    private static BubbleSortReverse instance = new BubbleSortReverse();

    /**
     * The method implements Singleton pattern
     * This prevents the formation of identical classes
     *
     * @return instance of a class
     */
    public static BubbleSortReverse getInstance() {
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
        sort(array,false);
    }
}
