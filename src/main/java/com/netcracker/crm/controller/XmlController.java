package com.netcracker.crm.controller;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.services.parser.CatalogParser;
import com.netcracker.crm.services.parser.exception.WrongXMLSchemaException;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by Ксения on 09.12.2016.
 */
@Controller
public class XmlController {
    private static final String NO_ROOTS = "noRoots";
    private static final String SUCCESS = "register-success";
    private static final String XML = "xmlParser";
    private User user;
    CatalogParser catalogParser;

    @Required
    public void setCatalogParser(CatalogParser catalogParser) {
        this.catalogParser = catalogParser;
    }

    @Required
    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping(value="/uploadFile", method = RequestMethod.GET)
    public String upload(ModelMap model) {
        if(!user.isAdmin())
            return NO_ROOTS;

        return XML;
    }
    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String handleFileUpload(@RequestParam("file") MultipartFile file, ModelMap model) {

        if(!user.isAdmin())
            return NO_ROOTS;

        if (!file.isEmpty()) {

            try {

                byte[] fileBytes = file.getBytes();
                String rootPath = System.getProperty("catalina.home")+"/catalogToAdd";
                int i=0;
                while(new File(rootPath+i+".xml").exists()) ++i;
                File newFile = new File(rootPath+i+".xml");

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(fileBytes);
                stream.close();
                model.put("msg","File is saved under: " + newFile.getAbsoluteFile());
                String schemaLocation = "/resources/xml-parser/catalogSchema.xsd";

                //String urlFrom = newFile.getAbsolutePath();
                String urlFrom = "/resources/xml-parser/catalogToAdd.xml";
                //String urlTo = "src/main/resources/xml-parser/generatedCatalog.xml";
                int productCount = 0;

                newFile.delete();
                //catalogParser.exportCatalog(urlTo);

                try {

                    productCount = catalogParser.importCatalog(urlFrom, schemaLocation);

                }
                catch (WrongXMLSchemaException e)
                {
                    model.put("msg2","Wrong XML Schema Exception");
                    return XML;
                }

                model.put("msg2",productCount + " new products was added");

                return XML;

            } catch (Exception e) {
                e.printStackTrace();
                model.put("msg","File upload is failed: " + e.getMessage());

                return XML;
            }
        } else {
            model.put("msg", "File upload is failed: File is empty");

            return XML;
        }
    }

}
