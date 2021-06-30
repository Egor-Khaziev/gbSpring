package gbb;

import gbb.utils.ParseIntBoolean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

public class Start {

    AnnotationConfigApplicationContext applicationContext;

    Cart cart;
    Start shopStart;
    BufferedReader reader;

    public static void main(String[] args) {
        new Start();

    }

    public Start() {
        applicationContext = new AnnotationConfigApplicationContext(ConfContext.class);
        cart = applicationContext.getBean(Cart.class);
        cart.setApp(applicationContext);
        start();
        //destroy();
    }

    private void start() {
        System.out.println("Server start");
        reader = new BufferedReader(new InputStreamReader(System.in));
        shopStart = this;
        startConsole();
    }


    private void startConsole() {

        int id;
        int value;
        String message;

        while (true) {
            showRepository();
            showCart();
            System.out.println("cart price: " + cart.getPrice() + "\n");
            System.out.println("Write Id your product");
            try {
                message = reader.readLine();
                if (ParseIntBoolean.parseIntBoolean(message)) {
                    id = Integer.parseInt(message);
                } else {
                    System.out.println("wrong input");
                    continue;
                }
                System.out.println("Write 1 to add or 0 to remove");
                message = reader.readLine();
                if (ParseIntBoolean.parseIntBoolean(message)) {
                    value = Integer.parseInt(message);
                } else {
                    System.out.println("wrong input");
                    continue;
                }
                if (value == 1) {
                    cart.addProductByID(id);
                } else if (value == 0) {
                    cart.removeProductByID(id);
                } else {
                    System.out.println("wrong input");
                    continue;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void showRepository() {
        System.out.println("Repository:");
        List<Product> cartList = getProductList();
        if (cartList != null) {
            cartList.forEach((x) -> System.out.println(x.toString()));
        } else {
            System.out.println("repository is empty");
        }
        System.out.println("\n");
    }

    private void showCart() {
        System.out.println("Your cart:");
        Map<Long, Integer> cartList = cart.getCartList();
        if (!cartList.isEmpty()) {
            cartList.forEach((x, y) -> System.out.println(getProductByID(x).toString() + " " + " PIECES: " + y));
            return;
        }
        System.out.println("cart is empty");
    }

    // if ID not found, value - NULL
    public Product getProductByID(long id) {
        if (applicationContext.getBean(ProductRepository.class).getProductByID(id) == null) {
            System.out.println("ID not found");
        }
        return applicationContext.getBean(ProductRepository.class).getProductByID(id);

    }

    public List<Product> getProductList() {
        return applicationContext.getBean(ProductRepository.class).getProductList();
    }

    public void destroy() {
        applicationContext.close();
    }


}
