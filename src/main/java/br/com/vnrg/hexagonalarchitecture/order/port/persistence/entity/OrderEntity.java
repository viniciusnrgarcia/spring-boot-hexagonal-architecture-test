package br.com.vnrg.hexagonalarchitecture.order.port.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_order")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_type")
    private Integer orderType;

    @Column(name = "order_description")
    private String orderDescription;

    @Column(name = "order_state")
    private Integer orderState;

    @Column(name = "order_value")
    private BigDecimal orderValue;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "customer_id")
    private String customerId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "user_created")
    private String userCreated;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "user_updated")
    private String userUpdated;

    @Column(name = "product_items")
    private Integer productItems;

}
