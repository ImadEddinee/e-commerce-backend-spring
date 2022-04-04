package ma.uca.ensas.ecommercebackendspring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Merchant extends User {

    @Enumerated(EnumType.STRING)
    private MerchantType merchantType;
    private String description;
    private String webSite;

    @JsonIgnore
    @OneToMany(
            mappedBy = "merchant",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Product> products;

}
