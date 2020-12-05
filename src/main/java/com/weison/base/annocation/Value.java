package com.weison.base.annocation;

import java.lang.annotation.*;
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Value {
	String value() default "1";
}
