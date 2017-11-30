package com.netcracker.sorts;

import com.netcracker.annotations.SortMethod;
import com.netcracker.sorts.abstracts.Sort;

import java.sql.Array;
import java.util.Arrays;

/**
 * The class implements Exchange sort - {@code ExchangeSort}
 * Getting an instance of the class using (@code getInstance ()), which implements the Singleton pattern
 *
 * @author Michael Rudyy
 * @version 1.0
 * @see Sort
 */

public class ExchangeSort extends Sort {

    static {
        Sort.addInstance(new ExchangeSort());
    }

    /**
     * Class instance
     */
    private static ExchangeSort instance = new ExchangeSort();

    /**
     * The method implements Singleton pattern
     * This prevents the formation of identical classes
     *
     * @return instance of a class
     */
    public static ExchangeSort getInstance() {
        return instance;
    }

    /**
     * The method implements Exchange sorting
     *
     * @param array - input array of int's
     * @see Sort#sort(int[])
     */
    @SortMethod
    @Override
    public void sort(int[] array) {

/*        if((array == null)&&(array.length == 0)){
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }*/

        Arrays.sort(array);
    }
}
