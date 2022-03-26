package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Product name is required")
    private String name;
    @NotEmpty(message = "Product description is required")
    @Lob
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private ProductStatus productStatus;
    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "orderDetail_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<OrderDetail> orderDetailList;
    @ManyToOne
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;
    @OneToMany(mappedBy = "product")
    private List<ProductExperience> productExperiences;
    @ManyToOne
    @JoinColumn(name = "merchant_id",referencedColumnName = "id")
    private Merchant merchant;
}
