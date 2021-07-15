package gb.spring.hibernate;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class ProductDao {

    Session session;
    SessionFactory sessionFactory;

    @Autowired
    public ProductDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Product findById(Long id) {
        return session.get(Product.class, id);
    }

    public List<Product> findAll() {
        return (List<Product>)session.createQuery("from Product", List.class);
    }

    public void deleteById(Long id) {
            session.delete(findById(id));
    }

    public void saveOrUpdate(Product product) {
         session.saveOrUpdate(product);
    }
}
