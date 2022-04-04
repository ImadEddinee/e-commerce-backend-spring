package ma.uca.ensas.ecommercebackendspring.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "COUNTRY")
public class Country {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "country",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<City> cities;
}
