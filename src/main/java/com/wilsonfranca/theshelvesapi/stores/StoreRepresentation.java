package com.wilsonfranca.theshelvesapi.stores;

import org.springframework.hateoas.RepresentationModel;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
class StoreRepresentation extends RepresentationModel<StoreRepresentation> {
    
    private String id;
    private String name;
    private String latitude;
    private String longitude;
    private String createdAt;

}