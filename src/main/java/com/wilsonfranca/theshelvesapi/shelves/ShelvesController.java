package com.wilsonfranca.theshelvesapi.shelves;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ShelvesController {

    private final ShelvesService shelvesService;

    @GetMapping
    @RequestMapping("/v1/stores/{store}/shelves")
    public HttpEntity<?> collection(@PathVariable final String store,
        final Pageable pageable){
            
            PagedModel<ShelfRepresentation> shelvesByStore = shelvesService.getShelvesByStore(store, pageable);
            
            return ResponseEntity.ok().body(shelvesByStore);
    }

}