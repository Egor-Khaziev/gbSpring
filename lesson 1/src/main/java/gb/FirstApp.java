package gb;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FirstApp", urlPatterns = "/FirstApp")
public class FirstApp implements Servlet {

    List<Product> productList = new ArrayList<>();

    private static Logger logger = LoggerFactory.getLogger(FirstApp.class);

    // Метод вызывается контейнером после того как был создан класс сервлета
    @Override
    public void init(ServletConfig config) throws ServletException {
        Product product = null;
        int cost = 0;
        for (int i = 0; i < 10; i++) {
            cost = (i == 0) ? (cost = 50) : (cost = i * 100);
            product = new Product(i, "product " + i, cost);
            productList.add(product);
        }
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    // Метод вызывается для каждого нового HTTP запроса к данному сервлету
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("New request");

        productList.stream().forEach(x -> {
            try {
                res.getWriter().println("id: " + x.id + " title: " + x.title + " cost: " + x.cost);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }


}
