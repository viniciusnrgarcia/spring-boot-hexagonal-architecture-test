package br.com.vnrg.hexagonalarchitecture.order.port.persistence.mapper;

import br.com.vnrg.hexagonalarchitecture.openapi.model.Order;
import br.com.vnrg.hexagonalarchitecture.order.port.persistence.entity.OrderStateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderStateMapper {

    OrderStateMapper INSTANCE = Mappers.getMapper(OrderStateMapper.class);

    @Mapping(target = "id", source = "orderState")
    public OrderStateEntity toOrderStateEntity(Order order);
}
