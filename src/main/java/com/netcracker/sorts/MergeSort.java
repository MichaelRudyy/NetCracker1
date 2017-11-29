package com.netcracker.sorts;

import com.netcracker.annotations.SortMethod;
import com.netcracker.sorts.abstracts.Sort;

import java.util.Arrays;

/**
 * The class implements Merge sort - {@code Merge Sort}.
 * Getting an instance of the class using {@code getInstance()}, which implements the Singleton pattern
 *
 * @author Michael Rudyy
 * @version 1.2
 * @link https://en.wikipedia.org/wiki/Merge_sort
 * @see Sort
 */


public class MergeSort extends Sort {

    static {
        Sort.addInstance(new MergeSort());
    }

    /**
     * Class instance
     */
    private static MergeSort instance = new MergeSort();

    /**
     * The method implements Singleton pattern.
     * This prevents the formation of identical classes.
     *
     * @return instance of a class
     */
    public static MergeSort getInstance() {
        return instance;
    }

    /**
     * The method that sets parameters of sorting.
     *
     * @param array - input array of int's
     * @see Sort#sort(int[])
     */
    @SortMethod
    @Override
    public void sort(int[] array) {
        if((array == null)&&(array.length == 0)){
            return;
        }

        devide(array, 0, array.length);
    }

    /**
     * The method implements devide of array.
     * When (@code end - start <= 1) , all sort parts of array will merge.
     *
     * @param array - input array of int's
     * @param start - start index of array
     * @param end   - end index of array
     */
    private void devide(int[] array, int start, int end) {
        if (end - start > 1) {
            devide(array, start, start + (end - start) / 2);
            devide(array, start + (end - start) / 2, end);
            merge(array, start, end);
        }
    }

    /**
     * The method start merge all sorted parts of array and sort them among themselves.
     *
     * @param array - input array of int's
     * @param start - start index of array
     * @param end   - end index of array
     */
    private void merge(int[] array, int start, int end) {
        int leftArray[] = Arrays.copyOfRange(array, start, start + (end - start) / 2);
        int rightArray[] = Arrays.copyOfRange(array, start + (end - start) / 2, end);

        int left = 0;
        int right = 0;
        int arrayCounter = start;

        while ((left < leftArray.length) && (right < rightArray.length)) {
            if (leftArray[left] < rightArray[right]) {
                array[arrayCounter] = leftArray[left];
                left++;
            } else {
                array[arrayCounter] = rightArray[right];
                right++;
            }
            arrayCounter++;
        }

        while (left < leftArray.length) {
            array[arrayCounter] = leftArray[left];
            left++;
            arrayCounter++;
        }

        while (right < rightArray.length) {
            array[arrayCounter] = rightArray[right];
            right++;
            arrayCounter++;
        }
    }

}

