package tacos.data;
 
import java.util.Optional;
 
import tacos.Ingredient;
 
public interface IngredientRepositoryWithJdbcTemplate {
 
  Iterable<Ingredient> findAll();
  
  Optional<Ingredient> findById(String id);
  
  Ingredient save(Ingredient ingredient);
  
}