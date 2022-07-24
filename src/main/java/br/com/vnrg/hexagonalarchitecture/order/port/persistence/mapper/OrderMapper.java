package br.com.vnrg.hexagonalarchitecture.order.port.persistence.mapper;

import br.com.vnrg.hexagonalarchitecture.order.domain.Order;
import br.com.vnrg.hexagonalarchitecture.order.port.persistence.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper(imports = UUID.class, componentModel = "string",
        uses = {OrderStateMapper.class,
                OrderTypeMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    // @Mapping(target = "orderState.id", source = "orderState")
    // @Mapping(target = "orderType.id", source = "orderType")
    public OrderEntity toOrderEntity(Order order);

    @Mapping(source = "id", target = "orderId")
    public Order toOrderDomain(OrderEntity orderEntity);

}
