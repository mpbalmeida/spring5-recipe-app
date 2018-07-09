package guru.springframework.repository;

import guru.springframework.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Marcos Almeida on 05/07/2018
 */
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    Optional<Ingredient> findByRecipeIdAndId(Long recipeId, Long id);
}
