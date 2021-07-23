package gb.spring.hibernate.repository;

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
public class UserDao {
    UtilSessionFactory sessionFactory;


    @Autowired
    public UserDao(UtilSessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public User findById(Long id) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        return user;
    }

    public List<User> findAll() {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        List<User> userList = (List<User>)session.createQuery("from User", List.class);
        session.getTransaction().commit();
        return userList;
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.delete(findById(id));
        session.getTransaction().commit();
    }

    public void saveOrUpdate(User user) {
        Session session = sessionFactory.getSession();
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();
    }

}
