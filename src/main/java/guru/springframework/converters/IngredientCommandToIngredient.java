package guru.springframework.converters;

import guru.springframework.commands.IngredientCommand;
import guru.springframework.domain.Ingredient;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Marcos Almeida on 05/07/2018
 */
@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    UnitOfMeasureCommandToUnitOfMeasure uomCommandConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomCommandConverter) {
        this.uomCommandConverter = uomCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Ingredient convert(IngredientCommand source) {
        if (source == null) {
            return null;
        }

        Ingredient ingredient = new Ingredient();
        ingredient.setAmount(source.getAmount());
        ingredient.setDescription(source.getDescription());
        ingredient.setId(source.getId());
        ingredient.setUom(uomCommandConverter.convert(source.getUom()));

        return ingredient;
    }
}
