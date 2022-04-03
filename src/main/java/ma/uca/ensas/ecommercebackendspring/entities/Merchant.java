package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "merchant_type",
        discriminatorType = DiscriminatorType.STRING,
        length = 1
)
@Table(name = "MERCHANT")
public abstract class Merchant extends Account {

    private String description;
    private String webSite;

    @OneToMany(
            mappedBy = "merchant",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Product> products;

}
