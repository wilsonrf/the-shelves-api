package com.wilsonfranca.theshelvesapi.shelves;

import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class ShelfRepresentationModelAssembler extends RepresentationModelAssemblerSupport<Shelf, ShelfRepresentation> {

    public ShelfRepresentationModelAssembler() {
        super(ShelvesController.class, ShelfRepresentation.class);
    }

    @Override
    public ShelfRepresentation toModel(Shelf shelf) {

        return ShelfRepresentation
            .builder()
            .id(shelf.getProduct())
            .description(shelf.getDescription())
            .latitude(shelf.getStore().getLocation().getY())
            .longitude(shelf.getStore().getLocation().getX())
            .available(shelf.isAvailable())
            .store(shelf.getStore().getName())
            .updatedAt(shelf.getUpdatedAt().toString())
            .build();
    }

}