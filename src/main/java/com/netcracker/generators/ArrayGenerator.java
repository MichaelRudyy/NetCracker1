package com.netcracker.generators;

import com.netcracker.annotations.FillerMethod;

import java.util.Random;

/**
 * Array generator class
 *
 * @author Michael Rudyy
 * @version 1.0
 */

public class ArrayGenerator {
    /**
     * Random uses in getRandomArray() and getSortedWithLastRandomElementArray()
     *
     * @see ArrayGenerator#getRandomArray(int)
     * @see ArrayGenerator#getSortedWithLastRandomElementArray(int)
     */
    static Random random = new Random();

    /**
     * Create and return sorted array
     *
     * @param lenght - lenght of returing array
     * @return sorted int[] from 1 to lenght
     */
    @FillerMethod
    public static int[] getSortedArray(int lenght) {

        if (!checkLenghtAccepted(lenght)) return new int[0];
        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    /**
     * Create and return array with random elements
     *
     * @param lenght - lenght of returing array
     * @return random int[] with elements from 1 to lenght
     */
    @FillerMethod
    public static int[] getRandomArray(int lenght) {

        if (!checkLenghtAccepted(lenght)) return new int[0];

        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            array[i] = random.nextInt(lenght);
        }
        return array;
    }

    /**
     * Create and return reverse-sort array
     *
     * @param lenght - lenght of returing array
     * @return sorted int[] from lenght to 1
     */
    @FillerMethod
    public static int[] getReverseSortedArray(int lenght) {

        if (!checkLenghtAccepted(lenght)) return new int[0];

        int[] array = new int[lenght];
        for (int i = 0; i < lenght; i++) {
            array[lenght - i - 1] = i + 1;
        }
        return array;
    }

    /**
     * Create and return sorted array with random last element
     *
     * @param lenght - lenght of returing array
     * @return sorted int[] from 1 to lenght-1 with random last element
     */
    @FillerMethod
    public static int[] getSortedWithLastRandomElementArray(int lenght) {

        if (!checkLenghtAccepted(lenght)) return new int[0];

        int[] array = new int[lenght];
        for (int i = 0; i < lenght - 1; i++) {
            array[i] = i + 1;
        }
        array[lenght - 1] = random.nextInt(lenght);
        return array;
    }

    private static boolean checkLenghtAccepted(int lenght){
        if (lenght < 0){
            return false;
        }else {
            return true;
        }
    }
}
