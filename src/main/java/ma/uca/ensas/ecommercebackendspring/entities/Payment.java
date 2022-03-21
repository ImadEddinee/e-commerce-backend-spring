package ma.uca.ensas.ecommercebackendspring.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
