package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ma.uca.ensas.ecommercebackendspring.entities.security.User;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "VERIFICATION_TOKEN")
public class VerificationToken {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
