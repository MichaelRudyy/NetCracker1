package com.netcracker;

import com.netcracker.annotations.SortInstance;
import com.netcracker.generators.ArrayGenerator;
import com.netcracker.reflections.Analyzer;
import com.netcracker.reflections.Reflection;
import com.netcracker.sorts.BubbleSort;
import com.netcracker.sorts.MergeSort;
import com.netcracker.sorts.QuickSort;
import com.netcracker.sorts.abstracts.Sort;
import com.netcracker.xlsxwriter.XLSXWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Michael Rudyy on 26-Oct-17.
 */

public class Main {
    public static void main(String[] args) {
/*
        XLSXWriter writer = new XLSXWriter("result.xlsx");

        try {
            Analyzer.setArrayLenght(10);
            writer.writeTimeToFile(Analyzer.action("com.netcracker"));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }*/

Sort sort = Sort.getSort(BubbleSort.class);
        int[] a = new int[]{1,3,1,2,3,4};
        sort.sort(a);
        for (Integer aa:a) {
            System.out.println(aa);
        }
    }
}
