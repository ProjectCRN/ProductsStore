package com.netcracker.crm.services.parser;

import com.google.common.collect.BiMap;
import com.netcracker.crm.services.parser.exception.NoSuchIdXMLException;
import com.netcracker.crm.services.parser.exception.NoSuchTagException;


public abstract class AbstractTag {
    protected BiMap<String, Integer> tags;
    protected String typeName;

    public int getIdByName(String name) throws NoSuchTagException {
        int id;
        try {
            id = tags.get(name);
        } catch (RuntimeException e) {
            throw new NoSuchTagException(e.getMessage());
        }
        return id;
    }

    public String getNameById(int id) throws NoSuchIdXMLException {
        String name;
        try {
            name = tags.inverse().get(id);
        } catch (RuntimeException e) {
            throw new NoSuchIdXMLException(e.getMessage());
        }
        return name;
    }

    public boolean isCorrectId(int id) {
        return tags.containsValue(id);
    }

    public static AbstractTag getTag(int typeid) {
        switch (typeid) {
            case 9:
                return new TelephoneTag();
            case 10:
                return new TabletTag();
            case 7:
                return new OrderTag();
            case 8:
                return new ProductInOrderTag();
            case 11:
                return null;
            default:
                return null;
        }
    }

    public String getTypeName() {
        return typeName;
    }
}
