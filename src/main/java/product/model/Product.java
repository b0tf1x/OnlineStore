package product.model;

import category.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import producer.model.Producer;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long price;
    @Column(unique = true)
    private String name;
    @Column(length = 512)
    private String description;
    @Column(length = 512)
    private String application;
    private Long amount;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "producer_id")
    private Producer producer;
    private Boolean onSale = false;
    private Long salePrice = null;
}
