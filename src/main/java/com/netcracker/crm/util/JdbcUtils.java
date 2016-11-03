package com.netcracker.crm.util;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by egor on 29.10.2016.
 */
public final class JdbcUtils {

    public static void closeQuietly(AutoCloseable resource){
        if (resource != null){
            try {
                resource.close();
            } catch (Exception e) {
                /*NOP*/
            }
        }
    }

    public static void closeQuietly(AutoCloseable... resources){
        for (AutoCloseable resource : resources){
            closeQuietly(resource);
        }
    }

}
