package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter


@AllArgsConstructor()
@NoArgsConstructor
public class Company{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String activity;
}
