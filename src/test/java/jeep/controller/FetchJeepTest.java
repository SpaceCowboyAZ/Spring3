package jeep.controller;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doThrow;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.jdbc.JdbcTestUtils;
import entity.Jeep;
import entity.jeepModel;

import jeep.controller.support.FetchTestJeep;
import service.JeepSalesService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql(scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
		"classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
config = @SqlConfig(encoding = "utf-8"))


class FetchJeepTest {

}
	
	
	@Nested
	@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@ActiveProfiles("test")
	@Sql(scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
			"classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
	config = @SqlConfig(encoding = "utf-8"))
	class TestsThatDoNotPolluteTheApplicationContext extends FetchTestJeep {
		
		@Autowired
		private JdbcTemplate jdbctemplate;
		@Test
		void testDb() {
		int numrows = JdbcTestUtils.countRowsInTable(jdbctemplate, "customers");
		System.out.println("num=" + numrows);
			

		}

		  @Test
		void testThatJeepsAreReturnedWhenAValidModelAndTrimAreSupplied() {
	jeepModel model = jeepModel.WRANGLER;
		String trim = "Sport";
		String URI = String.format("%s?model=%s&trim=%s", getBaseURI(), model, trim);
		

				ResponseEntity<List<Jeep>> response = 
				getRestTemplate()
				.exchange(URI, HttpMethod.GET, null, 
						new ParameterizedTypeReference<List<Jeep>>() {});
		
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		List<Jeep> actual = response.getBody();
		List<Jeep> expected = buildExpected();
		
		actual.forEach(jeep -> jeep.setModelPK(null));
		assertThat(response.getBody()).isEqualTo(expected);	
		}
	
		
		
	@ParameterizedTest
	@MethodSource("jeep.controller.FetchJeepTest#parametersforInvalidInput")
	void testThatErrorMessageIsReturnedWhenAInvalidModelAndTrimAreSupplied(
			String model, String trim, String reason) {

	String URI = String.format("%s?model=%s&trim=%s", getBaseURI(), model, trim);


			ResponseEntity<Map<String, Object>> response = 
			getRestTemplate().exchange(URI, HttpMethod.GET, null, 
					new ParameterizedTypeReference<>() {});

	assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	 Map<String, Object> error = response.getBody();
	 
	 assertErrorMessageValid(error, HttpStatus.BAD_REQUEST);	  }
	static Stream<Arguments> paramatersForInvalidInput() {
	return Stream.of(
			arguments("WRANGLER", "@#$%^&&%", "Trim contains non-alpha-numeric chars"));
			//arguments("WRANGLER", "C".repeat(Constants.TRIM_MAX_LENGTH + 1), "Trim length too long");
			//arguments("INVALID", "Sport", "Model is not enum value");
			
	}
		@Nested
		@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
		@ActiveProfiles("test")
		@Sql(scripts = {"classpath:flyway/migrations/V1.0__Jeep_Schema.sql",
				"classpath:flyway/migrations/V1.1__Jeep_Data.sql"},
		config = @SqlConfig(encoding = "utf-8"))
		class TestsThatPolluteTheApplicationContext extends FetchTestJeep {
	@MockBean
	private JeepSalesService jeepsalesservice;

	/**
	 * 
	 */
	  @Test
		void testThatAnUnplannedErrorResultsIn500Status() {
	jeepModel model = jeepModel.WRANGLER;
		String trim = "Invalid";
		String URI = String.format("%s?model=%s&trim=%s", getBaseURI(), model, trim);
		
		doThrow(new RuntimeException("No good")).when(jeepsalesservice)
		.fetchJeeps(model, trim);
				//Connection is made to the URI
				ResponseEntity<Map<String, Object>> response = 
				getRestTemplate().exchange(URI, HttpMethod.GET, null, 
						new ParameterizedTypeReference<>() {});
				//A internal error 500 status is returned
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
		 //Error message is returned
		Map<String, Object> error =  response.getBody();
		 assertErrorMessageValid(error, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
		 
}
		
		}
	



	

	
	
	


