package jeep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackageClasses = { ComponentScanMarker.class })

@ComponentScan(basePackages={"Jeep"})
public class jeepSales {

	public static void main(String[] args) {
		SpringApplication.run(jeepSales.class, args);

	}

}
