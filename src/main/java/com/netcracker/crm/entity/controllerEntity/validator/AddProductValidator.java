package com.netcracker.crm.entity.controllerEntity.validator;

import com.netcracker.crm.entity.controllerEntity.form.AddProductForm;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

/**
 * Created by Ксения on 06.12.2016.
 */
public class AddProductValidator {
    public boolean supports(Class<?> clazz) {
        return AddProductForm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        AddProductForm prod = (AddProductForm) target;

        String price = prod.getPrice();
        if (!(price.matches("\\d+(\\.\\d{0,2})?"))) {
            errors.rejectValue("price", "price.priceDontMatch", "price don't match.");
        }

        String height = prod.getHeight();
        if (!(height.matches("\\d+(\\.\\d{0,2})?"))) {
            errors.rejectValue("height", "height.heightDontMatch", "height don't match.");
        }

        String width = prod.getWidth();
        if (!(width.matches("\\d+(\\.\\d{0,2})?"))) {
            errors.rejectValue("width", "width.widthDontMatch", "width don't match.");
        }

        String depth = prod.getDepth();
        if (!(depth.matches("\\d+(\\.\\d{0,2})?"))) {
            errors.rejectValue("depth", "depth.depthDontMatch", "depth don't match.");
        }

        String display = prod.getDisplay();
        if (!(display.matches("\\d+(\\.\\d{0,1})?"))) {
            errors.rejectValue("display", "display.displayDontMatch", "display don't match.");
        }

        String capacity = prod.getCapacity();
        if (!(capacity.matches("[ 0-9]{1,}"))) {
            errors.rejectValue("capacity", "capacity.capacityDontMatch", "capacity don't match.");
        }

        String processorSpeed = prod.getProcessorSpeed();
        if (!(processorSpeed.matches("[ 0-9]{1,}"))) {
            errors.rejectValue("processorSpeed", "processorSpeed.processorSpeedDontMatch", "processorSpeed don't match.");
        }

        String weight = prod.getWeight();
        if (!(weight.matches("[ 0-9]{1,}"))) {
            errors.rejectValue("weight", "weight.weightDontMatch", "weight don't match.");
        }

        String camera = prod.getCamera();
        if (!(camera.matches("[ 0-9]{1,}"))) {
            errors.rejectValue("camera", "camera.cameraDontMatch", "camera don't match.");
        }

        String battery = prod.getBattery();
        if (!(battery.matches("[ 0-9]{1,}"))) {
            errors.rejectValue("battery", "battery.batteryDontMatch", "battery don't match.");
        }

        String summary = prod.getSummary();
        if (!(summary.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{5,140}$"))) {
            errors.rejectValue("summary", "summary.summaryDontMatch", "summary don't match.");
        }

        String operatingSystem = prod.getOperatingSystem();
        if (!(operatingSystem.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$"))) {
            errors.rejectValue("operatingSystem", "operatingSystem.operatingSystemDontMatch", "operatingSystem don't match.");
        }

        String simCard = prod.getSimCard();
        if (!(simCard.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$"))) {
            errors.rejectValue("simCard", "simCard.simCardDontMatch", "simCard don't match.");
        }

        String fabricator = prod.getFabricator();
        if (!(fabricator.matches("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$"))) {
            errors.rejectValue("fabricator", "fabricator.fabricatorDontMatch", "fabricator don't match.");
        }

        String imageUrl = prod.getImageUrl();
        if (!(imageUrl.matches("(http|https)\\:\\/\\/[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(\\/\\S*)?(\\w+.(jpg|png|gif))"))) {
            errors.rejectValue("imageUrl", "imageUrl.imageUrlDontMatch", "imageUrl don't match.");
        }

    }
}
