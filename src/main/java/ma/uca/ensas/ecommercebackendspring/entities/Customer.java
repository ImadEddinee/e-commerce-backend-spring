package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CUSTOMER")
public class Customer extends Account{

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Order> orders;
}
