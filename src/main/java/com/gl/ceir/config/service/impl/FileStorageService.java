package com.gl.ceir.config.service.impl;

import com.gl.ceir.config.model.app.Notification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {
    @Value("${notificationattachment.filepath}")
    private String filepath;

    private static final Logger logger = LogManager.getLogger(FileStorageService.class);

    public String storeFile(Notification notification, MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        logger.info("File Name" + fileName);

        try {
            if (fileName.contains(".."))
                logger.error("Sorry! Filename contains invalid path sequence " + fileName);  // Check if the file's name contains invalid characters

            var fileStorageLocation = Paths.get(filepath + "/" + notification.getFeatureTxnId() + "/").toAbsolutePath().normalize();
            Files.createDirectories(fileStorageLocation);
            Path targetLocation = fileStorageLocation.resolve(fileName); // Copy file to the target location (Replacing existing file with the same name)
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileStorageLocation.toString();
        } catch (IOException ex) {
            logger.error("Could not store file " + fileName + ". Please try again!", ex);
            return null;
        }
    }



}
