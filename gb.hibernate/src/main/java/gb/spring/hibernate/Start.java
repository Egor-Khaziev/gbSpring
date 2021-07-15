package gb.spring.hibernate;

import gb.spring.hibernate.model.Product;
import gb.spring.hibernate.model.User;
import gb.spring.hibernate.repository.ProductDao;
import gb.spring.hibernate.services.ProductService;
import gb.spring.hibernate.services.UserService;
import gb.spring.hibernate.utils.UtilSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class Start {

    Session session;
    UtilSessionFactory utilSessionFactory;
    UserService userService;
    ProductService productService;

    @PostConstruct
    private void init() throws IOException {
        //add products to db
        session.beginTransaction();
        String sql = Files.lines(Paths.get("import.sql")).collect(Collectors.joining(" "));
        session.createNativeQuery(sql).executeUpdate();
        session.getTransaction().commit();

        userService.userProductListByUserId(1L);
        productService.userListByProductId(1L);

    }
    @Autowired
    public Start(UserService userService, ProductService productService, UtilSessionFactory sessionFactory) throws Exception {

        this.utilSessionFactory = sessionFactory;
        this.productService = productService;
        this.session = sessionFactory.getSession();
        this.userService = userService;

    }

}
