package jeep.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import lombok.Getter;

public class baseTest {
 @LocalServerPort
private int serverPort;


@Autowired
@Getter
private TestRestTemplate restTemplate;
/**
 * 
 * @return
 */
protected String getBaseURIForJeeps() {
	return String.format("http://localhost:%d/jeeps", serverPort);
}

/**
 * 
 * @return
 */
protected String getBaseURIForOrders() {
	return String.format("http://localhost:%d/orders", serverPort);
}


}




