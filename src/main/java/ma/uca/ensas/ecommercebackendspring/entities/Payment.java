package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PAYMENT")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private LocalDateTime paymentDate;
    @Enumerated(EnumType.STRING)
    private PaymentCurrency paymentCurrency;
    private String address;
    private BigDecimal total;
    @OneToOne
    @JoinColumn(name = "orderDetail_id",referencedColumnName = "id")
    private OrderDetail orderDetail;
}
