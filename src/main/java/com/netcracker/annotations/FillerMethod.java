package com.netcracker.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This annotation mark "filler" methods
 * It can be used only for methods
 * It can be works on RunTime
 *
 * @author Michael Rudyy
 * @version 1.0
 */

@Target(ElementType.METHOD) // This annotation can be used only for methods
@Retention(RetentionPolicy.RUNTIME) // This annotation can be works on RunTime
public @interface FillerMethod {
}
