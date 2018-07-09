package guru.springframework.bootstrap;

import guru.springframework.domain.*;
import guru.springframework.domain.enums.Difficulty;
import guru.springframework.repository.CategoryRepository;
import guru.springframework.repository.RecipeRepository;
import guru.springframework.repository.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private CategoryRepository categoryRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DevBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Transactional
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData() {
        recipeRepository.saveAll(initRecipes());
        log.debug("loading bootstrap data");
    }

    public List<Recipe> initRecipes() {

        List<Recipe> recipes = new ArrayList<>(2);

        Optional<Category> dip = categoryRepository.findByDescription("Dip");
        if(!dip.isPresent()){
            throw new RuntimeException("Expected category Not Found");
        }
        Optional<Category> mexican = categoryRepository.findByDescription("Mexican");
        if(!mexican.isPresent()){
            throw new RuntimeException("Expected category Not Found");
        }
        Optional<Category> vegan = categoryRepository.findByDescription("Vegan");
        if(!vegan.isPresent()){
            throw new RuntimeException("Expected category Not Found");
        }
        Optional<Category> avocado = categoryRepository.findByDescription("Avocado");
        if(!avocado.isPresent()){
            throw new RuntimeException("Expected category Not Found");
        }

        Optional<UnitOfMeasure> teaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!teaspoon.isPresent()){
            throw new RuntimeException("Expected UoM Not Found");
        }
        Optional<UnitOfMeasure> tablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!tablespoon.isPresent()){
            throw new RuntimeException("Expected UoM Not Found");
        }
        Optional<UnitOfMeasure> dash = unitOfMeasureRepository.findByDescription("Dash");
        if(!dash.isPresent()){
            throw new RuntimeException("Expected UoM Not Found");
        }
        Optional<UnitOfMeasure> each = unitOfMeasureRepository.findByDescription("Each");
        if(!each.isPresent()){
            throw new RuntimeException("Expected UoM Not Found");
        }

        Optional<UnitOfMeasure> cup = unitOfMeasureRepository.findByDescription("Cup");
        if(!cup.isPresent()){
            throw new RuntimeException("Expected UoM Not Found");
        }

        Optional<UnitOfMeasure> pinch = unitOfMeasureRepository.findByDescription("Pinch");
        if(!pinch.isPresent()){
            throw new RuntimeException("Expected UoM Not Found");
        }

        Recipe guacamole = new Recipe();
        guacamole.setServings(4);
        guacamole.setSource("Simply Recipes");
        guacamole.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacamole.setCategories(Stream.of(dip.get(), mexican.get(), vegan.get(), avocado.get()).collect(Collectors.toSet()));
        guacamole.setCookTime(0);
        guacamole.setPrepTime(10);
        guacamole.setDescription("Perfect Guacamole");
        guacamole.setDifficulty(Difficulty.EASY);
        guacamole.setDirections("1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
                "\n" +
                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
                "\n" +
                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
                "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
                "4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" +
                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.");

        Notes notes = new Notes();
        notes.setRecipeNotes("For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" +
                "Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" +
                "The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" +
                "To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" +
                "For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!");
        notes.setRecipe(guacamole);
        guacamole.setNotes(notes);

        guacamole.addIngredient(new Ingredient("ripe avocados", new BigDecimal(2), each.get()));
        guacamole.addIngredient(new Ingredient("Kosher salt", new BigDecimal(".5"), teaspoon.get()));
        guacamole.addIngredient(new Ingredient("fresh lime juice or lemon juice", new BigDecimal(2), tablespoon.get()));
        guacamole.addIngredient(new Ingredient("minced red onion or thinly sliced green onion", new BigDecimal(2), tablespoon.get()));
        guacamole.addIngredient(new Ingredient("serrano chiles, stems and seeds removed, minced", new BigDecimal(2), each.get()));
        guacamole.addIngredient(new Ingredient("Cilantro", new BigDecimal(2), tablespoon.get()));
        guacamole.addIngredient(new Ingredient("freshly grated black pepper", new BigDecimal(2), dash.get()));
        guacamole.addIngredient(new Ingredient("ripe tomato, seeds and pulp removed, chopped", new BigDecimal(".5"), each.get()));

        //Yummy Tacos
        Recipe tacosRecipe = new Recipe();
        tacosRecipe.setServings(4);
        tacosRecipe.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
        tacosRecipe.setSource("Simply Recipes");
        tacosRecipe.setDescription("Spicy Grilled Chicken Taco");
        tacosRecipe.setCookTime(9);
        tacosRecipe.setPrepTime(20);
        tacosRecipe.setDifficulty(Difficulty.MODERATE);

        tacosRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                "\n" +
                "\n" +
                "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" +
                "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" +
                "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvtrAnNm");

        Notes tacoNotes = new Notes();
        tacoNotes.setRecipeNotes("We have a family motto and it is this: Everything goes better in a tortilla.\n" +
                "Any and every kind of leftover can go inside a warm tortilla, usually with a healthy dose of pickled jalapenos. I can always sniff out a late-night snacker when the aroma of tortillas heating in a hot pan on the stove comes wafting through the house.\n" +
                "Today’s tacos are more purposeful – a deliberate meal instead of a secretive midnight snack!\n" +
                "First, I marinate the chicken briefly in a spicy paste of ancho chile powder, oregano, cumin, and sweet orange juice while the grill is heating. You can also use this time to prepare the taco toppings.\n" +
                "Grill the chicken, then let it rest while you warm the tortillas. Now you are ready to assemble the tacos and dig in. The whole meal comes together in about 30 minutes!\n" +
                "\n" +
                "\n" +
                "Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz4jvu7Q0MJ");
        tacoNotes.setRecipe(tacosRecipe);
        tacosRecipe.setNotes(tacoNotes);


        tacosRecipe.addIngredient(new Ingredient("Ancho Chili Powder", new BigDecimal(2), tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Dried Oregano", new BigDecimal(1), teaspoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Dried Cumin", new BigDecimal(1), teaspoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Sugar", new BigDecimal(1), teaspoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Salt", new BigDecimal(".5"), teaspoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Clove of Garlic, Choppedr", new BigDecimal(1), each.get()));
        tacosRecipe.addIngredient(new Ingredient("finely grated orange zestr", new BigDecimal(1), tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("fresh-squeezed orange juice", new BigDecimal(3), tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("Olive Oil", new BigDecimal(2), tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("boneless chicken thighs", new BigDecimal(4), tablespoon.get()));
        tacosRecipe.addIngredient(new Ingredient("small corn tortillasr", new BigDecimal(8), each.get()));
        tacosRecipe.addIngredient(new Ingredient("packed baby arugula", new BigDecimal(3), cup.get()));
        tacosRecipe.addIngredient(new Ingredient("medium ripe avocados, slic", new BigDecimal(2), each.get()));
        tacosRecipe.addIngredient(new Ingredient("radishes, thinly sliced", new BigDecimal(4), each.get()));
        tacosRecipe.addIngredient(new Ingredient("cherry tomatoes, halved", new BigDecimal(".5"), pinch.get()));
        tacosRecipe.addIngredient(new Ingredient("red onion, thinly sliced", new BigDecimal(".25"), each.get()));
        tacosRecipe.addIngredient(new Ingredient("Roughly chopped cilantro", new BigDecimal(4), each.get()));
        tacosRecipe.addIngredient(new Ingredient("cup sour cream thinned with 1/4 cup milk", new BigDecimal(4), cup.get()));
        tacosRecipe.addIngredient(new Ingredient("lime, cut into wedges", new BigDecimal(4), each.get()));

        tacosRecipe.getCategories().add(mexican.get());

        recipes.add(tacosRecipe);
        recipes.add(guacamole);

        return recipes;
    }
}
