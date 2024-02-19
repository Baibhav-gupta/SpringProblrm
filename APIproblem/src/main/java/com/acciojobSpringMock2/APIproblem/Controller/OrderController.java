package com.acciojobSpringMock2.APIproblem.Controller;

import com.acciojobSpringMock2.APIproblem.Model.Product;
import com.acciojobSpringMock2.APIproblem.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("/orderwithA")
    public String createOrderStratingWithA(@PathVariable("userId") Integer userId)
    {
        return orderService.createOrderStratingWithA(userId);
    }
    @GetMapping("famousproduct")
    public Product findMostOrderedProduct()
    {
       return orderService.findMostOrderedProduct();
    }
}
