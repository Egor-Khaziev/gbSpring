package gb.spring.market.springmarket.services;

import gb.spring.market.springmarket.dto.ProductDTO;
import gb.spring.market.springmarket.model.Product;
import gb.spring.market.springmarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductList(){
        return productRepository.findAll();
    }

    public ProductDTO createNewProduct(Product newProduct){
        return new ProductDTO(productRepository.save(newProduct));
    }

    public ProductDTO getProductByID(Long id){
        return new ProductDTO(productRepository.findById(id).get());
    }

    public void deleteById(long id){
        productRepository.deleteById(id);
    }

    public Page<ProductDTO> findPage(int pageIndex, int pageSize) {
        Page <Product> page = productRepository.findAll(PageRequest.of(pageIndex, pageSize));
        Page <ProductDTO> pageDTO = productRepository.findAll(PageRequest.of(pageIndex, pageSize)).map(new Function<Product, ProductDTO>() {
            @Override
            public ProductDTO apply(Product entity) {
                ProductDTO dto = new ProductDTO(entity);
                return dto;
            }}
            );
        return pageDTO;

    }

}
