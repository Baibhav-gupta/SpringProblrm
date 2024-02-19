package com.acciojobSpringMock2.APIproblem.Controller;

import com.acciojobSpringMock2.APIproblem.Model.Product;
import com.acciojobSpringMock2.APIproblem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @PostMapping("/add")
    public String addProduct(@RequestBody Product product)
    {
       return productService.addProduct(product);
    }
    @GetMapping("/maxpricedproduct/{category}")
    public Product maxPricedProductOfGivenCategory(@PathVariable("category") String category)
    {
        return productService.maxPricedProductOfGivenCategory(category);
    }
}
