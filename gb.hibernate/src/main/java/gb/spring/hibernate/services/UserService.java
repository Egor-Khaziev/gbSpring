package gb.spring.hibernate.services;

import gb.spring.hibernate.model.User;
import gb.spring.hibernate.repository.ProductDao;
import gb.spring.hibernate.repository.UserDao;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    UserDao userDao;
    ProductDao productDao;

    @Autowired
    public UserService(UserDao userDao){//}, ProductDao productDao) {
        this.userDao = userDao;
        this.productDao = productDao;
    }

    public void userProductListByUserId(Long id){
        findById(id).getProductList().stream().forEach(x-> System.out.println(x));
    }

    public User findById(Long id){
        return userDao.findById(id);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public void deleteById(Long id) {
        userDao.deleteById(id);
    }

    public void saveOrUpdate(User user) {
        userDao.saveOrUpdate(user);
    }

}
