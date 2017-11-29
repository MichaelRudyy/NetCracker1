package com.netcracker.reflections;

import com.netcracker.annotations.FillerMethod;
import com.netcracker.annotations.SortMethod;
import com.netcracker.handlers.SortTimeHandler;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Analyzer class get data about fillers , sorts and sort times.
 *
 * @author Michael Rudyy
 * @version 1.1
 * @link https://github.com/ronmamo/reflections
 */

public class Analyzer {

    /**
     * Lenght of generated array.
     */
    static int arrayLenght;

    /**
     * Sets lenght of generated array
     *
     * @param arrayLenght - lenght of generated array
     */
    public static void setArrayLenght(int arrayLenght) {
        Analyzer.arrayLenght = arrayLenght;
    }

    /**
     * Method set up and analyse package by SortMethod and FillerMethod annotation
     *
     * @param packagePath - - path of scanning package
     * @return list - list of list (for each filler) that handle SortTimeHandler
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     */
    public static List<List<SortTimeHandler>> action(String packagePath) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Reflection reflection = new Reflection("com.netcracker");

        List<List<SortTimeHandler>> list = new ArrayList<>();
        Set<Method> SortMethod = reflection.getMethodsByAnnotation(SortMethod.class);
        Set<Method> FillerMethod = reflection.getMethodsByAnnotation(FillerMethod.class);

        long startTime, endTime;

        for (Method mFiller : FillerMethod) {
            List<SortTimeHandler> list1 = new ArrayList<>();
            int[] arr = (int[]) mFiller.invoke(null, arrayLenght);
            for (Method mSort : SortMethod) {
                startTime = System.nanoTime();
                mSort.invoke(mSort.getDeclaringClass().getMethod("getInstance").invoke(null), arr.clone());
                endTime = System.nanoTime();
                list1.add(new SortTimeHandler(mFiller.getName().substring(3),
                        mSort.getDeclaringClass().toString().replaceAll("class com.netcracker.sorts.", ""),
                        endTime - startTime));
            }
            list.add(list1);
        }
        return list;
    }
}