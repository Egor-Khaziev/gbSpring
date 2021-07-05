package gb.spring.market.springmarket.services;

import gb.spring.market.springmarket.repository.CartRepository;
import gb.spring.market.springmarket.utils.NotFoundProductException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addProduct(Long id, int cost){
        cartRepository.addProduct(id,cost);
    }

    public void removeProduct(Long id, int cost){
        cartRepository.removeProduct(id,cost);
    }
    public void clear (){
        cartRepository.clear();
    }

}
