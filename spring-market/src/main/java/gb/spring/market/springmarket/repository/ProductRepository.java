package gb.spring.market.springmarket.repository;

import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.utils.NotFoundProductException;
import gb.spring.market.springmarket.utils.UtilSessionFactory;
import lombok.Data;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class ProductRepository {

    UtilSessionFactory sessionFactory;

    @Autowired
    public ProductRepository(UtilSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Product findById(Long id) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        if(product!=null) {
            return product;
        }
        else {throw new NotFoundProductException();}
    }

    public List<Product> findAll() {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        List<Product> productList = session.createQuery("FROM Product").getResultList();
        session.getTransaction().commit();
        return productList;
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.delete(findById(id));
        session.getTransaction().commit();
    }

    public void saveOrUpdate(Product product) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.saveOrUpdate(product);
        session.getTransaction().commit();

    }
}
