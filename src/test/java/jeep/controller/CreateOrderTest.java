package jeep.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;

import jeep.controller.support.CreateOrderTestSupport;
import jeep.entity.Order;
import jeep.entity.jeepModel;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
		"classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
config = @SqlConfig(encoding = "utf-8"))
class CreateOrderTest extends CreateOrderTestSupport {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
/**
 * 
 */
	@Test
	void testCreateOrderReturnsSuccess201() {
	//given an order of JSON
		String body =	createOrderBody();
	String URI = getBaseURIForOrders();
	
	int numRowsOrders = JdbcTestUtils.countRowsInTable(jdbcTemplate, "orders");
	int numRowsOptions = JdbcTestUtils.countRowsInTable(jdbcTemplate, "order_options");
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_JSON);
	
	HttpEntity<String> bodyEntity = new HttpEntity<>(body, headers);
	//when order is sent
		ResponseEntity<Order> response = getRestTemplate().exchange
				(URI, HttpMethod.POST, bodyEntity, Order.class);
		//then a 201 status is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
	 //returned order is correct
		assertThat(response.getBody()).isNotNull();
		
		Order order = response.getBody();
		assertThat(order.getCustomer().getCustomerID()).isEqualTo("MORISON_LINA");
		assertThat(order.getModel().getModelId()).isEqualTo(jeepModel.WRANGLER);
		assertThat(order.getModel().getTrimLevel()).isEqualTo("Sport Altitude");
		assertThat(order.getModel().getNumDoors()).isEqualTo(4);
		assertThat(order.getColor().getColorId()).isEqualTo("EXT_NACHO");
		assertThat(order.getEngine().getEngineId()).isEqualTo("2_0_TURBO");
		assertThat(order.getTire().getTireId()).isEqualTo("35_TOYO");
		assertThat(order.getOptions()).hasSize(6);
		
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "orders"))
		.isEqualTo(numRowsOrders + 1);
		
		assertThat(JdbcTestUtils.countRowsInTable(jdbcTemplate, "order_options"))
		.isEqualTo(numRowsOptions + 6);
	}



}
