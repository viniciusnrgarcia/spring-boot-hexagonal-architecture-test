package br.com.vnrg.hexagonalarchitecture.order.port.rabbitmq.consumer;

import br.com.vnrg.hexagonalarchitecture.order.domain.Order;
import br.com.vnrg.hexagonalarchitecture.order.usecases.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PaymentCompletedReceiver {

    private final OrderService service;

    public PaymentCompletedReceiver(OrderService service) {
        this.service = service;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.payment-completed}")
    public void listen(final Order order) {
        log.info("payment-completed received {}", order.toString());
        this.service.updateOrder(order);
    }

}