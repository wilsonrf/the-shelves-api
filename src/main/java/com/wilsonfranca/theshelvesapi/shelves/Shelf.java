package com.wilsonfranca.theshelvesapi.shelves;

import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@Document
@CompoundIndex(def = "{'product': 1, 'store.storeId': 1}")
public class Shelf {

    @Id
    private String id;

    private String product;

    private String description;

    private Store store;

    @LastModifiedDate
    private Instant updatedAt;

    private boolean available;

    @Getter
    @Builder
    public static class Store {
        
        @Indexed
        private String storeId;
        
        @Indexed
        private String name;

        @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE)
        private GeoJsonPoint location;
    }

}