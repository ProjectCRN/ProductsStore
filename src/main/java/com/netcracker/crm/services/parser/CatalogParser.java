package com.netcracker.crm.services.parser;

import com.netcracker.crm.entity.Atribute;
import com.netcracker.crm.entity.Value;
import com.netcracker.crm.entity.serviceEntity.Product;
import com.netcracker.crm.services.IProductService;
import com.netcracker.crm.services.exception.ServiceException;
import com.netcracker.crm.services.listworker.ProductListWorker;
import com.netcracker.crm.services.parser.exception.NoSuchTagXMLException;
import com.netcracker.crm.services.parser.exception.WrongXMLShemaException;
import javafx.util.Pair;
import org.dom4j.*;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

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

            List<Product> productList = productService.getByUserAndType(-2, 8);
            productList.addAll(productService.getByUserAndType(-2,9));
            productList.addAll(productService.getByUserAndType(-2,10));
            for (Product product: productList) {
                Element productElement = catalogElement.addElement("product").addAttribute("type",
                        typeAttribute.getNameById(product.getEntityTypeId()));
                Element nameElement = productElement.addElement("name").addText(product.getEntityName());
                Element attributesElement = productElement.addElement("attributes");
                Product productDetails = productService.getById(product.getId());
                int attributeId;
                switch (product.getEntityTypeId()){
                    case 8:
                        for (Pair<Atribute, Value> pair : productDetails.getAtributeValueMap()) {
                            attributeId = pair.getKey().getId();
                            if (telephoneTag.isCorrectId(attributeId)) {
                                Element attributeElement = attributesElement.addElement(telephoneTag.getNameById(attributeId))
                                        .addText(pair.getValue().getValue());
                            }
                        }
                        break;
                    case 9:
                        for (Pair<Atribute, Value> pair : productDetails.getAtributeValueMap()) {
                            attributeId = pair.getKey().getId();
                            if (tabletTag.isCorrectId(attributeId)) {
                                Element attributeElement = attributesElement.addElement(tabletTag.getNameById(attributeId))
                                        .addText(pair.getValue().getValue());
                            }
                        }
                        break;
                     default:
                        throw new NoSuchTagXMLException("Unsupported ProductType");

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
    public void importCatalog(String url) throws ServiceException {
        try {
            List<Product> productsInBaseList = productService.getByUserAndType(-2, 8);
            productsInBaseList.addAll(productService.getByUserAndType(-2,9));
            productsInBaseList.addAll(productService.getByUserAndType(-2,10));
            File inputFile = new File("src/main/resources/xml-parser/catalogToAdd.xml");
            validateAgainstXSD(new FileInputStream(inputFile), new FileInputStream(new File("src/main/resources/xml-parser/catalogSchema.xsd")));
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputFile);
            Element catalogElement = document.getRootElement();
            List<Node> telephoneNodes = document.selectNodes("/catalog/product[@type='telephone']");
            for (Node telephoneNode : telephoneNodes){
                Element telephoneElement = (Element) telephoneNode;
                Element productNameElement = (Element) telephoneNode.selectSingleNode("name");
                if (ProductListWorker.containsNameIgnoreCaseAndWhitespace(productsInBaseList,productNameElement.getText())) continue;
                Node productAttributesNode = telephoneNode.selectSingleNode("attributes");
                Element attributesElement = (Element) productAttributesNode;
                List<Element> attributeList = attributesElement.elements();
                List<Pair<Atribute, Value>> values = new ArrayList<>();
                for (Element attribute : attributeList){
                    //values.add(new Value(0,attribute.getText(),0, telephoneTag.getIdByName(attribute.getName())));
                    Value value = new Value(0,attribute.getText(), 0, telephoneTag.getIdByName(attribute.getName()));
                    Atribute atribute = new Atribute(0,attribute.getName(), 0, true, 0, true );
                    values.add(new Pair<Atribute, Value>(atribute,value));
                }
                Product telephone = new Product(productNameElement.getText(),true, 8, -2, null);
                telephone.setAtributeValueMap(values);
                productService.add(telephone);

            }
            List<Node> tabletNodes = document.selectNodes("/catalog/product[@type='tablet']");
            for (Node tabletNode : tabletNodes){
                Element tabletElement = (Element) tabletNode;
                Element productNameElement = (Element) tabletNode.selectSingleNode("name");
                if (ProductListWorker.containsNameIgnoreCaseAndWhitespace(productsInBaseList,productNameElement.getText())) continue;
                Node productAttributesNode = tabletNode.selectSingleNode("attributes");
                Element attributesElement = (Element) productAttributesNode;
                List<Element> attributeList = attributesElement.elements();
                List<Pair<Atribute, Value>> values = new ArrayList<>();
                for (Element attribute : attributeList){
                    //values.add(new Value(0,attribute.getText(),0, telephoneTag.getIdByName(attribute.getName())));
                    Value value = new Value(0,attribute.getText(), 0, tabletTag.getIdByName(attribute.getName()));
                    Atribute atribute = new Atribute(0,attribute.getName(), 0, true, 0, true );
                    values.add(new Pair<Atribute, Value>(atribute,value));
                }
                Product tablet = new Product(productNameElement.getText(),true, 9, -2, null);
                tablet.setAtributeValueMap(values);
                productService.add(tablet);

            }


        } catch (DocumentException  | FileNotFoundException | NoSuchTagXMLException e){
            throw new ServiceException(e.getMessage());
        } catch ( WrongXMLShemaException e  ){
            throw new WrongXMLShemaException("Wrong XML Schema: " + e.getMessage());
        }
    }

    static boolean validateAgainstXSD(InputStream xml, InputStream xsd) throws WrongXMLShemaException {
        try
        {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new StreamSource(xsd));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(xml));
            return true;
        }
        catch(Exception ex)
        {
            throw new WrongXMLShemaException(ex.getMessage());
        }
    }
  }
