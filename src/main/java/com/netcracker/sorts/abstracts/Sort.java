package com.netcracker.sorts.abstracts;

import com.netcracker.annotations.SortInstance;
import com.netcracker.reflections.Reflection;
import com.netcracker.sorts.BubbleSort;

import java.util.*;

/**
 * Abstract class Sort
 * Implements (@code swap) and (@code sort) methods
 */

public abstract class Sort {

    static Set listOfSorts = new HashSet();

    static protected void addInstance(Sort sort){
        listOfSorts.add(sort);
    }

    static public Sort getSort(Class<? extends Sort> sortClass){
        Sort.update();
        System.out.println("BBB");
        Iterator<Sort> iter = listOfSorts.iterator();
        while (iter.hasNext()){
            Object sort = iter.next();
            System.out.println(sort.toString() + " : " + sortClass.isAssignableFrom(sort.getClass())+ " " + sortClass.toString());
            if (sortClass.isAssignableFrom(sort.getClass())) return (Sort) sort;
        }

        return null;
    }

    private static void update() {
        Reflection reflection = new Reflection("com.netcracker");
        listOfSorts = reflection.getInstance(SortInstance.class);
    }

    /**
     * Swap method.
     * Exchange possition of elements
     *
     * @param array - input array of int's
     * @param a     - index of first element that will be swaped with second
     * @param b     - index of second element that will be swaped with first
     */
    protected void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    /**
     * The method that should be implemented in the heirs of class Sort
     *
     * @param array - input array of int's
     * @see Sort
     */
    abstract public void sort(int[] array);
}
