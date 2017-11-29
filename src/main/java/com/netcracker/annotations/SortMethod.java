package com.netcracker.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by Michael Rudyy on 26-Oct-17.
 */

/**
 * This annotation mark "sorts" methods
 * It can be used only for methods
 * It can be works on RunTime
 *
 * @author Michael Rudyy
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SortMethod {
}
