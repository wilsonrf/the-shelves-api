package com.wilsonfranca.theshelvesapi.stores;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/stores")
@RequiredArgsConstructor
public class StoresController {

    private final StoreService storeService;

    @GetMapping
    public HttpEntity<?> collection(@RequestParam(name = "lat", required = true) final double latitude, 
    @RequestParam(name = "long", required = true) final double longitude, 
    final Pageable pageable, 
        final PagedResourcesAssembler<Store> pagedResourcesAssembler) {

            Page<Store> page = storeService.getLocationByLatLong(latitude, longitude, pageable);
            
            PagedModel<StoreRepresentation> model = 
                pagedResourcesAssembler.toModel(page, new StoreRepresentationModelAssembler());

            return ResponseEntity.ok(model);
    }
}