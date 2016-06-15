package org.yyf.gradleDemo.common.profiler;

import java.lang.annotation.*;

/**
 * Created by tobi on 16-6-14.
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RMI {
}
