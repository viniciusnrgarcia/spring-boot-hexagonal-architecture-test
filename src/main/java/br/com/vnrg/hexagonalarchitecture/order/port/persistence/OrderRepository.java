package br.com.vnrg.hexagonalarchitecture.order.port.persistence;

import br.com.vnrg.hexagonalarchitecture.order.port.persistence.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
