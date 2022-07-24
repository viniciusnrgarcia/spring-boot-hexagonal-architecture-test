package br.com.vnrg.hexagonalarchitecture.order.port.rabbitmq.producer;

import br.com.vnrg.hexagonalarchitecture.order.config.BroadcastConfig;
import br.com.vnrg.hexagonalarchitecture.order.domain.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderCreatedPublisher {

    private final ObjectMapper objectMapper;
    private final RabbitTemplate rabbitTemplate;

    private final BroadcastConfig broadcastConfig;

    public OrderCreatedPublisher(final ObjectMapper objectMapper, final RabbitTemplate rabbitTemplate, final BroadcastConfig broadcastConfig) {
        this.objectMapper = objectMapper;
        this.rabbitTemplate = rabbitTemplate;
        this.broadcastConfig = broadcastConfig;
    }

    /**
     * CloudEvent exemplo
     * {@code CloudEventBuilder eventBuilder = CloudEventBuilder.v1()
     * .withId(UUID.randomUUID().toString())
     * .withType("order-created")
     * .withSource(URI.create("spring-boot-hexagonal-architecture-test.svc.cluster.local"))
     * .withData(this.objectMapper.writeValueAsBytes(data))
     * .withDataContentType("application/json; charset=UTF-8")
     * .withTime(OffsetDateTime.now());
     * CloudEvent event = eventBuilder.build();
     * }
     */
    public void send(final Order data) {
        log.info("Send event: {}", data.toString());
        this.rabbitTemplate.convertAndSend(broadcastConfig.getExchangeName(), "", data);
    }
}
