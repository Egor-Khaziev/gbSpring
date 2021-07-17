package gb.spring.market.springmarket.services;

import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductList(){
        //return productRepository.getList();
        return productRepository.findAll();
    }

    public void createNewProduct(String title, int cost){
        //productRepository.createNewProduct(title,cost);
        productRepository.saveOrUpdate(new Product(title,cost));
    }

    public Product getProductByID(long id){
        //return  productRepository.getProductByID(id);
        return productRepository.findById(id);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

}
