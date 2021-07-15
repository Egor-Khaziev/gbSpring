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
public class UserDao {

    Session session;
    SessionFactory sessionFactory;

    @Autowired
    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public User findById(Long id) {
        return session.get(User.class, id);
    }

    public List<User> findAll() {
        return (List<User>)session.createQuery("from User", List.class);
    }

    public void deleteById(Long id) {
        session.delete(findById(id));
    }

    public void saveOrUpdate(User user) {
        session.saveOrUpdate(user);
    }

}
