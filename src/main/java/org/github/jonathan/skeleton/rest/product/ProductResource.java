package org.github.jonathan.skeleton.rest.product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.github.jonathan.skeleton.generic.ResourceGeneric;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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

    @ApiOperation(value= ProductConstant.GET_ALL_LIST_ORDER_BY_ID)
    @GetMapping("/order-id")
    public List<Product> getAllByOrderById() {
        return productRepository.findAllByOrderByIdAsc();
    }
}
