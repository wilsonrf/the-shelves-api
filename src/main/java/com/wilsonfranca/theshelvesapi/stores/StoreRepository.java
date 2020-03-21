package com.wilsonfranca.theshelvesapi.stores;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface StoreRepository extends MongoRepository<Store, ObjectId> {

    public Page<Store> findByLocationNear(final Point point, final Pageable pageable);

}