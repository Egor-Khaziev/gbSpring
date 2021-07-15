package gb.spring.hibernate;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name ="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public User(String name) {
        this.name = name;
    }

    @Column(name = "name")
    private String name;


    @ManyToMany
    @JoinTable(
            name = "users_products",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    public User() {
    }

    public User(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }
}
