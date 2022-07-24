package br.com.vnrg.hexagonalarchitecture.order.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.support.RetryTemplate;

@Slf4j
@Configuration
public class RabbitMQConfig {

    private final BroadcastConfig config;
    private final ObjectMapper objectMapper;

    public RabbitMQConfig(final BroadcastConfig config, final ObjectMapper objectMapper) {
        this.config = config;
        this.objectMapper = objectMapper;
    }

    /**
     * Configuração {@code ConnectionFactory}.
     * https://docs.spring.io/spring-amqp/reference/html/#connections
     * <p>
     * Configuração de cluster
     * {@code
     * connectionFactory.setAddresses("host1:5672,host2:5672,host3:5672");
     * connectionFactory.setAddressShuffleMode(AddressShuffleMode.RANDOM);
     * }
     *
     * @return {@link CachingConnectionFactory}
     */
    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(this.config.getHostname());
        connectionFactory.setPort(this.config.getPort());
        connectionFactory.setUsername(this.config.getUsername());
        connectionFactory.setPassword(this.config.getPassword());
        return connectionFactory;
    }

    @Bean
    public RabbitAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate template = new RabbitTemplate(connectionFactory());
        RetryTemplate retryTemplate = new RetryTemplate();
        ExponentialBackOffPolicy backOffPolicy = new ExponentialBackOffPolicy();
        backOffPolicy.setInitialInterval(this.config.getInitialInterval());
        backOffPolicy.setMultiplier(this.config.getMultiplier());
        backOffPolicy.setMaxInterval(this.config.getMaxInterval());
        retryTemplate.setBackOffPolicy(backOffPolicy);
        template.setRetryTemplate(retryTemplate);
        template.setMessageConverter(jsonConverter());
        template.setConfirmCallback((correlationData, b, s) -> {
            log.info("ConfirmCallback {} {} {} ", correlationData, b, s);
        });
        return template;
    }

    @Bean
    public MessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter(this.objectMapper);
    }

    @Bean
    public Queue queue() {
        return new Queue(this.config.getOrderCreatedQueue(), false);
    }

    @Bean
    public Queue queueProductNotAvailable() {
        return new Queue(this.config.getProductNotAvailableQueue(), false);
    }

    @Bean
    public Queue queuePaymentCompleted() {
        return new Queue(this.config.getPaymentCompletedQueue(), false);
    }

    /**
     * {@code
     * new TopicExchange("order-created-exchange");
     * new FanoutExchange("order-created-exchange");
     * }
     *
     * @return {@link DirectExchange}
     */
    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange(this.config.getExchangeName());
    }

    @Bean
    public FanoutExchange productNotAvailableExchange() {
        return new FanoutExchange(this.config.getProductNotAvailableExchangeName());
    }

    @Bean
    public FanoutExchange paymentCompletedExchange() {
        return new FanoutExchange(this.config.getPaymentCompletedExchangeName());
    }

    /**
     * Exemplo sem routingKey
     * {@code }return BindingBuilder.bind(queue()).to(exchange()).withQueueName();}
     * <p>
     * Exemplo com routingKey
     * {@code
     * BindingBuilder.bind(queue()).to(exchange()).with("*");
     * public static final String BINDING_PATTERN_IMPORTANT = "*.important.*";
     * public static final String BINDING_PATTERN_ERROR = "#.error";}
     * <p>
     * Exemplo multiplos bindinds
     * {@code
     *
     * @return
     * @Bean public Declarables topicBindings() {
     * return new Declarables(
     * new Queue(topicQueue1Name, false),
     * new Queue(topicQueue2Name, false),
     * new TopicExchange(topicExchangeName),
     * BindingBuilder.bind(topicQueue1).to(topicExchange).with("*.important.*"),
     * BindingBuilder.bind(topicQueue2).to(topicExchange).with("#.error"));
     * }
     * <p>
     * Exemplo unico binding
     * {@code
     * @Bean public Binding binding() {
     * return BindingBuilder.bind(queue()).to(exchange());
     * }
     * }
     */
    @Bean
    public Declarables bindings() {
        return new Declarables(
                BindingBuilder.bind(queue()).to(exchange()),
                BindingBuilder.bind(queueProductNotAvailable()).to(productNotAvailableExchange()),
                BindingBuilder.bind(queuePaymentCompleted()).to(paymentCompletedExchange())
        );
    }
}
