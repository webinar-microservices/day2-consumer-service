package in.webinar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Day2ConsumerServiceApplication {
	
	@Bean
	public RestTemplate registerRestTemplateWithSpringContainer() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(Day2ConsumerServiceApplication.class, args);
	}

}
