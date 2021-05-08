package jeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })
//@Configuration
//@EnableAutoConfiguration
//@ComponentScan
public class jeepSales {

	public static void main(String[] args) {
		SpringApplication.run(jeepSales.class, args);

	}

}
