package gb.spring.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        try (Session session = factory.getCurrentSession()) {

            session.beginTransaction();

            Product exmplProduct = session.get(Product.class, 1L);
            System.out.println(exmplProduct);

            User exmplUser = session.get(User.class, 1L);
            System.out.println(exmplUser);

            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}