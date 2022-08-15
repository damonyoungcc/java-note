package com.github.note.o10Annotation.CacheAop;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    int cacheSeconds() default 60;
}
