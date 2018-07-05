package guru.springframework.converters;

import guru.springframework.commands.UnityOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Marcos Almeida on 05/07/2018
 */
public class UnitOfMeasureCommandToUnitOfMeasureTest {

    public static final String DESCRIPTION = "descripion";
    public static final Long LONG_VALUE = Long.valueOf(1L);

    UnitOfMeasureCommandToUnitOfMeasure converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureCommandToUnitOfMeasure();
    }

    @Test
    public void testeNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testeEmptyObject() {
        assertNotNull(converter.convert(new UnityOfMeasureCommand()));
    }

    @Test
    public void convert() {
        //given
        UnityOfMeasureCommand command = new UnityOfMeasureCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        UnitOfMeasure uom = converter.convert(command);

        //then
        assertNotNull(uom);
        assertEquals(LONG_VALUE, uom.getId());
        assertEquals(DESCRIPTION, uom.getDescription());
    }
}