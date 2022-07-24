package br.com.vnrg.hexagonalarchitecture.order.port.http;

import br.com.vnrg.hexagonalarchitecture.openapi.api.OrderApi;
import br.com.vnrg.hexagonalarchitecture.openapi.model.ModelApiResponse;
import br.com.vnrg.hexagonalarchitecture.openapi.model.Order;
import br.com.vnrg.hexagonalarchitecture.order.usecases.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
class OrderController implements OrderApi {

    private final OrderService service;

    OrderController(OrderService service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<ModelApiResponse> addOrder(Order order) {
        log.info("addOrder {}", order.toString());
//        this.service.createOrder(order);
        var response = new ModelApiResponse();
        response.setCode(HttpStatus.ACCEPTED.value());
        response.setMessage("Order Accepted");
        response.setType("Success");
        return ResponseEntity.ok(response);
    }
}
