package com.dss.p1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;


import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.ui.Model;

import com.dss.p1.service.DatabaseExportService;
import com.dss.p1.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
    private DatabaseExportService databaseExportService;

    @Autowired
    private ProductService productService;

    // Página de administración (admin.html)
    @GetMapping
    public String admin(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "admin";
    }

    // Descarga BD en queries SQL
    @GetMapping("/export")
    public ResponseEntity<ByteArrayResource> exportDatabase() {
        byte[] data = databaseExportService.exportDatabaseToSql();
        ByteArrayResource resource = new ByteArrayResource(data);

        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=products.sql")
        		.contentType(MediaType.APPLICATION_OCTET_STREAM) .contentLength(data.length).body(resource);
    }
}