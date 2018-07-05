package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Marcos Almeida on 05/07/2018
 */
public class NotesToNotesCommandTest {

    public static final String RECIPE_NOTES = "notes";
    public static final Long LONG_VALUE = Long.valueOf(1L);

    NotesToNotesCommand converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesToNotesCommand();
    }

    @Test
    public void testEmptyParameter() {
        assertNotNull(converter.convert(new Notes()));
    }

    @Test
    public void testNullParamater() {
        assertNull(converter.convert(null));
    }

    @Test
    public void convert() {
        //given
        Notes notes = new Notes();
        notes.setId(LONG_VALUE);
        notes.setRecipeNotes(RECIPE_NOTES);

        //when
        NotesCommand command = converter.convert(notes);

        assertNotNull(command);
        assertEquals(LONG_VALUE, command.getId());
        assertEquals(RECIPE_NOTES, command.getRecipeNotes());
    }
}