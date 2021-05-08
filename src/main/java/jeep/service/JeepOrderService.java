package jeep.service;

import jeep.entity.Order;
import jeep.entity.OrderRequest;

public interface JeepOrderService {

	Order createOrder(OrderRequest orderRequest);

}
