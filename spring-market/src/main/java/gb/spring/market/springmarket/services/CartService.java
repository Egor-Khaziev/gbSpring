package gb.spring.market.springmarket.services;

import gb.spring.market.springmarket.model.Cart;
import gb.spring.market.springmarket.repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CartService {

    private final Cart cart;
    private final CartRepository cartRepository;


    public Map<Long, Integer> getCartList(){
        return cartRepository.getCartList();
    }
    public void addProductToCart(Long id, int cost){
        cartRepository.addProductToCart(id,cost);
    }
    public void removeProductToCart(Long id, int cost){
        cartRepository.removeProductToCart(id,cost);
    }
    public void clearCart (){
        cartRepository.clearCart();
    }

}
