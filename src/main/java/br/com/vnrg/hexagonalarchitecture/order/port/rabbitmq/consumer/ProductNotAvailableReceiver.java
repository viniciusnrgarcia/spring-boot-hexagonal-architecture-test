package br.com.vnrg.hexagonalarchitecture.order.port.rabbitmq.consumer;

import br.com.vnrg.hexagonalarchitecture.order.domain.Order;
import br.com.vnrg.hexagonalarchitecture.order.usecases.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProductNotAvailableReceiver {

    private final OrderService service;

    public ProductNotAvailableReceiver(OrderService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.product-not-available}",
            concurrency = "${spring.rabbitmq.queue.order-created-concurrency:1}")
    public void listen(final Order order) {
        log.info("product-not-available received {}", order.toString());
        this.service.updateOrder(order);
    }

}