package guru.springframework.converters;

import guru.springframework.commands.UnityOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * Created by Marcos Almeida on 03/07/2018
 */
@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure, UnityOfMeasureCommand> {

    @Synchronized
    @Nullable
    @Override
    public UnityOfMeasureCommand convert(UnitOfMeasure source) {
        if (source == null) {
            return null;
        }

        final UnityOfMeasureCommand uomc = new UnityOfMeasureCommand();
        uomc.setId(source.getId());
        uomc.setDescription(source.getDescription());

        return uomc;
    }
}
