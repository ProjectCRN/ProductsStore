package com.netcracker.crm.entity;

/**
 * Created by egor on 23.10.2016.
 */

import java.io.Serializable;

public abstract class Entity extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getId();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Entity)) {
            return false;
        }
        Entity other = (Entity) obj;
        if (getId() != other.getId()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity [id=" + getId() + "]";
    }

    public Entity() {}

    public Entity(int id) {
        super(id);
    }

}
