package gbb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class Cart {

    private HashMap<Long,Integer> cartList;
    private int price;

    AnnotationConfigApplicationContext applicationContext ;

    public void setApp(AnnotationConfigApplicationContext app){
        applicationContext = app;
    }

    @PostConstruct
    public void init(){
        price = 0;
        cartList = new HashMap<>();

    }

    public Map<Long, Integer> getCartList() {
        return Collections.unmodifiableMap(cartList);
    }

    public void addProductByID(long ID){
        if(cartList.containsKey(ID)){
            cartList.replace(ID,cartList.get(ID)+1);
            setPrice(applicationContext.getBean(ProductRepository.class).getProductByID(ID).cost);
        }
        else {
            cartList.put(ID,1);
            setPrice(applicationContext.getBean(ProductRepository.class).getProductByID(ID).cost);
        }
    }

    public int getPrice() {
        return price;
    }

    public void removeProductByID(long ID){
        if(cartList.containsKey(ID)&&cartList.get(ID)>1){
            cartList.replace(ID,cartList.get(ID)-1);
            setPrice(-(applicationContext.getBean(ProductRepository.class).getProductByID(ID).cost));
        }
        else if(cartList.containsKey(ID)&&cartList.get(ID)==1){
            cartList.remove(ID);
            setPrice(-(applicationContext.getBean(ProductRepository.class).getProductByID(ID).cost));
        }
        else {
            System.out.println("this product id(" + ID + ") is not in the shopping cart");
        }
    }

    //ПОКА НЕ РЕАЛИЗОВАННО
    public void clearCart(){
        cartList = new HashMap<>();
        price = 0;
    }

    public void setPrice(int cost){
        price = price + cost;
    }

}
