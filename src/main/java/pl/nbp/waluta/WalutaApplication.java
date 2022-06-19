package pl.nbp.waluta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class WalutaApplication {

	public static void main(String[] args) {
		SpringApplication.run(WalutaApplication.class, args);
	}

}
