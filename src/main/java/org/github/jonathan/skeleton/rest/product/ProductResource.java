package org.github.jonathan.skeleton.rest.product;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.github.jonathan.skeleton.generic.ResourceGeneric;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = ProductConstant.PATH_PRODUCT)
@Api(value=ProductConstant.DETAIL_PRODUCT_RESOURCE)
public class ProductResource extends ResourceGeneric<Product> {

    public ProductResource(ProductRepository repo) {
        super(repo);
    }

    @Autowired
    ProductRepository productRepository;

}
