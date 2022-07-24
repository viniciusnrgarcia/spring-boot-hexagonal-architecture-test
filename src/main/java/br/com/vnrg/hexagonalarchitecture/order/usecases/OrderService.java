package br.com.vnrg.hexagonalarchitecture.order.usecases;

import br.com.vnrg.hexagonalarchitecture.order.domain.Order;
import br.com.vnrg.hexagonalarchitecture.order.port.persistence.OrderRepository;
import br.com.vnrg.hexagonalarchitecture.order.port.persistence.mapper.OrderMapper;
import br.com.vnrg.hexagonalarchitecture.order.port.rabbitmq.producer.OrderCreatedPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public class OrderService {

    private final OrderRepository repository;

    private final OrderCreatedPublisher eventProducer;

    public OrderService(OrderRepository repository, OrderCreatedPublisher eventProducer) {
        this.repository = repository;
        this.eventProducer = eventProducer;
    }

    public void createOrder(Order order) {
        var orderDomain = this.saveOrder(order);
        this.sendEvent(orderDomain);
        log.info("created-order completed");
    }

    private void sendEvent(Order order) {
        this.eventProducer.send(order);
    }

    private Order saveOrder(Order order) {
        var mapper = OrderMapper.INSTANCE;
        var entity = mapper.toOrderEntity(order);
        entity.setUserCreated("spring-boot-hexagonal-architecture-test");
        entity.setUserUpdated("spring-boot-hexagonal-architecture-test");
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        this.repository.save(entity);
        return mapper.toOrderDomain(entity);
    }

    public void updateOrder(Order order) {
        var entityOptional = this.repository.findById(order.getOrderId());
        if (entityOptional.isPresent()) {
            var entity = entityOptional.get();
            entity.setOrderState(order.getOrderState());
            this.repository.save(entity);
        }
    }
}
