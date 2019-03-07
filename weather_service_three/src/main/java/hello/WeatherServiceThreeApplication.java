package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class WeatherServiceThreeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceThreeApplication.class, args);
	}

}
