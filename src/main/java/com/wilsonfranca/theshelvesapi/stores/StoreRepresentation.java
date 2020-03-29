package com.wilsonfranca.theshelvesapi.stores;

import org.springframework.hateoas.RepresentationModel;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
class StoreRepresentation extends RepresentationModel<StoreRepresentation> {
    
    private String id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String createdAt;

}