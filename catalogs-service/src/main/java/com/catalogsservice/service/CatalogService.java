package com.catalogsservice.service;

import com.catalogsservice.dto.ResponseCatalogDto;
import com.catalogsservice.repository.CatalogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final CatalogRepository catalogRepository;

    public List<ResponseCatalogDto> getAllCatalogs() {
        return catalogRepository.findAll().stream().map(ResponseCatalogDto::new).toList();
    }

}