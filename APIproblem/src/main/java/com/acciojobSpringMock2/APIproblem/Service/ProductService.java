package com.acciojobSpringMock2.APIproblem.Service;

import com.acciojobSpringMock2.APIproblem.Model.Product;
import com.acciojobSpringMock2.APIproblem.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    public String addProduct(Product product)
    {
        productRepository.save(product);
        return "product is saved to db";
    }
    public Product maxPricedProductOfGivenCategory( String category)
    {
        int maxPrice=-1;
        List<Product> productList=new ArrayList<>();
        Product ansproduct=new Product();
        productList=productRepository.findAll();
        for(Product obj:productList)
        {
            if(obj.getCategory().equals(category))
            {
                int price=obj.getPrice();
                if(price>maxPrice)
                {
                    maxPrice=price;
                    ansproduct=obj;
                }
            }
        }
        return ansproduct;
    }

}
