package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductExperience {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reviewTitle;
    private String reviewBody;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;
}
