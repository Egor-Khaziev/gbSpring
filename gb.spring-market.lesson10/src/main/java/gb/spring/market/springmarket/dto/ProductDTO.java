package gb.spring.market.springmarket.dto;

import gb.spring.market.springmarket.model.Product;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String title;
    private int price;
    private String category;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
        this.category = product.getCategory().getTitle();
    }

}
