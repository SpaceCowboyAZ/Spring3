package jeep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import jeep.entity.Order;
import jeep.entity.OrderRequest;
import jeep.service.JeepOrderService;
import lombok.extern.slf4j.Slf4j;
@RestController
@Slf4j
public class BasicJeepOrderController implements JeepOrderController {

	@Autowired
	private JeepOrderService jeepOrderService;
	
	@Override
	public Order createOrder(OrderRequest orderRequest) {
		log.debug("Order={}", orderRequest);
		return jeepOrderService.createOrder(orderRequest);
	}

}
