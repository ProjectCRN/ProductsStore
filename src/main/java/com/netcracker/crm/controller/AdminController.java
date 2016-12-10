package com.netcracker.crm.controller;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.controllerEntity.form.AddProductForm;
import com.netcracker.crm.entity.controllerEntity.validator.AddProductValidator;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.enums.PhoneAtribute;
import com.netcracker.crm.entity.enums.TabletAtribute;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.entity.serviceEntity.ProductFieldsPatterns;
import com.netcracker.crm.services.IPatternsService;
import com.netcracker.crm.services.IProductService;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by egor on 24.10.2016.
 */
@Controller
public class AdminController {
    private static final String ADDING = "newProduct";
    private static final String NO_ROOTS = "noRoots";
    private static final String SUCCESS = "register-success";
    private User user;
    private AddProductValidator addProductValidator;
    private IProductService productService;
    private IPatternsService patternsService;

    @Required
    public void setAddProductValidator(AddProductValidator addProductValidator) {
        this.addProductValidator = addProductValidator;
    }

    @Required
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    @Required
    public void setPatternsService(IPatternsService patternsService) {
        this.patternsService = patternsService;
    }


    @Required
    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping(value = "/newProduct/{type}", method = RequestMethod.GET)
    public String newProd(@PathVariable String type, ModelMap model) {
        if (!user.isAdmin())
            return NO_ROOTS;
        model.put("prod", new AddProductForm());
        model.put("currType", type);
        model.addAttribute("pattern", patternsService.getProductFieldsPatterns());
        model.put("prev",0);

        return ADDING;
    }

    @RequestMapping(value = "/updateProduct/{type}/{id}", method = RequestMethod.GET)
    public String updateProd(@PathVariable String type, @PathVariable String id, ModelMap model) {
        if (!user.isAdmin())
            return NO_ROOTS;
        Product prod = productService.getById(Integer.parseInt(id));
        AddProductForm form = new AddProductForm();
        form.setValuesFromProd(prod);
        model.put("prod", form);
        model.put("currType", type);
        model.addAttribute("pattern", patternsService.getProductFieldsPatterns());
        model.put("id",prod.getId());
        model.put("prev",1);

        return ADDING;
    }

    @RequestMapping(value = "/newProduct/{type}", method = RequestMethod.POST)
    public String addNewProd(AddProductForm addProductForm, BindingResult result, @PathVariable String type, ModelMap model) {

        addProductValidator.validate(addProductForm, result);
        if (result.hasErrors()) {
            return ADDING;
        }
        if (!user.isAdmin())
            return NO_ROOTS;
        int typeid = 9;
        Product prod = new Product();

        switch (type) {
            case "telephone":
                typeid = EntityType.Telephone.getTypeId();
                break;
            case "tablet":
                typeid = EntityType.Tablet.getTypeId();
                break;
        }

        prod.setIsActive(true);
        prod.setEntityName(addProductForm.getName());
        prod.setUserId(-2);
        prod.setEntityTypeId(typeid);
        prod.setPrice(Double.parseDouble(addProductForm.getPrice()));
        prod.setSummary(addProductForm.getSummary());
        if(addProductForm.getFabricator().equals(""))
            addProductForm.setFabricator("Unknown");
        prod.setFabricator(addProductForm.getFabricator());
        if(addProductForm.getImageUrl().equals(""))
            addProductForm.setImageUrl("/resources/img/img_phone.jpg");
        prod.setImageUrl(addProductForm.getImageUrl());

        setValueList(typeid,prod,addProductForm);
        productService.add(prod);
        model.addAttribute("hello", "Product created");
        return SUCCESS;
    }

    @RequestMapping(value = "/updateProduct/{type}/{id}", method = RequestMethod.POST)
    public String addNewProd(AddProductForm addProductForm, BindingResult result, @PathVariable String type, @PathVariable String id, ModelMap model) {

        addProductValidator.validate(addProductForm, result);
        if (result.hasErrors()) {
            return ADDING;
        }
        if (!user.isAdmin())
            return NO_ROOTS;
        int typeid = 9;
        Product prod = productService.getById(Integer.parseInt(id));

        switch (type) {
            case "telephone":
                typeid = EntityType.Telephone.getTypeId();
                break;
            case "tablet":
                typeid = EntityType.Tablet.getTypeId();
                break;
        }

        prod.setEntityName(addProductForm.getName());
        prod.setUserId(-2);
        prod.setEntityTypeId(typeid);
        prod.setPrice(Double.parseDouble(addProductForm.getPrice()));
        prod.setSummary(addProductForm.getSummary());
        if(addProductForm.getFabricator().equals(""))
            addProductForm.setFabricator("Unknown");
        prod.setFabricator(addProductForm.getFabricator());
        if(addProductForm.getImageUrl().equals(""))
            addProductForm.setImageUrl("/resources/img/img_phone.jpg");
        prod.setImageUrl(addProductForm.getImageUrl());

        setValueList(typeid,prod,addProductForm);
        productService.updateByProduct(prod);
        model.addAttribute("hello", "Product updated");
        return SUCCESS;
    }


    @RequestMapping(value = "/deleteProduct/{type}/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable String type, @PathVariable String id, ModelMap model) {
        if (!user.isAdmin())
            return NO_ROOTS;
        productService.delete(Integer.parseInt(id));
        return "redirect:/products/" + type;
    }

    @RequestMapping(value = "/restoreProduct/{type}/{id}", method = RequestMethod.GET)
    public String restore(@PathVariable String type, @PathVariable String id, ModelMap model) {
        if (!user.isAdmin())
            return NO_ROOTS;
        productService.restore(Integer.parseInt(id));
        return "redirect:/products/" + type;
    }

    public void setValueList(int typeid, Product prod, AddProductForm addProductForm)
    {
        if (typeid == EntityType.Telephone.getTypeId()) {
            prod.setValueInList(PhoneAtribute.Capacity.getAtributeId(), addProductForm.getCapacity());
            prod.setValueInList(PhoneAtribute.Battery.getAtributeId(), addProductForm.getBattery());

            if(!addProductForm.getOperatingSystem().equals(""))
                prod.setValueInList(PhoneAtribute.OperatingSystem.getAtributeId(), addProductForm.getOperatingSystem());
            if(!addProductForm.getProcessorSpeed().equals(""))
                prod.setValueInList(PhoneAtribute.Processorspeed.getAtributeId(), addProductForm.getProcessorSpeed());
            if(!addProductForm.getDisplay().equals(""))
                prod.setValueInList(PhoneAtribute.Display.getAtributeId(), addProductForm.getDisplay());
            if(!addProductForm.getHeight().equals(""))
                prod.setValueInList(PhoneAtribute.Height.getAtributeId(), addProductForm.getHeight());
            if(!addProductForm.getWidth().equals(""))
                prod.setValueInList(PhoneAtribute.Width.getAtributeId(), addProductForm.getWidth());
            if(!addProductForm.getDepth().equals(""))
                prod.setValueInList(PhoneAtribute.Depth.getAtributeId(), addProductForm.getDepth());
            if(!addProductForm.getWeight().equals(""))
                prod.setValueInList(PhoneAtribute.Weight.getAtributeId(), addProductForm.getWeight());
            if(!addProductForm.getCamera().equals(""))
                prod.setValueInList(PhoneAtribute.Camera.getAtributeId(), addProductForm.getCamera());
            if(!addProductForm.getSimCard().equals(""))
                prod.setValueInList(PhoneAtribute.SIMCard.getAtributeId(), addProductForm.getSimCard());
        } else {
            prod.setValueInList(TabletAtribute.Capacity.getAtributeId(), addProductForm.getCapacity());
            prod.setValueInList(TabletAtribute.Battery.getAtributeId(), addProductForm.getBattery());

            if(!addProductForm.getOperatingSystem().equals(""))
                prod.setValueInList(TabletAtribute.OperatingSystem.getAtributeId(), addProductForm.getOperatingSystem());
            if(!addProductForm.getProcessorSpeed().equals(""))
                prod.setValueInList(TabletAtribute.Processorspeed.getAtributeId(), addProductForm.getProcessorSpeed());
            if(!addProductForm.getDisplay().equals(""))
                prod.setValueInList(TabletAtribute.Display.getAtributeId(), addProductForm.getDisplay());
            if(!addProductForm.getHeight().equals(""))
                prod.setValueInList(TabletAtribute.Height.getAtributeId(), addProductForm.getHeight());
            if(!addProductForm.getWidth().equals(""))
                prod.setValueInList(TabletAtribute.Width.getAtributeId(), addProductForm.getWidth());
            if(!addProductForm.getDepth().equals(""))
                prod.setValueInList(TabletAtribute.Depth.getAtributeId(), addProductForm.getDepth());
            if(!addProductForm.getWeight().equals(""))
                prod.setValueInList(TabletAtribute.Weight.getAtributeId(), addProductForm.getWeight());
            if(!addProductForm.getCamera().equals(""))
                prod.setValueInList(TabletAtribute.Camera.getAtributeId(), addProductForm.getCamera());
            if(!addProductForm.getSimCard().equals(""))
                prod.setValueInList(TabletAtribute.SIMCard.getAtributeId(), addProductForm.getSimCard());
        }
    }
}
