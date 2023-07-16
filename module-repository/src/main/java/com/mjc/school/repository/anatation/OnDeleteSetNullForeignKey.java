package com.mjc.school.repository.anatation;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnDeleteSetNullForeignKey {
}
