package gb.spring.market.springmarket.repository;

import gb.spring.market.springmarket.utils.NotFoundProductException;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Component
@Scope("prototype")
public class CartRepository {

    private Map<Long, Integer> list;
    private int amount;

    @PostConstruct
    public void init(){
        list = new HashMap<>();
        amount = 0;
    }

    public Map<Long, Integer> getCartList() {
        return Collections.unmodifiableMap(list);
    }

    public void addProductToCart(Long id, int cost){
        if(list.containsKey(id)) {
            list.replace(id, list.get(id) + 1);
            amount = amount + cost;
            return;
        }
        list.put(id, 1);
        amount = amount + cost;
    }

    public void removeProductToCart(Long id, int cost){
        if(list.containsKey(id) && list.get(id)>1) {
            list.replace(id, list.get(id) -1);
            amount = amount - cost;
            return;
        }
        if (list.containsKey(id) && list.get(id)==1){
            list.remove(id);
            amount = amount - cost;
            return;
        }
        throw new NotFoundProductException();
    }
    public void clearCart (){
        amount = 0;
        list.clear();
    }

}
