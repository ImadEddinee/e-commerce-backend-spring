package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CATEGORY")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @Lob
    @NotBlank
    private String description;
    private String imageBase64;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
