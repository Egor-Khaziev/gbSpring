package gb.spring.hibernate;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private int price;

    public Product() {

    }

    @Override
    public String toString() {
        return String.format("SimpleItem [id = %d, title = %s, price = %d]", id, title, price);
    }

    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
