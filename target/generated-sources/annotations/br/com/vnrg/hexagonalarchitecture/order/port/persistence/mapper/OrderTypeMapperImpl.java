package br.com.vnrg.hexagonalarchitecture.order.port.persistence.mapper;

import br.com.vnrg.hexagonalarchitecture.openapi.model.Order;
import br.com.vnrg.hexagonalarchitecture.order.port.persistence.entity.OrderStateEntity;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-24T14:40:30-0300",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.3 (Azul Systems, Inc.)"
)
public class OrderTypeMapperImpl implements OrderTypeMapper {

    @Override
    public OrderStateEntity toOrderStateEntity(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderStateEntity orderStateEntity = new OrderStateEntity();

        orderStateEntity.setId( order.getOrderType() );

        return orderStateEntity;
    }
}
