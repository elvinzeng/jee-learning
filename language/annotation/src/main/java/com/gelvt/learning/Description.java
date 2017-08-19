package com.gelvt.learning;

import java.lang.annotation.*;

/**
 * @author: Elvin Zeng
 * @date: 17-8-19.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Description {
    String value() default "no description";
}
