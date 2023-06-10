package com.praneeth.productService.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("FoodItems")
public class FoodItem {
    @Id
    private String name;
    private String img_url;
    private int price;
    private boolean available;
}
