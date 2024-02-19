package com.acciojobSpringMock2.APIproblem.Repository;

import com.acciojobSpringMock2.APIproblem.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
