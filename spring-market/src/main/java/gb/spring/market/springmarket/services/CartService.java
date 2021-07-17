package gb.spring.market.springmarket.services;

import gb.spring.market.springmarket.model.Cart;
import gb.spring.market.springmarket.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class CartService {

    Cart cart;
    CartRepository cartRepository;

    @Autowired
    public CartService(Cart cart, CartRepository cartRepository) {
        this.cart = cart;
        this.cartRepository = cartRepository;
    }

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
