package guru.springframework.converters;

import guru.springframework.commands.CategoryCommand;
import guru.springframework.domain.Category;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Marcos Almeida on 05/07/2018
 */
public class CategoryCommandToCategoryTest {

    public static final String DESCRIPTION = "descripion";
    public static final Long LONG_VALUE = Long.valueOf(1L);

    CategoryCommandToCategory converter;

    @Before
    public void setUp() throws Exception {
        converter = new CategoryCommandToCategory();
    }

    @Test
    public void testNullParameter() {
        assertNull(converter.convert(null));
    }

    @Test
    public void testEmptyParameter() {
        assertNotNull(converter.convert(new CategoryCommand()));
    }

    @Test
    public void convert() {
        //given
        CategoryCommand command = new CategoryCommand();
        command.setId(LONG_VALUE);
        command.setDescription(DESCRIPTION);

        //when
        Category category = converter.convert(command);

        //then
        assertNotNull(category);
        assertEquals(LONG_VALUE, category.getId());
        assertEquals(DESCRIPTION, category.getDescription());
    }
}