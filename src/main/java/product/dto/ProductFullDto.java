package product.dto;

import category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import producer.model.Producer;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductFullDto {
    private Long id;
    private Long price;
    private String name;
    private String description;
    private String application;
    private Long amount;
    private Category category;
    private Producer producer;
    private Boolean onSale;
    private Long salePrice;
}
