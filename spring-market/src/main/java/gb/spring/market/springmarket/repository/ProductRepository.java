package gb.spring.market.springmarket.repository;

import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.utils.NotFoundProductException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private Long lastArticle;
    private List<Product> list;

    public List<Product> getList() {
        return Collections.unmodifiableList(list);
    }

    @PostConstruct
    public void init(){
        list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int cost = (i == 0) ? (cost = 50) : (cost = i * 100);
            list.add(new Product(i, "product " + i, cost));
        }

        //артикул последнего нового товара
        lastArticle = 4L;
    }

    public void createNewProduct(String title, int cost){
        list.add(new Product(++lastArticle,title,cost));
    }

    public Product getProductByID(long filterID){
        for (Product x: list) {
            if (x.getId()==filterID){
                return x;
            }
        }
        throw new NotFoundProductException();
    }

}
