package gb.spring.market.springmarket.services;

import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    public void createNewProduct(String title, int cost){
        productRepository.save(new Product(title,cost));
    }

    public Product getProductByID(Long id){
        return productRepository.findById(id).get();
    }

    public void deleteById(long id){
        productRepository.deleteById(id);
    }

    public Page<Product> findPage(int pageIndex, int pageSize) {
        return productRepository.findAll(PageRequest.of(pageIndex, pageSize));
    }

}
