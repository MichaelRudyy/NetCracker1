package com.netcracker.sorts;

import com.netcracker.annotations.SortMethod;
import com.netcracker.sorts.abstracts.Sort;

/**
 * The class implements Quick sort - {@code Quick Sort}.
 * Getting an instance of the class using {@code getInstance ()}, which implements the Singleton pattern
 *
 * @author Michael Rudyy
 * @version 1.1
 * @link https://en.wikipedia.org/wiki/Quicksort
 * @see Sort
 */

public class QuickSort extends Sort {

    static {
        Sort.addInstance(new QuickSort());
    }

    /**
     * Class instance.
     */
    private static QuickSort instance = new QuickSort();

    /**
     * The method implements Singleton pattern.
     * This prevents the formation of identical classes.
     *
     * @return instance of a class
     */
    public static QuickSort getInstance() {
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

        quickSort(array, 0, array.length - 1);
    }


    /**
     * The method implements Quick sort.
     * Sorting is done when (@code left) <= (@code right).
     *
     * @param array - input array of int's
     * @param left  - index of left element
     * @param right - index of right element
     * @link https://en.wikipedia.org/wiki/Quicksort
     * @see QuickSort#sort(int[])
     */
    private void quickSort(int[] array, int left, int right) {
        if (left >= right) return;
        int pivot = array[(left + right) / 2]; // pivot - елемент по якому зрівнюються елементи масиву
        int index = pertition(array, left, right, pivot); // index - елемент по якому ділиться масив
        quickSort(array, left, index - 1);
        quickSort(array, index, right);
    }

    /**
     * The method implements sorting of the specified part of the array.
     *
     * @param array - input array of int's
     * @param left  - index of left element
     * @param right - index of right element
     * @param pivot - element that is compared with other during swap
     * @return left - index of left element
     * @see Sort#swap(int[], int, int)
     */
    private int pertition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] < pivot) {
                left++;
            }

            while (array[right] > pivot) {
                right--;
            }

            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }
}
