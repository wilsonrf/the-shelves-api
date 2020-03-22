package com.wilsonfranca.theshelvesapi.shelves;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepository extends MongoRepository<Shelf, String> {

    Page<Shelf> findByStoreStoreId(final String storeId, Pageable pageable);
}