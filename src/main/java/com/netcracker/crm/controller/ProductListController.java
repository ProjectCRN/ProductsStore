package com.netcracker.crm.controller;


import com.netcracker.crm.services.ICartService;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.ISearchService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.netcracker.crm.entity.serviceEntity.SearchAttributes;
/**
 * Created by Ксения on 22.11.2016.
 */

@Controller
public class ProductListController {

    ApplicationContext context =
            new ClassPathXmlApplicationContext(new String[]{"SpringModule.xml"});
    private static final String PRODUCTS = "products";
    private static final String ITEM = "item";


    IProductService productService = (IProductService) context.getBean("productService");
    ICartService cartService = (ICartService) context.getBean("cartService");
    ISearchService searchService = (ISearchService) context.getBean("searchService");

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(ModelMap model) {

        model.addAttribute("productList", productService.getList(searchService.getSearchAttributes().getTypeId(),
                searchService.getSearchAttributes().getAttribute(),
                searchService.getSearchAttributes().getValues(),
                searchService.getSearchAttributes().getOperators()));
        model.addAttribute("types",searchService.getSearchAttributes().getTypes());
        model.addAttribute("currType",searchService.getSearchAttributes().getType());
        model.addAttribute("searchAttr", searchService.getSearchAttributes());
        return PRODUCTS;
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public String searchProducts(SearchAttributes searchAttr, ModelMap model) {
        searchService.validate(searchAttr);
        searchService.parseSearchAttributes();
        model.addAttribute("productList", productService.getList(
                searchService.getSearchAttributes().getTypeId(),
                searchService.getSearchAttributes().getAttribute(),
                searchService.getSearchAttributes().getValues(),
                searchService.getSearchAttributes().getOperators()));
        model.addAttribute("types",searchService.getSearchAttributes().getTypes());
        model.addAttribute("currType",searchService.getSearchAttributes().getType());
        model.addAttribute("searchAttr", searchService.getSearchAttributes());
        model.addAttribute("SearchRes", searchService.getSearchRes());
        return PRODUCTS;
    }

    @RequestMapping(value = "/addProduct/{id}", method = RequestMethod.GET)
    public void addProduct(@PathVariable String id, ModelMap model) {
        cartService.createCart(-2);
        cartService.addProduct(Integer.parseInt(id));


    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String item(@PathVariable String id, ModelMap model) {
        model.addAttribute("item",productService.getById(Integer.parseInt(id)));
        //model.addAttribute("item",productService.find(Integer.parseInt(id)));
        return ITEM;
    }

}
