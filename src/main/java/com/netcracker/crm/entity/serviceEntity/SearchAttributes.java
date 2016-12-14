package com.netcracker.crm.entity.serviceEntity;

import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.enums.PhoneAtribute;
import com.netcracker.crm.entity.enums.TabletAtribute;

import java.util.ArrayList;
import java.util.List;


public class SearchAttributes {
    private String minPrice;
    private String maxPrice;
    private String minCapacity;
    private String maxCapacity;
    private String minBattery;
    private String maxBattery;
    private String name;
    private String type;
    private String numPerPage;

    private int typeId;
    private String attribute;
    private String operators;
    private String values;
    private boolean sortBy;

    private List<String> sortValues;

    public SearchAttributes() {
        numPerPage = "2";
        name = "A-Z";
        sortBy = true;
        if (getSortValues() == null) {
            sortValues = new ArrayList<>();
            sortValues.add("A-Z");
            sortValues.add("Z-A");
        }
    }

    public String getLists() {
        return attribute + " | " + operators + " | " + values;
    }

    public boolean getSortBy() {
        return sortBy;
    }

    public void setSortBy(boolean sortBy) {
        this.sortBy = sortBy;
    }

    public List<String> getSortValues() {
        return sortValues;
    }

    public void setSortValues(List<String> sortValues) {
        this.sortValues = sortValues;
    }

    public String getNumPerPage() {
        if (numPerPage == null) return "";
        return numPerPage;
    }

    public void setNumPerPage(String numPerPage) {
        this.numPerPage = numPerPage;
    }

    public String getMinPrice() {
        if (minPrice == null) return "";
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        if (maxPrice == null) return "";
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinCapacity() {
        if (minCapacity == null) return "";
        return minCapacity;
    }

    public void setMinCapacity(String minCapacity) {
        this.minCapacity = minCapacity;
    }

    public String getMaxCapacity() {
        if (maxCapacity == null) return "";
        return maxCapacity;
    }

    public void setMaxCapacity(String maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getMinBattery() {
        if (minBattery == null) return "";
        return minBattery;
    }

    public void setMinBattery(String minBattery) {
        this.minBattery = minBattery;
    }

    public String getMaxBattery() {
        if (maxBattery == null) return "";
        return maxBattery;
    }

    public void setMaxBattery(String maxBattery) {
        this.maxBattery = maxBattery;
    }

    public String getName() {
        if (name == null) return "";
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {

        if (type == null) return "";
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getAttribute() {
        if (attribute == null) return "";
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getOperators() {
        if (operators == null) return "";
        return operators;
    }

    public void setOperators(String operators) {
        this.operators = operators;
    }

    public String getValues() {
        if (values == null) return "";
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    public String getShownAttributes() {
        if (typeId == EntityType.Telephone.getTypeId()) {
            return PhoneAtribute.Capacity.getAtributeId() + "," + PhoneAtribute.Battery.getAtributeId();
        }
        return TabletAtribute.Capacity.getAtributeId() + "," + TabletAtribute.Battery.getAtributeId();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchAttributes)) return false;

        SearchAttributes that = (SearchAttributes) o;

        if (getMinPrice() != null ? !getMinPrice().equals(that.getMinPrice()) : that.getMinPrice() != null)
            return false;
        if (getMaxPrice() != null ? !getMaxPrice().equals(that.getMaxPrice()) : that.getMaxPrice() != null)
            return false;
        if (getMinCapacity() != null ? !getMinCapacity().equals(that.getMinCapacity()) : that.getMinCapacity() != null)
            return false;
        if (getMaxCapacity() != null ? !getMaxCapacity().equals(that.getMaxCapacity()) : that.getMaxCapacity() != null)
            return false;
        if (getMinBattery() != null ? !getMinBattery().equals(that.getMinBattery()) : that.getMinBattery() != null)
            return false;
        if (getMaxBattery() != null ? !getMaxBattery().equals(that.getMaxBattery()) : that.getMaxBattery() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        return getNumPerPage() != null ? getNumPerPage().equals(that.getNumPerPage()) : that.getNumPerPage() == null;

    }

    @Override
    public int hashCode() {
        int result = minPrice != null ? minPrice.hashCode() : 0;
        result = 31 * result + (maxPrice != null ? maxPrice.hashCode() : 0);
        result = 31 * result + (minCapacity != null ? minCapacity.hashCode() : 0);
        result = 31 * result + (maxCapacity != null ? maxCapacity.hashCode() : 0);
        result = 31 * result + (minBattery != null ? minBattery.hashCode() : 0);
        result = 31 * result + (maxBattery != null ? maxBattery.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + typeId;
        return result;
    }
}
