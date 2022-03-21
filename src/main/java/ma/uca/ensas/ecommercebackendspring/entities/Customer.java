package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "CUSTOMER")
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "First name cannot be empty")
    @Size(min = 4,max = 20,message = "The first name should be between 4 and 20 characters")
    private String firstName;
    @NotEmpty(message = "Last name cannot be empty")
    @Size(min = 4,max = 30,message = "The last name should be between 4 and 20 characters")
    private String lastName;
    @NotEmpty(message = "Username is required")
    private String userName;
    @NotEmpty(message = "Password is required")
    private String password;
    @Email
    @NotEmpty(message = "Email is required")
    private String email;
    @Nullable
    private String address;
    @ManyToOne
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    private City city;
    @OneToOne(mappedBy = "customer")
    private ShoppingCart shoppingCart;
    @OneToMany(mappedBy = "customer",fetch = FetchType.LAZY)
    private List<Order> orders;
}
