package com.wilsonfranca.theshelvesapi.stores;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoresService {

    private final StoreRepository storeRepository;
    private final PagedResourcesAssembler<Store> pagedResourcesAssembler;

    public PagedModel<StoreRepresentation> getLocationByLatLong(final double latitude, final double longitude,
            final Pageable pageable) {

        Point point = new Point(latitude, longitude);

        Page<Store> findByLocationNear = storeRepository.findByLocationNear(point, pageable);

        PagedModel<StoreRepresentation> model = 
                pagedResourcesAssembler.toModel(findByLocationNear, new StoreRepresentationModelAssembler());
        
        return model;

    }

}