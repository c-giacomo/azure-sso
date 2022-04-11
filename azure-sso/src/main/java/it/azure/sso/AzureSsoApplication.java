package it.azure.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
@SpringBootApplication
public class AzureSsoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AzureSsoApplication.class, args);
	}

}
