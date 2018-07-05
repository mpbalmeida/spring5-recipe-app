package guru.springframework.converters;

import guru.springframework.commands.UnityOfMeasureCommand;
import guru.springframework.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Marcos Almeida on 05/07/2018
 */
public class UnitOfMeasureToUnitOfMeasureCommandTest {

    public static final String DESCRIPTION = "descripion";
    public static final Long LONG_VALUE = Long.valueOf(1L);

    UnitOfMeasureToUnitOfMeasureCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new UnitOfMeasureToUnitOfMeasureCommand();
    }

    @Test
    public void testeNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyObject() {
        assertNotNull(converter.convert(new UnitOfMeasure()));
    }

    @Test
    public void convert() {
        //given
        UnitOfMeasure uom = new UnitOfMeasure();
        uom.setDescription(DESCRIPTION);
        uom.setId(LONG_VALUE);

        //when
        UnityOfMeasureCommand command = converter.convert(uom);

        //then
        assertNotNull(command);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}