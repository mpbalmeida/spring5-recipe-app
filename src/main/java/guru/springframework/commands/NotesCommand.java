package guru.springframework.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Marcos Almeida on 02/07/2018
 */
@Getter
@Setter
@NoArgsConstructor
public class NotesCommand {
    private Long id;
    private RecipeCommand recipe;
    private String recipeNotes;
}
