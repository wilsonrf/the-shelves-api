package com.wilsonfranca.theshelvesapi.shelves;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShelvesService {

    private final ShelfRepository shelfRepository;
    private final PagedResourcesAssembler<Shelf> pagedResourcesAssembler;

    public PagedModel<ShelfRepresentation> getShelvesByStore(final String storeId, final Pageable pageable){

        Page<Shelf> page = shelfRepository.findByStoreStoreId(storeId, pageable);

        PagedModel<ShelfRepresentation> pagedModel = pagedResourcesAssembler.toModel(page, 
            new ShelfRepresentationModelAssembler());

        return pagedModel;

    }

}