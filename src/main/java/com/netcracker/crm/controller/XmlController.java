package com.netcracker.crm.controller;

import com.netcracker.crm.entity.User;
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
                String rootPath = System.getProperty("catalina.home");

                File newFile = new File(rootPath + File.separator + file.getOriginalFilename());
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(newFile));
                stream.write(fileBytes);
                stream.close();
                model.put("msg","File is saved under: " + rootPath + File.separator + file.getOriginalFilename());

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
