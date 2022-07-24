package br.com.vnrg.hexagonalarchitecture.order.port.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_order_type")
public class OrderTypeEntity {

    @Id
    private Integer id;

    @Column(name = "order_type_description")
    private String orderTypeDescription;
}
