package com.dss.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;

import com.dss.p1.model.Product;
import com.dss.p1.service.DatabaseExportService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private DatabaseExportService databaseExportService;

    // Descarga BD en queries SQL
    @GetMapping("/export")
    public ResponseEntity<ByteArrayResource> exportDatabase() {
        byte[] data = databaseExportService.exportDatabaseToSql();
        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=productos.sql")
        		.contentType(MediaType.APPLICATION_OCTET_STREAM) .contentLength(data.length).body(resource);
    }
}