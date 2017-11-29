package com.netcracker.sorts.abstracts;

import com.netcracker.sorts.BubbleSort;

/**
 * Created by Michael Rudyy on 02-Nov-17.
 */
public class AbstractBubbleSort extends Sort {

    protected void sort(int[] array, boolean mode) {
        if ((array == null) && (array.length == 0)) {
            return;
        }

        boolean isSorted;

        for (int i = 0; i < array.length - 1; i++) {
            isSorted = true;
            if (mode) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (array[j] > array[j + 1]) {
                        isSorted = false;
                        swap(array, j, j + 1);
                    }
                }
            } else {
                for (int j = array.length - 2; j >= i; j--) {
                    if (array[j] > array[j + 1]) {
                        isSorted = false;
                        swap(array, j, j + 1);
                    }
                }
            }
            if (isSorted) {
                break;
            }
        }
    }

    @Override
    public void sort(int[] array) {

    }
}
