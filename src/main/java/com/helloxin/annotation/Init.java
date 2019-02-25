package com.helloxin.annotation;

import java.lang.annotation.*;

/**
 * Created by nandiexin on 2019/2/22.
 */
@Documented
@Inherited
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Init {
    public String value() default "";
}
