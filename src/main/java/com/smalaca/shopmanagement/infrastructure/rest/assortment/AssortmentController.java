package com.smalaca.shopmanagement.infrastructure.rest.assortment;

import com.smalaca.shopmanagement.application.assortment.AssortmentApplicationService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/assortment")
public class AssortmentController {
    private final AssortmentApplicationService service;

    public AssortmentController(AssortmentApplicationService service) {
        this.service = service;
    }

    @PostMapping
    @RequestMapping("/product/${assortmentId}")
    public void addProduct(@PathVariable UUID assortmentId) {
        service.addProduct(assortmentId);
    }
}
