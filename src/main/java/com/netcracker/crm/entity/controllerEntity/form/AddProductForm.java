package com.netcracker.crm.entity.controllerEntity.form;

import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.enums.PhoneAtribute;
import com.netcracker.crm.entity.enums.TabletAtribute;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ксения on 06.12.2016.
 */
public class AddProductForm {
    String name;
    String price;
    String summary;
    String operatingSystem;
    String processorSpeed;
    String capacity;
    String display;
    String height;
    String width;
    String depth;
    String weight;
    String camera;
    String battery;
    String simCard;
    String fabricator;
    String imageUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepth() {
        return depth;
    }

    public void setDepth(String depth) {
        this.depth = depth;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getProcessorSpeed() {
        return processorSpeed;
    }

    public void setProcessorSpeed(String processorSpeed) {
        this.processorSpeed = processorSpeed;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getCamera() {
        return camera;
    }

    public void setCamera(String camera) {
        this.camera = camera;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getSimCard() {
        return simCard;
    }

    public void setSimCard(String simCard) {
        this.simCard = simCard;
    }

    public String getFabricator() {
        return fabricator;
    }

    public void setFabricator(String fabricator) {
        this.fabricator = fabricator;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Value> getListValue(int typeid){

        List<Value> values = new ArrayList<>();
        if(typeid == EntityType.Telephone.getTypeId())
        {
            values.add(new Value(operatingSystem,typeid, PhoneAtribute.OperatingSystem.getAtributeId()));
            values.add(new Value(processorSpeed,typeid, PhoneAtribute.Processorspeed.getAtributeId()));
            values.add(new Value(capacity,typeid, PhoneAtribute.Capacity.getAtributeId()));
            values.add(new Value(display,typeid, PhoneAtribute.Display.getAtributeId()));
            values.add(new Value(height,typeid, PhoneAtribute.Height.getAtributeId()));
            values.add(new Value(width,typeid, PhoneAtribute.Width.getAtributeId()));
            values.add(new Value(depth,typeid, PhoneAtribute.Depth.getAtributeId()));
            values.add(new Value(weight,typeid, PhoneAtribute.Weight.getAtributeId()));
            values.add(new Value(camera,typeid, PhoneAtribute.Camera.getAtributeId()));
            values.add(new Value(battery,typeid, PhoneAtribute.Battery.getAtributeId()));
            values.add(new Value(simCard,typeid, PhoneAtribute.SIMCard.getAtributeId()));
        }

        else
        {
            values.add(new Value(operatingSystem,typeid, TabletAtribute.OperatingSystem.getAtributeId()));
            values.add(new Value(processorSpeed,typeid, TabletAtribute.Processorspeed.getAtributeId()));
            values.add(new Value(capacity,typeid, TabletAtribute.Capacity.getAtributeId()));
            values.add(new Value(display,typeid, TabletAtribute.Display.getAtributeId()));
            values.add(new Value(height,typeid, TabletAtribute.Height.getAtributeId()));
            values.add(new Value(width,typeid, TabletAtribute.Width.getAtributeId()));
            values.add(new Value(depth,typeid, TabletAtribute.Depth.getAtributeId()));
            values.add(new Value(weight,typeid, TabletAtribute.Weight.getAtributeId()));
            values.add(new Value(camera,typeid, TabletAtribute.Camera.getAtributeId()));
            values.add(new Value(battery,typeid, TabletAtribute.Battery.getAtributeId()));
            values.add(new Value(simCard,typeid, TabletAtribute.SIMCard.getAtributeId()));
        }


        return values;
    }
}
