package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;
import org.apache.catalina.LifecycleState;

import javax.persistence.*;
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
    @NotEmpty(message = "Name is required")
    private String name;
    @Lob
    @NotEmpty(message = "Description is required")
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
