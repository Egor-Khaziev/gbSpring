package gb.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;


public class Start {

    private SessionFactory factory;
    private ProductDao productDao;

    public Start() {
        factory = new Configuration()
                .configure("config/hibernate.cfg.xml")
                .buildSessionFactory();
        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            //add products to db
            String sql = Files.lines(Paths.get("import.sql")).collect(Collectors.joining(" "));
            session.createNativeQuery(sql).executeUpdate();

            productDao = new ProductDao(factory);
            productDao.setSession(session);


            //find by ID: 1
            Product exmplProduct = productDao.findById(1L);
            System.out.println(exmplProduct);
            //exmplProduct.toString();
            //exmplProduct.getUsers().stream().forEach(x-> System.out.println(x));

            User exmplUser = session.get(User.class, 1L);
            System.out.println(exmplUser);
            exmplUser.toString();
            exmplUser.getProductList().stream().forEach(x-> System.out.println(x));


            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
