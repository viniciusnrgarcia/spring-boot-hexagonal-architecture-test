package br.com.vnrg.hexagonalarchitecture.order.port.persistence.mapper;

import br.com.vnrg.hexagonalarchitecture.openapi.model.Order;
import br.com.vnrg.hexagonalarchitecture.order.port.persistence.entity.OrderStateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderTypeMapper {

    OrderTypeMapper INSTANCE = Mappers.getMapper(OrderTypeMapper.class);

    @Mapping(target = "id", source = "orderType")
    public OrderStateEntity toOrderStateEntity(Order order);
}
