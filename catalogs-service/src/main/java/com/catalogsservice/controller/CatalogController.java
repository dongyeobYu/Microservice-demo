package com.catalogsservice.controller;

import com.catalogsservice.dto.ResponseCatalogDto;
import com.catalogsservice.service.CatalogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/catalogs-service")
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("/health_check")
    public String healthCheck() {
        return "health_check OK";
    }

    @GetMapping("/catalogs")
    public ResponseEntity<List<ResponseCatalogDto>> getAllCatalogs() {
        return ResponseEntity.ok(catalogService.getAllCatalogs());
    }
}
