package guru.springframework.services;

import guru.springframework.commands.IngredientCommand;

/**
 * Created by Marcos Almeida on 05/07/2018
 */
public interface IngredientService {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long id);
    IngredientCommand saveIngredientCommand(IngredientCommand command);
    void deleteById(Long id);
}
