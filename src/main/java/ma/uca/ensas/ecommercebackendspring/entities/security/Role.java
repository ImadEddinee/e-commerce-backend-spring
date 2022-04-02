package ma.uca.ensas.ecommercebackendspring.entities.security;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;

    public Role(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
    @Singular
    @ManyToMany(
            cascade = {CascadeType.MERGE, CascadeType.PERSIST},
            fetch = FetchType.EAGER
    )
    @JoinTable(
            name = "role_authority",
            joinColumns = {@JoinColumn(name = "role_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id",referencedColumnName = "id")}
    )
    private Set<Authority> authorities;
    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdDate;
    @UpdateTimestamp
    private Timestamp lastModifiedDate;
}
