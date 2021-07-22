package gb.spring.hibernate.repository;

import gb.spring.hibernate.model.Product;
import gb.spring.hibernate.model.User;
import gb.spring.hibernate.utils.UtilSessionFactory;
import lombok.Data;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Data
public class ProductDao {

    UtilSessionFactory sessionFactory;

    @Autowired
    public ProductDao(UtilSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Product findById(Long id) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        Product product = session.get(Product.class, id);
        session.getTransaction().commit();
        return product;
    }

    public List<Product> findAll() {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        List<Product> productList = (List<Product>)session.createQuery("from Product", List.class);
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
