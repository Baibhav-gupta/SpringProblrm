package com.acciojobSpringMock2.APIproblem.Service;

import com.acciojobSpringMock2.APIproblem.Model.Order;
import com.acciojobSpringMock2.APIproblem.Model.Product;
import com.acciojobSpringMock2.APIproblem.Repository.OrderRepository;
import com.acciojobSpringMock2.APIproblem.Repository.ProductRepository;
import com.acciojobSpringMock2.APIproblem.Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    public String createOrderStratingWithA(Integer userId)
    {
        List<Product> productList=new ArrayList<>();
        productList=productRepository.findAll();
        List<Product> forOrderA=new ArrayList<>();
        for(Product obj:productList)
        {
            String name=obj.getName();
            if(name.charAt(0)=='A')
            {
                forOrderA.add(obj);
            }
        }
        User user=userRepository.findById(userId).get();
        Order order=Order.builder()
                .productList(forOrderA)
                .user(user)
                .build();
        orderRepository.save(order);
        return " order made sucessfully";
    }
    public Product findMostOrderedProduct()
    {
        Product ans=new Product();
        // create hashmap of product Id vs frequency
        HashMap<Integer,Integer> hm=new HashMap<>();
        List<Order> orderList=new ArrayList<>();
        for(Order obj:orderList)
        {
            List<Product> productList=obj.getProductList();
            for(Product productObj:productList)
            {
                int productId=productObj.getProductId();

                    hm.put(productId,hm.getOrDefault(productId,0)+1);

            }
        }
        // my hashmap is completed now with all the product that has been ordered
        // now i need to find productId with max frequency
        // if more than one has same freq then i will see their price;
        int max=-1;
        int potAns=0;
        for(var e:hm.entrySet())
        {
            if(e.getValue()>max)
            {
                max=e.getValue();
                potAns=e.getKey();
            }
            if(e.getValue()==max)// compare a/c to price
            {
                Product pro1=productRepository.findById(potAns).get();//max
                Product pro2=productRepository.findById(e.getValue()).get();//e.getVAlue()
                if(pro2.getPrice()>pro1.getPrice())
                {
                    potAns= pro2.getProductId();
                }
            }
        }
ans=productRepository.findById(potAns).get();


        return ans;

    }
}
