package com.netcracker.crm.controller;

import com.netcracker.crm.entity.User;
import com.netcracker.crm.services.parser.CatalogParser;
import com.netcracker.crm.services.parser.exception.WrongXMLSchemaException;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by Ксения on 09.12.2016.
 */
@Controller
public class XmlController {
    private static final String NO_ROOTS = "noRoots";
    private static final int BUFFER_SIZE = 4096;
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

        model.addAttribute("userRole",user.getRoleId());
        model.addAttribute("userName", user.getUserName());

        if(!user.isAdmin())
            return NO_ROOTS;

        if (!file.isEmpty()) {

            try {

                byte[] fileBytes = file.getBytes();
                String appPath = System.getProperty("catalina.home")+"/webapps/ROOT/WEB-INF/classes/xml-parser";
                String fromPath = appPath+"/catalogToAdd";
                int i=0;
                while(new File(fromPath+i+".xml").exists()) ++i;
                File newFile = new File(fromPath+i+".xml");

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(fileBytes);
                stream.close();
                model.put("msg","File is saved under: " + newFile.getAbsoluteFile());
                String schemaLocation = appPath+"/catalogSchema.xsd";
                String urlFrom = newFile.getAbsolutePath();
                int productCount = 0;


                //catalogParser.exportCatalog(urlTo);

                try {

                    productCount = catalogParser.importCatalog(urlFrom, schemaLocation);

                }
                catch (WrongXMLSchemaException e)
                {
                    model.put("msg2","Wrong XML Schema Exception");
                    return XML;
                }
                newFile.delete();
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

    @RequestMapping(value = "/downloadSchema", method = RequestMethod.GET)
    public void downloadSchema(HttpServletRequest request,
                           HttpServletResponse response) throws IOException {


        String appPath = System.getProperty("catalina.home")+"/webapps/ROOT/WEB-INF/classes/xml-parser";
        String schemaLocation = appPath+"/catalogSchema.xsd";
        ServletContext context = request.getServletContext();

        File downloadFile = new File(schemaLocation);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        String mimeType = context.getMimeType(schemaLocation);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);

        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();
    }

    @RequestMapping(value = "/downloadCatalog", method = RequestMethod.GET)
    public void downloadCatalog(HttpServletRequest request,
                               HttpServletResponse response) throws IOException {


        String appPath = System.getProperty("catalina.home")+"/webapps/ROOT/WEB-INF/classes/xml-parser";
        String schemaLocation = appPath+"/catalogSchema.xsd";

        String fromPath = appPath+"/generatedCatalog";
        int i=0;
        while(new File(fromPath+i+".xml").exists()) ++i;
        String urlTo = fromPath+i+".xml";
        catalogParser.exportCatalog(urlTo);
        ServletContext context = request.getServletContext();

        File downloadFile = new File(urlTo);
        FileInputStream inputStream = new FileInputStream(downloadFile);

        String mimeType = context.getMimeType(urlTo);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
        }


        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        OutputStream outStream = response.getOutputStream();

        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();
        downloadFile.delete();
    }
}
