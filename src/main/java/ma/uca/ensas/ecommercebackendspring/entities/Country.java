package ma.uca.ensas.ecommercebackendspring.entities;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "COUNTRY")
public class Country {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    public Country(String name) {
        this.name = name;
    }

    @OneToMany(mappedBy = "country",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<City> cities;
}
