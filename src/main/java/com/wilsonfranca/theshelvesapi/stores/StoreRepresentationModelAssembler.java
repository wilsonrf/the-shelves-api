package com.wilsonfranca.theshelvesapi.stores;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class StoreRepresentationModelAssembler extends RepresentationModelAssemblerSupport<Store, StoreRepresentation> {

    public StoreRepresentationModelAssembler() {
        super(StoresController.class, StoreRepresentation.class);
    }

    @Override
    public StoreRepresentation toModel(final Store store) {

        return StoreRepresentation
            .builder()
            .id(store.getId().toHexString())
            .latitude(store.getLocation().getY())
            .longitude(store.getLocation().getX())
            .name(store.getName())
            .createdAt(store.getCreatedAt().toString())
            .build();
    }
    
}
