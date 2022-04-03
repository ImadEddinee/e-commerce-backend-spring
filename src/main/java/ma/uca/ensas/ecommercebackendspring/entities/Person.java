package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class Person  {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String firstName;
    private String LastName;
}
