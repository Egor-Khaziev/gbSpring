package gb.spring.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        applicationContext.getBean(Start.class);

    }
}