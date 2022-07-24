package br.com.vnrg.hexagonalarchitecture.order.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order implements Serializable {

    private Long orderId;

    private Integer orderType;

    private Integer orderState;

    private String orderDescription;

    private BigDecimal orderValue;

    private Long productId;

    private Integer productItems;

    private String productDescription;

    private UUID customerId;
}
