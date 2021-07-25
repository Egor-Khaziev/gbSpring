package gb.spring.market.springmarket.utils;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

//@Component
public class UtilSessionFactory {

//    private SessionFactory factory ;
//
//    @SneakyThrows
//    @PostConstruct
//    public void init (){
//        factory = new Configuration()
//                .configure("config/hibernate.cfg.xml")
//                .buildSessionFactory();
//
////        Session session = factory.getCurrentSession();
////        session.beginTransaction();
////        String sql = Files.lines(Paths.get("V1__init.sql")).collect(Collectors.joining(" "));
////        session.createNativeQuery(sql).executeUpdate();
////        session.getTransaction().commit();
//    }
//
//    public Session getSession() {
//        return factory.getCurrentSession();
//    }

}
