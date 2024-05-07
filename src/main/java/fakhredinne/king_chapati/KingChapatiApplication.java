package fakhredinne.king_chapati;

import com.github.javafaker.Faker;
import fakhredinne.king_chapati.models.Meal;
import fakhredinne.king_chapati.models.Restaurant;
import fakhredinne.king_chapati.repository.MealRepository;

import fakhredinne.king_chapati.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

public class KingChapatiApplication {

	public static void main(String[] args) {SpringApplication.run(KingChapatiApplication.class, args);
		System.out.println("It workS ya chaima");
	}
	/*@Bean
	public CommandLineRunner commandLineRunner(
			MealRepository meal_repository, RestaurantRepository retaurant_rep
			){
		return args -> {
			Faker faker=new Faker();
			Restaurant res=Restaurant.builder().Location(faker.name().title())




					.build();

		};
	}*/
	

}
