package br.com.vnrg.hexagonalarchitecture.order.port.persistence.mapper;

import br.com.vnrg.hexagonalarchitecture.order.domain.Order;
import br.com.vnrg.hexagonalarchitecture.order.port.persistence.entity.OrderEntity;
import java.util.UUID;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T14:40:33-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderEntity toOrderEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderType( order.getOrderType() );
        orderEntity.setOrderDescription( order.getOrderDescription() );
        orderEntity.setOrderState( order.getOrderState() );
        orderEntity.setOrderValue( order.getOrderValue() );
        orderEntity.setProductId( order.getProductId() );
        orderEntity.setProductDescription( order.getProductDescription() );
        if ( order.getCustomerId() != null ) {
            orderEntity.setCustomerId( order.getCustomerId().toString() );
        }
        orderEntity.setProductItems( order.getProductItems() );

        return orderEntity;
    }

    @Override
    public Order toOrderDomain(OrderEntity orderEntity) {
        if ( orderEntity == null ) {
            return null;
        }

        Order order = new Order();

        order.setOrderId( orderEntity.getId() );
        order.setOrderType( orderEntity.getOrderType() );
        order.setOrderState( orderEntity.getOrderState() );
        order.setOrderDescription( orderEntity.getOrderDescription() );
        order.setOrderValue( orderEntity.getOrderValue() );
        order.setProductId( orderEntity.getProductId() );
        order.setProductItems( orderEntity.getProductItems() );
        order.setProductDescription( orderEntity.getProductDescription() );
        if ( orderEntity.getCustomerId() != null ) {
            order.setCustomerId( UUID.fromString( orderEntity.getCustomerId() ) );
        }

        return order;
    }
}
