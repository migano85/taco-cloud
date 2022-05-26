package tacos;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import tacos.Ingredient.Type;
import tacos.data.IngredientRepository;

@SpringBootApplication
public class TacoCloudApplication /*implements ApplicationRunner method number 3 */{

	public static void main(String[] args) {
		SpringApplication.run(TacoCloudApplication.class, args);
	}
/* ****************************************
 * 3 ways to load data when application starts
 * 1 - make method that is annotated with @Bean and returns CommandlineRunner
 * 2 - make method that is annotated with @Bean and returns ApplicationRUnner
 * 3 - make any class implements CommandlineRunner or ApplicationRUnner even if this class is spring boot startup class (i.e TacoCloudApplication)
 */

	
	//method number 1
	@Bean
	public CommandLineRunner dataLoader(IngredientRepository repo) {
		return args -> {
		repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
		repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
		repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
		repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
		repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
		repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
		repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
		repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
		repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
		repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
		};
	}

	//method number 2
	/*@Bean
	public ApplicationRunner dataLoader(IngredientRepository repo) {
		return args -> {
		repo.save(new Ingredient("FLTO", "Flour Tortilla", Type.WRAP));
		repo.save(new Ingredient("COTO", "Corn Tortilla", Type.WRAP));
		repo.save(new Ingredient("GRBF", "Ground Beef", Type.PROTEIN));
		repo.save(new Ingredient("CARN", "Carnitas", Type.PROTEIN));
		repo.save(new Ingredient("TMTO", "Diced Tomatoes", Type.VEGGIES));
		repo.save(new Ingredient("LETC", "Lettuce", Type.VEGGIES));
		repo.save(new Ingredient("CHED", "Cheddar", Type.CHEESE));
		repo.save(new Ingredient("JACK", "Monterrey Jack", Type.CHEESE));
		repo.save(new Ingredient("SLSA", "Salsa", Type.SAUCE));
		repo.save(new Ingredient("SRCR", "Sour Cream", Type.SAUCE));
		};
	}*/
}
