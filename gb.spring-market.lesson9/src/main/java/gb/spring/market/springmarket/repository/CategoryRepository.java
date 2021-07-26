package gb.spring.market.springmarket.repository;

import gb.spring.market.springmarket.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findCategoryByTitleEquals(String title);

}
