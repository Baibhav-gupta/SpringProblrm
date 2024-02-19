package com.acciojobSpringMock2.APIproblem.Model;

import com.acciojobSpringMock2.APIproblem.Enum.Category;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private String category;
    private Integer price;
}
