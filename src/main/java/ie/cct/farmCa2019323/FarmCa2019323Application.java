package ie.cct.farmCa2019323;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ie.cct.farmCa2019323*")
public class FarmCa2019323Application {

	public static void main(String[] args) {
		SpringApplication.run(FarmCa2019323Application.class, args);
	}

}
