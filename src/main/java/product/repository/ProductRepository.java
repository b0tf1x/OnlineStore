package product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import product.dto.ProductFullDto;
import product.model.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select product from Products " +
            "where product.category.name = ?1 ")
    List<ProductFullDto> findByCategory(String category);
}
