package guru.springframework.converters;

import guru.springframework.commands.NotesCommand;
import guru.springframework.domain.Notes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Marcos Almeida on 05/07/2018
 */
public class NotesCommandToNotesTest {

    public static final String RECIPE_NOTES = "notes";
    public static final Long LONG_VALUE = Long.valueOf(1L);

    NotesCommandToNotes converter;

    @Before
    public void setUp() throws Exception {
        converter = new NotesCommandToNotes();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyParameter() {
        assertNotNull(converter.convert(new NotesCommand()));
    }

    @Test
    public void convert() {
        //given
        NotesCommand command = new NotesCommand();
        command.setId(LONG_VALUE);
        command.setRecipeNotes(RECIPE_NOTES);

        //when
        Notes notes = converter.convert(command);

        assertNotNull(notes);
        assertEquals(LONG_VALUE, notes.getId());
        assertEquals(RECIPE_NOTES, notes.getRecipeNotes());
    }
}