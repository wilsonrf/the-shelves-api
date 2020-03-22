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
@RequiredArgsConstructor
@RequestMapping("/v1/stores")
public class StoresController {

    private final StoresService storesService;

    @GetMapping
    public HttpEntity<?> collection(@RequestParam(name = "lat", required = true) final double latitude, 
    @RequestParam(name = "long", required = true) final double longitude, 
    final Pageable pageable) {
            
            PagedModel<StoreRepresentation> model = storesService.getLocationByLatLong(latitude, longitude, pageable);

            return ResponseEntity.ok(model);
    }
}