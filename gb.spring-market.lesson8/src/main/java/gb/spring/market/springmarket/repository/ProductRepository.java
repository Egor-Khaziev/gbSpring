package gb.spring.market.springmarket.repository;

import gb.spring.market.springmarket.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

        List<Product> findAllByCostBetween(int max, int min);
        List<Product> findAllByCostGreaterThanEqual(int min);
        List<Product> findAllByCostLessThanEqual(int max);

}
