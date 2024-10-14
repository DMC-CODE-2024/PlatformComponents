/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gl.ceir.config.controller;

import com.gl.ceir.config.model.app.GenricResponse;
import com.gl.ceir.config.service.impl.FileCopyServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gl.ceir.config.model.app.UploadedFileDB;
 
@RestController
public class FileCopierController {

    @Value("${common_storage_flag}")
    private String common_Storage_flag;

    @Autowired
    private FileCopyServiceImpl fileCopyServiceImpl;

    @PostMapping("/fileCopyApi")
    public MappingJacksonValue saveFileCopyDetails(@RequestBody UploadedFileDB uploadedFileDB) {
        if (common_Storage_flag.equalsIgnoreCase("true")) {
            return new MappingJacksonValue(new GenricResponse(0, "Success", "0"));
        }
        return new MappingJacksonValue(fileCopyServiceImpl.saveDetailsWithParam(uploadedFileDB));
    }
}
