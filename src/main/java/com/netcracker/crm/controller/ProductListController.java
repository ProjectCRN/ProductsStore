package com.netcracker.crm.controller;


import com.netcracker.crm.entity.User;
import com.netcracker.crm.entity.controllerEntity.NameSearch;
import com.netcracker.crm.entity.enums.EntityType;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.IPaginationService;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.ISearchService;
import com.netcracker.crm.services.impl.PaginationServiceImpl;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.netcracker.crm.entity.serviceEntity.SearchAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Ксения on 22.11.2016.
 */

@Controller
public class ProductListController {

    private static final String PRODUCTS = "products";
    private static final String ITEM = "item";
    private static final String NAME = "productsByName";

    private IProductService productService;
    private ISearchService searchService;
    private IPaginationService paginationService;

    private SearchAttributes searchAttributes;
    private User user;

    @Required
    public void setUser(User user) {
        this.user = user;
    }

    @Required
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }

    @Required
    public void setSearchService(ISearchService searchService) {
        this.searchService = searchService;
    }

    @Required
    public void setPaginationService(IPaginationService paginationService) {
        this.paginationService = paginationService;
    }

    public SearchAttributes getSearchAttributes() {
        return searchAttributes;
    }

    public void setSearchAttributes(SearchAttributes searchAttributes) {
        this.searchAttributes = searchAttributes;
    }

    @RequestMapping(value = "/products/{type}", method = RequestMethod.GET)
    public String products(@PathVariable String type, ModelMap model) {
        if(searchAttributes != null) {
            if(!(searchAttributes.getType() == null || searchAttributes.getType().equals(type)))
                searchAttributes.setType(type);

            searchService.validate(searchAttributes);
            searchService.parseSearchAttributes(searchAttributes);
        }
        else searchAttributes = new SearchAttributes();

        paginationService.setNumPerPage(Integer.parseInt(searchAttributes.getNumPerPage()));

        int typeid = findTypeId(type);
        List<Product> productList = productService.getList(
                typeid,
                searchAttributes.getAttribute(),
                searchAttributes.getValues(),
                searchAttributes.getOperators(),
                1,
                paginationService.getNumPerPage(),
                user.getRoleId(),
                searchAttributes.getSortBy());
        if (productList == null)
            productList = new ArrayList<>();

        model.addAttribute("productList", productList);
        model.addAttribute("currType", type);
        model.addAttribute("currSort", searchAttributes.getName());
        model.addAttribute("searchAttr", searchAttributes);
        int pageNumber = paginationService.calcPageNum(productService.rowCounter(
                typeid,
                searchAttributes.getAttribute(),
                searchAttributes.getValues(),
                searchAttributes.getOperators(), user.getRoleId()));
        paginationService.setPageNum(pageNumber);
        model.addAttribute("pages", paginationService.getPageNums(pageNumber,1));
        model.addAttribute("searchReq", "products/search");
        model.addAttribute("searchBtn", "search");
        model.addAttribute("searchName", new NameSearch());

        if (productList.isEmpty())
            model.addAttribute("emptyList", "sorry, nothing to show");
        model.addAttribute("role", user.getRoleId());
        return PRODUCTS;
    }

    private int findTypeId(String type){
        int typeid = 9;
        switch (type) {
            case "telephone":
                typeid = EntityType.Telephone.getTypeId();
                break;
            case "tablet":
                typeid = EntityType.Tablet.getTypeId();
                break;
        }
        return typeid;
    }


    @RequestMapping(value = "/products/search", method = RequestMethod.GET)
    public String searchProducts(SearchAttributes searchAttr, ModelMap model) {

        searchService.validate(searchAttr);
        searchService.parseSearchAttributes(searchAttr);
        paginationService.setNumPerPage(Integer.parseInt(searchAttr.getNumPerPage()));
        List<Product> productList = productService.getList(
                searchAttr.getTypeId(),
                searchAttr.getAttribute(),
                searchAttr.getValues(),
                searchAttr.getOperators(),
                1,
                paginationService.getNumPerPage(),
                user.getRoleId(),
                searchAttr.getSortBy());
        if (productList == null)
            productList = new ArrayList<>();
        if (productList.isEmpty())
            model.addAttribute("emptyList", "sorry, nothing to show");
        model.addAttribute("productList", productList);
        model.addAttribute("currType", searchAttr.getType());
        model.addAttribute("currSort", searchAttr.getName());
        model.addAttribute("searchAttr", searchAttr);
        this.setSearchAttributes(searchAttr);
        int pageNumber = paginationService.calcPageNum(productService.rowCounter(
                searchAttr.getTypeId(),
                searchAttr.getAttribute(),
                searchAttr.getValues(),
                searchAttr.getOperators(), user.getRoleId()));
        paginationService.setPageNum(pageNumber);
        model.addAttribute("pages", paginationService.getPageNums(pageNumber,1));
        model.addAttribute("searchReq", "products/search");
        model.addAttribute("searchBtn", "search");
        model.addAttribute("role", user.getRoleId());
        model.addAttribute("searchName", new NameSearch());
        setSearchAttributes(searchAttr);
        return PRODUCTS;
    }

    @RequestMapping(value = "/products/search/{type}/page/{pageNum}", method = RequestMethod.GET)
    public String searchProductsPages(SearchAttributes searchAttr, @PathVariable String type, @PathVariable String pageNum, ModelMap model) {

        searchService.validate(searchAttr);
        searchService.parseSearchAttributes(searchAttr);
        paginationService.setNumPerPage(Integer.parseInt(searchAttr.getNumPerPage()));
        SearchAttributes searchAttr2 = this.getSearchAttributes();
        int pagenum = Integer.parseInt(pageNum);
        int pageNumber = paginationService.getPageNum();
        if (!searchAttr.equals(searchAttr2)&&(searchAttr2 != null)) {
            pagenum = 1;
            pageNumber = paginationService.calcPageNum(productService.rowCounter(
                    searchAttr.getTypeId(),
                    searchAttr.getAttribute(),
                    searchAttr.getValues(),
                    searchAttr.getOperators(), user.getRoleId()));
            paginationService.setPageNum(pageNumber);
        }
        List<Product> productList = productService.getList(
                searchAttr.getTypeId(),
                searchAttr.getAttribute(),
                searchAttr.getValues(),
                searchAttr.getOperators(),
                pagenum,
                paginationService.getNumPerPage(),
                user.getRoleId(),
                searchAttr.getSortBy());
        if (productList == null)
            productList = new ArrayList<>();
        if (productList.isEmpty())
            model.addAttribute("emptyList", "sorry, nothing to show");
        model.addAttribute("productList", productList);
        model.addAttribute("currType", searchAttr.getType());
        model.addAttribute("currSort", searchAttr.getName());
        model.addAttribute("searchAttr", searchAttr);
        this.setSearchAttributes(searchAttr);

        model.addAttribute("pages", paginationService.getPageNums(pageNumber,pagenum));
        model.addAttribute("searchReq", "products/search");
        model.addAttribute("searchBtn", "search");
        model.addAttribute("searchName", new NameSearch());
        model.addAttribute("role", user.getRoleId());
        setSearchAttributes(searchAttr);
        return PRODUCTS;
    }

    @RequestMapping(value = "{type}/searchByName", method = RequestMethod.GET)
    public String searchByName( @PathVariable String type, NameSearch nameSearch, ModelMap model) {

        int typeid = findTypeId(type);

        nameSearch.validate();
        if(!nameSearch.getName().equals("")) {
            List<Product> productList = productService.searchByName(typeid, nameSearch.getName(), 1, Integer.MAX_VALUE-1, user.getRoleId(), true);

            if (productList == null)
                productList = new ArrayList<>();
            if (productList.isEmpty())
                model.addAttribute("emptyList", "sorry, nothing to show");
            model.addAttribute("productList", productList);
        }
        else model.addAttribute("emptyList", "please, input product name");

        model.addAttribute("role", user.getRoleId());
        return NAME;
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public String item(@PathVariable String id, ModelMap model) {
        model.addAttribute("item", productService.getById(Integer.parseInt(id)));
        return ITEM;
    }



}
