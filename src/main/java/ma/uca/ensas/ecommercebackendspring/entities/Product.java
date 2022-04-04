package ma.uca.ensas.ecommercebackendspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PRODUCT")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private String imageUrl;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;
    @JsonIgnore
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
    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<ProductExperience> productExperiences;
    @ManyToOne
    @JoinColumn(name = "merchant_id",referencedColumnName = "id")
    private Merchant merchant;
}
