package com.netcracker.crm.services.parser;

import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.exception.ServiceException;
import com.netcracker.crm.services.listworker.ProductListWorker;
import com.netcracker.crm.services.parser.exception.NoSuchTagException;
import com.netcracker.crm.services.parser.exception.WrongXMLSchemaException;
import javafx.util.Pair;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Required;


import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by egor on 26.11.2016.
 */

public class CatalogParser {


    private IProductService productService;
    TelephoneTag telephoneTag;
    TabletTag tabletTag;
    TypeAttribute typeAttribute;

    @Required
    public void setProductService(IProductService productService) {
        this.productService = productService;
    }
    @Required
    public void setTelephoneTag(TelephoneTag telephoneTag) {
        this.telephoneTag = telephoneTag;
    }
    @Required
    public void setTabletTag(TabletTag tabletTag) {
        this.tabletTag = tabletTag;
    }
    @Required
    public void setTypeAttribute(TypeAttribute typeAttribute) {
        this.typeAttribute = typeAttribute;
    }

    public void exportCatalog(String url) throws ServiceException {


        try {
            Document document = DocumentHelper.createDocument();
            Namespace xmlns = DocumentHelper.createNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
            Element catalogElement = document.addElement("catalog");
            catalogElement.add(xmlns);
            catalogElement.addAttribute(QName.get("noNamespaceSchemaLocation","xsi","http://www.w3.org/2001/XMLSchema-instance"), "catalogSchema.xsd");

            List<Product> productList = productService.getByUserAndType(-2, 9);
            productList.addAll(productService.getByUserAndType(-2,10));
            for (Product product: productList) {


                Element productElement = catalogElement.addElement(typeAttribute.getNameById(product.getEntityTypeId()));
                Element nameElement = productElement.addElement("name").addText(product.getEntityName());
                Element attributesElement = productElement.addElement("attributes");
                Product productDetails = productService.getById(product.getId());
                int attributeId;
                switch (product.getEntityTypeId()){
                    case 9:
                        for (Pair<Atribute, Value> pair : productDetails.getAtributeValueMap()) {
                            attributeId = pair.getKey().getId();
                            if (telephoneTag.isCorrectId(attributeId)) {
                                Element attributeElement = attributesElement.addElement(telephoneTag.getNameById(attributeId))
                                        .addText(pair.getValue().getValue());
                            }
                        }
                        break;
                    case 10:
                        for (Pair<Atribute, Value> pair : productDetails.getAtributeValueMap()) {
                            attributeId = pair.getKey().getId();
                            if (tabletTag.isCorrectId(attributeId)) {
                                Element attributeElement = attributesElement.addElement(tabletTag.getNameById(attributeId))
                                        .addText(pair.getValue().getValue());
                            }
                        }
                        break;
                     default:
                        throw new NoSuchTagException("Unsupported ProductType");

                }
            }
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            XMLWriter writer = new XMLWriter(new FileWriter(
                    new File("src/main/resources/xml-parser/generatedCatalog.xml")
            ), outputFormat);
            writer.write( document );
            writer.close();
        } catch (IOException e){
            throw new ServiceException(e.getMessage());
        }
    }
    public int importCatalog(String url, String schemaLocation) throws ServiceException {
        int productCount = 0;
        try {
            List<Product> productsInBaseList = new ArrayList<>();
            productsInBaseList.addAll(productService.getByUserAndType(-2,9));
            productsInBaseList.addAll(productService.getByUserAndType(-2,10));

            File inputFile = new File(url);
            validateAgainstXSD(url, schemaLocation);
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputFile);
            Element catalogElement = document.getRootElement();
            List<Node> telephoneNodes = document.selectNodes("/catalog/telephone");
            for (Node telephoneNode : telephoneNodes){
                Element telephoneElement = (Element) telephoneNode;
                Element productNameElement = (Element) telephoneNode.selectSingleNode("name");
                if (ProductListWorker.containsNameIgnoreCaseAndWhitespace(productsInBaseList,productNameElement.getText())) continue;
                Node productAttributesNode = telephoneNode.selectSingleNode("attributes");
                Element attributesElement = (Element) productAttributesNode;
                List<Element> attributeList = attributesElement.elements();

                Product telephone = new Product(productNameElement.getText(),true, 9, -2);

                for (Element attribute : attributeList){
                    telephone.setValueInList(telephoneTag.getIdByName(attribute.getName()),attribute.getText());

                }
                productService.add(telephone);
                productCount++;

            }
            List<Node> tabletNodes = document.selectNodes("/catalog/tablet");
            for (Node tabletNode : tabletNodes){
                Element tabletElement = (Element) tabletNode;
                Element productNameElement = (Element) tabletNode.selectSingleNode("name");
                if (ProductListWorker.containsNameIgnoreCaseAndWhitespace(productsInBaseList,productNameElement.getText())) continue;
                Node productAttributesNode = tabletNode.selectSingleNode("attributes");
                Element attributesElement = (Element) productAttributesNode;
                List<Element> attributeList = attributesElement.elements();
                Product tablet = new Product(productNameElement.getText(),true, 10, -2);

                for (Element attribute : attributeList){
                    tablet.setValueInList(tabletTag.getIdByName(attribute.getName()),attribute.getText());

                }
                productService.add(tablet);
                productCount++;

            }


        } catch (DocumentException  | NoSuchTagException e){
            throw new ServiceException(e.getMessage());
        } catch ( WrongXMLSchemaException e  ){
            throw new WrongXMLSchemaException("Wrong XML Schema: " + e.getMessage());
        }
        return productCount;
    }

    public boolean validateAgainstXSD(String xml, String xsd) throws WrongXMLSchemaException {
        try
        {
            FileInputStream xmlIS = new FileInputStream(new File(xml));
            FileInputStream xsdIS =  new FileInputStream(new File(xsd));

            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsdIS));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xmlIS));
            return true;
        }
        catch(Exception ex)
        {
            throw new WrongXMLSchemaException(ex.getMessage());
        }
    }
  }
