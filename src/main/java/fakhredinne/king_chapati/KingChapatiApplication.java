package fakhredinne.king_chapati;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan
public class KingChapatiApplication {

	public static void main(String[] args) {SpringApplication.run(KingChapatiApplication.class, args);
		System.out.println("It workS ya chaima");
	}

}
