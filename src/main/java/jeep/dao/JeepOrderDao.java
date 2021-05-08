package jeep.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import jeep.entity.Color;
import jeep.entity.Customer;
import jeep.entity.Engine;
import jeep.entity.Jeep;
import jeep.entity.Option;
import jeep.entity.Order;
import jeep.entity.Tire;
import jeep.entity.jeepModel;


public interface JeepOrderDao {

	Optional<Customer> fetchCustomer(String customer);

	Optional<Jeep> fetchModel(jeepModel model, String trim, int doors);

	Optional<Color> fetchColor(String color);

	Optional<Engine> fetchEngine(String engine);

	Optional<Tire> fetchTire(String tireId);

	Order saveOrder(Customer customer, Jeep jeep, Color color, Engine engine, Tire tire, BigDecimal price, List<Option> options);

	List<Option> fetchOptions(List<String> optionsId);
	}




