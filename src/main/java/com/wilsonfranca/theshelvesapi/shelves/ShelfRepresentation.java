package com.wilsonfranca.theshelvesapi.shelves;

import org.springframework.hateoas.RepresentationModel;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ShelfRepresentation extends RepresentationModel<ShelfRepresentation> {

    private String id;
    private String description;
    private String store;
    private Double latitude;
    private Double longitude;
    private String updatedAt;
    private boolean available;

}