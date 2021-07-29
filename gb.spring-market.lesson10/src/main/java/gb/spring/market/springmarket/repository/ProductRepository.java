package gb.spring.market.springmarket.repository;

import gb.spring.market.springmarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

//        List<Product> findAllByPriceBetween(int max, int min);
//        List<Product> findAllByPriceGreaterThanEqual(int min);
//        List<Product> findAllByPriceLessThanEqual(int max);

}
