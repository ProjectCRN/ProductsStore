package com.netcracker.crm.entity;

import java.io.Serializable;

/**
 * Created by οκ on 12.11.2016.
 */
public class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;

    public AbstractEntity(){}

    public AbstractEntity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
