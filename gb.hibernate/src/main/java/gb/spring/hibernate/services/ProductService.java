package gb.spring.hibernate.services;

import gb.spring.hibernate.model.Product;
import gb.spring.hibernate.repository.ProductDao;
import gb.spring.hibernate.repository.UserDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    UserDao userDao;
    ProductDao productDao;

    @Autowired
    public ProductService(UserDao userDao, ProductDao productDao) {
        this.userDao = userDao;
        this.productDao = productDao;
    }

    public void userListByProductId(Long id){
        findById(id).getUserList().stream().forEach(x-> System.out.println(x));
    }

    private Product findById(Long id) {
        return productDao.findById(id);
    }

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    public void saveOrUpdate(Product product) {
        productDao.saveOrUpdate(product);

    }
}
