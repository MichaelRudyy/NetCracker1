package com.netcracker.reflections;

import org.reflections.Reflections;
import org.reflections.scanners.FieldAnnotationsScanner;
import org.reflections.scanners.MethodAnnotationsScanner;

import java.lang.reflect.Method;
import java.util.Set;

/**
 * Reflection class get method by annotation.
 * Use Reflections lib.
 *
 * @author Michael Rudyy
 * @version 1.0
 * @link https://github.com/ronmamo/reflections
 */


public class Reflection {

    /**
     * Reflctions object that handle path of scan.
     */
    Reflections reflections;

    /**
     * Sets parametrs to (@code reflections)
     *
     * @param packagePath - path of scanning package
     */

    public Reflection(String packagePath) {
        this.reflections = new Reflections(packagePath, new MethodAnnotationsScanner(),new FieldAnnotationsScanner());
    }

    public Set<Method> getMethodsByAnnotation(Class annotationClass){
        return reflections.getMethodsAnnotatedWith(annotationClass);
    }

    public Set getInstance(Class annotationClass){
        return reflections.getFieldsAnnotatedWith(annotationClass);
    }
}
