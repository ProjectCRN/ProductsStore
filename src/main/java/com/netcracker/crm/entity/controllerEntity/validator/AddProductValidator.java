package com.netcracker.crm.entity.controllerEntity.validator;

import com.netcracker.crm.entity.controllerEntity.form.AddProductForm;
import com.netcracker.crm.entity.serviceEntity.ProductFieldsPatterns;
import com.netcracker.crm.services.IPatternsService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.Errors;


public class AddProductValidator {

    IPatternsService patternsService;

    @Required
    public void setPatternsService(IPatternsService patternsService) {
        this.patternsService = patternsService;
    }

    public boolean supports(Class<?> clazz) {
        return AddProductForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {

        ProductFieldsPatterns patterns = patternsService.getProductFieldsPatterns();
        AddProductForm prod = (AddProductForm) target;

        String price = prod.getPrice();
        if (!(price.matches(patterns.getPrice()))) {
            errors.rejectValue("price", "price.priceDontMatch", "price don't match.");
        }

        String height = prod.getHeight();
        if (!(height.equals("") || height.matches(patterns.getHeight()))) {
            errors.rejectValue("height", "height.heightDontMatch", "height don't match.");
        }

        String width = prod.getWidth();
        if (!(width.equals("") || width.matches(patterns.getWidth()))) {
            errors.rejectValue("width", "width.widthDontMatch", "width don't match.");
        }

        String depth = prod.getDepth();
        if (!(depth.equals("") || depth.matches(patterns.getDepth()))) {
            errors.rejectValue("depth", "depth.depthDontMatch", "depth don't match.");
        }

        String display = prod.getDisplay();
        if (!(display.equals("") || display.matches(patterns.getDisplay()))) {
            errors.rejectValue("display", "display.displayDontMatch", "display don't match.");
        }

        String capacity = prod.getCapacity();
        if (!(capacity.matches(patterns.getCapacity()))) {
            errors.rejectValue("capacity", "capacity.capacityDontMatch", "capacity don't match.");
        }

        String processorSpeed = prod.getProcessorSpeed();
        if (!(processorSpeed.equals("") || processorSpeed.matches(patterns.getProcessorSpeed()))) {
            errors.rejectValue("processorSpeed", "processorSpeed.processorSpeedDontMatch", "processorSpeed don't match.");
        }

        String weight = prod.getWeight();
        if (!(weight.equals("") || weight.matches(patterns.getWeight()))) {
            errors.rejectValue("weight", "weight.weightDontMatch", "weight don't match.");
        }

        String camera = prod.getCamera();
        if (!(camera.equals("") || camera.matches(patterns.getCamera()))) {
            errors.rejectValue("camera", "camera.cameraDontMatch", "camera don't match.");
        }

        String battery = prod.getBattery();
        if (!(battery.matches(patterns.getBattery()))) {
            errors.rejectValue("battery", "battery.batteryDontMatch", "battery don't match.");
        }

        String summary = prod.getSummary();
        if (!(summary.matches(patterns.getSummary()))) {
            errors.rejectValue("summary", "summary.summaryDontMatch", "summary don't match.");
        }

        String operatingSystem = prod.getOperatingSystem();
        if (!(operatingSystem.equals("") || operatingSystem.matches(patterns.getOperatingSystem()))) {
            errors.rejectValue("operatingSystem", "operatingSystem.operatingSystemDontMatch", "operatingSystem don't match.");
        }

        String name = prod.getName();
        if (!(name.matches(patterns.getName()))) {
            errors.rejectValue("name", "name.nameDontMatch", "name don't match.");
        }

        String simCard = prod.getSimCard();
        if (!(simCard.equals("") || simCard.matches(patterns.getSimCard()))) {
            errors.rejectValue("simCard", "simCard.simCardDontMatch", "simCard don't match.");
        }

        String fabricator = prod.getFabricator();
        if (!(fabricator.equals("") || fabricator.matches(patterns.getFabricator()))) {
            errors.rejectValue("fabricator", "fabricator.fabricatorDontMatch", "fabricator don't match.");
        }

        String imageUrl = prod.getImageUrl();
        if (!(imageUrl.equals("") || imageUrl.matches(patterns.getImageUrl()))) {
            errors.rejectValue("imageUrl", "imageUrl.imageUrlDontMatch", "imageUrl don't match.");
        }

    }
}
