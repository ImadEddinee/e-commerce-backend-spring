package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "CITY")
public class City {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public City(String name, Country country) {
        this.name = name;
        this.country = country;
    }

    @ManyToOne
    @JoinColumn(name = "country_id",referencedColumnName = "id")
    private Country country;
    @OneToMany(mappedBy = "city",fetch = FetchType.LAZY)
    private List<Customer> customers;
}
