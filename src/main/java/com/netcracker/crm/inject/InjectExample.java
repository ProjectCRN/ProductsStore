package com.netcracker.crm.inject;

import java.lang.annotation.*;

/**
 * Created by egor on 24.10.2016.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectExample {
    public String value();
}
