package gbb;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> list;

    @PostConstruct
    public void init(){
        list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int cost = (i == 0) ? (cost = 50) : (cost = i * 100);
            list.add(new Product(i, "product" + i, cost));
        }
    }

    public Product getProductByID(long filterID){
        for (Product x: list) {
            if (x.id==filterID){
                return x;
            }
        }
        return null;
    }

    public List <Product> getProductList(){
        return Collections.unmodifiableList(list);
    }

}
