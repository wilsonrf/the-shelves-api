package com.wilsonfranca.theshelvesapi.stores;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public Page<Store> getLocationByLatLong(final double latitude, final double longitude, final Pageable pageable){

        Point point = new Point(latitude, longitude);
        
        return storeRepository.findByLocationNear(point, pageable);

    }

}