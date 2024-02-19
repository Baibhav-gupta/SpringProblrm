package com.acciojobSpringMock2.APIproblem.Repository;

import com.acciojobSpringMock2.APIproblem.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
